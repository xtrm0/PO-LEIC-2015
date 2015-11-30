/** @version $Id: Save.java,v 1.11 2015/11/30 23:17:08 ist181861 Exp $ */
package edt.textui.main;

import edt.core.Document;
import edt.core.DocumentEditor;
import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;
import java.io.File;

import java.io.IOException;

/**
 * Save to file under current name (if unnamed, query for name).
 */
public class Save extends Command<DocumentEditor> {
	public Save(DocumentEditor w) {
		super(MenuEntry.SAVE, w);
	}

	@Override
	public final void execute() throws DialogException, IOException {
		String inp = null;
		try {
			if (_receiver.issetFilename()) {
				inp = IO.readString(Message.newSaveAs());
				_receiver.save(inp);
			} else {
				_receiver.save();
			}
		} catch (Exception e) {
			//MAYBE: actualmente nao foi definido nada para fazer neste caso
		}
	}
}
