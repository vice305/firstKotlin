package org.example

import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

fun main() {
    println("=== Random Fact Generator -(Moringa Capstone) ===")
    println("Press Enter to get a new fact")
    println("Type 'quit' or 'exit' and press Enter to stop")

    val reader = java.io.BufferedReader(java.io.InputStreamReader(System.`in`))

    while (true) {
        print("→ Press Enter for next fact... ")
        val input = reader.readLine()?.trim() ?: ""

        if (input.equals("quit", ignoreCase = true) || input.equals("exit", ignoreCase = true)) {
            println("\nThanks for using the Fact Generator! Goodbye 👋")
            break
        }

        if (input.isNotEmpty()) {
            println("Unknown command. Just press Enter for next fact, or type 'quit' to exit.")
            continue
        }

        println("\nFetching a random interesting fact...\n")

        try {
            val fact = fetchRandomFact()
            println("Random Fact:")
            println(fact)
            println()
        } catch (e: Exception) {
            println("Error fetching fact: ${e.message ?: "Unknown error"}")
            println("Full error: ${e.javaClass.simpleName}")
        }
    }
}

fun fetchRandomFact(): String {
    val apiUrl = "https://api.api-ninjas.com/v1/facts"

    val apiKey = "WuQfAYctqEg8VyAxxrHilBc62oIX77VDnxWVi3Xo"  // ← your real key

    val client = HttpClient.newBuilder()
        .followRedirects(HttpClient.Redirect.NORMAL)
        .build()

    val request = HttpRequest.newBuilder()
        .uri(URI.create(apiUrl))
        .header("X-Api-Key", apiKey)
        .GET()
        .build()

    val response = client.send(request, HttpResponse.BodyHandlers.ofString())

    if (response.statusCode() == 200) {
        val json = response.body().trim()  // remove leading/trailing whitespace
        println("Raw JSON from API: $json")  // keep for debug, remove later

        // Find start of "fact" value (more tolerant to spaces)
        val keyIndex = json.indexOf("\"fact\"")
        if (keyIndex == -1) {
            throw RuntimeException("No 'fact' key found in JSON: $json")
        }

        // Skip to after the colon and opening quote
        var valueStart = json.indexOf(":", keyIndex) + 1
        while (valueStart < json.length && json[valueStart].isWhitespace()) valueStart++
        if (json[valueStart] != '"') {
            throw RuntimeException("Expected quote after colon: $json")
        }
        valueStart++  // skip opening "

        // Find closing quote, handling escaped quotes
        var valueEnd = valueStart
        while (valueEnd < json.length) {
            if (json[valueEnd] == '"' && json[valueEnd - 1] != '\\') {
                break
            }
            valueEnd++
        }
        if (valueEnd >= json.length || json[valueEnd] != '"') {
            throw RuntimeException("Unclosed string in JSON: $json")
        }

        var fact = json.substring(valueStart, valueEnd)

        // Unescape JSON escapes
        fact = fact.replace("\\\"", "\"")
                   .replace("\\\\", "\\")
                   .replace("\\t", " ")  // convert tab to space for clean output
                   .replace("\\n", " ")
                   .trim()

        return fact
    } else {
        throw RuntimeException("API error - status ${response.statusCode()}: ${response.body()}")
    }
}