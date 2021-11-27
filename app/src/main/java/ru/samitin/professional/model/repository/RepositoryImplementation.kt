package ru.samitin.professional.model.repository

import io.reactivex.Observable
import ru.samitin.professional.model.data.DataModel
import ru.samitin.professional.model.datasource.DataSource

class RepositoryImplementation(private val dataSource: DataSource<List<DataModel>>):
Repository<List<DataModel>>{

    override fun getData(word: String): Observable<List<DataModel>> {
        return dataSource.getData(word)
    }
}