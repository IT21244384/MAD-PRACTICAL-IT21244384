package lab01.part2.q2

import kotlin.math.sqrt

// Part 02 - Q2: interface Shape with setup() and draw(); each shape overrides them.

interface Shape {
    fun setup()
    fun draw()
}

class Circle(private val radius: Double) : Shape {
    private var area = 0.0

    override fun setup() {
        area = 3.14 * radius * radius
        println("Circle setup: radius = $radius, area = $area")
    }

    override fun draw() {
        println("Drawing a round circle")
    }
}

class Rectangle(private val width: Double, private val height: Double) : Shape {
    private var area = 0.0

    override fun setup() {
        area = width * height
        println("Rectangle setup: $width x $height, area = $area")
    }

    override fun draw() {
        println("Drawing a rectangle with four right angles")
    }
}

class Triangle(private val a: Double, private val b: Double, private val c: Double) : Shape {
    private var perimeter = 0.0

    override fun setup() {
        perimeter = a + b + c
        val s = perimeter / 2
        val area = sqrt(s * (s - a) * (s - b) * (s - c))
        println("Triangle setup: sides $a, $b, $c, perimeter = $perimeter, area = $area")
    }

    override fun draw() {
        println("Drawing a triangle with three sides")
    }
}

fun main() {
    val shapes: List<Shape> = listOf(Circle(5.0), Rectangle(4.0, 6.0), Triangle(3.0, 4.0, 5.0))

    for (shape in shapes) {
        shape.setup()
        shape.draw()
        println()
    }
}
