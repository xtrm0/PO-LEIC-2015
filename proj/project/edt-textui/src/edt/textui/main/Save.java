/** @version $Id: Save.java,v 1.6 2015/10/22 21:20:48 ist181861 Exp $ */
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
	//XXX: isto esta claramente mal feito, ie, nao cumpre as specs
	public final void execute() throws DialogException, IOException {
		String inp = null;
		File f = null;

		if (_receiver.issetFilename()) {
			inp = IO.readString(Message.saveAs());
			f = new File(inp);
		}

		try {
			if (f == null) {
				_receiver.save();
			} else {
				_receiver.save(f);
			}
		} catch (Exception e) {
			// TODO
		}
	}
}
