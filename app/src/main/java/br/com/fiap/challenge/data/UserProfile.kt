package br.com.fiap.challenge.data

import br.com.fiap.challenge.Components.Certification

data class UserProfile(
    var nome: String = "",
    var email: String = "",
    var cargo: String = "",
    var empresa: String = "",
    var cidade: String = "",
    var estado: String = "",
    var pais: String = "",
    var estudos: String = "",
    var experienciaProfissional: String = "",
    var softSkills: String = "",
    var hardSkills: String = "",
    var idiomas: String = "",
    var nivelIdioma: String = "",
    var areasInteresse: String = "",
    var cartaSemana: String = "",
    var sobre: String = "",
    var temasMentor: String = "",
    var temasAprendiz: String = "",
    var foto: String = "",
    var certificados: String = "",
    var certifications: List<Certification> = listOf()
)