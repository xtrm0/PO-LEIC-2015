/** @version $Id: TextEditor.java,v 1.1 2015/10/05 16:00:34 david Exp $ */
package edt.textui;

import static ist.po.ui.Dialog.IO;

import java.io.IOException;

/* FIXME: import core classes here */

/**
 * Class that starts the application's textual interface.
 */
public class TextEditor {
	public static void main(String[] args) {
		/* FIXME: create core object(s) here */
		String datafile = System.getProperty("import"); //$NON-NLS-1$
		if (datafile != null) {
			/* FIXME: tell core object(s) to import data into core */
			}
		}
		edt.textui.main.MenuBuilder.menuFor(/* FIXME: core object */);
		IO.closeDown();
	}
}
