package ru.samitin.professional.presenter


import ru.samitin.professional.model.data.AppState
import ru.samitin.professional.view.base.View

interface Presenter <T:AppState,V: View>{
    fun attachView(view:V)
    fun detachView(View : V)
    fun getData(word:String,isOnline: Boolean)
}