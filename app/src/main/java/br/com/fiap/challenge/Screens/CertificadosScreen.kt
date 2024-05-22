package br.com.fiap.challenge.Screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import br.com.fiap.challenge.Components.Certification
import br.com.fiap.challenge.Components.MiniCard
import br.com.fiap.challenge.viewmodel.UserProfileViewModel

@Composable
fun CertificadosScreen(navController: NavHostController, userProfileViewModel: UserProfileViewModel = viewModel()) {
    var certificationName by remember { mutableStateOf("") }
    var issuingOrganization by remember { mutableStateOf("") }
    var issueDate by remember { mutableStateOf("") }
    var expiryDate by remember { mutableStateOf("") }

    val userProfile = userProfileViewModel.userProfile.observeAsState().value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        TextField(
            value = certificationName,
            onValueChange = { certificationName = it },
            label = { Text("Nome da certificação") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = issuingOrganization,
            onValueChange = { issuingOrganization = it },
            label = { Text("Organização emissora") },
            modifier = Modifier.fillMaxWidth()
        )
        Row {
            TextField(
                value = issueDate,
                onValueChange = { issueDate = it },
                label = { Text("Data de emissão") },
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(8.dp))
            TextField(
                value = expiryDate,
                onValueChange = { expiryDate = it },
                label = { Text("Data de validade") },
                modifier = Modifier.weight(1f)
            )
        }
        Button(
            onClick = {
                if (certificationName.isNotBlank() && issuingOrganization.isNotBlank()) {
                    val newCertification = Certification(certificationName, issuingOrganization, issueDate, expiryDate)
                    userProfileViewModel.addCertification(newCertification)
                    certificationName = ""
                    issuingOrganization = ""
                    issueDate = ""
                    expiryDate = ""
                }
            },
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text("Adicionar")
        }
        Spacer(modifier = Modifier.height(16.dp))
        userProfile?.certifications?.forEach { certification ->
            MiniCard(content = "${certification.name} - ${certification.organization}", onDelete = {
                userProfileViewModel.removeCertification(certification)
            })
        }
        Spacer(modifier = Modifier.height(32.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = { navController.popBackStack() },
                shape = RoundedCornerShape(25.dp),
                modifier = Modifier
                    .weight(1f)
                    .height(54.dp)
                    .padding(end = 8.dp)
                    .border(2.dp, Color.Black, RoundedCornerShape(8.dp)),
                colors = ButtonDefaults.buttonColors(containerColor = Color.White)
            ) {
                Text("Voltar", color = Color.Black, fontSize = 16.sp)
            }
            Button(
                onClick = { navController.navigate("next_screen_route") },  // Replace "next_screen_route" with the actual route
                shape = RoundedCornerShape(25.dp),
                modifier = Modifier
                    .weight(1f)
                    .height(54.dp)
                    .padding(start = 8.dp)
                    .border(2.dp, Color.Blue, RoundedCornerShape(8.dp)),
                colors = ButtonDefaults.buttonColors(containerColor = Color.White)
            ) {
                Text("Salvar e Continuar", color = Color.Blue, fontWeight = FontWeight.ExtraBold, fontSize = 16.sp)
            }
        }
    }
}
