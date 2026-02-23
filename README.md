# Prompt-Powered Kickstart: Building a Beginner’s Toolkit for Kotlin + API Calls

## 1. Title & Objective

**Technology chosen:** Kotlin (with built-in Java `HttpClient` for HTTP requests)  
**Why I chose it:** Kotlin is modern, concise, safe (null-safety), and runs on the JVM. I wanted a beginner-friendly way to make real API calls without adding heavy libraries or frameworks — perfect for learning networking basics.  
**End goal:** Create an interactive console app that fetches and displays random interesting facts from a public API, with a loop for user interaction ("Press Enter for next fact").

## 2. Quick Summary of the Technology

Kotlin is a statically-typed programming language developed by JetBrains. It interoperates fully with Java, so we can use Java's built-in `java.net.http.HttpClient` (available since Java 11) for HTTP GET requests — no extra dependencies needed!

- **What is it?** A productive alternative to Java with better syntax, coroutines, extensions, and null safety.  
- **Where is it used?** Android apps (official language), backend servers (Ktor/Spring), desktop (Compose), scripts, and more.  
- **One real-world example:** Pinterest, Trello, and Netflix use Kotlin heavily for Android and backend services.

## 3. System Requirements

- **OS:** Linux (Ubuntu tested), Mac, or Windows  
- **Tools/Editors:** VS Code (with extensions: Extension Pack for Java, Gradle for Java, Kotlin by fwcd)  
- **JDK:** Java 17 or 21 (you have OpenJDK 17)  
- **Build tool:** Gradle (version 9.3.1+ from SDKMAN)  
- **Other:** Internet connection (for API calls)  

No npm, pip, or extra package managers needed!

## 4. Installation & Setup Instructions

 1. Create a new directory:
 mkdir kotlin-fact-generator
 cd kotlin-fact-generator

 2. Initialize a Kotlin application project with Gradle:  **gradle init**
 - Choose: Application → Kotlin → Java 21 → Single application project → Kotlin DSL →   kotlin.test → Yes to new APIs.

 3. Open in VS Code: **.code**
 Install extensions if prompted (Java Pack, Gradle, Kotlin).

 4. (Optional) Upgrade Gradle via SDKMAN for latest version:
  curl -s "https://get.sdkman.io" | bash
  source "$HOME/.sdkman/bin/sdkman-init.sh"
  sdk install gradle

 5. Make the app interactive by adding to `build.gradle.kts` (fixes input waiting):
  ```kotlin
  tasks.named<JavaExec>("run") {
    standardInput = System.`in`
  }

## 5. Minimal Working Example 

What it does:
An interactive console program that:

Uses java.net.http.HttpClient to call the API Ninjas Facts API.
Fetches a random interesting fact (JSON response).
Prints it cleanly.
Loops: Press Enter for next fact; type 'quit' to exit.

How to run: **./gradlew run**

Expected output example:
  === Random Fact Generator - (Moringa Capstone) ===
Press Enter to get a new fact
Type 'quit' or 'exit' and press Enter to stop

→ Press Enter for next fact... 
Fetching a random interesting fact...

Random Fact:
2.5 cans of Spam are consumed every second in the United States

→ Press Enter for next fact... quit

Thanks for using the Fact Generator! Goodbye 👋

 Full code is in src/main/kotlin/org/example/App.kt (includes error handling and simple JSON parsing without libraries).

## 6. AI Prompt Journal

## 7. Common Issues & Fixes

 A. gradle init no prompts/files → 
 Use non-interactive flags or fresh empty folder.
 B. Error: Could not find or load main class org.example.AppKt → 
 Ensure mainClass = "org.example.AppKt" in build.gradle.kts and file is in correct package/folder.
 C. -Xverify:none warning → 
 Remove deprecated flags from gradle.properties.
 D. API returns 400 "limit parameter is for premium" → 
 Remove ?limit=1 for free tier (default is 1 fact).
 E. JSON parsing fails (whitespace/escapes) → 
 Use tolerant index search + unescape \t, \n.
 F. readLine() doesn't wait / infinite loop →
  Add standardInput = System.in`` to run task in build.gradle.kts.
 G. Network/API errors → 
 Check internet; verify API key; test endpoint in browser/curl.

## 8. References

 1. Official Kotlin docs:https://kotlinlang.org/docs/home.html
 2. Java HttpClient (used in code):https://docs.oracle.com/en/java/javase/21/docs/api/java.net.http/java/net/http/HttpClient.html
 3. API Ninjas Facts API (used here):https://api-ninjas.com/api/facts
 4. Gradle Kotlin DSL guide:https://docs.gradle.org/current/userguide/kotlin_dsl.html
 5. Numbers API (tried first, unreliable):http://numbersapi.com
 6. VS Code Kotlin setup:https://kotlinlang.org/docs/command-line.html#using-the-command-line-compiler

GitHub Repo: https://github.com/vice305/firstKotlin
Author: Chris Kim
Date: February 2026, Nairobi, Kenya 