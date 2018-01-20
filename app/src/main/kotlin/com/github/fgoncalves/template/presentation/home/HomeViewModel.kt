package com.github.fgoncalves.template.presentation.home

import android.databinding.ObservableField
import com.github.fgoncalves.template.presentation.base.BaseViewModel
import javax.inject.Inject

abstract class HomeViewModel : BaseViewModel() {
    abstract val text: ObservableField<String>
}

class HomeViewModelImpl @Inject constructor() : HomeViewModel() {
    override val text: ObservableField<String> = ObservableField("This is the home screen")
}
