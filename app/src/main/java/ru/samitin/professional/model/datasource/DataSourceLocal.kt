package ru.samitin.professional.model.datasource

import io.reactivex.Observable
import ru.samitin.professional.model.data.DataModel

class DataSourceLocal(private val remoteProvider:RoomDataBaseImplementation= RoomDataBaseImplementation())
    :DataSource<List<DataModel>>{
    override fun getData(word: String): Observable<List<DataModel>> =remoteProvider.getData(word)
}