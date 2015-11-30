/** @version $Id: Open.java,v 1.13 2015/11/30 23:17:08 ist181861 Exp $ */
package edt.textui.main;

import edt.core.Document;
import edt.core.DocumentEditor;
import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;
import java.io.File;

import java.io.IOException;

/**
 * Open existing document.
 */
public class Open extends Command<DocumentEditor> {
	public Open(DocumentEditor w) {
		super(MenuEntry.OPEN, w);
	}

	@Override
	public final void execute() throws DialogException, IOException {
		String inp = IO.readString(Message.openFile());
		try {
			_receiver.loadDocument(inp);
		} catch (IOException e) {
			IO.println(Message.fileNotFound(inp));
		} catch (ClassNotFoundException|IllegalArgumentException e) {
			//Dont know what to do
			//IO.println("Other *stuff* happened");
			IO.println(Message.fileNotFound(inp));
		}
	}

}
