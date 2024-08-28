package null_pointer_example;

class NullPointerExample {
  public static void main(String[] args) {
    String message = "Hallo";
    printMessageLength(message);
    message = null;
    printMessageLength(message);
  }

  private static void printMessageLength(String message) {
    if(message == null) {
      System.out.println("Message is null");
      return;
    }
    System.out.println("Length: " + message.length());
  }
}