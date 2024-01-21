package com.aytachuseynli.energyappui.common.utils

import android.view.View

object Extensions {

    fun View.visible(){
        this.visibility = View.VISIBLE
    }

    fun View.gone(){
        this.visibility = View.GONE
    }

    fun<T> applyToAll(vararg objects : T, action: T.() -> Unit){
        objects.forEach {obj ->
            action.invoke(obj)
        }
    }
    fun List<View>.goneEach(){
        this.forEach{
            it.gone()
        }
    }

    fun List<View>.visibleEach(){
        this.forEach{
            it.visible()
        }
    }
}