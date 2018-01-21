package com.github.fgoncalves.template.presentation.base

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LifecycleRegistry
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.Toolbar
import android.view.*
import com.github.fgoncalves.template.R
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.activity_main.*
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

    override fun onResume() {
        super.onResume()

        val mainActivity: MainActivity = activity as MainActivity
        val drawer_layout = mainActivity.drawer_layout
        val supportsDrawer = supportsDrawer()

        if (supportsDrawer) {
            drawer_layout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED, Gravity.START)
        } else {
            drawer_layout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED, Gravity.START)
        }

        toolbar()?.run {
            mainActivity.setSupportActionBar(this)
            mainActivity.supportActionBar?.title = toolbarTitle()

            if (supportsDrawer) {
                val toggle = ActionBarDrawerToggle(mainActivity, drawer_layout, this, R.string.open_drawer,
                        R.string.close_drawer)

                drawer_layout.addDrawerListener(toggle)
                toggle.syncState()
            } else {
                mainActivity.supportActionBar?.setDisplayHomeAsUpEnabled(supportsHomeButton())
            }
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setHasOptionsMenu(true)
    }

    abstract fun applyBindings(binding: VIEW)

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        menuResource()?.let { inflater?.inflate(it, menu) }
    }

    open fun menuResource(): Int? = null

    open fun supportsHomeButton(): Boolean = false

    open fun supportsDrawer(): Boolean = false

    open fun toolbar(): Toolbar? = null

    open fun toolbarTitle(): String = ""
}
