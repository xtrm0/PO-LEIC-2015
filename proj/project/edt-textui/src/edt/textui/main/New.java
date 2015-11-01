/** @version $Id: New.java,v 1.4 2015/10/22 21:20:48 ist181861 Exp $ */
package edt.textui.main;

import edt.core.DocumentWorker;
import edt.core.Document;
import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;

import java.io.IOException;

/**
 * Open a new document.
 */
public class New extends Command<DocumentWorker> {
	public New(DocumentWorker w) {
		super(MenuEntry.NEW, w);
	}

	@Override
	public final void execute() throws DialogException, IOException {
		_receiver.newDocument();
	}

}
