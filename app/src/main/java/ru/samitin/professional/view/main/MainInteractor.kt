package ru.samitin.professional.view.main

import io.reactivex.Observable
import ru.samitin.professional.model.data.AppState
import ru.samitin.professional.model.data.DataModel
import ru.samitin.professional.model.repository.Repository
import ru.samitin.professional.presenter.Interactor

class MainInteractor(
    private val remoteRepository:Repository<List<DataModel>>,
    private val localRepository:Repository<List<DataModel>>
) :Interactor<AppState>{
    override fun getData(word: String, fromRemoteSource: Boolean): Observable<AppState> {
        return if(fromRemoteSource){
            remoteRepository.getData(word).map { AppState.Success(it) }
        }else{
            localRepository.getData(word).map { AppState.Success(it) }
        }
    }
}