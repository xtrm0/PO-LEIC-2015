package edt.core;

import java.nio.file.Path;

public class Document extends Section{
	//AuthorArray a;
	Path saveLocation;
	public Document() {
		super(null, null);
		saveLocation = null;
	}
	
	public Document(Path p) {
		//TODO: do stuff
		super(null,null);
		loadFile(p);
	}
	
	private void loadFile(Path p) {
		//TODO: do stuff
		saveLocation = p;
	}
	
	public void save() {
		//TODO: do stuff
	}
	
	
}
