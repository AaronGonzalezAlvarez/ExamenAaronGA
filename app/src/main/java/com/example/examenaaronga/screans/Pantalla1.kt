package com.example.examenaaronga.screans

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ExamenAndroidDAMTheme.data.DataSource
import com.example.ExamenAndroidDAMTheme.data.LoteriaTipo
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import com.example.examenaaronga.Routes
import com.example.examenaaronga.viewModel.LogicaViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Pantalla1(navController: NavHostController,viewModel: LogicaViewModel = viewModel()) {
    val valoresUiState by viewModel.uiState.collectAsState()
    Column(
        modifier= Modifier
            .padding(top = 50.dp, start = 15.dp, end = 15.dp)
        //.background(Color.Magenta)
    ) {
        Text(
            modifier = Modifier.padding(start = 20.dp),
            text = "Bienvenido a apuestas AGA"
        )
        LazyRow(
            verticalAlignment = Alignment.CenterVertically
        ) {
            items(DataSource.loterias) { loteria ->
                loteriaCard(
                    lote = loteria,
                    viewModel
                )
            }
        }
        if(valoresUiState.mensajeError){
            Spacer(modifier = Modifier.height(25.dp))
            Text(
                text = "No tienes dinero para apostar ya que tienes 0 euros."
            )
        }
        if(valoresUiState.mensajeErrorTexto){
            Spacer(modifier = Modifier.height(25.dp))
            Text(
                text = "Esa loteria no existe: ${valoresUiState.nombreLoteriaAponer}"
            )
        }
        Spacer(modifier = Modifier.height(25.dp))
        Row (
            modifier = Modifier.fillMaxWidth()
        ){
            //var nombreLoteria by remember { mutableStateOf( "") }
            TextField(
                label = { Text(text = "Loteria")},
                modifier = Modifier.width(150.dp),
                value = valoresUiState.nombreLoteriaAponer,
                onValueChange = {
                    viewModel.actualizarValorNombreLoteria(it)
                }
            )
            Spacer(modifier = Modifier.width(25.dp))
            //var dineroApostar by remember { mutableStateOf( "") }
            TextField(
                label = { Text(text = "Dinero apostado")},
                modifier = Modifier.width(180.dp),
                value = valoresUiState.apuestaARealizar.toString(),
                onValueChange = {
                    viewModel.actualizarValor(it)
                }
            )
        }
        Spacer(modifier = Modifier.height(30.dp))
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { viewModel.lanzarApuestaNormal()}
        ) {
            Text(text = "Jugar a la lotería")
        }
        Spacer(modifier = Modifier.height(30.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.DarkGray)
                .height(250.dp),
        ){
            if(valoresUiState.primerMensaje){
                Text(
                    text = valoresUiState.mensaje1
                )
            }else{
                Column {
                    if(valoresUiState.pierdes){
                        Text(text = "Has perdido")
                    }else{
                        Text(text = "Has ganado")
                    }
                    Text(text = "dinero ganado: ${valoresUiState.dineroGanado}")
                    Text(text = "dinero gastado: ${valoresUiState.dineroGastado}")
                    Text(text = "veces ganado: ${valoresUiState.partidasGanadas}")
                    Text(text = "veces perdidas: ${valoresUiState.partidasPerdidas}")
                    Text(text = "veces jugadas: ${valoresUiState.auxVecesApuesta}")
                }
            }
        }
        Spacer(modifier = Modifier.height(30.dp))
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { navController.navigate(route = Routes.Pantalla2.route) }
        ) {
            Text(text = "Cambiar pantalla")
        }
    }
}
@Composable
fun loteriaCard(lote: LoteriaTipo,viewModel: LogicaViewModel) {
    Card (
        modifier = Modifier
            .width(200.dp)
            .padding(4.dp)
    ){
        Column (){
            Text(
                modifier = Modifier
                    .padding(3.dp)
                    .background(Color.Yellow)
                    .fillMaxWidth()
                    .height(35.dp)
                    .padding(start = 5.dp),
                text = "Nombre ${lote.nombre}",
                lineHeight = 15.sp
            )
            Text(
                modifier = Modifier
                    .padding(3.dp)
                    .background(Color.Blue)
                    .fillMaxWidth()
                    .height(35.dp)
                    .padding(start = 5.dp),
                text = "Premio ${lote.premio}",
            )
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = { viewModel.lanzarApuestaEnListaHorizontal(lote.nombre,lote.premio) }
            ) {
                Text(
                    text = "Apostar"
                )
            }
        }
    }

}