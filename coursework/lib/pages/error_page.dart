import 'package:flutter/material.dart';

class ErrorPage extends StatefulWidget {
  const ErrorPage({Key? key}) : super(key: key);

  @override
  State<ErrorPage> createState() => _ErrorPageState();
}

class _ErrorPageState extends State<ErrorPage> {
  @override
  Widget build(BuildContext context) {
    return SafeArea(
      child: Container(
        decoration: const BoxDecoration(
            image: DecorationImage(
                image: AssetImage("assets/homepage.png"), fit: BoxFit.cover)),
        child: const Center(
          child: Text('Error',style: TextStyle(backgroundColor: Colors.transparent),),
        ),
      ),
    );
  }

}
