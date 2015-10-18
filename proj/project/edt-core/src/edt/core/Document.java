package edt.core;

import java.io.File;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

public class Document extends Section{
	private Set<String> authorsNamesUsed;
	private ArrayList<Author> authors;

	File saveLocation;
	public Document() {
		super(null, null);
		saveLocation = null;
		authorsNamesUsed = new HashSet<String>();
		authors = new ArrayList<Author>();
	}

	public Document(File p) {
		this();
		loadFile(p);
	}

	public void reset() {
		//TODO: reset factory
		saveLocation = null;
		authorsNamesUsed = new HashSet<String>();
		authors = new ArrayList<Author>();
	}

	public void addAuthor(String name, String email) {
		//OPT: Do name and email validation
		if (!authorsNamesUsed.add(name)) {
			//TODO: Throws
		}
		authors.add(new Author(name,email));
	}

	public void loadFile(File p) {
		//TODO: do stuff
		saveLocation = p;
	}

	public void save() {
		//TODO: do stuff
	}

	public void save(File f) {
		//TODO: do stuff
	}

	public Node getElementById(String id) {
		return factory.findByUniqueId(id);
	}

	public boolean requestFilename() {
		return this.saveLocation == null;
	}

	public ArrayList<Author> getAuthors() {
		return authors;
	}

}
