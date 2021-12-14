import 'package:coursework/dao/database_service.dart';
import 'package:flutter/material.dart';

class LoginPage extends StatefulWidget {
  const LoginPage({Key? key}) : super(key: key);

  @override
  State<LoginPage> createState() => _LoginPageState();
}

class _LoginPageState extends State<LoginPage> {
  bool obscured = true;
  String login = "";
  String password = "";

  @override
  Widget build(BuildContext context) {
    return SafeArea(
      child: Container(
          decoration: const BoxDecoration(
              image: DecorationImage(
                  image: AssetImage("assets/homepage.png"), fit: BoxFit.cover)),
          child: Scaffold(
            backgroundColor: Colors.transparent,
            body: Column(
              mainAxisAlignment: MainAxisAlignment.end,
              crossAxisAlignment: CrossAxisAlignment.center,
              children: [
                TextFormField(
                  onChanged: (String editLogin) {
                    login = editLogin;
                  },
                  onFieldSubmitted: (String editLogin) {
                    login = editLogin;
                  },
                  initialValue: login,
                  decoration: const InputDecoration(
                    focusColor: Colors.orange,
                    labelText: 'Login',
                    border: OutlineInputBorder(),
                  ),
                ),
                const SizedBox(
                  height: 30,
                ),
                TextFormField(
                  onChanged: (String editPassword) {
                    password = editPassword;
                  },
                  onFieldSubmitted: (String editPassword) {
                    password = editPassword;
                  },
                  obscureText: obscured,
                  initialValue: password,
                  decoration: const InputDecoration(
                    labelText: 'Password',
                    border: OutlineInputBorder(),
                  ),
                ),
                IconButton(
                  icon: const Icon(Icons.admin_panel_settings),
                  onPressed: () {
                    setState(() {
                      obscured = !obscured;
                    });
                  },
                ),
                ElevatedButton(
                    onPressed: () {
                      if (password.isNotEmpty && login.isNotEmpty) {
                        var base = DataBaseService();

                        var future = base.checkUser(login, password);
                        var isDone = false;
                        future.then((value) => isDone = value);
                        if (isDone) {
                          Navigator.pushNamed(context, '/success');
                        }else{
                          Navigator.pushNamed(context, '/error');
                        }
                      }
                    },
                    child: const Text('Войти')),
                Row(mainAxisAlignment: MainAxisAlignment.center, children: [
                  const Text('Нет аккаунта?',
                      style: TextStyle(color: Colors.white)),
                  ElevatedButton(
                      onPressed: () {
                        Navigator.pushNamed(context, '/register');
                      },
                      style: ButtonStyle(
                          backgroundColor: MaterialStateProperty.all<Color>(
                              Colors.transparent)),
                      child: const Text(
                        'Зарегестрироваться!',
                        style: TextStyle(color: Colors.white),
                      ))
                ])
              ],
            ),
          )),
    );
  }
}
