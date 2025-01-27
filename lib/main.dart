// lib/main.dart
import 'package:flutter/material.dart';
import 'package:school_see_navbar/homepage.dart'; // Import HomePage correctly

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: HomePage(), // Use HomePage as the starting point
    );
  }
}
