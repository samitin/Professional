package ru.samitin.professional.model.datasource

import io.reactivex.Observable
import ru.samitin.professional.model.data.DataModel

class RoomDataBaseImplementation : DataSource<List<DataModel>> {
    override fun getData(word: String): Observable<List<DataModel>> {
        TODO("Not yet implemented")
    }

}