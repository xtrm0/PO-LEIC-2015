/** @version $Id: TextEditor.java,v 1.4 2015/10/18 02:07:21 ist181861 Exp $ */
package edt.textui;

import static ist.po.ui.Dialog.IO;

import edt.core.Document;

/* FIXME: import core classes here */

/**
 * Class that starts the application's textual interface.
 */
public class TextEditor {
	public static void main(String[] args) {
		Document mainWorker = new Document();

		String datafile = System.getProperty("import"); //$NON-NLS-1$
		if (datafile != null) {
			/* FIXME: tell core object(s) to import data into core */
			// WARN: No ideia what this is for :S
		}

		edt.textui.main.MenuBuilder.menuFor(mainWorker);
		IO.closeDown();
	}
}
