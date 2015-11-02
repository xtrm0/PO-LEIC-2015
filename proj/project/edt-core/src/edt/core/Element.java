package edt.core;

import java.io.Serializable;

public abstract class Element implements Serializable {
	private String id;
	private int length;
	private Element parent;

	protected Element(Element parent) {
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

	protected void notifyLength(int deltaLenght) {
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

	protected abstract int calcLength();

	public Element getParent() {
		return parent;
	}
}
