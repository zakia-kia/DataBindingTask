package com.zakia.idn.databindingtask.common
import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import androidx.lifecycle.ViewModel

open class FoodsBaseViewModel : ViewModel(), Observable {
    //open = bisa di akses ke mana aj tapi satu family, viewmodel
    private val callbacks: PropertyChangeRegistry = PropertyChangeRegistry()

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback) {
        callbacks.remove(callback)
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback) {
        callbacks.add(callback)
    }

    fun notifyPropertyChanged(position : Int){
        callbacks.notifyCallbacks(this, position, null)
    }

}