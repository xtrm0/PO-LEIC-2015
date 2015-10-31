package edt.core;

import java.util.Map;
import java.util.HashMap;

public abstract class Element {
	private String id;
	private int length;
	private Element parent;

	public Element(Element parent) {
		id = null;
		length = 0;
		this.parent = parent;
	}

	void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	private void notifyLength(int deltaLenght) {
		length += deltaLenght;
		if (getParent() != null)
			getParent().notifyLength(deltaLenght);
	}

	public void updateLength() {
		int oldLength = this.length;
		this.length = calcLength();
		if (getParent() != null)
			getParent().notifyLength(this.length - oldLength);
	}

	public int getLength() {
		return length;
	}

	public void delete() {
		if (parent != null)
			parent.notifyLength(-length);
		parent = null;
	}

	protected abstract int calcLength();

	public Element getParent() {
		return parent;
	}
}
