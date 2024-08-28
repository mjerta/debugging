package concurrect_modification_example;

import java.util.ArrayList;
import java.util.List;

class ConcurrentModificationExample {
  public static void main(String[] args) {
    List<String> names = new ArrayList<>();
    names.add("Alice");
    names.add("Bob");
    names.add("Charlie");
      for(int i = 0; i < names.size(); i++) {
        if (names.get(i).equals("Charlie")) {
          names.remove(i);
        }
      }
    System.out.println(names);
  }
}