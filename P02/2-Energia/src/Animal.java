
public abstract class Animal {
	int energy;
	private boolean sleeping;
	private boolean alive;
	private final int BASE_ENERGY;
	private final int RUN_ENERGY;
	protected Animal(int baseEnergy, int runEnergy) {
		BASE_ENERGY = baseEnergy;
		RUN_ENERGY = runEnergy;
		this.energy = BASE_ENERGY;
		this.sleeping = false;
		this.alive = true;
	}
	public boolean run() {
		if (energy < RUN_ENERGY || !this.isAlive()) {
			return false;
		}
		energy -= RUN_ENERGY;
		return true;
	}
	public void sleep() {
		if(!this.isAlive()) return;
		this.energy = BASE_ENERGY;
		this.sleeping = true;
	}
	public void wakeup() {
		if(!this.isAlive()) return;
		this.sleeping = false;
	}
	public void escaped() {
		this.energy += this.BASE_ENERGY;
		this.energy += 5;
	}
	public void attacked(Animal o) {
		this.run();
	}
	
	public abstract void attack(Animal o);
	public abstract boolean equals(Object o);
	public abstract String toString();
	
	/*
	 * 	Getters and Setters
	*/
	public int getEnergy() {
		return this.energy;
	}
	public void setEnergy(int energy) {
		this.energy = energy;
	}
	public void eat(Animal o) {
		this.energy += o.getEnergy();
		o.energy = 0;
		o.kill();
	}
	public boolean isAlive() {
		return this.alive;
	}
	public void kill() {
		this.alive = false;
	}
	public boolean isSleeping() {
		return this.sleeping;
	}
}
