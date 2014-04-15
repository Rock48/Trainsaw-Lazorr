package base;

import base.HashMap;

import item.AssortedOrangeSlice;
import item.Item;

public class Locations {

	public static Location forest;
	public static Location forest2;
	
	public static void initLocations() {
	    forest = new Location("The Forest", "A quiet clearing with a path leading north, west, and one leading south with a town sign", new String[]{"on the ground."}, new Item[]{new AssortedOrangeSlice()}, new HashMap<String, String>().add("NORTH", "forest2"));
	    forest2 = new Location("The Forest", "A path shrouded by trees, going south to north", new String[]{}, new Item[]{}, new HashMap<String, String>().add("SOUTH", "forest"));
	    
	}
}
