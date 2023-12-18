package com.example.examenaaronga.viewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LogicaViewModel: ViewModel(){
    private val _uiState = MutableStateFlow(ValoresUiState())
    val uiState: StateFlow<ValoresUiState> = _uiState.asStateFlow()


    fun lanzarApuestaEnListaHorizontal(nombreApuesta: String,cantidaApostada: Int,){

        //validar si es cero la cantidad
        if(_uiState.value.apuestaARealizar == 0){
            _uiState.update { currentState -> currentState.copy(
                mensajeError = true
            ) }
        }else{
            //si vamos a proceder a lo demas
            var ticketPersona = (1..4).random()
            var ticketGanador = (1..4).random()

            if(ticketGanador == ticketPersona){
                var auxPartidas= _uiState.value.auxVecesApuesta
                var auxPartidasGanadas= _uiState.value.partidasGanadas
                var auxdineroGastado= _uiState.value.dineroGastado
                var auxdineroGanado= _uiState.value.dineroGanado
                auxPartidasGanadas++
                auxPartidas++
                auxdineroGastado+= cantidaApostada

                auxdineroGanado+=cantidaApostada*5
                _uiState.update { currentState -> currentState.copy(
                    mensajeError = false,
                    partidasGanadas = auxPartidasGanadas,
                    auxVecesApuesta = auxPartidas,
                    dineroGanado = auxdineroGanado,
                    dineroGastado = auxdineroGastado,
                    primerMensaje = false,
                    pierdes = false
                ) }
            }else{
                var auxPartidas= _uiState.value.auxVecesApuesta
                var auxPartidasPerdidas= _uiState.value.partidasPerdidas
                var auxdineroGastado= _uiState.value.dineroGastado
                auxPartidasPerdidas++
                auxPartidas++
                auxdineroGastado+= cantidaApostada
                _uiState.update { currentState -> currentState.copy(
                    mensajeError = false,
                    partidasPerdidas = auxPartidasPerdidas,
                    auxVecesApuesta = auxPartidas,
                    dineroGastado = auxdineroGastado,
                    primerMensaje = false,
                    pierdes = true
                ) }
            }
        }

    }

    fun lanzarApuestaNormal(){
        if(_uiState.value.apuestaARealizar == 0){
            _uiState.update { currentState -> currentState.copy(
                mensajeError = true
            ) }
        }else{
                //si vamos a proceder a lo demas
                var ticketPersona = (1..4).random()
                var ticketGanador = (1..4).random()

                if(ticketGanador == ticketPersona){
                    var auxPartidas= _uiState.value.auxVecesApuesta
                    var auxPartidasGanadas= _uiState.value.partidasGanadas
                    var auxdineroGastado= _uiState.value.dineroGastado
                    var auxdineroGanado= _uiState.value.dineroGanado
                    auxPartidasGanadas++
                    auxPartidas++
                    //auxdineroGastado+= cantidaApostada

                    auxdineroGanado+=auxdineroGanado*5
                    _uiState.update { currentState -> currentState.copy(
                        mensajeError = false,
                        partidasGanadas = auxPartidasGanadas,
                        auxVecesApuesta = auxPartidas,
                        dineroGanado = auxdineroGanado,
                        dineroGastado = auxdineroGastado,
                        primerMensaje = false,
                        pierdes = false
                    ) }
                }else{
                    var auxPartidas= _uiState.value.auxVecesApuesta
                    var auxPartidasPerdidas= _uiState.value.partidasPerdidas
                    var auxdineroGastado= _uiState.value.dineroGastado
                    auxPartidasPerdidas++
                    auxPartidas++
                    //auxdineroGastado+= cantidaApostada
                    _uiState.update { currentState -> currentState.copy(
                        mensajeError = false,
                        mensajeErrorTexto = false,
                        partidasPerdidas = auxPartidasPerdidas,
                        auxVecesApuesta = auxPartidas,
                        dineroGastado = auxdineroGastado,
                        primerMensaje = false,
                        pierdes = true
                    ) }
                }

                /*_uiState.update { currentState -> currentState.copy(
                    mensajeErrorTexto = false,
                    mensajeError = false
                ) }*/

        }
    }

    fun actualizarValor(valorActual:String){
        _uiState.update { currentState -> currentState.copy(
            apuestaARealizar = valorActual.toInt()
        ) }
    }

    fun actualizarValorNombreLoteria(valorActualNombreLoteria:String){
        _uiState.update { currentState -> currentState.copy(
            nombreLoteriaAponer = valorActualNombreLoteria
        ) }
    }
}