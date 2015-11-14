package edt.core;

import java.io.Serializable;

public final class Author implements Comparable<Author>, Serializable {
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

	public int compareTo(Author o) {
		return this.name.compareTo(o.name);
	}
}
