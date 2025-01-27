import 'package:curved_navigation_bar/curved_navigation_bar.dart';
import 'package:flutter/material.dart';

class HomePage extends StatefulWidget {
  const HomePage({Key? key}) : super(key: key);

  @override
  State<HomePage> createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  int _currentIndex = 2;

  @override
  Widget build(BuildContext context){
    return Scaffold(
      backgroundColor: Colors.deepPurple,
      bottomNavigationBar: CurvedNavigationBar(
          backgroundColor: Colors.deepPurple,
          index: _currentIndex,
          items: const [
        Icon(Icons.assignment),
        Icon(Icons.notifications),
        Icon(Icons.home),
        Icon(Icons.directions_bus),
        Icon(Icons.person)
      ],
        onTap: (index) {
            setState(() {
              _currentIndex = index;
        });
      }
      ),
    );
  }
}