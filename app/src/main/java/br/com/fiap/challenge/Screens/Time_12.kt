package br.com.fiap.challenge.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.com.fiap.challenge.R
import br.com.fiap.challenge.navigation.Screen

@Composable
fun TimeScreen(navController: NavHostController) {
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

    val availabilityState = remember {
        mutableStateListOf<DayAvailability>().apply {
            daysOfWeek.forEach { day ->
                add(DayAvailability(day, mutableStateListOf()))
            }
        }
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
            modifier = Modifier.size(160.dp)
        )
        Text(
            text = "Excelente! Então vamos definir os seus horários disponíveis.",
            fontSize = 16.sp,
            color = Color.Black,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = painterResource(id = R.drawable.calendar01),
            contentDescription = "Calendário",
            modifier = Modifier.size(260.dp)
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
                    onClick = { navController.navigate(Screen.User.route) },
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
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Etapa 9/12",
                fontSize = 12.sp,
                color = Color.Gray,
                modifier = Modifier.padding(top = 8.dp),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(16.dp))
            Image(
                painter = painterResource(id = R.drawable.db1_logo),
                contentDescription = "DB1 Logo",
                modifier = Modifier.size(100.dp)
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