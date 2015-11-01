/** @version $Id: AddAuthor.java,v 1.6 2015/11/01 21:42:21 ist181861 Exp $ */
package edt.textui.main;

import edt.core.Document;
import edt.core.DocumentWorker;
import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;

import java.io.IOException;

/**
 * §2.1.3.
 */
public class AddAuthor extends Command<DocumentWorker> {
	public AddAuthor(DocumentWorker w) {
		super(MenuEntry.ADD_AUTHOR, w);
	}

	@Override
	public final void execute() throws DialogException, IOException {
		Document recvDoc = _receiver.getCurrentDocument();
		String name = IO.readString(Message.requestAuthorName());
		String email = IO.readString(Message.requestEmail());

		if (recvDoc.addAuthor(name, email)) {
			IO.println(Message.duplicateAuthor(name));
		} else {
			_receiver.setDirtyBit();
		}
	}
}
