/** @version $Id: TextEditor.java,v 1.10 2015/11/26 03:44:16 ist181861 Exp $ */
package edt.textui;

import static ist.po.ui.Dialog.IO;

import edt.core.Document;
import edt.core.DocumentEditor;

/**
 * Class that starts the application's textual interface.
 */
public class TextEditor {
	public static void main(String[] args) {
		DocumentEditor mainWorker;

		String datafile = System.getProperty("import"); //$NON-NLS-1$
		if (datafile != null) {
			mainWorker = new DocumentEditor(datafile);
		} else {
			mainWorker = new DocumentEditor();
		}

		edt.textui.main.MenuBuilder.menuFor(mainWorker);
		IO.closeDown();
	}
}
