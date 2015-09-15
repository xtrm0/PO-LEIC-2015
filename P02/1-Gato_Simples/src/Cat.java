
public class Cat {
	private String 	_name;
	private	int 	_age;
	private double 	_weight;
	
	public String get_name() {
		return _name;
	}
	public void set_name(String _name) {
		this._name = _name;
	}
	public int get_age() {
		return _age;
	}
	public void set_age(int _age) {
		this._age = _age;
	}
	public double get_weight() {
		return _weight;
	}
	public void set_weight(double _weight) {
		this._weight = _weight;
	}
	public Cat(String _name, int _age, double _weight) {
		this._name = _name;
		this._age = _age;
		this._weight = _weight;
	}
	
	public boolean equals(Object o) {
		if (o instanceof Cat) {
			Cat cat = (Cat) o;
			return (_name.equals(cat._name)) && (_age == cat._age) && (_weight == cat._weight); 
		}
		return false;
	}
	
	
	public String toString() {
		return _name + " (cat) (" + _age + ": " + _weight + ")";
	}	
	
	
}


