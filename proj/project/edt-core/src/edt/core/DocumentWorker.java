package edt.core;

import java.io.File;
import java.io.Serializable;
import java.io.IOException;
import java.lang.ClassNotFoundException;
import java.io.ObjectStreamException;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

public class DocumentWorker {
  private Document currDoc;

	File saveLocation;

	public DocumentWorker() {
		currDoc = new Document();
    saveLocation = null;
	}

	public void newDocument() {
		currDoc = new Document();
    saveLocation = null;
	}

	public void loadDocument(File p) {
		currDoc = new Document(p);
	}

	public void save() {
		//TODO
	}

	public void save(File f) {
		//TODO
	}

	public boolean issetFilename() {
		return saveLocation == null;
	}

  public Document getCurrentDocument() {
    return currDoc;
  }
}
