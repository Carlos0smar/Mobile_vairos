import 'package:flutter/material.dart';

class Avisos extends StatefulWidget {
  const Avisos({super.key});
  @override
  State<Avisos> createState() => _Avisos();
}

class _Avisos extends State<Avisos> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Avisos'),
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
