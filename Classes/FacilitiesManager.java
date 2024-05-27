package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FacilitiesManager {
    private List<Item> inventoryItems = new ArrayList<>();

    public void viewInventory() {
        if (inventoryItems.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            System.out.println("Inventory:");
            for (Item item : inventoryItems) {
                System.out.println(item);
            }
        }
    }

    public void addItems(String itemName, float price, int quantity, Date expirationDate) {
        Item newItem = new Item(itemName, price, quantity, expirationDate);
        inventoryItems.add(newItem);
        System.out.println("Item added successfully.");
    }

    public void deleteItems(String itemName) {
        boolean itemFound = false;
        for (int i = 0; i < inventoryItems.size(); i++) {
            if (inventoryItems.get(i).getItemName().equals(itemName)) {
                inventoryItems.remove(i);
                itemFound = true;
                System.out.println("Item deleted successfully.");
                break;
            }
        }
        if (!itemFound) {
            System.out.println("Item not found in inventory.");
        }
    }

    public void editInventory(String itemName, float newPrice, int newQuantity, Date newExpirationDate) {
        boolean itemFound = false;
        for (int i = 0; i < inventoryItems.size(); i++) {
            if (inventoryItems.get(i).getItemName().equals(itemName)) {
                inventoryItems.get(i).setPrice(newPrice);
                inventoryItems.get(i).setQuantity(newQuantity);
                inventoryItems.get(i).setExpirationDate(newExpirationDate);
                itemFound = true;
                System.out.println("Item details updated successfully.");
                break;
            }
        }
        if (!itemFound) {
            System.out.println("Item not found in inventory.");
        }
    }

    public List<Item> filterInventory(String category, String keyword) {
        List<Item> filteredItems = new ArrayList<>();
        for (Item item : inventoryItems) {
            if (item.getItemName().toLowerCase().contains(keyword.toLowerCase())) {
                filteredItems.add(item);
            }
        }
        return filteredItems;
    }
}
