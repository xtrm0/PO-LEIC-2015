package edt.core;

public class Paragraph extends Node {
	private String text;

	public Paragraph(Node parent, IdentificationFactory factory) {
		super(parent, factory);
		this.setText("");
	}

	public Paragraph(Node parent, IdentificationFactory factory, String text) {
		super(parent, factory);
		this.setText(text);
	}

	@Override
	protected int calcLength() {
		return text.length();
	}

	public void setText(String text) {
		this.text = text;
		this.updateLength();
	}

	public String getText() {
		return text;
	}
}
