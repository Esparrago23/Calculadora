package com.patatus.calculadora.presentation.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Shapes
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.patatus.calculadora.presentation.viewmodel.CalculadoraViewmodel
import com.patatus.calculadora.presentation.viewmodel.CalculatorAction
import com.patatus.calculadora.presentation.viewmodel.CalculatorOperation

//wip: work in progress
@Composable
fun CalculadoraScreen(
    viewModel: CalculadoraViewmodel = androidx.lifecycle.viewmodel.compose.viewModel()
    ){
    val state = viewModel.state
    val displayText = if (state.number1 == "Error") {
        "Error"
    } else {
        state.number1 + (state.operation?.symbol ?: "") + state.number2
    }
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.DarkGray)
        .padding(16.dp)) {
        Box(
            modifier = Modifier
                .weight(2f)
                .fillMaxWidth()
                .padding(bottom = 40.dp),
            contentAlignment = Alignment.BottomEnd
        ) {
            Text(
                text = displayText.ifBlank { "0" },
                color = Color.White,
                fontSize = 80.sp,
                textAlign = TextAlign.End,
                lineHeight = 80.sp
            )
        }
        Column(
            modifier = Modifier.weight(1.5f),
            verticalArrangement = Arrangement.spacedBy(7.dp)
        ) {
            Row(horizontalArrangement = Arrangement.spacedBy(7.dp)) {
                CalculatorButton(text = "AC", modifier = Modifier.weight(2f), backgroundColor = Color.LightGray, textColor = Color.Black, onClick = {
                    viewModel.onAction(CalculatorAction.Clear)
                })
                CalculatorButton(text = "Del", modifier = Modifier.weight(1f), backgroundColor = Color.LightGray, textColor = Color.Black, onClick = {
                    viewModel.onAction(CalculatorAction.Delete)
                })
                CalculatorButton(text = "/", modifier = Modifier.weight(1f), backgroundColor = Color(0xFFE0F7FA), onClick = {
                    viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Divide))
                })
            }
            // Fila 2
            Row(horizontalArrangement = Arrangement.spacedBy(7.dp)) {
                CalculatorButton(text = "7", modifier = Modifier.weight(1f), onClick = {
                    viewModel.onAction(CalculatorAction.Number(7))
                })
                CalculatorButton(text = "8", modifier = Modifier.weight(1f), onClick = {
                    viewModel.onAction(CalculatorAction.Number(8))
                })
                CalculatorButton(text = "9", modifier = Modifier.weight(1f), onClick = {
                    viewModel.onAction(CalculatorAction.Number(9))
                })
                CalculatorButton(text = "*", modifier = Modifier.weight(1f), backgroundColor = Color(0xFFE0F7FA), onClick = {
                    viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Multiply))
                })
            }
            // Fila 3
            Row(horizontalArrangement = Arrangement.spacedBy(7.dp)) {
                CalculatorButton(text = "4", modifier = Modifier.weight(1f), onClick = {
                    viewModel.onAction(CalculatorAction.Number(4))
                })
                CalculatorButton(text = "5", modifier = Modifier.weight(1f), onClick = {
                    viewModel.onAction(CalculatorAction.Number(5))
                })
                CalculatorButton(text = "6", modifier = Modifier.weight(1f), onClick = {
                    viewModel.onAction(CalculatorAction.Number(6))
                })
                CalculatorButton(text = "-", modifier = Modifier.weight(1f), backgroundColor = Color(0xFFE0F7FA), onClick = {
                    viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Subtract))
                })
            }
            // Fila 4
            Row(horizontalArrangement = Arrangement.spacedBy(7.dp)) {
                CalculatorButton(text = "1", modifier = Modifier.weight(1f), onClick = {
                    viewModel.onAction(CalculatorAction.Number(1))
                })
                CalculatorButton(text = "2", modifier = Modifier.weight(1f), onClick = {
                    viewModel.onAction(CalculatorAction.Number(2))
                })
                CalculatorButton(text = "3", modifier = Modifier.weight(1f), onClick = {
                    viewModel.onAction(CalculatorAction.Number(3))
                })
                CalculatorButton(text = "+", modifier = Modifier.weight(1f), backgroundColor = Color(0xFFE0F7FA), onClick = {
                    viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Add))
                })
            }
            // Fila 5
            Row(horizontalArrangement = Arrangement.spacedBy(7.dp)) {
                CalculatorButton(text = "0", modifier = Modifier.weight(1f), onClick = {
                    viewModel.onAction(CalculatorAction.Number(0))
                })
                CalculatorButton(text = ".", modifier = Modifier.weight(1f), onClick = {
                    viewModel.onAction(CalculatorAction.Decimal)
                })
                CalculatorButton(text = "=", modifier = Modifier.weight(2f), backgroundColor = Color(0xFFE0F7FA), onClick = {
                    viewModel.onAction(CalculatorAction.Calculate)
                })
            }
        }
    }
}

@Composable
fun CalculatorButton(
    text: String,
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color(0xFFF7D8BA),
    textColor: Color = Color.Black,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .padding(1.dp),
        shape = RoundedCornerShape(20.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            contentColor = textColor
        )
    ) {
        Text(
            text = text,
            fontSize = 25.sp,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CalculadoraScreenPreview() {
    CalculadoraScreen()
}