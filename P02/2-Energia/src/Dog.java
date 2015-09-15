
public class Dog extends Animal {
	String name;
	public Dog(String name) {
		super(1000, 50);
		this.name = name;
	}
	
	@Override
	public void attack(Animal o) {
		if (!this.isAlive() || !o.isAlive()) return;
		if (!this.run()) return; //esta aqui a correr!

		if (o instanceof Mouse && o.isSleeping()) {
			eat(o);
			return;
		}
		
		//o alvo esta acordado:
		o.attacked(this);
		if (o instanceof Cat) {
			energy -= 100;
			((Cat) o).attacked(this);
		} else if (o instanceof Mouse) {
			o.run();
			if (0 == (int) 25*Math.random()) {
				eat(o);
			} else {
				o.escaped();
			}
		}
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Dog) {
			Dog dog = (Dog) o;
			return name.equals(dog.getName()) && energy == dog.getEnergy();
		}
		return false;
	}

	@Override
	public String toString() {
		return name + " (dog) (" + energy + ")";
	}

	@Override
	public void attacked(Animal o) {
		//pass
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
