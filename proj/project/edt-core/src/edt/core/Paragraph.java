package edt.core;

class Paragraph extends Node {
	private String text;

	public Paragraph(Node parent, IdentificationFactory factory) {
		super(parent, factory);
		text = new String("");
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
	
	@Override
	public void delete() {
		super.delete();
		this.text = "";
		this.updateLength();
	}

}
