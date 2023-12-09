import 'dart:convert';
import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'package:flutter_mobile/screens/data_model.dart';
// import 'package:sis104/models/data_model.dart';

class RecoveryPage extends StatefulWidget {
  @override
  _RecoveryState createState() => _RecoveryState();
}


class _RecoveryState extends State<RecoveryPage> {
  bool _isLoading = true;

  @override
  void initState() {
    super.initState();
    _getData();
  }

  DataModel? dataFromAPI;
  _getData() async {
    try {
      String url = "https://dummyjson.com/products";
      http.Response res = await http.get(Uri.parse(url));
      if (res.statusCode == 200) {
        dataFromAPI = DataModel.fromJson(json.decode(res.body));
        _isLoading = false;
        setState(() {});
      }
    } catch (e) {
      debugPrint(e.toString());
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
          title: const Text('Recovery data'),
          backgroundColor: Colors.blueAccent),
      body: _isLoading
          ? const Center(
              child: CircularProgressIndicator(),
            )
          : ListView.builder(
              scrollDirection: Axis.vertical,
              itemBuilder: (context, index) {
                return Padding(
                  padding: const EdgeInsets.all(8.0),
                  child: Row(
                    mainAxisAlignment: MainAxisAlignment.spaceBetween,
                    children: [
                      Image.network(
                        dataFromAPI!.products[index].thumbnail,
                        width: 100,
                      ),
                      Text(dataFromAPI!.products[index].title.toString()),
                      Text(
                          "\$${dataFromAPI!.products[index].price.toString()}"),
                    ],
                  ),
                );
              },
              itemCount: dataFromAPI!.products.length,
            ),
    );
  }
}
