package br.com.fiap.challenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.fiap.challenge.Screens.AbordagemScreen
import br.com.fiap.challenge.Screens.DadosScreen
import br.com.fiap.challenge.Screens.EstudoScreen
import br.com.fiap.challenge.Screens.ExperienceScreen
import br.com.fiap.challenge.Screens.LocationScreen
import br.com.fiap.challenge.Screens.LoginScreen
import br.com.fiap.challenge.Screens.MentorScreen
import br.com.fiap.challenge.Screens.SkillsScreen
import br.com.fiap.challenge.Screens.SoftScreen
import br.com.fiap.challenge.Screens.TimeScreen
import br.com.fiap.challenge.Screens.UserScreen
import br.com.fiap.challenge.Screens.WelcomeScreen
import br.com.fiap.challenge.Screens.YouScreen
import br.com.fiap.challenge.ui.theme.ChallengeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChallengeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    UserScreen()
                }
            }
        }
    }
}

