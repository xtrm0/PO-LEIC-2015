package edt.core;

import java.io.File;

import java.io.IOException;
import java.lang.ClassNotFoundException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.nio.charset.Charset;

public final class DocumentEditor {
  private Document currDoc;

	private File saveLocation;
  private boolean dirtyBit;

	public DocumentEditor() {
		currDoc = new Document();
    saveLocation = null;
    dirtyBit = true;
	}

  public DocumentEditor(String datafile) {
    this();
    try {
      String tmp;
      InputStream fis = new FileInputStream(datafile);
      InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
      BufferedReader br = new BufferedReader(isr);
      Section lastSection = currDoc;
      tmp = br.readLine();
      currDoc.setTitle(tmp);
      tmp = br.readLine();
      String[] tmp2;
      for (String authorStr : tmp.split("\\|")) {
        tmp2 = authorStr.split("/");
        currDoc.addAuthor(tmp2[0], tmp2[1]);
      }
      while ((tmp = br.readLine()) != null) {
        tmp2 = tmp.split("\\|");
        if (tmp2[0].equals("SECTION")) {
          currDoc.insertSection(tmp2[2], currDoc.getSectionsCount());
          lastSection = currDoc.getNthSection(currDoc.getSectionsCount()-1);
          if (tmp2[1]!=null && !tmp2[1].equals("")) {
            currDoc.addElementId(tmp2[1], lastSection);
          }
        } else if (tmp2[0].equals("PARAGRAPH")) {
          lastSection.insertParagraph(tmp2[1], lastSection.getParagraphsCount());
        } else {
          throw new ClassNotFoundException("First token must be either SECTION or PARAGRAPH!");
        }
      }
    } catch (Exception ex) { //caso o documento nao seja valido
      //System.out.println("catn laod shti");
      currDoc = new Document();
      saveLocation = null;
      dirtyBit = true;
      //System.out.println(ex);
    }
  }

	public void newDocument() {
		currDoc = new Document();
    saveLocation = null;
    dirtyBit = true;
	}

	public void loadDocument(File path) throws IOException, ClassNotFoundException, IllegalArgumentException {
    if (path == null) throw new IllegalArgumentException("Null is not a valid File");
    if (!path.exists() || path.isDirectory()) throw new IOException("File not found!");
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
    saveLocation.setWritable(true,false);
    saveLocation.setReadable(true,false);
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
