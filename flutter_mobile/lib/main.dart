import 'package:flutter/material.dart';
//import 'package:flutter_application_1/modules/operaciones/PruebaPage.dart';

void main() {
  runApp(const MainApp());
}

class MainApp extends StatelessWidget {
  const MainApp({super.key});

  @override
  Widget build(BuildContext context) {
    return const MaterialApp(
      title: 'Por un mundo Saludable',
      debugShowCheckedModeBanner: false,
      home: BeginPage(),
    );
  }
}

class BeginPage extends StatefulWidget {
  const BeginPage({Key? key}) : super(key: key);
  @override
  State<BeginPage> createState() => BeginPageState();
}

class BeginPageState extends State<BeginPage> {
  @override
  Widget build(BuildContext context) {
    return Container(
        alignment: Alignment.center,
        decoration: const BoxDecoration(
          image: DecorationImage(
            image: AssetImage("assets/images/background.jpg"),
            fit: BoxFit.cover,
          ),
        ),
        child: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.spaceEvenly,
            crossAxisAlignment: CrossAxisAlignment.center,
            children: <Widget>[
              Row(
                mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                crossAxisAlignment: CrossAxisAlignment.center,
                children: <Widget>[
                  _createButtonItem(
                      imagen: 'assets/images/lugares.jpg',
                      text: 'Lugares',
                      splashColor:
                          Colors.blue, // color diferente para el splash
                      onTap: () {
                        //const PruebaPage();
                      }),
                  _createButtonItem(
                      imagen: 'assets/images/aprender.jpg',
                      text: 'Aprender',
                      splashColor:
                          Colors.green, // color diferente para el splash
                      onTap: () {
                        //const PrimeraPage();
                      }),
                ],
              ),
              Row(
                mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                crossAxisAlignment: CrossAxisAlignment.center,
                children: <Widget>[
                  _createButtonItem(
                      imagen: 'assets/images/evaluacion.png',
                      text: 'Evaluacion',
                      splashColor: Colors.red, // color diferente para el splash
                      onTap: () {
                        //const PrimeraPage();
                      }),
                  _createButtonItem(
                      imagen: 'assets/images/avisos.jpg',
                      text: 'Avisos',
                      splashColor:
                          Colors.yellow, // color diferente para el splash
                      onTap: () {
                        //const PrimeraPage();
                      }),
                ],
              ),
            ],
          ),
        ));
  }

  Widget _createButtonItem(
      {String? imagen,
      String? text,
      Color? splashColor, // parámetro opcional para el color del splash
      GestureTapCallback? onTap}) {
    text ??= '';
    imagen ??= '';
    splashColor ??= Colors.white; // valor por defecto para el color del splash
    return Material(
      color: Colors.white,
      elevation: 8,
      borderRadius: BorderRadius.circular(6),
      clipBehavior: Clip.antiAliasWithSaveLayer,
      child: InkWell(
        splashColor: splashColor, // asignar el valor del parámetro al atributo
        onTap: onTap,
        child: Column(
          mainAxisSize: MainAxisSize.min,
          children: [
            Ink.image(
              image: AssetImage(imagen),
              height: 120,
              width: 120,
              //fit: BoxFit.cover,
            ),
            const Divider(
              height: 6,
            ),
            Text(
              text,
              style: TextStyle(fontSize: 15, color: Colors.green.shade900),
            ),
          ],
        ),
      ),
    );
  }
}