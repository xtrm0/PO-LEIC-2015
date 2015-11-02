package edt.core;

import java.io.File;

import java.io.IOException;
import java.lang.ClassNotFoundException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public final class DocumentWorker {
  private Document currDoc;

	private File saveLocation;
  private boolean dirtyBit;

	public DocumentWorker() {
		currDoc = new Document();
    saveLocation = null;
    dirtyBit = true;
	}

	public void newDocument() {
		currDoc = new Document();
    saveLocation = null;
    dirtyBit = true;
	}

	public void loadDocument(File path) throws IOException, ClassNotFoundException, IllegalArgumentException {
    if (path == null) throw new IllegalArgumentException("Null is not a valid File");
    FileInputStream inFileStream = new FileInputStream(path);
    ObjectInputStream in = new ObjectInputStream(inFileStream);
    Document tmpDoc = (Document) in.readObject(); //Separamos esta linha para garantir strong exception safety
    if (tmpDoc == null) throw new IOException("*Stuff* happened");
    currDoc = tmpDoc;
    saveLocation = path;
    dirtyBit = false;
	}

	public void save() throws IOException, IllegalArgumentException {
    if (dirtyBit == false) {
      return; //MAYBE: What to do here?
    }
    if (saveLocation == null) {
      throw new IllegalArgumentException("Null is not a valid File");
    }
    FileOutputStream outFileStream = new FileOutputStream(saveLocation);
    ObjectOutputStream out = new ObjectOutputStream(outFileStream);
    out.writeObject(currDoc);
    dirtyBit = false;
	}

	public void save(File path) throws IOException, IllegalArgumentException {
    boolean oldDirtyBit = dirtyBit;
    File oldPath = saveLocation;
    saveLocation = path;
    dirtyBit = true;
    try {
      save();
    } catch (IOException|IllegalArgumentException e) {
      saveLocation = oldPath;
      dirtyBit = oldDirtyBit;
      throw e;
    }
	}

	public boolean issetFilename() {
		return saveLocation == null;
	}

  public Document getCurrentDocument() {
    return currDoc;
  }

  public void setDirtyBit() {
    dirtyBit = true;
  }
}
