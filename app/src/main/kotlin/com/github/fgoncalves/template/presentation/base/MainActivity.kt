package com.github.fgoncalves.template.presentation.base


import android.os.Bundle
import android.support.v4.view.GravityCompat
import com.github.fgoncalves.pathmanager.ScreenNavigator
import com.github.fgoncalves.template.R
import com.github.fgoncalves.template.presentation.home.HomeScreen
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var screenNavigator: ScreenNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        setupDrawer()

        screenNavigator.single(HomeScreen.newInstance())
    }

    override fun onBackPressed() {
        if (!screenNavigator.back()) finish()
    }

    private fun setupDrawer() {
        drawer?.run {
            setNavigationItemSelectedListener {
                drawer_layout?.closeDrawer(GravityCompat.START)
                it.isChecked = false
                true
            }
        }
    }
}
