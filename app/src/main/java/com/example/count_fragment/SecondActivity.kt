package com.example.count_fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity(), View.OnClickListener, CounterInterface {

    private lateinit var buttonFragment: ButtonFragment
    private lateinit var textFragment: TextFragment
    private var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        toFragmentButton.setOnClickListener(this)
        toFragmentText.setOnClickListener(this)

        buttonFragment = ButtonFragment()
        textFragment = TextFragment()

        supportFragmentManager.beginTransaction().add(R.id.fragContainer, buttonFragment).commit()

    }

    private fun switchFragment(fragment : Fragment) {
        supportFragmentManager.beginTransaction().add(R.id.fragContainer, fragment).commit()

    }

    override fun onClick(v: View) {
        when(v) {
            toFragmentButton -> {
                switchFragment(buttonFragment)
            }
            toFragmentText -> {
                textFragment.counter = counter
                switchFragment(textFragment)
            }
        }
    }

    override fun notifyDecrement() {
        counter -= 1
    }

    override fun notifyIncrement() {
        counter += 1
    }
}