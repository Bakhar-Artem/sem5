import 'package:encrypt/encrypt.dart';

class PasswordHashUtil {
  var key = Key.fromLength(32);
  var iv = IV.fromLength(8);

  String encryptPassword(String password) {
    var encryptor = Encrypter(Salsa20(key));
    return encryptor.encrypt(password, iv: iv).base64;
  }
}
