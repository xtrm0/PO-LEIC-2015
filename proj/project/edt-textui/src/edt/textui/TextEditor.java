/** @version $Id: TextEditor.java,v 1.9 2015/11/04 00:20:27 ist181861 Exp $ */
package edt.textui;

import static ist.po.ui.Dialog.IO;

import edt.core.Document;
import edt.core.DocumentWorker;

/**
 * Class that starts the application's textual interface.
 */
public class TextEditor {
	public static void main(String[] args) {
		DocumentWorker mainWorker;

		String datafile = System.getProperty("import"); //$NON-NLS-1$
		if (datafile != null) {
			mainWorker = new DocumentWorker(datafile);
		} else {
			mainWorker = new DocumentWorker();
		}

		edt.textui.main.MenuBuilder.menuFor(mainWorker);
		IO.closeDown();
	}
}
