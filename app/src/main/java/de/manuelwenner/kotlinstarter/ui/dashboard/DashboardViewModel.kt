package de.manuelwenner.kotlinstarter.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import de.manuelwenner.kotlinstarter.data.MovieResultPoko
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class DashboardViewModel : ViewModel() {
    private val hero: MutableLiveData<String> = MutableLiveData()

    init {
        hero.value = "Hero is warming up..."
    }

    fun getHero(): LiveData<String> {
        return hero
    }

    fun loadHero(param: String) {
//        Thread {
//            println("API Call started")
//            SystemClock.sleep(3000)
//            hero.postValue("Welcome: $param")
//        }.start()

        Thread {
            val ipAddress = "https://api.themoviedb.org/3/discover/movie?include_adult=false&include_video=false&language=en-US&page=1&sort_by=popularity.desc"
            val bearerToken = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIwYzA2MGZiZThhZmU0MTcxM2E2NDFhMjM3YjgyNTViMyIsInN1YiI6IjVkNmUyODhkYjZjMjY0MDAwZjMzNzAzZCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.5pIPrrtrFLueNNUJB_6a2w_vyfwp6XFCSR0P8-29DSU"

            try {
                // URL-Objekt erstellen
                val url = URL(ipAddress)

                // HttpURLConnection öffnen
                val connection = url.openConnection() as HttpURLConnection

                // Verbindungsparameter setzen
                connection.requestMethod = "GET"

                // Authorization Header setzen (wenn nötig)
                connection.setRequestProperty("Authorization", "Bearer $bearerToken")

                // Verbindung herstellen
                connection.connect()

                // Response-Code prüfen
                if (connection.responseCode == HttpURLConnection.HTTP_OK) {
                    // InputStream vom HttpURLConnection erhalten
                    val inputStream = connection.inputStream
                    val reader = BufferedReader(InputStreamReader(inputStream))
                    val result = reader.readLine()

                    println("API Result: $result")

                    val movieList = Gson().fromJson(result, MovieResultPoko::class.java)

                    hero.postValue(movieList.results[0].title)

                    // Verbindung schließen
                    connection.disconnect()
                } else {
                    println("Failed to make API call. Response code: ${connection.responseCode}")
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }.start()
    }
}