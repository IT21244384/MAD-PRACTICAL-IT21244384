package com.example.madlab02

/**
 * Bill = Fixed Charge + Energy Charge + Service Charge + VAT
 *
 *  - Fixed charge : 150 LKR
 *  - Energy charge: units x 29 LKR (unit cost)
 *  - Service charge: NOT given on the lab sheet, so it is a constant set to 0.0.
 *                    Change SERVICE_CHARGE if your lecturer gives a value.
 *  - VAT          : 15 % of (fixed + energy + service)
 */
object BillCalculator {
    const val FIXED_CHARGE = 150.0
    const val UNIT_COST = 29.0
    const val SERVICE_CHARGE = 0.0
    const val VAT_RATE = 0.15

    fun calculateBill(units: Int): Double {
        val energyCharge = units * UNIT_COST
        val subTotal = FIXED_CHARGE + energyCharge + SERVICE_CHARGE
        val vat = subTotal * VAT_RATE
        return subTotal + vat
    }
}
