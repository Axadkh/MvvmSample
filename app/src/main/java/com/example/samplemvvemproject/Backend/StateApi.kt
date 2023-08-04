package com.example.samplemvvemproject.Backend


public sealed class StateApi<T>(val data: T? = null, open val message: String? = null) {

    class Success<T>(data: T) : StateApi<T>(data)
    sealed class Error<T> : StateApi<T>() {
        class InternalError<T>(override val message: String) : Error<T>()
        class ConnectionError<T>(override val message: String) : Error<T>()
        class ServerError<T>(override val message: String) : Error<T>()
        class UnknownError<T>(override val message: String) : Error<T>()
        class TimeOut<T>(override val message: String) : Error<T>()
    }
}



