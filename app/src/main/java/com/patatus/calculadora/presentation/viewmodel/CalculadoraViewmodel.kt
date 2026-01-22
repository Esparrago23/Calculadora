package com.patatus.calculadora.presentation.viewmodel
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

sealed class CalculatorAction {
    data class Number(val number: Int) : CalculatorAction()
    object Clear : CalculatorAction()
    object Delete : CalculatorAction()
    object Decimal : CalculatorAction()
    object Calculate : CalculatorAction()
    data class Operation(val operation: CalculatorOperation) : CalculatorAction()
}

enum class CalculatorOperation(val symbol: String) {
    Add("+"),
    Subtract("-"),
    Multiply("*"),
    Divide("/")
}

data class CalculatorState(
    val number1: String = "",
    val number2: String = "",
    val operation: CalculatorOperation? = null
)
class CalculadoraViewmodel: ViewModel() {
    var state by mutableStateOf(CalculatorState())
        private set

    fun onAction(action: CalculatorAction) {
        when(action) {
            is CalculatorAction.Number -> enterNumber(action.number)
            is CalculatorAction.Decimal -> enterDecimal()
            is CalculatorAction.Clear -> state = CalculatorState()
            is CalculatorAction.Delete -> performDeletion()
            is CalculatorAction.Operation -> enterOperation(action.operation)
            is CalculatorAction.Calculate -> performCalculation()
        }
    }

    private fun enterNumber(number: Int) {
        if (state.operation == null) {
            if (state.number1.length >= MAX_NUM_LENGTH) {
                return
            }
            state = state.copy(number1 = state.number1 + number)
        } else {
            if (state.number2.length >= MAX_NUM_LENGTH) {
                return
            }
            state = state.copy(number2 = state.number2 + number)
        }
    }

    private fun enterDecimal() {
        if (state.operation == null) {
            if (state.number1.contains(".")) {
                return
            }
            state = state.copy(
                number1 = if (state.number1.isNotBlank()) state.number1 + "." else "0."
            )
        } else {
            if (state.number2.contains(".")) {
                return
            }
            state = state.copy(
                number2 = if (state.number2.isNotBlank()) state.number2 + "." else "0."
            )
        }
    }

    private fun performDeletion() {
        when {
            state.number2.isNotBlank() -> state = state.copy(
                number2 = state.number2.dropLast(1)
            )
            state.operation != null -> state = state.copy(
                operation = null
            )
            state.number1.isNotBlank() -> state = state.copy(
                number1 = state.number1.dropLast(1)
            )
        }
    }

    private fun enterOperation(operation: CalculatorOperation) {
        if (state.number1.isNotBlank() && state.number1 != "Error") {
            if (state.number2.isNotBlank()) {
                performCalculation()
                if (state.number1 != "Error") {
                    state = state.copy(operation = operation)
                }
            } else {
                state = state.copy(operation = operation)
            }
        }
    }

    private fun performCalculation() {
        val number1 = state.number1.toDoubleOrNull()
        val number2 = state.number2.toDoubleOrNull()
        val operation = state.operation

        if (number1 != null && number2 != null && operation != null) {
            if (operation == CalculatorOperation.Divide && number2 == 0.0) {
                state = CalculatorState(number1 = "Error")
                return
            }

            val result = when (operation) {
                CalculatorOperation.Add -> number1 + number2
                CalculatorOperation.Subtract -> number1 - number2
                CalculatorOperation.Multiply -> number1 * number2
                CalculatorOperation.Divide -> number1 / number2
            }

            val resultString = if (result % 1.0 == 0.0) {
                result.toLong().toString()
            } else {
                result.toString()
            }

            state = state.copy(
                number1 = resultString.take(MAX_NUM_LENGTH),
                number2 = "",
                operation = null
            )
        }
    }

    companion object {
        private const val MAX_NUM_LENGTH = 10
    }
}