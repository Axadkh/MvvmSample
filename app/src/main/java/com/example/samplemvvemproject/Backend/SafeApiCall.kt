package com.enterkomug.justlo_package.webServices


import com.example.samplemvvemproject.Backend.StateApi
import retrofit2.Response
import java.net.SocketTimeoutException
import java.net.UnknownHostException


abstract class SafeApiCall {


    suspend fun <T : Any> safeCall(apiCall: suspend () -> Response<T>): StateApi<T>? {
        try {

            val response = apiCall()

            return if (response.isSuccessful) {

                val responseBody = response.body()

                 responseBody?.let { StateApi.Success(it) }

            }
            else if (response.code() == 500) {

                 StateApi.Error.InternalError("An unexpected error occurredAn")
            }
            else {
                 StateApi.Error.ServerError(response.errorBody().toString())

            }
        } catch (ex: Exception) {

            return if (ex is UnknownHostException) {
                StateApi.Error.ConnectionError("No internet connection ")

            } else if (ex is SocketTimeoutException) {
                StateApi.Error.TimeOut("Time out Retry")
            } else {
                StateApi.Error.UnknownError(" ${ex.localizedMessage}")
            }
        }

    }

}
