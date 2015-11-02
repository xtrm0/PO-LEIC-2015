package edt.core;

import java.io.Serializable;

public final class Paragraph extends Element implements Serializable {
	private String text;

	Paragraph(Element parent) {
		super(parent);
		this.setText("");
	}

	Paragraph(Element parent, String text) {
		super(parent);
		this.setText(new String(text));
	}

	@Override
	protected int calcLength() {
		return text.length();
	}

	public void setText(String text) {
		if (text==null); //TODO: throw
		this.text = new String(text);
		this.updateLength();
	}

	public String getText() {
		return text;
	}
}
