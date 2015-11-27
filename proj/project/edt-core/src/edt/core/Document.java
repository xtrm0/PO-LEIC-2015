package edt.core;

import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Collections;

public final class Document extends Section implements Serializable {
	private Set<String> authorsNamesUsed;
	private ArrayList<Author> authors;
	private Map<String, Element> elementIds;

	public Document() {
		super(null);
		authorsNamesUsed = new HashSet<String>();
		authors = new ArrayList<Author>();
		elementIds = new HashMap<String, Element>();
	}

	public boolean addAuthor(String name, String email) throws NullPointerException  {
		Author author = new Author(name,email); //name and email are validated in Author constructor (this might throw)
		if (!authorsNamesUsed.add(author.getName())) {
			return true;
		}
		authors.add(author);
		return false;
	}

	public ArrayList<Author> getAuthors() {
		Collections.sort(authors);
		return authors;
	}

	/*Classes relacionadas com o controller de Id's: */
	public Element getElementById(String id) {
		if (id==null) return null; //nao queremos que null seja uma key
		return elementIds.get(id);
	}

	/*
	 * Adds a <id,node> pair to the map. Returns the previous node with that id,
	 * or null if there was none.
	 */
	public Element addElementId(String id, Element el) throws NullPointerException {
		if (id==null || el==null) throw new NullPointerException();
		if (el.getId() != null) {
			elementIds.remove(el.getId());
		}
		Element rv = getElementById(id);
		if (rv != null) {
			rv.setId(null);
		}
		elementIds.put(id, el);
		el.setId(id);
		return rv;
	}

	public void removeParagraph(Section s, int id) throws NullPointerException, IndexOutOfBoundsException {
		if (s == null) throw new NullPointerException();
		Paragraph p = s.getNthParagraph(id);
		s.removeParagraph(id);

		if (p.getId() != null) {
			elementIds.remove(p.getId());
		}

		/*MAYBE:?:
		p=null;
		System.gc();*/
	}


	private void _removeSectionIdsRecursive(Section s) {
		elementIds.remove(s.getId());

		Iterator<Paragraph> pit = s.getParagraphIterator();
		while (pit.hasNext()) {
			Paragraph p = pit.next();
			elementIds.remove(p.getId());
		}

		Iterator<Section> sit = s.getDirectIterator();
		while (sit.hasNext()) {
			Section sub = sit.next();
			_removeSectionIdsRecursive(sub);
		}
	}

	public void removeSection(Section s, int id) throws NullPointerException, IndexOutOfBoundsException {
		if (s == null) throw new NullPointerException();
		Section subSection = s.getNthSection(id);
		s.removeSection(id);
		_removeSectionIdsRecursive(subSection);

		/*MAYBE:?:
		it=null;
		subSection=null;
		System.gc();*/
	}

	public int getIdsCount() {
		return elementIds.size();
	}

	public void accept(ElementVisitor visitor) {
		visitor.visit(this);
	}
}
