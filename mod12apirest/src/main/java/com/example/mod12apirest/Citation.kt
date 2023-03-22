package com.example.mod12apirest

data class Citation(
    val citation : String,
    val infos:Infos
)
data class Infos(
    val auteur : String,
    val acteur : String,
    val personnage : String,
    val saison : String,
    val episode : String
)
