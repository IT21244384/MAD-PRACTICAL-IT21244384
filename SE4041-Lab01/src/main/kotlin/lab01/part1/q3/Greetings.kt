package lab01.part1.q3

// Part 01 - Q3: greeting + driving licence eligibility (age limit 18).
const val LICENSE_AGE_LIMIT = 18

fun greetings(name: String, age: Int) {
    println("Hello $name! You are $age years old.")

    if (age >= LICENSE_AGE_LIMIT) {
        println("You are eligible to apply for a driving license.")
    } else {
        val yearsLeft = LICENSE_AGE_LIMIT - age
        println("Sorry $name, you are not eligible to apply for a driving license yet.")
        println("You can apply in $yearsLeft year(s).")
    }
}

fun main() {
    greetings("Nimal", 25)
    println()
    greetings("Kamali", 17)
    println()
    greetings("Sunil", 18)
}
