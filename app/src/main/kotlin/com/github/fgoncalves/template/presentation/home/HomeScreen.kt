package com.github.fgoncalves.template.presentation.home

import android.support.v7.widget.Toolbar
import com.github.fgoncalves.template.R
import com.github.fgoncalves.template.databinding.HomeBinding
import com.github.fgoncalves.template.presentation.base.BaseFragment
import kotlinx.android.synthetic.main.home.*

class HomeScreen : BaseFragment<HomeViewModel, HomeBinding>() {
    override val viewModelClass: Class<HomeViewModel> = HomeViewModel::class.java

    override val layoutResId: Int = R.layout.home

    override fun applyBindings(binding: HomeBinding) {
        binding.viewModel = viewModel
    }

    companion object {
        fun newInstance(): HomeScreen = HomeScreen()
    }

    override fun toolbar(): Toolbar? = home_toolbar

    override fun toolbarTitle(): String = context?.getString(R.string.home_tool_bar_title)!!
}
