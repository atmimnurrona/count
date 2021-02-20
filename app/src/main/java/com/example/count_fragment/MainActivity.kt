package com.example.count_fragment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_second.*
import kotlinx.android.synthetic.main.fragment_text.*

class MainActivity : AppCompatActivity(), CounterInterface {

    private lateinit var buttonFragment: ButtonFragment
    private lateinit var textFragment: TextFragment
    private var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonFragment = fragmentButton as ButtonFragment
        textFragment = fragmentText as TextFragment

    }

    fun toSecondActivity(view: View) {
        startActivity(Intent(this, SecondActivity::class.java))
    }

    override fun notifyDecrement() {
        counter = Integer.parseInt(resultText.text.toString())
        counter--
        textFragment.notif(counter)
    }

    override fun notifyIncrement() {
        counter = Integer.parseInt(resultText.text.toString())
        counter++
        textFragment.notif(counter)
    }
}