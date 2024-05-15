package br.com.fiap.challenge.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.challenge.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EstudoScreen() {
    var selectedGrau by remember { mutableStateOf("") }
    var selectedArea by remember { mutableStateOf("") }
    var nomeInstituicao by remember { mutableStateOf("") }
    var nomeCurso by remember { mutableStateOf("") }
    var duracao by remember { mutableStateOf("") }
    var dataConclusao by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(32.dp))
        Image(
            painter = painterResource(id = R.drawable.mentorsphere_logo),
            contentDescription = "Logo",
            modifier = Modifier.size(120.dp)
        )
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = "Me conte sobre seus estudos:",
            fontSize = 24.sp,
            color = Color.Black,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .border(2.dp, Color.Black, RoundedCornerShape(16.dp))
                .padding(16.dp)
        ) {
            Column {
                DropdownMenuField(
                    value = selectedGrau,
                    onValueChange = { selectedGrau = it },
                    label = { Text("Grau de escolaridade") },
                    options = listOf("Ensino Médio", "Graduação", "Pós-graduação"),
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))
                DropdownMenuField(
                    value = selectedArea,
                    onValueChange = { selectedArea = it },
                    label = { Text("Área de estudo") },
                    options = listOf("Ciências Exatas", "Ciências Humanas", "Biológicas"),
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))
                OutlinedTextField(
                    value = nomeInstituicao,
                    onValueChange = { nomeInstituicao = it },
                    label = { Text("Nome da instituição") },
                    placeholder = { Text("Digite o nome da instituição") },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.Black,
                        unfocusedBorderColor = Color.Black
                    )
                )
                Spacer(modifier = Modifier.height(16.dp))
                OutlinedTextField(
                    value = nomeCurso,
                    onValueChange = { nomeCurso = it },
                    label = { Text("Nome do curso") },
                    placeholder = { Text("Digite o nome do curso") },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.Black,
                        unfocusedBorderColor = Color.Black
                    )
                )
                Spacer(modifier = Modifier.height(16.dp))
                Row {
                    OutlinedTextField(
                        value = duracao,
                        onValueChange = { duracao = it },
                        label = { Text("Duração") },
                        placeholder = { Text("xx") },
                        modifier = Modifier
                            .weight(1f)
                            .padding(end = 8.dp),
                        shape = RoundedCornerShape(8.dp),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Color.Black,
                            unfocusedBorderColor = Color.Black
                        )
                    )
                    DropdownMenuField(
                        value = "",
                        onValueChange = { },
                        label = { Text("Unidade") },
                        options = listOf("Meses", "Anos"),
                        modifier = Modifier.weight(1f)
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                OutlinedTextField(
                    value = dataConclusao,
                    onValueChange = { dataConclusao = it },
                    label = { Text("Data de conclusão") },
                    placeholder = { Text("xx/xx/xxxx") },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.Black,
                        unfocusedBorderColor = Color.Black
                    )
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Adicionar mais um (+)",
                    fontSize = 16.sp,
                    color = Color.Blue,
                    textDecoration = TextDecoration.Underline,
                    modifier = Modifier.clickable { /* Handle Add More */ },
                    textAlign = TextAlign.Center
                )
            }
        }
        Spacer(modifier = Modifier.height(32.dp))

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = { /* Handle Save and Return Later */ },
                    shape = RoundedCornerShape(25.dp),
                    modifier = Modifier
                        .weight(1f)
                        .height(54.dp)
                        .padding(end = 8.dp)
                        .border(2.dp, Color.Black, RoundedCornerShape(8.dp)),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White)
                ) {
                    Text("Salvar e Voltar depois", color = Color.Black, fontSize = 16.sp)
                }
                Button(
                    onClick = { /* Handle Save and Continue */ },
                    shape = RoundedCornerShape(25.dp),
                    modifier = Modifier
                        .weight(1f)
                        .height(54.dp)
                        .padding(start = 8.dp)
                        .border(2.dp, Color.Black, RoundedCornerShape(8.dp)),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White)
                ) {
                    Text("Salvar e Continuar", color = Color.Black, fontSize = 16.sp)
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Página 3/xx",
                fontSize = 12.sp,
                color = Color.Gray,
                modifier = Modifier.padding(top = 8.dp),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(16.dp))
            Image(
                painter = painterResource(id = R.drawable.db1_logo),
                contentDescription = "DB1 Logo",
                modifier = Modifier.size(64.dp)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropdownOptField(
    value: String,
    onValueChange: (String) -> Unit,
    label: @Composable () -> Unit,
    options: List<String>,
    modifier: Modifier = Modifier,
) {
    var expanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded },
        modifier = modifier
    ) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            label = label,
            modifier = Modifier
                .menuAnchor()
                .fillMaxWidth(),
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(
                    expanded = expanded
                )
            },
            readOnly = true,
            shape = RoundedCornerShape(8.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Black,
                unfocusedBorderColor = Color.Black
            )
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = { Text(text = option) },
                    onClick = {
                        onValueChange(option)
                        expanded = false
                    }
                )
            }
        }
    }
}
