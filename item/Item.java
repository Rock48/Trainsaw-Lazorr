package item;

import java.io.Serializable;

public interface Item extends Serializable{
	public abstract String getName();
	public abstract String getDescription();
	public abstract float getWeight();
}
