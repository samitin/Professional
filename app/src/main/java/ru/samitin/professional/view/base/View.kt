package ru.samitin.professional.view.base

import ru.samitin.professional.model.data.AppState

interface View {
    fun renderData(appState:AppState)
}