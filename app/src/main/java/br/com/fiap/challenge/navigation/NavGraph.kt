package br.com.fiap.challenge.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import br.com.fiap.challenge.Screens.AbordagemScreen
import br.com.fiap.challenge.Screens.AprendizScreen
import br.com.fiap.challenge.Screens.CardSelectionScreen
import br.com.fiap.challenge.Screens.CardWeekScreen
import br.com.fiap.challenge.Screens.CargoScreen
import br.com.fiap.challenge.Screens.CartaScreen
import br.com.fiap.challenge.Screens.CertificadosScreen
import br.com.fiap.challenge.Screens.CidadeScreen
import br.com.fiap.challenge.Screens.DadosScreen
import br.com.fiap.challenge.Screens.DashboardScreen
import br.com.fiap.challenge.Screens.EmailScreen
import br.com.fiap.challenge.Screens.EmpresaScreen
import br.com.fiap.challenge.Screens.EstadoScreen
import br.com.fiap.challenge.Screens.EstudoScreen
import br.com.fiap.challenge.Screens.EstudosScreen
import br.com.fiap.challenge.Screens.ExperienceScreen
import br.com.fiap.challenge.Screens.ExperienciaScreen
import br.com.fiap.challenge.Screens.FotoScreen
import br.com.fiap.challenge.Screens.HardScreen
import br.com.fiap.challenge.Screens.IdiomasScreen
import br.com.fiap.challenge.Screens.InteresseScreen
import br.com.fiap.challenge.Screens.LocationScreen
import br.com.fiap.challenge.Screens.LoginScreen
import br.com.fiap.challenge.Screens.MatchesScreen
import br.com.fiap.challenge.Screens.MentorScreen
import br.com.fiap.challenge.Screens.NivelScreen
import br.com.fiap.challenge.Screens.NomeScreen
import br.com.fiap.challenge.Screens.PaisScreen
import br.com.fiap.challenge.Screens.ProfileScreen
import br.com.fiap.challenge.Screens.ProfileScreenRead
import br.com.fiap.challenge.Screens.SearchAdvancedScreen
import br.com.fiap.challenge.Screens.SearchScreen
import br.com.fiap.challenge.Screens.SkillsScreen
import br.com.fiap.challenge.Screens.SobreScreen
import br.com.fiap.challenge.Screens.SoftScreen
import br.com.fiap.challenge.Screens.SuccessScreen
import br.com.fiap.challenge.Screens.TimeScreen
import br.com.fiap.challenge.Screens.UserScreen
import br.com.fiap.challenge.Screens.WelcomeScreen
import br.com.fiap.challenge.Screens.YouScreen

