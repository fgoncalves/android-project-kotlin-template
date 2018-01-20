package com.github.fgoncalves.template.presentation.base

import android.support.annotation.LayoutRes

interface LayoutProvider {
    /**
     * The layout id that should be inflated by the container
     */
    @LayoutRes
    fun layout(): Int
}
