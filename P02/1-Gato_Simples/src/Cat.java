@SuppressWarnings("nls")
public class Cat {
	private String 	name;
	private	int 	age;
	private double 	weight;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getWeight() {
		return this.weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public Cat(String name, int age, double weight) {
		this.name = name;
		this.age = age;
		this.weight = weight;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Cat) {
			Cat cat = (Cat) o;
			return (this.name.equals(cat.name)) && (this.age == cat.age) && (this.weight == cat.weight);
		}
		return false;
	}


	@Override
	public String toString() {
		return this.name + " (cat) (" + this.age + ": " + this.weight + ")";
	}
}
