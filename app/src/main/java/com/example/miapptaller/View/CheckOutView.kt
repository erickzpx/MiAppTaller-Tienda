package com.example.miapptaller.View

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.outlined.Place
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.miapptaller.ui.theme.Green1 // Tu azul oscuro (#103f6a)
import com.example.miapptaller.ui.theme.AplicacionTallerTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CheckOutView(
    onBackClick: () -> Unit = {}
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Finalizar compra",
                        color = Green1,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Regresar",
                            tint = Green1
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.height(8.dp))

            // 1. SECCIÓN: UBICACIÓN DE ENTREGA
            SectionTitle(title = "Ubicación de entrega")

            // Simulación del Mapa (Mockup sin API)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color(0xFFEBF0F5)), // Un gris/azul muy clarito
                contentAlignment = Alignment.Center
            ) {
                // Si en el futuro descargas una foto de un mapa, puedes cambiar este Icon por un Image con painterResource
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(
                        imageVector = Icons.Outlined.Place,
                        contentDescription = "Mapa",
                        tint = Color.Gray,
                        modifier = Modifier.size(48.dp)
                    )
                    Text("Simulación de Mapa", color = Color.Gray)
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = "Pin",
                    tint = Green1,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Dirección detectada:\nLat: 20.7082, Lng: -100.4400",
                    fontSize = 14.sp,
                    color = Color.DarkGray
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // 2. SECCIÓN: RESUMEN DEL PEDIDO
            SectionTitle(title = "Resumen del Pedido")

            // Lista de productos (Ejemplo adaptado a fútbol)
            OrderRow(item = "1x Adidas Predator Elite", price = "$5299.00")
            Spacer(modifier = Modifier.height(8.dp))

            HorizontalDivider(color = Color.LightGray, thickness = 1.dp)
            Spacer(modifier = Modifier.height(8.dp))

            OrderRow(item = "Subtotal:", price = "$5299.00", color = Color.Gray)
            OrderRow(item = "Costo de Envío:", price = "$150.00", color = Color.Gray)

            Spacer(modifier = Modifier.height(8.dp))

            // Total a Pagar
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Total a Pagar:", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Text(text = "$5449.00", fontWeight = FontWeight.Bold, fontSize = 18.sp, color = Green1)
            }

            Spacer(modifier = Modifier.height(24.dp))

            // 3. SECCIÓN: MÉTODO DE PAGO
            SectionTitle(title = "Método de Pago")

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFF8FAFC)) // Blanco azulado
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(selected = true, onClick = { /*TODO*/ })
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "Tarjeta de Crédito / Débito", fontSize = 16.sp)
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            // BOTÓN FINALIZAR
            Button(
                onClick = { /* TODO: Acción de compra */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Green1),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(text = "Confirmar Pedido", fontSize = 16.sp, fontWeight = FontWeight.Bold)
            }

            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}

@Composable
fun SectionTitle(title: String) {
    Text(
        text = title,
        color = Green1,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        modifier = Modifier.padding(bottom = 12.dp)
    )
}

@Composable
fun OrderRow(item: String, price: String, color: Color = Color.Black) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = item, fontSize = 15.sp, color = color)
        Text(text = price, fontSize = 15.sp, color = color)
    }
}

@Preview(showBackground = true)
@Composable
fun CheckOutPreview() {
    AplicacionTallerTheme {
        CheckOutView()
    }
}