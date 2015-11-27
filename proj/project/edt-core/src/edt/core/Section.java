package edt.core;

import java.util.List;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.Serializable;
import java.util.NoSuchElementException;

/**
 * @author xtrm0
 * The class Section represents a Section
 * @param title the section title
 * @param subParagraphs all the paragraphs this sections has
 * @param subSections all the sections this sections has
 */
public class Section extends Element implements Serializable{
	private String title;
	private List<Paragraph> subParagraphs;
	private List<Section> subSections;

	/**
	 * Creates a new section
	 * @param parent the element that will own this element (can be null)
	 */
	protected Section(Element parent) {
		super(parent);
		title = "";
		subParagraphs = new ArrayList<Paragraph>(); // MAYBE: isto tem delete O(n). Podemos fazer uma bst com as 3 operacoes necessarias O(logn)
		subSections = new ArrayList<Section>(); // MAYBE: isto tem delete O(n). Podemos fazer uma bst com as 3 operacoes necessarias O(logn)
	}

	@Override
	protected int calcLength() {
		int ans = title.length();
		for (int i=0; i<subSections.size(); i++)
			ans += subSections.get(i).getLength();
		for (int i=0; i<subParagraphs.size(); i++)
			ans += subParagraphs.get(i).getLength();
		return ans;
	}

	/**
	 * Returns the nth paragraph owned by this section
	 * @param n
	 * @return the nth paragraph, or null if n is invalid
	 */
	public Paragraph getNthParagraph(int n) {
		if (subParagraphs.size() <= n || n < 0)
			return null;
		return subParagraphs.get(n);
	}

	/**	Returns the nth section owned by this section
	 * @param n
	 * @return the nth section, or null if n is invalid
	 */
	public Section getNthSection(int n) {
		if (subSections.size() <= n || n < 0)
			return null;
		return subSections.get(n);
	}

	/**
	 * @return the section title
	 */
	public String getTitle() {
		return title;
	}

	/** Sets the section title
	 * Strong exception safety
	 * @param title
	 * @throws NullPointerException if title is null
	 */
	public void setTitle(String title) throws NullPointerException {
		this.title = new String(title);
		updateLength();
	}

	/**
	 * Creates a new empty section and inserts it before the n-th section
	 * Strong exception safety
	 * @param title the new section title
	 * @param n the position to write the section
	 * @throws IndexOutOfBoundsException if n is invalid
	 * @throws NullPointerException if title is null
	 */
	public void insertSection(String title, int n) throws IndexOutOfBoundsException, NullPointerException {
		if (subSections.size() < n || n < 0) throw new IndexOutOfBoundsException();
		Section x = new Section(this); //this might throw, and we let it go up the call chain
		x.setTitle(title);
		subSections.add(n, x);
	}

	/**
	 * Creates a new paragraph and inserts it before the n-th paragraph
	 * Strong exception safety
	 * @param text the text for the new paragraph
	 * @param n the position to write the paragraph
	 * @throws IndexOutOfBoundsException if n is invalid
	 * @throws NullPointerException if text is null
	 */
	public void insertParagraph(String text, int n) throws IndexOutOfBoundsException, NullPointerException {
		if (subParagraphs.size() < n || n < 0) throw new IndexOutOfBoundsException();
		Paragraph x = new Paragraph(this); //this might throw, and we let it go up the call chain
		x.setText(text);
		subParagraphs.add(n, x);
	}

	/**
	 * Removes the n-th paragraph
	 * Strong exception safety
	 * @param n the index
	 * @throws IndexOutOfBoundsException if n is invalid
	 */
	protected void removeParagraph(int n) throws IndexOutOfBoundsException {
		Paragraph p = subParagraphs.get(n);
		if (p==null) throw new IndexOutOfBoundsException();
		//atualiza lenght:
		notifyLength(-p.getLength());
		//Remove efetivamente
		subParagraphs.remove(n);
	}

	/**
	 * Removes the n-th section
	 * Strong exception safety
	 * @param n the index
	 * @throws IndexOutOfBoundsException if n is invalid
	 */
	protected void removeSection(int n) throws IndexOutOfBoundsException {
		Section s = subSections.get(n);
		if (s==null) throw new IndexOutOfBoundsException();
		//Atualiza length:
		notifyLength(-s.getLength());
		//Remove efetivamente:
		subSections.remove(n);
	}

	/**
	 * @return the number of direct child Sections
	 */
	public int getSectionsCount() {
		return subSections.size();
	}

	/**
	 * @return the number of sub Paragraphs
	 */
	public int getParagraphsCount() {
		return subParagraphs.size();
	}

	/**
	 * @return an iterator to the paragraphs
	 */
	public Iterator<Paragraph> getParagraphIterator() {
		return subParagraphs.iterator();
	}

	/**
	 * @return a iterator to the direct child sections of the current sections
	 */
	public Iterator<Section> getDirectIterator() {
		return subSections.iterator();
	}

	public void accept(ElementVisitor visitor) {
		visitor.visit(this);
	}
}
