package com.github.fgoncalves.template.presentation.base


import android.os.Bundle
import com.github.fgoncalves.template.R
import dagger.android.support.DaggerAppCompatActivity

class MainActivity : DaggerAppCompatActivity(), LayoutProvider {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(layout())
    }

    override fun layout(): Int = R.layout.activity_main
}
