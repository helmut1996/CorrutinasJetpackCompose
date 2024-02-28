  package com.example.corrutinasapp

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.corrutinasapp.ui.theme.CorrutinasappTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewmodel:MainViewModel by viewModels()
        setContent {
            CorrutinasappTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                  Content(viewmodel)
                 }
            }
        }
    }
}

  @Composable
  fun Content(viewModel: MainViewModel){
      Column(
          verticalArrangement = Arrangement.Center,
          horizontalAlignment = Alignment.CenterHorizontally
      ) {
          BotonColor()
          if (viewModel.loading){
              CircularProgressIndicator()
          }else{
              Text(text = viewModel.resultState)
          }
          Button(onClick = { viewModel.fetchData() }) {
              Text(text = "LLamar API")
          }
      }
  }


@Composable
  fun BotonColor(){
      var color by remember { mutableStateOf(false) }
      Button(onClick = {color= !color}, colors = ButtonDefaults.buttonColors(
       containerColor = if (color) androidx.compose.ui.graphics.Color.Blue else androidx.compose.ui.graphics.Color.Red
      )) {
            Text(text = "Cambiar Color")
      }
  }