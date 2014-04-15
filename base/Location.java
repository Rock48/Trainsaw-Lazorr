package base;
import java.io.Serializable;
import java.util.Set;

import base.HashMap;

import item.AssortedOrangeSlice;
import item.Item;


public class Location implements Serializable {
	
	
	String[] itemLocations;
	Item[] items;
	String zoneName;
	String zoneDescription;
	HashMap<String, Location> exits;

	public Location(String name, String description, String[] itemLocations, Item[] items, HashMap<String, Location> exits){
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
		System.out.println(direction);
		if(exits.containsKey(direction)) {
			Trainsaw.instance.setLocation(exits.get(direction));
			return true;
		}
		return false;
	}

}
