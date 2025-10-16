package com.hesapmakinesi.app

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlin.math.pow

data class CalculatorState(
    val currentNumber: String = "",
    val previousNumber: String = "",
    val operation: String = ""
)

sealed class CalculatorAction {
    data class Number(val number: String) : CalculatorAction()
    data class Operation(val operation: String) : CalculatorAction()
    object Clear : CalculatorAction()
    object Calculate : CalculatorAction()
    object Decimal : CalculatorAction()
    object ToggleSign : CalculatorAction()
    object Percent : CalculatorAction()
}

class CalculatorViewModel : ViewModel() {
    private val _state = MutableStateFlow(CalculatorState())
    val state: StateFlow<CalculatorState> = _state.asStateFlow()
    
    fun onAction(action: CalculatorAction) {
        when (action) {
            is CalculatorAction.Number -> enterNumber(action.number)
            is CalculatorAction.Operation -> enterOperation(action.operation)
            is CalculatorAction.Clear -> clear()
            is CalculatorAction.Calculate -> calculate()
            is CalculatorAction.Decimal -> enterDecimal()
            is CalculatorAction.ToggleSign -> toggleSign()
            is CalculatorAction.Percent -> percent()
        }
    }
    
    private fun enterNumber(number: String) {
        val current = _state.value.currentNumber
        
        // Limit number length
        if (current.length >= 15) return
        
        // Don't allow multiple zeros at start
        if (current == "0" && number == "0") return
        
        // Replace 0 with the new number
        if (current == "0") {
            _state.value = _state.value.copy(currentNumber = number)
            return
        }
        
        _state.value = _state.value.copy(
            currentNumber = current + number
        )
    }
    
    private fun enterOperation(operation: String) {
        val current = _state.value.currentNumber
        val previous = _state.value.previousNumber
        val currentOp = _state.value.operation
        
        // If we already have an operation, calculate first
        if (currentOp.isNotEmpty() && current.isNotEmpty()) {
            calculate()
        }
        
        _state.value = _state.value.copy(
            previousNumber = if (current.isNotEmpty()) current else previous,
            currentNumber = "",
            operation = operation
        )
    }
    
    private fun calculate() {
        val current = _state.value.currentNumber.toDoubleOrNull() ?: return
        val previous = _state.value.previousNumber.toDoubleOrNull() ?: return
        val operation = _state.value.operation
        
        val result = when (operation) {
            "+" -> previous + current
            "-" -> previous - current
            "×" -> previous * current
            "/" -> if (current != 0.0) previous / current else return
            else -> return
        }
        
        _state.value = _state.value.copy(
            currentNumber = formatResult(result),
            previousNumber = "",
            operation = ""
        )
    }
    
    private fun enterDecimal() {
        val current = _state.value.currentNumber
        
        // Don't allow multiple decimals
        if (current.contains(",")) return
        
        _state.value = _state.value.copy(
            currentNumber = if (current.isEmpty()) "0," else "$current,"
        )
    }
    
    private fun toggleSign() {
        val current = _state.value.currentNumber
        if (current.isEmpty()) return
        
        val newNumber = if (current.startsWith("-")) {
            current.drop(1)
        } else {
            "-$current"
        }
        
        _state.value = _state.value.copy(currentNumber = newNumber)
    }
    
    private fun percent() {
        val current = _state.value.currentNumber.replace(",", ".").toDoubleOrNull() ?: return
        val result = current / 100
        
        _state.value = _state.value.copy(
            currentNumber = formatResult(result)
        )
    }
    
    private fun clear() {
        _state.value = CalculatorState()
    }
    
    private fun formatResult(value: Double): String {
        // Remove trailing zeros
        val formatted = if (value % 1.0 == 0.0) {
            value.toLong().toString()
        } else {
            "%.8f".format(value).trimEnd('0').trimEnd('.')
        }
        return formatted.replace(".", ",")
    }
}
