package model;

import java.util.ArrayList;
import java.util.List;

public class Supplier {
    private String companyName;
    private String phoneNumber;
    private String companyAddress;
    private String name;
    private List<ItemInfo> suppliedItems;

    public Supplier(String companyName, String phoneNumber, String companyAddress, String name) {
        this.companyName = companyName;
        this.phoneNumber = phoneNumber;
        this.companyAddress = companyAddress;
        this.name = name;
        this.suppliedItems = new ArrayList<>();
    }

    public void addItem(ItemInfo item) {
        suppliedItems.add(item);
    }

    public void deleteItem(ItemInfo item) {
        boolean itemFound = false;
        for (int i = 0; i < suppliedItems.size(); i++) {
            if (suppliedItems.get(i).equals(item)) {
                suppliedItems.remove(i);
                itemFound = true;
                break;
            }
        }
        if (!itemFound) {
            System.out.println("Item not found in supplier's list.");
        }
    }

    // Getters and Setters
}
