package com.example.myapplication.core.di

import android.content.Context
import com.example.myapplication.core.di.qualifiers.HeadersInterceptor

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import timber.log.Timber
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object OkHttpModule {

    const val TIMEOUT_IN_SEC = 30L

    private const val HEADER_KEY_LANGUAGE = "language"

    const val HEADER_KEY_AUTHORIZATION = "Authorization"

    const val HEADER_KEY_IGNORE_BASE_URL = "HEADER_KEY_IGNORE_BASE_URL"

    const val HEADER_KEY_NEW_URL = "HEADER_KEY_NEW_URL"

    @Singleton
    @Provides
    fun provideOkHttpClient(
        @HeadersInterceptor headersInterceptor: Interceptor,
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder().apply {
            connectTimeout(TIMEOUT_IN_SEC, TimeUnit.SECONDS)
            readTimeout(TIMEOUT_IN_SEC, TimeUnit.SECONDS)
            writeTimeout(TIMEOUT_IN_SEC, TimeUnit.SECONDS)

            addInterceptor(headersInterceptor)

            addNetworkInterceptor(httpLoggingInterceptor)
        }.build()
    }

    @HeadersInterceptor
    @Provides
    fun provideHeadersInterceptor(
        @ApplicationContext context: Context
    ): Interceptor {
        return Interceptor { chain ->
            val request = chain.request()

            val url = request.url.toString()


            Timber.e("Retrofit Requests URL -> $url")
            Timber.e(
                "Retrofit Request body -> ${
                    request.body?.toString()?.let { formatString(it) }
                }"
            )
            val builder = request.newBuilder()
            if (url.startsWith(RetrofitModule.BASE_URL)) {
                builder.addHeader(HEADER_KEY_LANGUAGE, "ar"/*context.getProjectCurrentLocale()*/)

                builder.addHeader("Accept", "application/json")
                //builder.addHeader("Content-Type", "application/json")

                request.header(HEADER_KEY_AUTHORIZATION)?.also {
                    builder.removeHeader(HEADER_KEY_AUTHORIZATION)
                    if (it.isNotEmpty()) {
                        builder.addHeader(HEADER_KEY_AUTHORIZATION, "Bearer $it")
                        Timber.e("bear token -> $it")
                    }
                }
                builder.addHeader("platform", "1 ")

                /*request.header(HEADER_KEY_IGNORE_BASE_URL)?.also { ignoreBaseUrl ->
                    if (ignoreBaseUrl.toBooleanStrictOrNull() == true) {
                        val newUrl = request.header(HEADER_KEY_NEW_URL).orEmpty()

                        if (ignoreBaseUrl.toBooleanStrictOrNull() == true && newUrl.isNotEmpty()) {
                            val allQueryParams = "?${url.substringAfter("?", "")}"

                            builder.url("$newUrl$allQueryParams")
                        }
                    }
                }*/
            }

            chain.proceed(builder.build())
        }
    }

    /**
     * - Used for debugging.
     */
    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor { message ->
            Timber.e("Retrofit Response -> ${formatString(message)}")
        }.also {
            it.level = HttpLoggingInterceptor.Level.BODY
        }
    }

    private fun formatString(text: String): String {
        val json = StringBuilder()
        var indentString = ""
        var inQuotes = false
        var isEscaped = false
        for (i in 0 until text.length) {
            val letter = text[i]
            when (letter) {
                '\\' -> isEscaped = !isEscaped
                '"' -> if (!isEscaped) {
                    inQuotes = !inQuotes
                }

                else -> isEscaped = false
            }
            if (!inQuotes && !isEscaped) {
                when (letter) {
                    '{', '[' -> {
                        json.append(
                            """
                            
                            $indentString$letter
                            
                            """.trimIndent()
                        )
                        indentString += "\t"
                        json.append(indentString)
                    }

                    '}', ']' -> {
                        indentString = indentString.replaceFirst("\t".toRegex(), "")
                        json.append(
                            """
                            
                            $indentString$letter
                            """.trimIndent()
                        )
                    }

                    ',' -> json.append(
                        """
                        $letter
                        $indentString
                        """.trimIndent()
                    )

                    else -> json.append(letter)
                }
            } else {
                json.append(letter)
            }
        }
        return json.toString()
    }
}
