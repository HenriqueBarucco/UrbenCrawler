package com.henriquebarucco.urben.application.utils

import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

class PictureDownloader {
    companion object {
        fun download(url: String): ByteArray {
            val connection = URL(url).openConnection() as HttpURLConnection
            connection.requestMethod = "GET"
            connection.doInput = true

            return connection.inputStream.use { inputStream ->
                readBytesFromStream(inputStream)
            }
        }

        private fun readBytesFromStream(inputStream: InputStream): ByteArray {
            val buffer = ByteArray(1024)
            val outputStream = ByteArrayOutputStream()
            var bytesRead: Int

            while (inputStream.read(buffer).also { bytesRead = it } != -1) {
                outputStream.write(buffer, 0, bytesRead)
            }

            return outputStream.toByteArray()
        }
    }
}
