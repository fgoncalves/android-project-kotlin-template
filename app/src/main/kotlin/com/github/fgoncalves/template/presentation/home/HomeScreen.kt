package com.github.fgoncalves.template.presentation.home

import com.github.fgoncalves.template.R
import com.github.fgoncalves.template.databinding.HomeBinding
import com.github.fgoncalves.template.presentation.base.BaseFragment

class HomeScreen : BaseFragment<HomeViewModel, HomeBinding>() {
    override val viewModelClass: Class<HomeViewModel> = HomeViewModel::class.java

    override val layoutResId: Int = R.layout.home

    override fun applyBindings(binding: HomeBinding) {
        binding.viewModel = viewModel
    }

    companion object {
        fun newInstance(): HomeScreen = HomeScreen()
    }
}
