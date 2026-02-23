## Prompt-Powered Kickstart: Building a Beginner’s Toolkit for Kotlin + API Calls##

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
- **JDK:** Java 17 or 21 (tested with OpenJDK 17)  
- **Build tool:** Gradle (version 9.3.1+ from SDKMAN)  
- **Other:** Internet connection (for API calls)  

No npm, pip, or extra package managers needed!

## 4. Installation & Setup Instructions

1. Create a new directory:
   ```bash
   mkdir kotlin-fact-generator
   cd kotlin-fact-generator

Initialize a Kotlin application project with Gradle:Bashgradle initChoose:
Application
Kotlin
Java 21
Single application project
Kotlin DSL
kotlin.test
Yes to new APIs

Open in VS Code:Bashcode .Install extensions if prompted (Java Pack, Gradle, Kotlin).
(Optional) Upgrade Gradle via SDKMAN for the latest version:Bashcurl -s "https://get.sdkman.io" | bash
source "$HOME/.sdkman/bin/sdkman-init.sh"
sdk install gradle
Make the app interactive by adding this to build.gradle.kts (fixes input waiting issue):Kotlintasks.named<JavaExec>("run") {
    standardInput = System.`in`
}

## 5. Minimal Working Example
What it does:
An interactive console program that:

Uses java.net.http.HttpClient to call the API Ninjas Facts API.
Fetches a random interesting fact (JSON response).
Prints it cleanly.
Loops: Press Enter for next fact; type 'quit' to exit.

How to run:
Bash./gradlew run
Expected output example:
text=== Random Fact Generator - Chris Kim (Moringa Capstone) ===
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

🛠 The Prompts
1. The Roadmap Strategy
Prompt: "I'm proficient in JavaScript and Python and want to learn Kotlin to build simple console apps with API calls. Could you help me create a structured learning journey plan with 3-4 distinct learning phases, prerequisites, and specific steps?"

AI Response Summary: Suggested a 4-phase approach: (1) Syntax differences, (2) Gradle project architecture, (3) Networking/JSON, and (4) Interactive CLI apps.

Evaluation: Extremely Helpful. It provided a clear sequence and prevented me from jumping into the complexities of Android development before mastering Kotlin's core logic.

2. Conceptual Bridge (Mental Models)
Prompt: "What are the key philosophical differences between JS/Python and Kotlin? What mental models should I adjust? What are common misconceptions developers from my background have?"

AI Response Summary: Focused on Null Safety (avoiding undefined), Static Typing, and the difference between Coroutines vs. Promises/Async-Await.

Evaluation: Very Clarifying. Understanding val vs var and the ? operator early on helped prevent "Java-style" code in a Kotlin project.

3. Feature Mapping (HTTP Requests)
Prompt: "I want to understand HTTP GET requests in Kotlin. Compare how it's implemented using built-in libraries vs. fetch() in JS or requests in Python. Focus on structure, not complex code yet."

AI Response Summary: Introduced java.net.http.HttpClient (standard since Java 11) and emphasized exception handling and immutability.

Evaluation: Perfect Starting Point. By requesting a "built-in" approach first, I avoided dependency bloat (like Ktor or OkHttp) until I understood the underlying JVM mechanics.

4. Code Quality & Code Review
Prompt: "I'm a junior developer learning Kotlin. Could you review this code for quality improvements: [pasted HTTP GET attempt]. Identify code smells and explain why improvements matter in Kotlin."

AI Response Summary: Recommended URI.create(), better naming conventions, and utilizing Kotlin’s try-catch as an expression.

Evaluation: Great for Idiomatic Learning. It shifted my code from "scripting style" to robust, type-safe production style.

5. Writing Idiomatic Kotlin
Prompt: "Help me make this JSON parsing logic more idiomatic. What Kotlin features am I not taking advantage of? Show my version and the improved version side-by-side."

AI Response Summary: Introduced Scope Functions (let, run), Extension Functions, and the Elvis Operator (?:).

Evaluation: This was the "Aha!" moment where the code began to look like native Kotlin rather than translated Python.

6. Environment Troubleshooting (The "Standard Input" Wall)
Prompt: "I'm using Kotlin with Gradle. My app using readLine() doesn't wait for input when I run ./gradlew run. Why does this happen and how do I fix it?"

AI Response Summary: Explained that Gradle's forked process doesn't inherit stdin by default. Provided the specific snippet: standardInput = System.in for build.gradle.kts.

Evaluation: Critical Save. This specific configuration issue is poorly documented for beginners, and the AI saved hours of manual debugging.

📈 Learning Reflections
Static vs. Dynamic: Transitioning to Kotlin's null-safety felt restrictive at first but resulted in significantly fewer runtime crashes than my typical Python scripts.

The Build System: Coming from npm and pip, Gradle was the steepest learning curve. Using AI to explain build.gradle.kts structure was essential.

The Power of "Why": The most successful prompts were those that asked the AI to explain the philosophy behind a feature, not just provide the syntax..
## 7. Common Issues & Fixes

A.gradle init no prompts/files → Use non-interactive flags or start in a fresh empty folder.
B.Error: Could not find or load main class org.example.AppKt → Ensure mainClass = "org.example.AppKt" in build.gradle.kts and file is in correct package/folder.
C.-Xverify:none warning → Remove deprecated flags from gradle.properties.
D. API returns 400 "limit parameter is for premium" → Remove ?limit=1 (free tier defaults to 1 fact).
E. JSON parsing fails (whitespace/escapes) → Use tolerant index search + unescape \t, \n.
F.readLine() doesn't wait / infinite loop → Add standardInput = System.in`` to the run task in build.gradle.kts.
G. Network/API errors → Check internet; verify API key; test endpoint in browser/curl.

## 8. References

Official Kotlin docs: https://kotlinlang.org/docs/home.html
Java HttpClient (used in code): https://docs.oracle.com/en/java/javase/21/docs/api/java.net.http/java/net/http/HttpClient.html
API Ninjas Facts API (used here): https://api-ninjas.com/api/facts
Gradle Kotlin DSL guide: https://docs.gradle.org/current/userguide/kotlin_dsl.html
Numbers API (tried first, unreliable): http://numbersapi.com
VS Code Kotlin setup: https://kotlinlang.org/docs/command-line.html#using-the-command-line-compiler

GitHub Repo: https://github.com/vice305/firstKotlin
Author: Chris Kim
Date: February 2026, Nairobi, Kenya
Happy fact-learning! 🌟