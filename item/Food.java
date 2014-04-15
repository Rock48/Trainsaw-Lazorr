package item;

import base.Trainsaw;

public abstract class Food implements Item {
	public abstract float getSatisfaction();
	protected abstract void onEat();
	public final void eat() {
		Trainsaw.instance.fullness+=getSatisfaction();
		System.out.println("You gain: " + getSatisfaction());
		System.out.println("Your Food level is now " + Trainsaw.instance.fullness);
		onEat();
	}
	
}
