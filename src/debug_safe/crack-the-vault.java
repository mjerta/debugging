package debug_safe;

class DebugSafe {

  public static void main(String[] args) {
    String code1 = "ABCDE";
    String code2 = "zBxDv";
    int code3 = 1000171;

    if (checkCode1(code1) && checkCode2(code2) && checkCode3(code3)) {
      revealSecretWord(code1, code2, code3);
    } else {
      System.out.println("Niet alle codes zijn correct. Probeer het opnieuw.");
    }
  }

  public static boolean checkCode1(String code1) {
    if (code1.length() != 5) {
      return false;
    }
    for (int i = 0; i < code1.length(); i++) {
      char c = code1.charAt(i);
      if (c != 'A' + i) {
        return false;
      }
    }
    return true;
  }

  public static boolean checkCode2(String code2) {
    if (code2.length() != 5) {
      return false;
    }
    for (int i = 0; i < code2.length(); i++) {
      char c = code2.charAt(i);
      // the first part of the if statement checks if the character is lowercase and the index is even
      // the second part of the if statement checks if the character is uppercase and the index is odd
      // every time the iteration is done, the character should be the next character in the alphabet
      // so this is being done for z -> a and Z -> A
      if (((Character.isLowerCase(c) && i % 2 == 0) && c != 'z' - i) || ((Character.isUpperCase(c) && i % 2 != 0) && c != 'A' + i)) {
        return false;
      }
    }
    return true;
  }

  public static boolean checkCode3(int code3) {
    int[] numbers = {1000171, 1000172, 1000173, 1000174};
    for (int number : numbers) {
      if (number == code3) {
        return true;
      }
    }
    return false;
  }

  public static void revealSecretWord(String code1, String code2, int code3) {
    int shift1 = code1.charAt(0) - 'A';
    int shift2 = code2.charAt(4) - 'V';
    int shift3 = 1;
    int totalShift = (shift1 + shift2 + shift3) % 26;

    String encryptedWord = "Ovlyh ola pz jvkpun dlkulzkhf!";
    String decryptedWord = decrypt(encryptedWord, totalShift);
    System.out.println("Geheim woord: " + decryptedWord);
  }

  public static String decrypt(String text, int shift) {
    StringBuilder result = new StringBuilder();
    for (char c : text.toCharArray()) {
      if (Character.isLetter(c)) {
        char shifted = (char) (c - shift);
        if (c >= 'a' && c <= 'z' && shifted < 'a') {
          shifted += 26;
        } else if (c >= 'A' && c <= 'Z' && shifted < 'A') {
          shifted += 26;
        }
        result.append(shifted);
      } else {
        result.append(c);
      }
    }
    return result.toString();
  }

  public static String encrypt(String text, int shift) {
    StringBuilder result = new StringBuilder();
    for (char c : text.toCharArray()) {
      if (Character.isLetter(c)) {
        char shifted = (char) (c + shift);
        if (c >= 'a' && c <= 'z' && shifted > 'z') {
          shifted -= 26;
        } else if (c >= 'A' && c <= 'Z' && shifted > 'Z') {
          shifted -= 26;
        }
        result.append(shifted);
      } else {
        result.append(c);
      }
    }
    return result.toString();
  }
}