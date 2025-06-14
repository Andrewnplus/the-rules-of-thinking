plugins {
    id("com.diffplug.spotless") version "6.25.0"
    id("io.github.fstaudt.hugo") version "0.10.0"
}

hugo {
    version.set("0.144.0")
    sourceDirectory.set("site")
}

spotless {
    format("markdown") {
        target("site/content/**/*.md")
        prettier().config(mapOf("parser" to "markdown"))
    }
}

tasks {
    register<Copy>("stage") {
        dependsOn("hugoBuild")
        from(layout.buildDirectory.dir("hugo/publish"))
        into(layout.buildDirectory.dir("dist"))
    }
}

tasks.named("spotlessCheck").configure {
    outputs.upToDateWhen { false }
}

subprojects.forEach {
    it.tasks.matching { task -> task.name in listOf("hugoBuild", "hugoServer") }
        .configureEach { dependsOn(rootProject.tasks.named("spotlessCheck")) }
}

