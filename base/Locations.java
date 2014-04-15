package base;

import base.HashMap;

import item.AssortedOrangeSlice;
import item.Item;

public class Locations {

	public static Location forest = new Location("The Forest", "A quiet clearing with a path leading north, west, and one leading south with a town sign", new String[]{"on the ground."}, new Item[]{new AssortedOrangeSlice()}, new HashMap<String, Location>().add("NORTH", Locations.forest2));
	public static Location forest2 = new Location("The Forest", "A path shrouded by trees, going south to north", new String[]{}, new Item[]{}, new HashMap<String, Location>().add("SOUTH", Locations.forest));
}
