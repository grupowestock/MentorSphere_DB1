package br.com.fiap.challenge.Components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp

// Se você ainda não tem, adicione os seguintes imports para o uso de Icons e outros componentes básicos
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.material3.TextField
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.TextButton
import androidx.compose.ui.graphics.vector.ImageVector
import br.com.fiap.challenge.Screens.MiniCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LanguageSkills() {
    var language by remember { mutableStateOf("") }
    var level by remember { mutableStateOf("Básico") }
    var expanded by remember { mutableStateOf(false) }
    var languagesList by remember { mutableStateOf(listOf<Pair<String, String>>()) }
    val levels = listOf("Básico", "Intermediário", "Avançado")

    Column {
        Row(modifier = Modifier.fillMaxWidth()) {
            TextField(
                value = language,
                onValueChange = { language = it },
                label = { Text("Idioma") },
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Box(modifier = Modifier.weight(1f)) {
                ExposedDropdownMenuBox(
                    expanded = expanded,
                    onExpandedChange = { expanded = it }
                ) {
                    TextField(
                        readOnly = true,
                        value = level,
                        onValueChange = {},
                        label = { Text("Nível") },
                        trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                        colors = ExposedDropdownMenuDefaults.textFieldColors(),
                        modifier = Modifier.fillMaxWidth()
                    )
                    ExposedDropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false }
                    ) {
                        levels.forEach { selectionOption ->
                            DropdownMenuItem(
                                text = { Text(selectionOption) },
                                onClick = {
                                    level = selectionOption
                                    expanded = false
                                }
                            )
                        }
                    }
                }
            }
            IconButton(
                onClick = {
                    if (language.isNotBlank() && level.isNotBlank()) {
                        languagesList = languagesList + (language to level)
                        language = ""
                        level = "Básico"
                    }
                },
                modifier = Modifier.align(Alignment.CenterVertically)
            ) {
                Icon(Icons.Filled.Add, contentDescription = "Add")
            }
        }
        languagesList.forEach { (lang, lvl) ->
            MiniCard("$lang - $lvl") { languagesList = languagesList - (lang to lvl) }
        }
    }
}

@Composable
fun DropdownMenu(text: String, options: List<String>, onOptionSelected: (String) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    val label = remember { text }
    Box(modifier = Modifier.fillMaxWidth()) {
        TextButton(onClick = { expanded = true }) {
            Text(text)
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth()
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = { Text(option) },
                    onClick = {
                        onOptionSelected(option)
                        expanded = false
                    }
                )
            }
        }
    }
}