
public class Mouse extends Animal {
	public Mouse() {
		super(20, 5);
	}
	
	@Override
	public void attack(Animal o) {
		//pass mouses currently cannot attack any other animal
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Mouse) {
			Mouse mouse = (Mouse) o;
			return energy == mouse.getEnergy();
		}
		return false;
	}

	@Override
	public String toString() {
		return "mouse (" + energy + ")";
	}

	
}
