package com.vicks.secondapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
//import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.foundation.verticalScroll
//import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
//import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
//import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
//import androidx.compose.material3.LocalTextStyle
//import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
//import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
//import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.res.colorResource
//import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.TextStyle
//import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vicks.secondapp.ui.theme.Blue10
import com.vicks.secondapp.ui.theme.Blue30
import com.vicks.secondapp.ui.theme.Brown20
import com.vicks.secondapp.ui.theme.SecondAppTheme
import com.vicks.secondapp.ui.theme.white20
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SecondAppTheme {
                // A surface container using the 'background' color from the theme
                View()
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Preview
    @Composable
    fun View() {
        val scroll = rememberScrollState()
        var email by remember { mutableStateOf(" ") }
        var error by remember { mutableStateOf(" ") }
        var password by remember { mutableStateOf(" ") }
        Column(
            Modifier
                .fillMaxSize()
                .padding(20.dp, 20.dp)
                .verticalScroll(scroll),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalAlignment = CenterHorizontally
        ) {
            Text(
                "Welcome new User",
                modifier = Modifier.padding(24.dp),
                color = Blue30,
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(20.dp),
                horizontalAlignment = CenterHorizontally
            ) {

                Text(error, color = Color.Red)
                OutlinedTextField(
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        textColor = Brown20,
                        disabledTextColor = Color.Gray,
                        selectionColors = TextSelectionColors(
                            handleColor = Blue10,
                            backgroundColor = white20
                        )
                    ),
                    value = email,
                    onValueChange = { email = it },
                    modifier = Modifier
                        .size(388.dp, 60.dp)
                        .clip(RoundedCornerShape(4.dp)),
                    label = { Text("Email", fontSize = 16.sp, fontWeight = FontWeight.Medium) },
                    placeholder = { Text("Enter an email", fontWeight = FontWeight.Light) },
                    trailingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_person_24),
                            contentDescription = "profile icon",
                            modifier = Modifier
                                .size(32.dp, 32.dp)
                                .align(CenterHorizontally),
                            tint = Brown20
                        )
                    }
                )
                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Password", fontSize = 16.sp, fontWeight = FontWeight.Medium) },
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(4.dp))
                        .size(388.dp, 60.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        textColor = Brown20,
                        disabledTextColor = Color.Gray,
                        selectionColors = TextSelectionColors(
                            handleColor = Blue10,
                            backgroundColor = white20
                        )
                    ),
                    placeholder = { Text("enter a password", fontWeight = FontWeight.Light) },
                    trailingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.lock),
                            contentDescription = "password icon",
                            modifier = Modifier
                                .size(24.dp, 24.dp)
                                .align(CenterHorizontally),
                            tint = Brown20
                        )
                    }
                )
            }
            Column(horizontalAlignment = Alignment.Start) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = false,
                        onCheckedChange = {},
                        modifier = Modifier.size(24.dp, 24.dp),
                        colors = CheckboxDefaults.colors(
                            checkedColor = Color.Green,
                            uncheckedColor = Brown20
                        )
                    )
                    Text("I accept the Terms and Conditions", fontSize = 12.sp)
                }
            }

            Button(
                onClick = {
                    if (email.length < 10) error = "Invalid email"
                    else if (password.length < 6) error = "Password must be at least 6 characters"
                    else if(!email.contains('@',true))  error = "Invalid email format"
                    //else if(!password.contains())
                },
                Modifier.size(388.dp, 48.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Blue30,
                    contentColor = white20
                )
            ) {
                Text("Sign In", fontSize = 16.sp, fontWeight = FontWeight.Medium)
            }
            Text("Or", fontSize = 16.sp,textAlign = TextAlign.Center)
            OutlinedButton(
                colors = ButtonDefaults.outlinedButtonColors(contentColor = Brown20),
                modifier = Modifier.size(388.dp, 48.dp),
                shape = RoundedCornerShape(8.dp),
                onClick = {
                    if (email.length < 10) error = "Invalid email"
                    else if (password.length < 6) error = "Password must be at least 6 characters"
                }) {
                Image(
                    painter = painterResource(id = R.drawable.google),
                    contentDescription = "Google icon",
                    modifier = Modifier
                        .size(32.dp, 32.dp)
                        .padding(8.dp, 0.dp)
                )
                Text("Continue with Google", fontSize = 16.sp, fontWeight = FontWeight.Medium)
            }
            Row(horizontalArrangement = Arrangement.spacedBy(2.dp),
                verticalAlignment = Alignment.CenterVertically){
                Text("Already have an Account?")
                TextButton(onClick = { },modifier = Modifier.padding(0.dp,0.dp),colors = ButtonDefaults.textButtonColors(contentColor=Blue30)) {
                    Text("Sign In")

                }
            }
        }
    }
}
