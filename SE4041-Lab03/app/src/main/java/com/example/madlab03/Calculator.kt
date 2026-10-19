package com.example.madlab03

/** Pure calculator logic (no Android classes) so it is easy to test. */
object Calculator {

    enum class Operation { ADD, SUBTRACT, MULTIPLY, DIVIDE }

    /** Returns the result, or null when dividing by zero. */
    fun calculate(a: Double, b: Double, operation: Operation): Double? = when (operation) {
        Operation.ADD -> a + b
        Operation.SUBTRACT -> a - b
        Operation.MULTIPLY -> a * b
        Operation.DIVIDE -> if (b == 0.0) null else a / b
    }
}
