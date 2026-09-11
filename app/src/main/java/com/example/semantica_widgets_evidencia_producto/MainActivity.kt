package com.example.semantica_widgets_evidencia_producto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            App()
        }
    }
}

@Composable
fun App(modifier: Modifier = Modifier) {

    var mostrarHistoria by remember { mutableStateOf( false) }

    Column(
        modifier = modifier.fillMaxSize()
    ) {
        // HEADER
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(Color(0xFF1E293B)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "La Historia del Chicle",
                fontSize = 20.sp,
                color = Color.LightGray
            )
        }

        // MAIN

      if (mostrarHistoria) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .background(Color(0xFFE0F2FE)) // Color Azul Nieve
                    .padding(24.dp),
                contentAlignment = Alignment.Center,
            )
            {
                Text(
                    text = "Su popularidad masiva despegó a finales del siglo XIX, cuando el expresidente mexicano Antonio López de Santa Anna llevó esta resina a Estados Unidos y se la presentó al inventor Thomas Adams. Adams le añadió azúcar y saborizantes, transformando la resina tradicional en las primeras golosinas comerciales; más tarde, las campañas masivas durante la Segunda Guerra Mundial —donde se incluía en las raciones de los soldados estadounidenses— terminaron por globalizar su consumo.",
                    color = Color(0xFF0F172A),
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Medium,
                    lineHeight = 24.sp
                )
            }

      } else {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .background(Color(0xFF90CAF9)),
                contentAlignment = Alignment.Center
            ) {
                ContainerMain()
            }
        }
        // FOOTER
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(Color(0xFF1E293B)),
            contentAlignment = Alignment.Center
        ) {
            Button(
                onClick = { mostrarHistoria = !mostrarHistoria },

            ) {
                Text(
                    text = if (mostrarHistoria) "Ocultar Historia" else "Saber más",
                    fontSize = 16.sp,
                    color = Color.White
                )

            }

        }
    }
}

@Composable
fun ContainerMain(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxSize()
    ) {
        // NAVEGACIÓN
        Column(
            modifier = Modifier
                .weight(1.5f)
                .fillMaxHeight()
                .background(Color(0xFF1E293B))
                .padding(vertical = 12.dp, horizontal = 5.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = painterResource(id = R.drawable.chicle),
                contentDescription = "Imagen ",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .weight(1f)
                    .padding(4.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.chicle2),
                contentDescription = "Imagen I",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .weight(1f)
                    .padding(4.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.chicle3),
                contentDescription = "Imagen II",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .weight(1f)
                    .padding(4.dp)
            )
        }

        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
        ) {
            // SECCIÓN 1
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .background(Color(0xFFF8FAFC)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Surgió originalmente cuando los antiguos mayas extraían la resina del árbol del chicozapote (Manilkara zapota). " +
                            "Para masticarla y limpiar sus dientes o calmar el hambre.",
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(horizontal = 15.dp),
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 20.sp,
                )
            }

            // SECCIÓN 2
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .background(Color(0xFFE0F2FE)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "A finales del siglo XIX, esa misma resina se mezcló con azúcar en EE.UU., dando inicio a la industria moderna.",
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(horizontal = 15.dp),
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 22.sp,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Vista() {
    App()
}