@Composable
fun NavGraph(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = Screen.Login.route,
        modifier = modifier
    ) {
        composable(Screen.Login.route) { LoginScreen(navController) }
        composable(Screen.Welcome.route) { WelcomeScreen(navController) }
        composable(Screen.Dados.route) { DadosScreen(navController) }
        composable(Screen.Location.route) { LocationScreen(navController) }
        composable(Screen.Estudo.route) { EstudoScreen(navController) }
        composable(Screen.Experience.route) { ExperienceScreen(navController) }
        composable(Screen.Soft.route) { SoftScreen(navController) }
        composable(Screen.Skills.route) { SkillsScreen(navController) }
        composable(Screen.You.route) { YouScreen(navController) }
        composable(Screen.Abordagem.route) { AbordagemScreen(navController) }
        composable(Screen.Mentor.route) { MentorScreen(navController) }
        composable(Screen.Time.route) { TimeScreen(navController) }
        composable(Screen.User.route) { UserScreen(navController) }
        composable(Screen.CardWeek.route) { CardWeekScreen(navController) }
        composable(Screen.CardSelection.route) { CardSelectionScreen(navController) }
        composable(Screen.Success.route) { SuccessScreen(navController) }
        composable(Screen.Dashboard.route) { DashboardScreen(navController) }
        composable(Screen.Profile.route) { ProfileScreen(navController) }
        composable(Screen.ProfileRead.route) { ProfileScreenRead(navController) }
        composable(Screen.SearchScreen.route) { SearchScreen(navController) }
        composable(Screen.SearchAdvancedScreen.route) { SearchAdvancedScreen(navController) }
        composable(Screen.MatchesScreen.route) { MatchesScreen(navController) }
        composable(Screen.NomeScreen.route) { NomeScreen(navController) }
        composable(Screen.EmailScreen.route) { EmailScreen(navController) }
        composable(Screen.CargoScreen.route) { CargoScreen(navController) }
        composable(Screen.EmpresaScreen.route) { EmpresaScreen(navController) }
        composable(Screen.CidadeScreen.route) { CidadeScreen(navController) }
        composable(Screen.EstadoScreen.route) { EstadoScreen(navController) }
        composable(Screen.PaisScreen.route) { PaisScreen(navController) }
        composable(Screen.EstudosScreen.route) { EstudosScreen(navController) }
        composable(Screen.ExperienciaScreen.route) { ExperienciaScreen(navController) }
        composable(Screen.SoftScreen.route) { SoftScreen(navController) }
        composable(Screen.HardScreen.route) { HardScreen(navController) }
        composable(Screen.IdiomasScreen.route) { IdiomasScreen(navController) }
        composable(Screen.NivelScreen.route) { NivelScreen(navController) }
        composable(Screen.InteresseScreen.route) { InteresseScreen(navController) }
        composable(Screen.CartaScreen.route) { CartaScreen(navController) }
        composable(Screen.SobreScreen.route) { SobreScreen(navController) }
        composable(Screen.MentorScreen.route) { MentorScreen(navController) }
        composable(Screen.AprendizScreen.route) { AprendizScreen(navController) }
        composable(Screen.FotoScreen.route) { FotoScreen(navController) }
        composable(Screen.CertificadosScreen.route) { CertificadosScreen(navController) }
    }
}

sealed class Screen(val route: String) {
    object Login : Screen("login")
    object Welcome : Screen("welcome")
    object Dados : Screen("dados")
    object Location : Screen("location")
    object Estudo : Screen("estudo")
    object Experience : Screen("experience")
    object Soft : Screen("soft")
    object Skills : Screen("skills")
    object You : Screen("you")
    object Abordagem : Screen("abordagem")
    object Mentor : Screen("mentor")
    object Time : Screen("time")
    object User : Screen("user")
    object CardWeek : Screen("card_week")
    object CardSelection : Screen("card_selection")
    object Success : Screen("success")
    object Dashboard : Screen("dashboard")
    object Profile : Screen("profile")
    object ProfileRead : Screen("profile_read")
    object SearchScreen : Screen("search_screen")
    object SearchAdvancedScreen : Screen("search_advanced_screen")
    object MatchesScreen : Screen("matches_screen")
    object NomeScreen : Screen("nome_screen")
    object EmailScreen : Screen("email_screen")
    object CargoScreen : Screen("cargo_screen")
    object EmpresaScreen : Screen("empresa_screen")
    object CidadeScreen : Screen("cidade_screen")
    object EstadoScreen : Screen("estado_screen")
    object PaisScreen : Screen("pais_screen")
    object EstudosScreen : Screen("estudos_screen")
    object ExperienciaScreen : Screen("experiencia_screen")
    object SoftScreen : Screen("soft_screen")
    object HardScreen : Screen("hard_screen")
    object IdiomasScreen : Screen("idiomas_screen")
    object NivelScreen : Screen("nivel_screen")
    object InteresseScreen : Screen("interesse_screen")
    object CartaScreen : Screen("carta_screen")
    object SobreScreen : Screen("sobre_screen")
    object MentorScreen : Screen("mentor_screen")
    object AprendizScreen : Screen("aprendiz_screen")
    object FotoScreen : Screen("foto_screen")
    object CertificadosScreen : Screen("certificados_screen")

}
