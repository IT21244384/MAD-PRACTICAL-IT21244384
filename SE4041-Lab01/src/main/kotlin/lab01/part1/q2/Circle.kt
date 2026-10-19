package lab01.part1.q2

// Part 01 - Q2: circumference and area of a circle (PI = 3.14).
const val PI = 3.14

fun circumference(radius: Double): Double = 2 * PI * radius

fun area(radius: Double): Double = PI * radius * radius

fun main() {
    val radius = 7.0
    println("Radius        = $radius")
    println("Circumference = ${circumference(radius)}")
    println("Area          = ${area(radius)}")
}
