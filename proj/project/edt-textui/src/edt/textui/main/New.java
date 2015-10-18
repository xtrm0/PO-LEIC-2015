/** @version $Id: New.java,v 1.3 2015/10/18 01:59:15 ist181861 Exp $ */
package edt.textui.main;

import edt.core.Document;
import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;

import java.io.IOException;

/**
 * Open a new document.
 */
public class New extends Command<Document> {
	public New(Document w) {
		super(MenuEntry.NEW, w);
	}

	@Override
	public final void execute() throws DialogException, IOException {
		_receiver.reset();
	}

}
