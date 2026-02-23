import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

fun main() {
    println("=== Random Math Fact Generator ===")
    println("Fetching a new fact...\n")

    try {
        val fact = fetchRandomMathFact()
        println("Math Fact:")
        println(fact)
    } catch (e: Exception) {
        println("Oops! Something went wrong: ${e.message}")
    }

    println("\nRun the program again for a different fact! 🚀")
}

fun fetchRandomMathFact(): String {
    // The API endpoint for a random math fact (plain text response)
    val url = "http://numbersapi.com/random/math"

    // Create HTTP client (built-in since Java 11)
    val client = HttpClient.newHttpClient()

    // Build the GET request
    val request = HttpRequest.newBuilder()
        .uri(URI.create(url))
        .GET()
        .build()

    // Send request and get response as plain String
    val response = client.send(request, HttpResponse.BodyHandlers.ofString())

    // Check if successful
    if (response.statusCode() == 200) {
        return response.body().trim()
    } else {
        throw RuntimeException("API returned status ${response.statusCode()}")
    }
}
