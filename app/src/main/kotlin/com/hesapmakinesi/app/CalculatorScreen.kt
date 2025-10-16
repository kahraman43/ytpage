package com.hesapmakinesi.app

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun CalculatorScreen(
    viewModel: CalculatorViewModel = viewModel()
) {
    val state by viewModel.state.collectAsState()
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1E1E1E))
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // Display
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = state.previousNumber + " ${state.operation}",
                fontSize = 24.sp,
                color = Color.Gray,
                textAlign = TextAlign.End,
                modifier = Modifier.fillMaxWidth()
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Text(
                text = state.currentNumber.ifEmpty { "0" },
                fontSize = 56.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.End,
                modifier = Modifier.fillMaxWidth(),
                maxLines = 2
            )
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // Buttons
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Row 1: C, ±, %, ÷
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                CalculatorButton(
                    text = "C",
                    modifier = Modifier.weight(1f),
                    backgroundColor = Color(0xFFA5A5A5),
                    textColor = Color.Black,
                    onClick = { viewModel.onAction(CalculatorAction.Clear) }
                )
                CalculatorButton(
                    text = "±",
                    modifier = Modifier.weight(1f),
                    backgroundColor = Color(0xFFA5A5A5),
                    textColor = Color.Black,
                    onClick = { viewModel.onAction(CalculatorAction.ToggleSign) }
                )
                CalculatorButton(
                    text = "%",
                    modifier = Modifier.weight(1f),
                    backgroundColor = Color(0xFFA5A5A5),
                    textColor = Color.Black,
                    onClick = { viewModel.onAction(CalculatorAction.Percent) }
                )
                CalculatorButton(
                    text = "÷",
                    modifier = Modifier.weight(1f),
                    backgroundColor = Color(0xFFFF9500),
                    textColor = Color.White,
                    onClick = { viewModel.onAction(CalculatorAction.Operation("/")) }
                )
            }
            
            // Row 2: 7, 8, 9, ×
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                CalculatorButton(
                    text = "7",
                    modifier = Modifier.weight(1f),
                    onClick = { viewModel.onAction(CalculatorAction.Number("7")) }
                )
                CalculatorButton(
                    text = "8",
                    modifier = Modifier.weight(1f),
                    onClick = { viewModel.onAction(CalculatorAction.Number("8")) }
                )
                CalculatorButton(
                    text = "9",
                    modifier = Modifier.weight(1f),
                    onClick = { viewModel.onAction(CalculatorAction.Number("9")) }
                )
                CalculatorButton(
                    text = "×",
                    modifier = Modifier.weight(1f),
                    backgroundColor = Color(0xFFFF9500),
                    textColor = Color.White,
                    onClick = { viewModel.onAction(CalculatorAction.Operation("×")) }
                )
            }
            
            // Row 3: 4, 5, 6, −
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                CalculatorButton(
                    text = "4",
                    modifier = Modifier.weight(1f),
                    onClick = { viewModel.onAction(CalculatorAction.Number("4")) }
                )
                CalculatorButton(
                    text = "5",
                    modifier = Modifier.weight(1f),
                    onClick = { viewModel.onAction(CalculatorAction.Number("5")) }
                )
                CalculatorButton(
                    text = "6",
                    modifier = Modifier.weight(1f),
                    onClick = { viewModel.onAction(CalculatorAction.Number("6")) }
                )
                CalculatorButton(
                    text = "−",
                    modifier = Modifier.weight(1f),
                    backgroundColor = Color(0xFFFF9500),
                    textColor = Color.White,
                    onClick = { viewModel.onAction(CalculatorAction.Operation("-")) }
                )
            }
            
            // Row 4: 1, 2, 3, +
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                CalculatorButton(
                    text = "1",
                    modifier = Modifier.weight(1f),
                    onClick = { viewModel.onAction(CalculatorAction.Number("1")) }
                )
                CalculatorButton(
                    text = "2",
                    modifier = Modifier.weight(1f),
                    onClick = { viewModel.onAction(CalculatorAction.Number("2")) }
                )
                CalculatorButton(
                    text = "3",
                    modifier = Modifier.weight(1f),
                    onClick = { viewModel.onAction(CalculatorAction.Number("3")) }
                )
                CalculatorButton(
                    text = "+",
                    modifier = Modifier.weight(1f),
                    backgroundColor = Color(0xFFFF9500),
                    textColor = Color.White,
                    onClick = { viewModel.onAction(CalculatorAction.Operation("+")) }
                )
            }
            
            // Row 5: 0, ., =
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                CalculatorButton(
                    text = "0",
                    modifier = Modifier.weight(2f),
                    onClick = { viewModel.onAction(CalculatorAction.Number("0")) }
                )
                CalculatorButton(
                    text = ",",
                    modifier = Modifier.weight(1f),
                    onClick = { viewModel.onAction(CalculatorAction.Decimal) }
                )
                CalculatorButton(
                    text = "=",
                    modifier = Modifier.weight(1f),
                    backgroundColor = Color(0xFFFF9500),
                    textColor = Color.White,
                    onClick = { viewModel.onAction(CalculatorAction.Calculate) }
                )
            }
        }
    }
}

@Composable
fun CalculatorButton(
    text: String,
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color(0xFF333333),
    textColor: Color = Color.White,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier.aspectRatio(if (text == "0") 2.2f else 1f),
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor
        ),
        shape = RoundedCornerShape(16.dp),
        contentPadding = PaddingValues(0.dp)
    ) {
        Text(
            text = text,
            fontSize = 32.sp,
            color = textColor,
            fontWeight = FontWeight.Medium
        )
    }
}
