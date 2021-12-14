import 'package:coursework/pages/success_page.dart';
import 'package:firebase_core/firebase_core.dart';
import 'package:flutter/material.dart';
import 'package:coursework/pages/home_page.dart';
import 'package:coursework/pages/login_page.dart';
import 'package:coursework/pages/register_page.dart';
import 'package:coursework/pages/error_page.dart';

void initFirebase() async {
  WidgetsFlutterBinding.ensureInitialized();
  await Firebase.initializeApp();
}

void main() {
  initFirebase();
  runApp(MaterialApp(initialRoute: '/', routes: {
    '/': (context) => const HomePage(),
    '/login': (context) => const LoginPage(),
    '/register': (context) => const RegisterPage(),
    '/success': (context) => const SuccessPage(),
    '/error': (context) => const ErrorPage(),
  }));
}
