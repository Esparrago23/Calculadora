package com.patatus.calculadora.presentation.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CalculadoraScreen(){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.DarkGray),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Box(modifier = Modifier.weight(1f) .padding(16.dp)) {
            Text(text = "Calculadora", modifier = Modifier
                .background(color = Color.Gray)
            )
        }
        Column(modifier = Modifier.weight(2f)) {
            Row() {
                Button(colors = ButtonDefaults.buttonColors(),
                    onClick = { /*TODO*/ }) {
                        Text(text = "AC")
                }
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Del")
                }
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "/")
                }
            }
            Row() {
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "7")
                }
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "8")
                }
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "9")
                }
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "*")
                }
            }
            Row() {
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "4")
                }
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "5")
                }
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "6")
                }
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "-")
                }
            }
            Row() {
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "1")
                }
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "2")
                }
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "3")
                }
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "+")
                }
            }
            Row() {
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "0")
                }
                Button(onClick = { /*TODO*/ }) {
                    Text(text = ".")
                }
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "=")
                }
            }

        }
    }
}


@Preview(showBackground = true)
@Composable
fun CalculadoraScreenPreview() {
    CalculadoraScreen()
}