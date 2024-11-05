package com.example.myapplication.core.network.domain.exampleApi.dataSource

import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Query

interface ExampleApiServices {
    /**
     * multi-part for images
     */
    @Multipart
    @POST("")
    suspend fun exampleMultipart(
        @Part image: MultipartBody.Part,
        @Part("lat") lat: Float,
        @Part("lng") lng: Float,
        @HeaderMap headerMap: Map<String, String>,
    ): Response<Any?>
    /**
     * normal GET call with query parameter
     */
    @GET("")
    suspend fun getAttendanceRecords(
        @Query("page") page: Int,
        @HeaderMap headerMap: Map<String, String>,
    ): Response<Any?>
    /**
     * normal post method with FormUrlEncoded
     */
    @FormUrlEncoded
    @POST("")
    suspend fun login(
        @Field("username") username: String,
        @Field("password") password: String
    ): Response<Any?>
}