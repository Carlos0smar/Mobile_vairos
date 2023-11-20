import 'package:flutter/material.dart';

class Lugares extends StatefulWidget {
  const Lugares({super.key});
  @override
  State<Lugares> createState() => _Lugares();
}

class _Lugares extends State<Lugares> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Lugares'),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            Text(
              'Hello, World!',
              style: TextStyle(fontSize: 24),
            ),
          ],
        ),
      ),
    );
  }
}
