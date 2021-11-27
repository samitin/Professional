package ru.samitin.professional.model.datasource

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class BaseInterceptor private constructor():Interceptor {

    private var responseCode:Int=0

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val response = chain.proceed(chain.request())
        responseCode=response.code()
        return response
    }
    fun getResponseCode(): ServerResponseStatusCode{
        var statusCode=ServerResponseStatusCode.UNDEFINED_ERROR
        when(responseCode/100){
            1-> statusCode=ServerResponseStatusCode.INFO
            2-> statusCode=ServerResponseStatusCode.SUCCESS
            3-> statusCode=ServerResponseStatusCode.REDIRECTION
            4-> statusCode=ServerResponseStatusCode.CLIENT_ERROR
            5-> statusCode=ServerResponseStatusCode.SERVER_ERROR
        }
        return statusCode
    }

    enum class ServerResponseStatusCode{
        INFO,//ИНФОРМАЦИЯ
        SUCCESS,//УСПЕХ
        REDIRECTION,//Перенаправление
        CLIENT_ERROR,//Ошибка клиента
        SERVER_ERROR,//Ошибка сервера
        UNDEFINED_ERROR//Неопределённая ошибка
    }
    companion object{
        val interceptor:BaseInterceptor
        get() = BaseInterceptor()
    }
}