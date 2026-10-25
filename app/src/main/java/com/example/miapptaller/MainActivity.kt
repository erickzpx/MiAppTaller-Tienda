package com.example.miapptaller
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.miapptaller.View.ContadorScreen
import com.example.miapptaller.View.HomeView
import com.example.miapptaller.View.LoginView
import com.example.miapptaller.ViewModel.ContadorViewModel
import com.example.miapptaller.navigation.NavGraph
import com.example.miapptaller.ui.theme.AplicacionTallerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AplicacionTallerTheme {
                Scaffold( modifier = Modifier.fillMaxSize() ) { innerPadding ->
                    NavGraph(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}