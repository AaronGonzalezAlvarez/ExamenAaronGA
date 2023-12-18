package com.example.examenaaronga.viewModel

data class ValoresUiState(
    val auxVecesApuesta:Int = 0,
    val mensajeError:Boolean = false,
    val mensajeErrorTexto:Boolean = false,
    val primerMensaje:Boolean = true,
    val nombreLoteriaAponer: String = "",
    val apuestaARealizar : Int =0,
    val mensaje1: String ="No has jugado ninguna loteria por ahora.",
    val mensaje2: String ="resultados",
    val partidasGanadas:Int =0,
    val partidasPerdidas:Int =0,
    val dineroGastado:Int =0,
    val dineroGanado:Int =0,
    val resultados:Boolean = false,
    val pierdes:Boolean = false
)
