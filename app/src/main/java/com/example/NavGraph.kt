package com.example

import kotlinx.serialization.Serializable

@Serializable
sealed class Screen {
    @Serializable
    data object Landing : Screen()
    
    @Serializable
    data class ChapterDetail(val chapterId: String) : Screen()
    
    @Serializable
    data object AppendixList : Screen()
    
    @Serializable
    data class AppendixDetail(val appendixId: String) : Screen()
    
    @Serializable
    data object Glossary : Screen()
}
