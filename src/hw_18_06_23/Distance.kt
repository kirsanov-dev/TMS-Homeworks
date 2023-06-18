package hw_18_06_23

import java.awt.Point
import java.lang.Math.pow
import kotlin.math.abs
import kotlin.math.sqrt

// Дан data class Circle(val center: Point, val radius: Double) {}
///**
// * Простая (2 балла)
// *
// * Рассчитать расстояние между двумя окружностями.
// * Расстояние между непересекающимися окружностями рассчитывается как
// * расстояние между их центрами минус сумма их радиусов.
// * Расстояние между пересекающимися окружностями считать равным 0.0.
// */

fun main() {
    val circleOne: Circle = Circle(Point(0,0),5.0)
    val circleTwo: Circle = Circle(Point(15,20),3.0)
    val output = """
        Distance between circle (${circleOne.toString()}) 
        and circle (${circleTwo.toString()}) 
        is ${circleOne.distance(circleTwo)}
    """
    println(output.trimIndent())
}

data class Circle(val center: Point, val radius: Double) {

    fun distance(other: Circle): Double {
        val distanceBetweenCentres = sqrt(pow((this.center.getX() - other.center.getX()), 2.0) + pow((this.center.getY() - other.center.getY()), 2.0))
        val sumOfRadiuses = this.radius + other.radius

        if (distanceBetweenCentres > sumOfRadiuses) {
            return abs(distanceBetweenCentres - sumOfRadiuses)
        }

        return 0.0
    }

    override fun toString(): String {
        return "x = ${this.center.x}, y = ${this.center.y}, r = ${this.radius}"
    }
}

