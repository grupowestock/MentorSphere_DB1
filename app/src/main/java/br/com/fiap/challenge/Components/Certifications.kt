package br.com.fiap.challenge.Components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

data class Certification(
    val name: String,
    val organization: String,
    val issueDate: String,
    val expiryDate: String
)

@Composable
fun Certifications() {
    var certificationName by remember { mutableStateOf("") }
    var issuingOrganization by remember { mutableStateOf("") }
    var issueDate by remember { mutableStateOf("") }
    var expiryDate by remember { mutableStateOf("") }
    var certificationsList by remember { mutableStateOf(listOf<Certification>()) }

    Column {
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
                    certificationsList = certificationsList + Certification(certificationName, issuingOrganization, issueDate, expiryDate)
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
        certificationsList.forEach { certification ->
            MiniCard(content = "${certification.name} - ${certification.organization}", onDelete = {
                certificationsList = certificationsList - certification
            })
        }
    }
}

@Composable
fun MiniCard(content: String, onDelete: () -> Unit, shape: Shape = RoundedCornerShape(25.dp)) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp, horizontal = 8.dp),
        shape = shape,
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(content, modifier = Modifier.weight(1f))
            IconButton(onClick = onDelete) {
                Icon(Icons.Filled.Close, contentDescription = "Delete")
            }
        }
    }
}
