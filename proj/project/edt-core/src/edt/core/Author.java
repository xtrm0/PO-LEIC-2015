package edt.core;

public final class Author {
	private final String name;
	private final String contact;

	Author(String name, String contact) throws NullPointerException {
		//MAYBE: what is a valid name // contact?
		this.name = new String(name);
		this.contact = new String(contact);
	}

	public String getName() {
		return name;
	}

	public String getContact() {
		return contact;
	}
}
