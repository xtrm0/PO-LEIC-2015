package edt.core;

public final class Author {
	private final String name;
	private final String contact;

	Author(String name, String contact) {
		//MAYBE: we should throw here instead of casting
		this.name = name != null ? new String(name) : "";
		this.contact = contact != null ? new String(contact) : "";
	}

	public String getName() {
		return name;
	}

	public String getContact() {
		return contact;
	}
}
