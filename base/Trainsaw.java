package base;

import java.util.Scanner;

import base.HashMap;

import item.AssortedOrangeSlice;
import item.Item;


public class Trainsaw {
	
	public float fullness;
	
	public static Trainsaw instance;
	
	private Location currentLocation;
	
	public static void main(String[] args) {
		instance = new Trainsaw();
		instance.start();
	}
	
	public Trainsaw() {
		fullness = 10;
		currentLocation = Locations.forest;
		
		
	}
	
	public void start() {
	
		currentLocation.printInfo();
		loop();
	}
	
	public void loop() {
		boolean running = true;
		Scanner input = new Scanner(System.in);
		while(running) {
			String[] in = (input.next() + " ").split(" ");
			if(in.length == 0) {
				continue;
			}
			String command = in[0];
			
			if(command.equalsIgnoreCase("exit") || command.equalsIgnoreCase("quit")) {
				running = false;
			}
			if(command.equalsIgnoreCase("go")) {
				String location = "";
				for(int i = 1; i < in.length; i++){
					location+=in[i];
				}
				if(!currentLocation.go(location))
					System.out.println("You can't go that way");
			}
		}
		input.close();
	}
	
	public void setLocation(Location location) {
		location.printInfo();
		this.currentLocation = location;
	}

}
