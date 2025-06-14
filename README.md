# The Rules of Thinking

## Introduction

Welcome to The Rules of Thinking

## Technology Stack

* **Hugo** – a fast static site generator written in Go
* **hugo-book** – a Hugo theme optimized for technical notes and books, pulled in via Hugo Modules
* **Gradle Wrapper** – used to orchestrate Hugo commands without requiring a global install
* **JDK 17+** – required by the Gradle toolchain
* **Goldmark** – Hugo’s built-in Markdown renderer, with custom Render Hooks for link handling

## Local Setup & Testing

These steps assume you have JDK 17+ installed and a POSIX-compatible shell:

1. Clone the repository
   ```bash
   git clone git@github.com:Andrewnplus/the-rules-of-thinking.git
   cd the-rules-of-thinking
   ```   

2. Start the Hugo development server
   ```bash
   ./gradlew hugoServer
   ```
   Once started, open your browser to http://localhost:1313 to preview the site.

3.Rebuild after changes  
Whenever you update content or configuration, simply rerun:

   ```bash
   ./gradlew hugoServer
   ```