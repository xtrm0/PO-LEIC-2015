
public class Cat extends Animal {
	String name;
	public Cat(String name) {
		super(500, 25);
		this.name = name;
	}
	
	@Override
	public void attack(Animal o) {
		if (!this.isAlive() || !o.isAlive()) return;
		if (!this.run()) return;
		
		if (o instanceof Mouse && o.isSleeping()) {
			eat(o);
			return;
		}
		
		//o alvo esta acordado:
		o.attacked(this);
		
		if (o instanceof Mouse) {
			if (0 == (int) 5*Math.random()) {
				eat(o);
			} else {
				o.escaped();
			}
		} else if (o instanceof Bird) {
			if (0 == (int) 10*Math.random()) {
				eat(o);
			} else {
				o.escaped();
			}
		}
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Cat) {
			Cat cat = (Cat) o;
			return name.equals(cat.getName()) && energy == cat.getEnergy();
		}
		return false;
	}

	@Override
	public String toString() {
		return name + " (cat) (" + energy + ")";
	}

	@Override
	public void attacked(Animal o) {
		if (o instanceof Dog) {
			this.energy -= 25;
		}
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
