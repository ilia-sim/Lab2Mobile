package com.example.lab1mobile.model

data class Artwork(
    val id: Long,
    val title: String,
    val artist: String,
    val year: Int,
    val medium: String,
    val dimensions: String,
    val imageUrl: String? = null,
    val isOnDisplay: Boolean = false
)