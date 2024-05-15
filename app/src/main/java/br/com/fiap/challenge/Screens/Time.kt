package br.com.fiap.challenge.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.challenge.R

@Composable
fun TimeScreen() {
    var durationHours by remember { mutableStateOf("") }
    var durationMinutes by remember { mutableStateOf("") }

    val daysOfWeek = listOf(
        "Segunda-feira",
        "Terça-feira",
        "Quarta-feira",
        "Quinta-feira",
        "Sexta-feira",
        "Sábado",
        "Domingo"
    )

    val availabilityState = remember { mutableStateListOf<DayAvailability>() }

    daysOfWeek.forEach { day ->
        availabilityState.add(DayAvailability(day, mutableStateListOf()))
    }

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
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Mentor",
            fontSize = 24.sp,
            color = Color.Black,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = "Excelente! Então vamos definir os seus horários disponíveis.",
            fontSize = 16.sp,
            color = Color.Black,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Duração:",
            fontSize = 16.sp,
            color = Color.Black,
            textAlign = TextAlign.Center
        )
        Row(
            modifier = Modifier.padding(vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            BasicTextField(
                value = durationHours,
                onValueChange = { durationHours = it },
                modifier = Modifier
                    .width(40.dp)
                    .border(1.dp, Color.Black, RoundedCornerShape(4.dp)),
                singleLine = true
            )
            Text(text = "hora(s) e", modifier = Modifier.padding(horizontal = 8.dp))
            BasicTextField(
                value = durationMinutes,
                onValueChange = { durationMinutes = it },
                modifier = Modifier
                    .width(40.dp)
                    .border(1.dp, Color.Black, RoundedCornerShape(4.dp)),
                singleLine = true
            )
            Text(text = "minutos", modifier = Modifier.padding(horizontal = 8.dp))
        }
        Text(
            text = "Quanto tempo pode durar cada agendamento?",
            fontSize = 12.sp,
            color = Color.Gray,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Disponibilidade:",
            fontSize = 16.sp,
            color = Color.Black,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        availabilityState.forEach { dayAvailability ->
            AvailabilityRow(dayAvailability = dayAvailability)
            Spacer(modifier = Modifier.height(8.dp))
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
                text = "Página 9/xx",
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

data class DayAvailability(val day: String, val availability: MutableList<TimeSlot>)

data class TimeSlot(var from: String = "", var to: String = "", var isSelected: Boolean = false)

@Composable
fun AvailabilityRow(dayAvailability: DayAvailability) {
    Column {
        Text(
            text = dayAvailability.day,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            fontSize = 16.sp,
            color = Color.Black
        )
        dayAvailability.availability.forEachIndexed { index, timeSlot ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .border(1.dp, Color.Black, RoundedCornerShape(8.dp))
                    .padding(8.dp)
            ) {
                BasicTextField(
                    value = timeSlot.from,
                    onValueChange = { dayAvailability.availability[index] = timeSlot.copy(from = it) },
                    modifier = Modifier
                        .width(60.dp)
                        .border(1.dp, Color.Black, RoundedCornerShape(4.dp)),
                    singleLine = true
                )
                Text(text = "às", modifier = Modifier.padding(horizontal = 8.dp))
                BasicTextField(
                    value = timeSlot.to,
                    onValueChange = { dayAvailability.availability[index] = timeSlot.copy(to = it) },
                    modifier = Modifier
                        .width(60.dp)
                        .border(1.dp, Color.Black, RoundedCornerShape(4.dp)),
                    singleLine = true
                )
                Checkbox(
                    checked = timeSlot.isSelected,
                    onCheckedChange = { dayAvailability.availability[index] = timeSlot.copy(isSelected = it) }
                )
                IconButton(onClick = {
                    dayAvailability.availability.removeAt(index)
                }) {
                    Icon(painter = painterResource(id = R.drawable.ic_delete), contentDescription = "Remove")
                }
            }
        }
        IconButton(onClick = {
            dayAvailability.availability.add(TimeSlot())
        }) {
            Icon(painter = painterResource(id = R.drawable.ic_add), contentDescription = "Add Time Slot")
        }
    }
}
