import 'package:flutter/material.dart';

class Aprender extends StatefulWidget {
  const Aprender({super.key});
  @override
  State<Aprender> createState() => _Aprender();
}

class _Aprender extends State<Aprender> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Aprender'),
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
