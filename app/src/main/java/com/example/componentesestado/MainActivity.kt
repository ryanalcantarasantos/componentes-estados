package com.example.componentesestado

import android.R.attr.contentDescription
import android.R.attr.fontWeight
import android.R.attr.text
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.componentesestado.ui.theme.ComponentesEstadoTheme
import com.example.componentesestado.ui.theme.fonte

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComponentesEstadoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BasicComponentsScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun BasicComponentsScreen(modifier: Modifier = Modifier) {
    var textoInput by remember {
        mutableStateOf("batatal")
    }

    var quantidade by remember {
        mutableStateOf("")
    }

    var email by remember {
        mutableStateOf("")
    }

    var kotlin by remember {
        mutableStateOf(false)
    }

    var jetpack by remember {
        mutableStateOf(false)
    }

    var android by remember {
        mutableStateOf(false)
    }

    var sistemaSelecionado by remember {
        mutableStateOf("")
    }

    var corFundo by remember {
        mutableStateOf(Color(239, 247, 207))
    }

    var favoritado by remember {
        mutableStateOf(false)
    }


    Column(
        modifier = modifier
            .fillMaxSize()
            .background(corFundo)

    ) {

        Text(
            text = "Aulas android",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF3DDC84),
            fontFamily = FontFamily.Serif,
            modifier = Modifier
                .fillMaxWidth(),
            textAlign = TextAlign.End,
            letterSpacing = 4.sp
        )
        Text(
            text = "Com jetpack compose",
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(66, 137, 244),
            fontFamily = fonte,
            modifier = Modifier.align(Alignment.CenterHorizontally)

        )

        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = textoInput,
            onValueChange = { novoValor ->
                Log.i("teste", novoValor)

                textoInput = novoValor
            },

            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Words
            ),

            label = {
                Text("Nome e sobrenome")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Pessoa",
                    tint = Color(66, 133, 244)
                )
            },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Icone pessoa",
                    tint = Color(66, 133, 244)
                )
            }
        )

        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = quantidade,
            onValueChange = { novoValor ->
                quantidade = novoValor
            },

            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
            placeholder = {
                Text("Qual a quantidade?")
            },
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.Blue,
                unfocusedTextColor = Color.Red,
                unfocusedPlaceholderColor = Color.Magenta
            )



        )

        Spacer(modifier = Modifier.height(16.dp)

        )


        OutlinedTextField(
            value = email,
            onValueChange = { email = it  },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Email")
            },
            placeholder = {
                Text(text = "Digite seu email")
            },
            shape = RoundedCornerShape(
                topStart = 32.dp,
                bottomEnd = 32.dp
            ),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Blue,
                unfocusedBorderColor = Color.Red
            )
        )

        Row(verticalAlignment = Alignment.CenterVertically) {

            Checkbox(
                checked = kotlin,
                onCheckedChange = {kotlin = it},
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Blue,
                    uncheckedColor = Color.Red
                )
            )

            Text("Kotlin")
        }

        Row(verticalAlignment = Alignment.CenterVertically) {

            Checkbox(
                checked = jetpack,
                onCheckedChange = {jetpack = it},
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Blue,
                    uncheckedColor = Color.Red
                )
            )

            Text("Jetpack")
        }

        Row(verticalAlignment = Alignment.CenterVertically) {

            Checkbox(
                checked = android,
                onCheckedChange = {android = it},
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Blue,
                    uncheckedColor = Color.Red
                )
            )

            Text("Android")
        }

        Row(verticalAlignment = Alignment.CenterVertically) {

            RadioButton(
                selected = sistemaSelecionado == "mo",
                onClick = {sistemaSelecionado = "mo"}
            )

            Text("MacOs")
        }

        Row(verticalAlignment = Alignment.CenterVertically) {

            RadioButton(
                selected = sistemaSelecionado == "wi",
                onClick = {sistemaSelecionado = "wi"}
            )

            Text("Windows")
        }

        Row(verticalAlignment = Alignment.CenterVertically) {

            RadioButton(
                selected = sistemaSelecionado == "li",
                onClick = {sistemaSelecionado = "li"}
            )

            Text("Linux")
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Button(
                onClick = {corFundo = Color.Cyan},
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Blue,
                    contentColor = Color.Green
                ),

                border = BorderStroke(4.dp,Color.Red),
                shape = RoundedCornerShape(topEnd = 12.dp, bottomStart = 12.dp)

            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "Star"
                    )

                    Text("Clique aqui!")
                }

            }

            OutlinedButton(
                onClick = {
                    corFundo = Color.Red
                }
            ) {
                Text("Outro botao")
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            if (favoritado) {
                Icon(
                    modifier = Modifier.size(40.dp)
                        .clickable {
                            favoritado = false
                        },
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Favorite Icon"
                )


            } else {
                Icon(
                    modifier = Modifier.size(40.dp)
                        .clickable {
                            favoritado = true
                        },
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = "Favorite Border Icon"
                )

            }
        }






    }

}

@Composable
fun AndroidEnemy(
    color: Color,
    modifier: Modifier = Modifier
) {
    Image(
        modifier = modifier,
        painter = painterResource(R.drawable.ic_launcher_foreground),
        colorFilter = ColorFilter.tint(color = color),
        contentDescription = "Android Enemy"
    )

}