/** @version $Id: TextEditor.java,v 1.5 2015/10/22 21:20:48 ist181861 Exp $ */
package edt.textui;

import static ist.po.ui.Dialog.IO;

import edt.core.DocumentWorker;

/**
 * Class that starts the application's textual interface.
 */
public class TextEditor {
	public static void main(String[] args) {
		DocumentWorker mainWorker = new DocumentWorker();

		String datafile = System.getProperty("import"); //$NON-NLS-1$
		if (datafile != null) {
			/* FIXME: tell core object(s) to import data into core */
			// WARN: No ideia what this is for :S
		}

		edt.textui.main.MenuBuilder.menuFor(mainWorker);
		IO.closeDown();
	}
}
