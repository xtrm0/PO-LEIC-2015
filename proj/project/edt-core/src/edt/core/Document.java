package edt.core;

import java.io.File;
import java.io.Serializable;
import java.io.IOException;
import java.lang.ClassNotFoundException;
import java.io.ObjectStreamException;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class Document extends Section{
	private Set<String> authorsNamesUsed;
	private ArrayList<Author> authors;
	private Map<String, Element> elementIds;

	public Document() {
		super(null);
		authorsNamesUsed = new HashSet<String>();
		authors = new ArrayList<Author>();
		elementIds = new HashMap<String, Element>();
	}

	public Document(File p) {
		this();
		//XXX loadFile(p);
	}

	public boolean addAuthor(String name, String email) {
		// XXX: Do name and email validation
		if (!authorsNamesUsed.add(name)) {
			// TODO: Throws
			return false;
		}
		authors.add(new Author(name, email));
		return true;
	}

	public ArrayList<Author> getAuthors() {
		return authors;
	}

	/*Classes relacionadas com o controller de Id's: */
	public Element getElementById(String id) {
		return elementIds.get(id);
	}

	/*
	 * Adds a <id,node> pair to the map. Returns the previous node with that id,
	 * or null if there was none.
	 */
	public Element addElementId(String id, Element el) {
		//XXX esta mal
		Element rv = getElementById(id);
		if (rv != null) {
			rv.setId(null);
		}
		elementIds.put(id, el);
		el.setId(id);
		return rv;
	}

	/*
		Removes a node with the given id
	*/
	public void removeElementWithId(String id) {
		//TODO
	}

	public int getIdsCount() {
		return elementIds.size();
	}
}
