package lab01.part1.q4

// Part 01 - Q4: store 5 names and print them with their index using a for loop.
fun main() {
    val names = listOf("Nimal", "Kamali", "Sunil", "Dilani", "Ravindu")

    for (index in names.indices) {
        println("$index: ${names[index]}")
    }
}
