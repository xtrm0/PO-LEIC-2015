/** @version $Id: Save.java,v 1.4 2015/10/18 02:07:21 ist181861 Exp $ */
package edt.textui.main;

import edt.core.Document;
import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;
import java.io.File;

import java.io.IOException;

/* FIXME: import core classes here */

/**
 * Save to file under current name (if unnamed, query for name).
 */
public class Save extends Command<Document> {
	public Save(Document w) {
		super(MenuEntry.SAVE, w);
	}

	@Override
	public final void execute() throws DialogException, IOException {
		String inp = null;
		File f = null;

		if (_receiver.requestFilename()) { // Este comando nao faz sentido neste
											// padrao de desenho :S
			inp = IO.readString(Message.openFile());
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
