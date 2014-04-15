package base;

import item.Item;

public class MiscLib {
	public static final Item EMPTY = new Item() {

		@Override
		public String getName() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getDescription() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public float getWeight() {
			// TODO Auto-generated method stub
			return 0;
		}};
	public static boolean startsWithVowel(String str) {
		return str.startsWith("a") || str.startsWith("e") || str.startsWith("i") || str.startsWith("o") || str.startsWith("u") ;
	}
}
