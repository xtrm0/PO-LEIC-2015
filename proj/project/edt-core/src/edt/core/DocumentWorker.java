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

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;

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

	public void loadDocument(File path) throws IOException, ClassNotFoundException {
    FileInputStream inFileStream = new FileInputStream(path);
    ObjectInputStream in = new ObjectInputStream(inFileStream);
    Document tmpDoc = (Document) in.readObject(); //Separamos esta linha para garantir strong exception safety
    if (tmpDoc == null) throw new IOException("*Stuff* happened");
    currDoc = tmpDoc;
    saveLocation = path;
    dirtyBit = false;
	}

//XXX: check if saving was sucessfull
//XXX: check if timestamp on disk differs
//XXX: ask teacher how are we suposed to check wheter we should write the file or not
	public void save() throws IOException {
    if (dirtyBit == false) {
      return; //TODO: Add an exception for this ?
    }
    FileOutputStream outFileStream = new FileOutputStream(saveLocation);
    ObjectOutputStream out = new ObjectOutputStream(outFileStream);
    out.writeObject(currDoc);
    dirtyBit = false;
	}

//XXX: check xxx definitions for save above,
/*HACK: Is this ok?
  What is better to keep the strong exception guarantee:
    1) Use the same code twice
    2) Use a try-catch and on the catch do a rollback and throw back
*/
	public void save(File path) throws IOException {
    boolean oldDirtyBit = dirtyBit;
    File oldPath = saveLocation;
    saveLocation = path;
    dirtyBit = true;
    try {
      save();
    } catch (IOException e) {
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
