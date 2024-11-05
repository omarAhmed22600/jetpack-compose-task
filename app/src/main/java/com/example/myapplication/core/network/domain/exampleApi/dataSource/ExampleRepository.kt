package com.example.myapplication.core.network.domain.exampleApi.dataSource

import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.Multipart
import javax.inject.Inject

class ExampleRepository @Inject constructor(
    private val exampleApiServices: ExampleApiServices
) {
    suspend fun getAttendanceRecords(page: Int): Response<Any?> =
        exampleApiServices.getAttendanceRecords(
            page,
            mapOf(Pair("Bear Token", "{Auth-Header}"))
        )

    suspend fun exampleMultipart(
        image: MultipartBody.Part,
        lat: Float,
        lng: Float
    ): Response<Any?> = exampleApiServices.exampleMultipart(
        image,
        lat,
        lng,
        mapOf(Pair("Bear Token", "{Auth-Header}"))
    )

    suspend fun login(
        username: String,
        password: String
    ): Response<Any?> = exampleApiServices.login(
        username, password
    )


}