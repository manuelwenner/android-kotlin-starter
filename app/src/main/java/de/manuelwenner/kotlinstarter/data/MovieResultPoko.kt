package de.manuelwenner.kotlinstarter.data

data class MovieResultPoko(
    val page: Int,
    val results: List<Movie>,
    val total_pages: Int,
    val total_results: Int
)
