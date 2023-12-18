package com.example.examenaaronga

import android.os.Bundle
import android.text.Layout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ExamenAndroidDAMTheme.data.DataSource
import com.example.ExamenAndroidDAMTheme.data.LoteriaTipo
import com.example.examenaaronga.screans.Pantalla1
import com.example.examenaaronga.ui.theme.ExamenAaronGATheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExamenAaronGATheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //appAaron()
                    //Pantalla1()
                    AppNav()
                }
            }
        }
    }
}
/*
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun appAaron() {
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
                    lote = loteria
                )
            }
        }
        Spacer(modifier = Modifier.height(25.dp))
        Row (
            modifier = Modifier.fillMaxWidth()
        ){
            TextField(
                modifier = Modifier.width(150.dp),
                value = "Loteria",
                onValueChange = {}
            )
            Spacer(modifier = Modifier.width(25.dp))
            TextField(
                modifier = Modifier.width(180.dp),
                value = "Dinero apostado",
                onValueChange = {}
            )
        }
        Spacer(modifier = Modifier.height(30.dp))
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { /*TODO*/ }
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
            Text(
                text = "No has jugado ninguna loteria"
            )
        }
        Spacer(modifier = Modifier.height(30.dp))
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { /*TODO*/ }
        ) {
            Text(text = "Cambiar pantalla")
        }
    }
}
@Composable
fun loteriaCard(lote: LoteriaTipo) {
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
                onClick = { /*TODO*/ }
            ) {
              Text(
                  text = "Apostar"
              )
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ExamenAaronGATheme {
        appAaron()
    }
}*/