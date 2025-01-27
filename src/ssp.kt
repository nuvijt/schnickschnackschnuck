import kotlin.random.Random

fun main() {
    val options = arrayOf("Schere", "Stein", "Papier")
    var playAgain = "j"

    println("Willkommen beim Schere-Stein-Papier-Spiel!")
    println("Wie heissen Sie?")
    var username = readLine()
    println("Hi $username")

    do {
        println("Wählen Sie (Schere, Stein, Papier): ")
        val userChoice = readLine()!!.trim()

        if (userChoice !in options) {
            println("Ungültige Wahl. Bitte wähle Schere, Stein oder Papier.")
            continue
        }

        val computerChoice = options[Random.nextInt(options.size)]
        println("Der Computer wählt: $computerChoice")

        when {
            userChoice.equals(computerChoice, ignoreCase = true) -> println("Unentschieden!")
            (userChoice.equals("Schere", ignoreCase = true) && computerChoice == "Papier") ||
                    (userChoice.equals("Stein", ignoreCase = true) && computerChoice == "Schere") ||
                    (userChoice.equals("Papier", ignoreCase = true) && computerChoice == "Stein") -> println("Du gewinnst!")
            else -> println("Der Computer gewinnt!")
        }

        println("Möchten Sie nochmal spielen? (j/n): ")
        playAgain = readLine()!!.trim()

    } while (playAgain.equals("j", ignoreCase = true))

    println("Danke fürs Spielen!")
}