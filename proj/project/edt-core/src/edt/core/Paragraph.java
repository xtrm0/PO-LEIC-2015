package edt.core;

import java.io.Serializable;

public class Paragraph extends Element implements Serializable {
	private String text;

	Paragraph(Element parent) {
		super(parent);
		this.setText("");
	}

	Paragraph(Element parent, String text) {
		super(parent);
		this.setText(text);
	}

	@Override
	protected int calcLength() {
		return text.length();
	}

	public void setText(String text) {
		this.text = new String(text);
		this.updateLength();
	}

	public String getText() {
		return text;
	}

	public void accept(ElementVisitor visitor) {
		visitor.visit(this);
	}
}
