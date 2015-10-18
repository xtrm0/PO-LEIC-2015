/** @version $Id: Open.java,v 1.4 2015/10/18 02:07:21 ist181861 Exp $ */
package edt.textui.main;

import edt.core.Document;
import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;
import java.io.File;

import java.io.IOException;

/**
 * Open existing document.
 */
public class Open extends Command<Document> {
	public Open(Document w) {
		super(MenuEntry.OPEN, w);
	}

	@Override
	public final void execute() throws DialogException, IOException {
		String inp = IO.readString(Message.openFile());
		File f = new File(inp);
		try {
			_receiver.loadFile(f);
		} catch (Exception e) {
			// TODO
		}
	}

}
