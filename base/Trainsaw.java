package base;

import item.Food;
import item.Item;

import java.util.ArrayList;
import java.util.Scanner;


public class Trainsaw {
	
	public float fullness;
	
	public static Trainsaw instance;
	
	private Location currentLocation;
	
	public ArrayList<Item> inventory;
	
	public static void main(String[] args) {
		instance = new Trainsaw();
		instance.start();
	}
	
	public Trainsaw() {
		fullness = 10;
		Locations.initLocations();
		inventory = new ArrayList<Item>();
		currentLocation = Locations.forest2;
		
		
	}
	
	public void start() {
	
		currentLocation.printInfo();
		loop();
	}
	
	public void loop() {
		boolean running = true;
		Scanner input = new Scanner(System.in);
		while(running) {
		    String[] in = input.nextLine().split("\\s+");
			
			if(in.length == 0) {
				continue;
			}
			String command = in[0];
			
			if(command.equalsIgnoreCase("exit") || command.equalsIgnoreCase("quit")) {
				running = false;
			}else if(command.equalsIgnoreCase("go")) {
				String location = "";
				for(int i = 1; i < in.length; i++){
					location+=in[i];
				}
				if(!currentLocation.go(location))
					System.out.println("You can't go that way");
			}else if(command.equalsIgnoreCase("pick") && in[1].equalsIgnoreCase("up")) {
				String item = "";
				for(int i = 2; i < in.length; i++){
					item+=in[i];
					if(i != in.length-1) {
						item+=" ";
					}
				}
				currentLocation.takeItem(item);
			}else if((command.equalsIgnoreCase("look") && in.length == 1) || (command.equalsIgnoreCase("look") && in[1].equalsIgnoreCase("around"))) {
				currentLocation.printInfo();
			}else if(command.equalsIgnoreCase("eat")){
				String item = "";
				for(int i = 2; i < in.length; i++){
					item+=in[i];
					if(i != in.length-1) {
						item+=" ";
					}
				}
				for(Item i : inventory) {
					if(i.getName().toUpperCase().contains(item.toUpperCase())){
						if(i instanceof Food) {
							((Food) i).eat();
							break;
						}
					}	
				}
			}else{
				System.out.println("I don't understand that.");
			}
		}
		input.close();
	}
	public void setLocation(Location location) {
		location.printInfo();
		this.currentLocation = location;
	}

}
