package edt.core;

public class Paragraph extends Element {
	private String text;

	public Paragraph(Element parent) {
		super(parent);
		this.setText("");
	}

	public Paragraph(Element parent, String text) {
		super(parent);
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
