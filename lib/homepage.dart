// lib/homepage.dart
import 'package:flutter/material.dart';
import 'package:curved_navigation_bar/curved_navigation_bar.dart';
import 'package:school_see_navbar/BusTrackingScreen.dart'; // Correct import path

class HomePage extends StatefulWidget {
  const HomePage({Key? key}) : super(key: key);

  @override
  State<HomePage> createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  int _currentIndex = 2; // Default to the Home tab

  @override
  Widget build(BuildContext context) {
    // List of screens for navigation bar
    final List<Widget> screens = [
      const PlaceholderScreen(title: "Assignments"),
      const PlaceholderScreen(title: "Notifications"),
      const PlaceholderScreen(title: "Home"),
      BusTrackingScreen(), // Add the Bus Tracking screen
      const PlaceholderScreen(title: "Profile"),
    ];

    return Scaffold(
      body: screens[_currentIndex], // Display the selected screen
      bottomNavigationBar: CurvedNavigationBar(
        backgroundColor: Colors.deepPurple, // Adjust for color coordination
        color: Colors.white,
        index: _currentIndex, // Show the active screen
        items: const [
          Icon(Icons.assignment, size: 30),
          Icon(Icons.notifications, size: 30),
          Icon(Icons.home, size: 30),
          Icon(Icons.directions_bus, size: 30),
          Icon(Icons.person, size: 30),
        ],
        onTap: (index) {
          setState(() {
            _currentIndex = index; // Update selected index
          });
        },
      ),
    );
  }
}

// Placeholder screen for other sections
class PlaceholderScreen extends StatelessWidget {
  final String title;

  const PlaceholderScreen({Key? key, required this.title}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.deepPurple,
      body: Center(
        child: Text(
          title,
          style: TextStyle(fontSize: 24, color: Colors.white),
        ),
      ),
    );
  }
}
