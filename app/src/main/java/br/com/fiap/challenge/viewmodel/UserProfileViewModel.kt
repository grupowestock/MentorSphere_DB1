package br.com.fiap.challenge.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.fiap.challenge.Components.Certification
import br.com.fiap.challenge.data.StepsCardData
import br.com.fiap.challenge.data.UserProfile

class UserProfileViewModel : ViewModel() {
    private val _userProfile = MutableLiveData(UserProfile())
    val userProfile: LiveData<UserProfile> = _userProfile
    private val _cartaSemana = MutableLiveData<StepsCardData?>()
    val cartaSemana: LiveData<StepsCardData?> get() = _cartaSemana

    fun updateName(newName: String) {
        _userProfile.value = _userProfile.value?.copy(nome = newName)
    }

    fun updateEmail(newEmail: String) {
        _userProfile.value = _userProfile.value?.copy(email = newEmail)
    }

    fun updateJob(newJob: String) {
        _userProfile.value = _userProfile.value?.copy(cargo = newJob)
    }

    fun updateCompany(newCompany: String) {
        _userProfile.value = _userProfile.value?.copy(empresa = newCompany)
    }

    fun updateCity(newCity: String) {
        _userProfile.value = _userProfile.value?.copy(cidade = newCity)
    }

    fun updateEstado(newState: String) {
        _userProfile.value = _userProfile.value?.copy(estado = newState)
    }

    fun updateCountry(newCountry: String) {
        _userProfile.value = _userProfile.value?.copy(pais = newCountry)
    }

    fun updateStudy(newStudy: String) {
        _userProfile.value = _userProfile.value?.copy(estudos = newStudy)
    }

    fun updateProfessionalExperience(newProfessionalExperience: String) {
        _userProfile.value = _userProfile.value?.copy(experienciaProfissional = newProfessionalExperience)
    }

    fun updateSoftSkills(newSoftSkills: String) {
        _userProfile.value = _userProfile.value?.copy(softSkills = newSoftSkills)
    }

    fun updateHardSkills(newHardSkills: String) {
        _userProfile.value = _userProfile.value?.copy(hardSkills = newHardSkills)
    }

    fun updateLanguage(newLanguage: String) {
        _userProfile.value = _userProfile.value?.copy(idiomas = newLanguage)
    }

    fun updateLevel(newLevel: String) {
        _userProfile.value = _userProfile.value?.copy(nivelIdioma = newLevel)
    }

    fun updateInterestAreas(newInterestAreas: String) {
        _userProfile.value = _userProfile.value?.copy(areasInteresse = newInterestAreas)
    }

    fun updateCard(newCard: String) {
        _userProfile.value = _userProfile.value?.copy(cartaSemana = newCard)
    }

    fun updateAbout(newAbout: String) {
        _userProfile.value = _userProfile.value?.copy(sobre = newAbout)
    }

    fun updateMentorThemes(newMentorThemes: String) {
        _userProfile.value = _userProfile.value?.copy(temasMentor = newMentorThemes)
    }

    fun updateApprenticeThemes(newApprenticeThemes: String) {
        _userProfile.value = _userProfile.value?.copy(temasAprendiz = newApprenticeThemes)
    }

    fun updatePhoto(newPhoto: String) {
        _userProfile.value = _userProfile.value?.copy(foto = newPhoto)
    }

    fun updateCartaSemana(card: StepsCardData) {
        _cartaSemana.value = card
    }

    fun updateCertificados(newCertificados: String) {
        _userProfile.value = _userProfile.value?.copy(certificados = newCertificados)
    }

    fun addCertification(certification: Certification) {
        val currentList = _userProfile.value?.certifications ?: listOf()
        _userProfile.value = _userProfile.value?.copy(certifications = currentList + certification)
    }

    fun removeCertification(certification: Certification) {
        val currentList = _userProfile.value?.certifications ?: listOf()
        _userProfile.value = _userProfile.value?.copy(certifications = currentList - certification)
    }
}
