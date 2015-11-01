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
import java.util.Iterator;

public class Document extends Section implements Serializable {
	private Set<String> authorsNamesUsed;
	private ArrayList<Author> authors;
	private Map<String, Element> elementIds;

	public Document() {
		super(null);
		authorsNamesUsed = new HashSet<String>();
		authors = new ArrayList<Author>();
		elementIds = new HashMap<String, Element>();
	}

	public boolean addAuthor(String name, String email) {
		// MAYBE: Do name and email validation
		if (!authorsNamesUsed.add(name)) {
			return true;
		}
		authors.add(new Author(name, email));
		return false;
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

	public boolean removeParagraph(Section s, int id) {
		if (s == null) return true;
		Paragraph p = s.getNthParagraph(id);
		if (p == null) return true;
		if (s.removeParagraph(id)) return true;

		if (p.getId() != null) {
			elementIds.remove(p.getId());
		}

		/*MAYBE:?:
		p=null;
		System.gc();*/

		return false;
	}

	public boolean removeSection(Section s, int id) {
		if (s == null) return true;
		Section subSection = s.getNthSection(id);
		if (subSection == null) return true;
		if (s.removeSection(id)) return true;

		//remove ids recursivamente:
		Iterator<Section> it = subSection.getPrefixIterator();
		while (it.hasNext()) {
			Section target = it.next();
			Iterator<Paragraph> pit = target.getParagraphIterator();
			while (pit.hasNext()) {
				Paragraph p = pit.next();
				elementIds.remove(p.getId());
			}
			elementIds.remove(target.getId());
		}

		/*MAYBE:?:
		it=null;
		subSection=null;
		System.gc();*/

		return false;
	}

	public int getIdsCount() {
		return elementIds.size();
	}
}
