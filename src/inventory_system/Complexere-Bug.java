package inventory_system;

import java.util.HashMap;

import java.util.Map;

class InventorySystem {
  private Map<String, Integer> inventory = new HashMap<>();

  public static void main(String[] args) {
    InventorySystem system = new InventorySystem();
    system.addItem("Apple", 10);
    system.addItem("Banana", 5);
    system.removeItem("Apple", 5);
    system.removeItem("Banana", 10);
  }

  public void addItem(String item, int quantity) {
    inventory.put(item, inventory.getOrDefault(item, 0) + quantity);
    System.out.println("Added " + quantity + " " + item + "(s)");
  }

  public void removeItem(String item, int quantity) {
    if (inventory.containsKey(item) && inventory.get(item) >= quantity ) {
      inventory.put(item, inventory.get(item) - quantity);
      System.out.println("Removed " + quantity + " " + item + "(s)");
    }
    else {
      System.out.println("Error: Not enough " + item + " in inventory");
    }
  }

}