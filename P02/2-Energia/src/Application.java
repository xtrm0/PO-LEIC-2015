public class Application {
 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Dog d1 = new Dog("Piloto");
		Dog d2 = new Dog("Átila");
 
		Cat c1 = new Cat("Tareco");
		Cat c2 = new Cat("Pantufa");
		Cat c3 = new Cat("Kitty");
 
		Bird[] birds = new Bird[20];
		for (int ix = 0; ix < birds.length; ix++)
			birds[ix] = new Bird();
 
		Mouse[] mice = new Mouse[50];
		for (int ix = 0; ix < mice.length; ix++)
			mice[ix] = new Mouse();
 
		// snapshot: present everything
		System.out.println("BEFORE");
		System.out.println(d1);
		System.out.println(d2);
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
 
		for (int ix = 0; ix < birds.length; ix++)
			System.out.println(birds[ix]);
 
		for (int ix = 0; ix < mice.length; ix++)
			System.out.println(mice[ix]);
 
		// run, chase, eat, sleep, etc.
 
		for (int ix = 0; ix < birds.length; ix++)
			birds[ix].fly();
 
		d1.run();
		d2.attack(c1);
		c2.attack(birds[2]);
		c3.attack(birds[9]);
		c3.attack(mice[0]);
		d2.attack(mice[1]);
		c3.attack(mice[0]);
		d2.attack(mice[1]);
		c3.attack(mice[0]);
		d2.attack(mice[1]);
		mice[3].run();
 
		// snapshot: present everything
		System.out.println("AFTER");
		System.out.println(d1);
		System.out.println(d2);
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
 
		int mousesAlive = 0;
		int birdsAlive = 0;
		for (int ix = 0; ix < birds.length; ix++)
			if (birds[ix].isAlive())
				birdsAlive++; 
 
		for (int ix = 0; ix < mice.length; ix++)
			if (mice[ix].isAlive())
				mousesAlive++;
		
		System.out.println(mousesAlive + " mouses alive");
		System.out.println(birdsAlive + " birds alive");
	}
}