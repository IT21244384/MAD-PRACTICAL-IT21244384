package com.example.madlab03

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment

/** Main screen: two numbers and the four operation buttons. */
class InputFragment : Fragment() {

    private lateinit var edtNumber1: EditText
    private lateinit var edtNumber2: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_input, container, false)

        edtNumber1 = rootView.findViewById(R.id.edtNumber1)
        edtNumber2 = rootView.findViewById(R.id.edtNumber2)

        rootView.findViewById<Button>(R.id.btnAdd).setOnClickListener {
            calculate(Calculator.Operation.ADD)
        }
        rootView.findViewById<Button>(R.id.btnSubtract).setOnClickListener {
            calculate(Calculator.Operation.SUBTRACT)
        }
        rootView.findViewById<Button>(R.id.btnMultiply).setOnClickListener {
            calculate(Calculator.Operation.MULTIPLY)
        }
        rootView.findViewById<Button>(R.id.btnDivide).setOnClickListener {
            calculate(Calculator.Operation.DIVIDE)
        }

        return rootView
    }

    private fun calculate(operation: Calculator.Operation) {
        val text1 = edtNumber1.text.toString().trim()
        val text2 = edtNumber2.text.toString().trim()

        if (text1.isEmpty() || text2.isEmpty()) {
            toast(R.string.enter_both_numbers)
            return
        }

        val a = text1.toDoubleOrNull()
        val b = text2.toDoubleOrNull()
        if (a == null || b == null) {
            toast(R.string.invalid_number)
            return
        }

        val result = Calculator.calculate(a, b, operation)
        if (result == null) {
            toast(R.string.divide_by_zero)
            return
        }

        // Show the answer on its own screen; Back returns here with the inputs intact
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, AnswerFragment.newInstance(result))
            .addToBackStack(null)
            .commit()
    }

    private fun toast(message: Int) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}
