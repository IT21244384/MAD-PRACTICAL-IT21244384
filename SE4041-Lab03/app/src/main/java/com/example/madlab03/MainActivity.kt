package com.example.madlab03

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/** Hosts the fragments: InputFragment first, AnswerFragment on its own screen. */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Only add on a fresh start; after rotation the FragmentManager restores them
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, InputFragment())
                .commit()
        }
    }
}
