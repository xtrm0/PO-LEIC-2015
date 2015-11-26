/** @version $Id: New.java,v 1.6 2015/11/26 03:44:16 ist181861 Exp $ */
package edt.textui.main;

import edt.core.DocumentEditor;
import edt.core.Document;
import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;

import java.io.IOException;

/**
 * Open a new document.
 */
public class New extends Command<DocumentEditor> {
	public New(DocumentEditor w) {
		super(MenuEntry.NEW, w);
	}

	@Override
	public final void execute() throws DialogException, IOException {
		_receiver.newDocument();
	}

}
