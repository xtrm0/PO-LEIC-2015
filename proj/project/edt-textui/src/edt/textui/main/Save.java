/** @version $Id: Save.java,v 1.9 2015/11/12 05:41:40 ist181861 Exp $ */
package edt.textui.main;

import edt.core.Document;
import edt.core.DocumentWorker;
import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;
import java.io.File;

import java.io.IOException;

/**
 * Save to file under current name (if unnamed, query for name).
 */
public class Save extends Command<DocumentWorker> {
	public Save(DocumentWorker w) {
		super(MenuEntry.SAVE, w);
	}

	@Override
	public final void execute() throws DialogException, IOException {
		String inp = null;
		File f = null;

		try {
			if (_receiver.issetFilename()) {
				inp = IO.readString(Message.newSaveAs());
				f = new File(inp);
				_receiver.save(f);
			} else {
				_receiver.save();
			}
		} catch (Exception e) {
			//MAYBE: actualmente nao foi definido nada para fazer neste caso
		}
	}
}
