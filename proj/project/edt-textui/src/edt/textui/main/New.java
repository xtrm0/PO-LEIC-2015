/** @version $Id: New.java,v 1.1 2015/10/05 16:00:36 david Exp $ */
package edt.textui.main;

import edt.core.DocumentWorker;
import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;

import java.io.IOException;

/* FIXME: import core classes here */

/**
 * Open a new document.
 */
public class New extends Command<DocumentWorker> {
	public New(DocumentWorker w) {
		super(MenuEntry.NEW, w);
	}

	@Override
	public final void execute() throws DialogException, IOException {
		/* FIXME: implement command */
	}

}
