import 'package:flutter/material.dart';

class Evaluacion extends StatefulWidget {
  const Evaluacion({super.key});
  @override
  State<Evaluacion> createState() => _Evaluacion();
}

class _Evaluacion extends State<Evaluacion> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Evaluacion'),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            Text(
              'Evaluacion',
              style: TextStyle(fontSize: 24),
            ),
          ],
        ),
      ),
    );
  }
}
