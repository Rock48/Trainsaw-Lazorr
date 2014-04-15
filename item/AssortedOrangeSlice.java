package item;

public class AssortedOrangeSlice extends Food {

	@Override
	public String getName() {
		return "Assorted Orange Slice";
	}

	@Override
	public String getDescription() {
		return "It is a candy orange slice, seemingly from an assorted package of orange slices, warning may contain death poison";
	}

	@Override
	public float getWeight() {
		return 0.2f;
	}

	@Override
	public float getSatisfaction() {
		return 5;
	}

	@Override
	protected void onEat() {
		System.out.println("You Died.");
	}
}
