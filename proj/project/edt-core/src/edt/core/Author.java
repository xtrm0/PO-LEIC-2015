package edt.core;

import java.util.Set;
import java.util.HashSet;

class Author {
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

}


class AuthorFactory {
  private Set<String> authors;
  public AuthorFactory() {
    authors = new HashSet<String>();
  }
  public boolean addAuthor(String authorName) {
    return authors.add(authorName);
  }
}
