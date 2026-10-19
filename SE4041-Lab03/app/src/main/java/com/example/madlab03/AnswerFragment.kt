package com.example.madlab03

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

/** Dedicated answer screen. */
class AnswerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_answer, container, false)

        val answer = requireArguments().getDouble(ARG_ANSWER)
        rootView.findViewById<TextView>(R.id.tvAnswer).text =
            getString(R.string.answer_format, answer.toString())

        rootView.findViewById<Button>(R.id.btnBack).setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        return rootView
    }

    companion object {
        private const val ARG_ANSWER = "answer"

        fun newInstance(answer: Double) = AnswerFragment().apply {
            arguments = Bundle().apply { putDouble(ARG_ANSWER, answer) }
        }
    }
}
