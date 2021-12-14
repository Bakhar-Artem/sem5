import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:coursework/utils/password_hash.dart';

class DataBaseService {
  void registerUser(name, email, password) {
    FirebaseFirestore.instance
        .collection('users')
        .add({'name': name, 'email': email, 'password': password});
  }

  Future<bool> checkUser(email, password) async {
    var collection = FirebaseFirestore.instance
        .collection('users')
        .where('email', isEqualTo: email);
    var querySnapshot = await collection.get();
    if (querySnapshot.docs.isNotEmpty) {
      var doc = querySnapshot.docs.first;
      Map<String, dynamic> data = doc.data();
      var bdPassword = data['password'];
      var crypt=PasswordHashUtil();
      var encryptedPassword= crypt.encryptPassword(password);
      if (bdPassword == encryptedPassword) {
      }
      return Future.value(true);
    }
    return Future.value(false);
  }
}
