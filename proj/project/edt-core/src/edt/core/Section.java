package edt.core;

import java.util.List;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.Serializable;
import java.util.NoSuchElementException;

public class Section extends Element implements Serializable{
	private String title;
	private List<Paragraph> subParagraphs;
	private List<Section> subSections;

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

	public Paragraph getNthParagraph(int n) throws IndexOutOfBoundsException {
		if (subParagraphs.size() <= n || n < 0)
			throw new IndexOutOfBoundsException();
		return subParagraphs.get(n);
	}

	public Section getNthSection(int n) throws IndexOutOfBoundsException {
		if (subSections.size() <= n || n < 0)
			throw new IndexOutOfBoundsException();
		return subSections.get(n);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) throws NullPointerException {
		this.title = new String(title);
		updateLength();
	}

	public boolean insertSection(String title, int n) throws IndexOutOfBoundsException, NullPointerException {
		if (subSections.size() < n || n < 0) throw new IndexOutOfBoundsException();
		Section x = new Section(this); //this might throw, and we let it go up the call chain
		x.setTitle(title);
		subSections.add(n, x);
		return false;
	}

	public boolean insertParagraph(String text, int n) throws IndexOutOfBoundsException, NullPointerException {
		if (subParagraphs.size() < n || n < 0) throw new IndexOutOfBoundsException();
		Paragraph x = new Paragraph(this); //this might throw, and we let it go up the call chain
		x.setText(text);
		subParagraphs.add(n, x);
		return false;
	}

	protected void removeParagraph(int n) throws IndexOutOfBoundsException {
		Paragraph p = subParagraphs.get(n);
		//atualiza lenght:
		notifyLength(-p.getLength());
		//Remove efetivamente
		subParagraphs.remove(n);
	}

	protected void removeSection(int n) throws IndexOutOfBoundsException {
		Section s = subSections.get(n);
		//Atualiza length:
		notifyLength(-s.getLength());
		//Remove efetivamente:
		subSections.remove(n);
	}

	public int getSectionsCount() {
		return subSections.size();
	}

	public int getParagraphsCount() {
		return subParagraphs.size();
	}

	public Iterator<Paragraph> getParagraphIterator() {
		return subParagraphs.iterator();
	}

	public Iterator<Section> getPrefixIterator() {
		return new SectionPrefixRecursiveIterator();
	}

	public Iterator<Section> getDirectIterator() {
		return subSections.iterator();
	}

	public void runAutoOperator(SectionOperator op) {
		SectionPrefixRecursiveIterator it = new SectionPrefixRecursiveIterator(op);
		while(it.hasNext()) it.next();
	}

	class SectionPrefixRecursiveIterator implements Iterator<Section> {
		Section rootSection;
		Stack<Integer> idStack;
		SectionOperator op;
		boolean ended;

		public SectionPrefixRecursiveIterator() {
			rootSection = Section.this;
			idStack = new Stack<Integer>();
			idStack.push(0);
			op=null;
		}

		public SectionPrefixRecursiveIterator(SectionOperator op) {
			this();
			this.op = op;
		}

		@Override
		public boolean hasNext() {
			return !ended;
		}

		@Override
		public Section next() throws NoSuchElementException{
			if (!hasNext())
				throw new NoSuchElementException();
			if (op!=null) op.onCall(rootSection);
			Section ret = rootSection;
			while (rootSection.getSectionsCount() == idStack.peek()) {
				if (op!=null) op.onRet(rootSection);
				rootSection = (Section) rootSection.getParent();
				idStack.pop();
				if (idStack.isEmpty()) {
					ended = true;
					return ret;
				}
			}
			int nx = idStack.peek();
			idStack.pop();
			idStack.push(nx+1);
			idStack.push(0);
			rootSection = rootSection.getNthSection(nx);
			return ret;
		}
	}
}
