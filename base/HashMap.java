package base;

public class HashMap<K,V> extends java.util.HashMap<K,V>{
	private static final long serialVersionUID = -3120887112044001599L;
	
	public HashMap<K, V> add(K key, V value) {
		super.put(key, value);
		return this;
	}
}
