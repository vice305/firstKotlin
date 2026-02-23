# Prompt-Powered Kickstart: Building a Beginner’s Toolkit for Kotlin + HTTP Requests

## 1. Title & Objective
**Technology chosen:** Kotlin programming language + built-in Java HTTP client  
**Why I chose it:** Kotlin is modern, safe, and fun. I wanted a very simple way to call an API without adding many libraries — perfect for beginners.  
**End goal:** Make a console program that fetches and prints a different random math fact every time it runs.

## 2. Quick Summary of the Technology
Kotlin is a modern programming language created by JetBrains. It runs on the JVM (Java Virtual Machine) and is fully compatible with Java libraries.  
Used for: Android apps, server apps (Ktor), desktop, scripts.  
Real-world example: Many Android apps (Pinterest, Trello), backend services.

## 3. System Requirements
- OS: Linux / Mac / Windows (I used Ubuntu)
- Tools: VS Code + Java JDK 17 or 21 (I have 17)
- Gradle (already set up via gradle init)

## 4. Installation & Setup Instructions
(You already did this — summarize your steps)
1. Created empty folder: `mkdir kotlin-hello && cd kotlin-hello`
2. Ran `gradle init` and chose:
   - Application
   - Kotlin
   - Java 21
   - Single project
   - Kotlin DSL
   - kotlin.test
   - New APIs: yes
3. Opened in VS Code: `code .`
4. No extra installs needed for HTTP — uses built-in `java.net.http`

## 5. Minimal Working Example
**What it does:** Calls a free API to get a random math fact and prints it.

**Code:** (paste the full code above)

**How to run:**
```bash
./gradlew run