// lib/main.dart
import 'package:flutter/material.dart';
import 'package:school_see_navbar/screens/otp_verification.dart';


void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'OTP UI',
      home: OTPVerificationScreen(),
    );
  }
}
