package com.github.fgoncalves.template.presentation.base

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LifecycleRegistry
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.DaggerFragment
import javax.inject.Inject

abstract class BaseFragment<VIEWMODEL : BaseViewModel, in VIEW : ViewDataBinding> :
        DaggerFragment(), LifecycleOwner {
    private lateinit var lifecycleRegistry: LifecycleRegistry
    @Inject
    lateinit var viewModelFactory: ViewModelFactory
        protected set

    protected lateinit var viewModel: VIEWMODEL

    protected abstract val viewModelClass: Class<VIEWMODEL>

    protected abstract val layoutResId: Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<VIEW>(inflater, layoutResId, container, false)

        viewModel = ViewModelProviders.of(this, viewModelFactory)[viewModelClass]

        lifecycleRegistry = LifecycleRegistry(this)

        lifecycle.addObserver(viewModel)

        applyBindings(binding)

        return binding.root
    }


    abstract fun applyBindings(binding: VIEW)
}
