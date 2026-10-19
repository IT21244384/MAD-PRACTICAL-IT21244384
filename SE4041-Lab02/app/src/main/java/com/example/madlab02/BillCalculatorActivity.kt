package com.example.madlab02

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class BillCalculatorActivity : AppCompatActivity() {

    private lateinit var edtUnits: EditText
    private lateinit var btnCalculate: Button
    private lateinit var tvBill: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bill_calculator)

        edtUnits = findViewById(R.id.edtUnits)
        btnCalculate = findViewById(R.id.btnCalculate)
        tvBill = findViewById(R.id.tvBill)

        btnCalculate.setOnClickListener {
            calculate()
        }
    }

    private fun calculate() {
        val units = edtUnits.text.toString().trim().toIntOrNull()

        if (units == null) {
            Toast.makeText(this, R.string.units_required, Toast.LENGTH_SHORT).show()
            return
        }

        val bill = BillCalculator.calculateBill(units)

        // Show the result in the "Electricity Bill:" text field
        tvBill.text = getString(R.string.electricity_bill_result, String.format("%.2f", bill))
    }
}
