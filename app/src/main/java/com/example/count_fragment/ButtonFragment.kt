package com.example.count_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_button.*

class ButtonFragment : Fragment(), View.OnClickListener {

private lateinit var counterHandler : CounterInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        counterHandler = activity as CounterInterface
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_button, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        min.setOnClickListener(this)
        plus.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v) {
            plus -> {
                counterHandler.notifyIncrement()
            }
            min -> {
                counterHandler.notifyDecrement()
            }
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() = ButtonFragment()
    }
}
