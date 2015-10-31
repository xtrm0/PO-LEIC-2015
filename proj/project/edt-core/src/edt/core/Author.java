package edt.core;

public class Author {
	private final String name;
	private final String contact;

	public Author(String name, String contact) {
		this.name = new String(name);
		this.contact = new String(contact);
	}

	public String getName() {
		return name;
	}

	public String getContact() {
		return contact;
	}
	
	//XXX ToString

}
