package edt.core;

import java.util.List;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.Serializable;

public class Section extends Element implements Serializable{
	private String title;
	private List<Paragraph> subParagraphs;
	private List<Section> subSections;

	protected Section(Element parent) {
		super(parent);
		title = "";
		subParagraphs = new ArrayList<Paragraph>(); // TODO: isto tem delete
													// O(n). Podemos fazer uma
													// bst com as 3 operacoes
													// necessarias O(logn)
		subSections = new ArrayList<Section>(); // TODO: isto tem delete O(n).
												// Podemos fazer uma bst com as
												// 3 operacoes necessarias
												// O(logn)
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

	public Paragraph getNthParagraph(int n) {
		if (subParagraphs.size() <= n || n < 0)
			return null;
		return subParagraphs.get(n);
	}

	public Section getNthSection(int n) {
		if (subSections.size() <= n || n < 0)
			return null;
		return subSections.get(n);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		if (title == null); //TODO: throw
		this.title = new String(title);
		updateLength();
	}

	//TODO: catch null string and throw
	public boolean insertSection(String title, int n) {
		if (subSections.size() < n || n < 0) return true; //TODO: throw the right kind of exception
		Section x = new Section(this);
		try {
			x.setTitle(title);
		} catch (Exception e) {//TODO: fix this to throw the right exception
			throw e;
		}
		subSections.add(n, x);
		return false;
	}

	public boolean insertParagraph(String text, int n) {
		if (subParagraphs.size() < n || n < 0) return true; //TODO: throw the right kind of exception
		Paragraph x = new Paragraph(this);
		try {
			x.setText(text);
		} catch (Exception e) { //TODO: fix this to throw the right exception
			throw e;
		}
		subParagraphs.add(n, x);
		return false;
	}

	protected boolean removeParagraph(int n) {
		//Garante que é uma operação válida: TODO: we should do this somewhere?
		if (subParagraphs.size() <= n || n < 0) return true;
		Paragraph p = subParagraphs.get(n);

		//atualiza lenght:
		notifyLength(-p.getLength());

		//Remove efetivamente
		subParagraphs.remove(n);
		return false;
	}

	protected boolean removeSection(int n) {
		//Garante que é uma operação válida: TODO: we should do this somewhere?
		if (subSections.size() <= n || n < 0) return true;
		Section s = subSections.get(n);

		//Atualiza length:
		notifyLength(-s.getLength());

		//Remove efetivamente:
		subSections.remove(n);
		return false;
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
		return new SectionPrefixRecursiveIterator(this);
	}

	public Iterator<Section> getDirectIterator() {
		return new SectionDirectChildIterator(this);
	}

	public void runAutoOperator(SectionOperator op) {
		SectionPrefixRecursiveIterator it = new SectionPrefixRecursiveIterator(this, op);
		while(it.hasNext()) it.next();
	}
}

//XXX:2: Change this to be a private class
class SectionPrefixRecursiveIterator implements Iterator<Section> {
	Section rootSection;
	Stack<Integer> idStack;
	SectionOperator op;
	boolean ended;

	public SectionPrefixRecursiveIterator(Section s) {
		rootSection = s;
		idStack = new Stack<Integer>();
		idStack.push(0);
		op=null;
	}

	public SectionPrefixRecursiveIterator(Section s, SectionOperator op) {
		this(s);
		this.op = op;
	}

	@Override
	public boolean hasNext() {
		return !ended;
	}

	@Override
	public Section next() {
		if (!hasNext())
			return null;
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


//MAYBE: remove this class at all?
class SectionDirectChildIterator implements Iterator<Section> {
	Section rootSection;
	int n;

	public SectionDirectChildIterator(Section s) {
		rootSection = s;
		n = 0;
	}

	@Override
	public boolean hasNext() {
		return (n < rootSection.getSectionsCount());
	}

	@Override
	public Section next() {
		if (!hasNext())
			return null;
		n++;
		return rootSection.getNthSection(n - 1);
	}
}
