import 'package:flutter/material.dart';
import 'package:coursework/dao/database_service.dart';
import 'package:coursework/utils/password_hash.dart';

class RegisterPage extends StatefulWidget {
  const RegisterPage({Key? key}) : super(key: key);

  @override
  State<RegisterPage> createState() => _RegisterPageState();
}

class _RegisterPageState extends State<RegisterPage> {
  bool obscured = true;
  String mail = '';
  String name = '';
  String password = '';

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
                  onChanged: (String editName) {
                    name = editName;
                  },
                  onFieldSubmitted: (editName) {
                    name = editName;
                  },
                  initialValue: name,
                  decoration: const InputDecoration(
                    focusColor: Colors.orange,
                    labelText: 'name',
                    border: OutlineInputBorder(),
                  ),
                ),
                TextFormField(
                  onChanged: (String editMail) {
                    mail = editMail;
                  },
                  onFieldSubmitted: (editMail) {
                    mail = editMail;
                  },
                  initialValue: mail,
                  decoration: const InputDecoration(
                    focusColor: Colors.orange,
                    labelText: 'email',
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
                  onFieldSubmitted: (editPassword) {
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
                      if (name.isNotEmpty &&
                          mail.isNotEmpty &&
                          password.isNotEmpty) {
                        var encrypt = PasswordHashUtil();
                        String encryptedPassword =
                            encrypt.encryptPassword(password);
                        DataBaseService base = DataBaseService();
                        base.registerUser(name, mail, encryptedPassword);
                        Navigator.pushNamed(context, '/success');
                      } else {
                        Navigator.pushNamed(context, '/error');
                      }
                    },
                    child: const Text('Зарегистрироваться')),
                Row(mainAxisAlignment: MainAxisAlignment.center, children: [
                  const Text('Есть аккаунт?',
                      style: TextStyle(color: Colors.white)),
                  ElevatedButton(
                      onPressed: () {
                        Navigator.pushNamed(context, '/login');
                      },
                      style: ButtonStyle(
                          backgroundColor: MaterialStateProperty.all<Color>(
                              Colors.transparent)),
                      child: const Text(
                        'Войти!',
                        style: TextStyle(color: Colors.white),
                      ))
                ])
              ],
            ),
          )),
    );
  }
}
