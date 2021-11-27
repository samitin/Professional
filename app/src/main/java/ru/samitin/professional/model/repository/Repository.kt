package ru.samitin.professional.model.repository

import io.reactivex.Observable

interface Repository<T> {
    fun getData(word: String):Observable<T>
}