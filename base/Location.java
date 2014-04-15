package base;
import java.io.Serializable;

import base.HashMap;

import item.Item;


public class Location implements Serializable {
	
    private static final long serialVersionUID = -3149982037784772285L;
    
    String[] itemLocations;
	Item[] items;
	String zoneName;
	String zoneDescription;
	HashMap<String, String> exits;

	public Location(String name, String description, String[] itemLocations, Item[] items, HashMap<String, String> exits){
		if(itemLocations.length != items.length) {
			new Exception("Not enough locations for items, or more locations than items").printStackTrace();
			System.exit(0);
		}
		zoneName = name;
		zoneDescription = description;
		this.itemLocations = itemLocations;
		this.items = items;
		this.exits = exits;
	}
	public void printInfo() {
		System.out.print(" ");
		for(int i = 0; i < zoneName.length(); i++) {
			System.out.print(zoneName.charAt(i) + " ");
		}
		System.out.println();
		for(int i = 0; i < ( zoneName.length() + 1 ) * 2; i++) {
			System.out.print("-");
		}
		System.out.println();
		System.out.println(zoneDescription);
		for(int i = 0; i < items.length; i++) {
			if(items[i] != MiscLib.EMPTY){
				System.out.println("There is"+(MiscLib.startsWithVowel(items[i].getName()) ? " a " : " an ")+ items[i].getName() + " " + itemLocations[i]);
			}
		}
	}
	public void takeItem(String itemName) {
		for(int i = 0; i< items.length; i++) {
			if(items[i].getName() == itemName && items[i] != MiscLib.EMPTY) {
				System.out.println(itemName + " taken.");
				items[i] = MiscLib.EMPTY;
				return;
			}
		}
		System.out.println("There is no " + itemName);
	}
	public void exit(String exit) {
		if(exits.containsKey(exit)) {
			exits.get(exit);
		}
	}
	public boolean go(String direction) {
		if(exits.containsKey(direction.toUpperCase())) {
			try {
                Trainsaw.instance.setLocation((Location) Locations.class.getField(exits.get(direction.toUpperCase())).get("argIgnored"));
            } catch (IllegalArgumentException | IllegalAccessException
                    | NoSuchFieldException | SecurityException e) {
                e.printStackTrace();
            }
			return true;
		}
		return false;
	}

}
