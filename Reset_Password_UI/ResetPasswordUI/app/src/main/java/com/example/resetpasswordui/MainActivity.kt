// MainActivity.kt
package com.example.resetpasswordui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.resetpasswordui.ui.theme.ResetPasswordUITheme
import androidx.compose.foundation.clickable
import androidx.compose.ui.platform.LocalContext
import android.app.Activity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ResetPasswordUITheme {
                ResetPasswordScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResetPasswordScreen() {
    val context = LocalContext.current as? Activity

    // ✅ FIXED: Use proper state variables
    var newPassword by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var parentNumber by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF00C853)), // Green background
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Back Icon (Top Left Corner)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, top = 35.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.round_arrow_back_ios_24),
                    contentDescription = "Back Icon",
                    modifier = Modifier
                        .size(30.dp)
                        .clickable { context?.onBackPressed() },
                    colorFilter = androidx.compose.ui.graphics.ColorFilter.tint(Color.White)
                )
            }

            // Lock Icon
            Image(
                painter = painterResource(id = R.drawable.forgot_password),
                contentDescription = "Custom Lock Icon",
                modifier = Modifier
                    .size(250.dp)
                    .padding(top = 0.dp)
                    .rotate(0f) // Slightly tilted icon
            )

            // White Card Below the Icon
            Card(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 0.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    // Reset Password Title
                    Text(
                        text = "Reset Password?",
                        fontSize = 30.sp,
                        color = Color.Black
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // ✅ FIXED: New Password Field
                    Text(text = "New Password")
                    // New Password Field (Shows normal text)
                    TextField(
                        value = newPassword,
                        onValueChange = { newPassword = it },
                        placeholder = { Text("Enter new password") },
                        shape = RoundedCornerShape(12.dp),
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color(0xFFF5F5F5),  // Light Gray Background
                            focusedIndicatorColor = Color.Transparent, // No underline
                            unfocusedIndicatorColor = Color.Transparent
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )
                    Text(text = "Password must be 8+ characters with a number & symbol", fontSize = 12.sp)

                    Spacer(modifier = Modifier.height(8.dp))

                    // ✅ FIXED: Confirm Password Field
                    Text(text = "Confirm Password")
                    TextField(
                        value = confirmPassword,
                        onValueChange = { confirmPassword = it },
                        placeholder = { Text("Re-enter password") },
                        shape = RoundedCornerShape(12.dp),
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color(0xFFF5F5F5),
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    // ✅ FIXED: Parent Number Field
                    Text(text = "Parent Number")
                    TextField(
                        value = parentNumber,
                        onValueChange = { parentNumber = it },
                        placeholder = { Text("Enter parent number") },
                        shape = RoundedCornerShape(12.dp),
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color(0xFFF5F5F5),
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Send Button
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {
                        Button(
                            onClick = { /* TODO: Implement send functionality */ },
                            shape = RoundedCornerShape(12.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFEB3B)),
                            modifier = Modifier.fillMaxWidth(0.5f)
                        ) {
                            Text(text = "Send", fontSize = 16.sp, color = Color.Black)
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewResetPasswordScreen() {
    ResetPasswordUITheme {
        ResetPasswordScreen()
    }
}
