package array_example;

class ArrayExample {
  public static void main(String[] args) {
    int[] numbers = {1, 2, 3, 4, 5};
    printNumberAtIndex(numbers, 10);
  }

  private static void printNumberAtIndex(int[] array, int index) {
    if(index < 0 || index >= array.length) {
      System.out.println("Index out of bounds");
      return;
    }
    System.out.println("Number: " + array[index]);
  }
}