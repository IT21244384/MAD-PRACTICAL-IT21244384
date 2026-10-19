package lab01.part2.q1

// Part 02 - Q1: abstract class Employee with two subclasses.

abstract class Employee(val id: Int, val name: String) {

    // Every employee type calculates its monthly pay differently
    abstract fun calculateMonthlyPay(): Double

    fun showDetails() {
        println("Employee #$id - $name")
    }
}

class TemporaryStaff(
    id: Int,
    name: String,
    val hourlyRate: Double,
    val hoursWorked: Int,
    val contractEndDate: String
) : Employee(id, name) {

    override fun calculateMonthlyPay(): Double = hourlyRate * hoursWorked

    fun contractInfo() {
        println("Temporary staff - contract ends on $contractEndDate")
    }
}

class PermanentStaff(
    id: Int,
    name: String,
    val monthlySalary: Double,
    val annualLeaveDays: Int
) : Employee(id, name) {

    override fun calculateMonthlyPay(): Double = monthlySalary

    fun leaveInfo() {
        println("Permanent staff - $annualLeaveDays annual leave days")
    }
}

fun main() {
    val temp = TemporaryStaff(1, "Nimal", hourlyRate = 850.0, hoursWorked = 120, contractEndDate = "2026-12-31")
    val perm = PermanentStaff(2, "Kamali", monthlySalary = 150000.0, annualLeaveDays = 21)

    temp.showDetails()
    temp.contractInfo()
    println("Monthly pay: ${temp.calculateMonthlyPay()}")
    println()

    perm.showDetails()
    perm.leaveInfo()
    println("Monthly pay: ${perm.calculateMonthlyPay()}")
}
