package lab01.part1.q1

// Part 01 - Q1: whoAmI returns the type of the parameter passed to it.
fun whoAmI(value: Any?): String = when (value) {
    null -> "Null"
    is Int -> "Int"
    is Long -> "Long"
    is Double -> "Double"
    is Float -> "Float"
    is Boolean -> "Boolean"
    is Char -> "Char"
    is String -> "String"
    is List<*> -> "List"
    is Set<*> -> "Set"
    is Map<*, *> -> "Map"
    is Array<*> -> "Array"
    else -> value::class.simpleName ?: "Unknown"
}

fun main() {
    println("42            -> ${whoAmI(42)}")
    println("9876543210L   -> ${whoAmI(9876543210L)}")
    println("3.14          -> ${whoAmI(3.14)}")
    println("2.5f          -> ${whoAmI(2.5f)}")
    println("true          -> ${whoAmI(true)}")
    println("'K'           -> ${whoAmI('K')}")
    println("\"Kotlin\"      -> ${whoAmI("Kotlin")}")
    println("listOf(1,2,3) -> ${whoAmI(listOf(1, 2, 3))}")
    println("setOf(1,2)    -> ${whoAmI(setOf(1, 2))}")
    println("mapOf(1 to 2) -> ${whoAmI(mapOf(1 to 2))}")
    println("null          -> ${whoAmI(null)}")
}
