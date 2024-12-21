package com.henriquebarucco.urben.infrastructure.external.http.easywhatsapp

import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File
import java.io.IOException

class EasyWhatsAppCustom(
    private val url: String,
    private val endpoint: String,
) {
    fun sendPhoto(
        token: String,
        phone: String,
        photo: ByteArray,
        name: String,
    ) {
        val client = OkHttpClient()
        val mediaType = "image/jpeg".toMediaTypeOrNull()

        val tempFile = File.createTempFile("image", ".jpg")
        tempFile.writeBytes(photo)

        val requestBody =
            MultipartBody
                .Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("phone", phone)
                .addFormDataPart("file", tempFile.name, tempFile.asRequestBody(mediaType))
                .addFormDataPart("caption", name.replace(".jpg", ""))
                .build()

        val request =
            Request
                .Builder()
                .url("$url$endpoint")
                .post(requestBody)
                .addHeader("Token", token)
                .addHeader("Content-Type", "multipart/form-data")
                .build()

        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) {
                throw IOException("Unexpected code $response")
            }
        }
    }
}
