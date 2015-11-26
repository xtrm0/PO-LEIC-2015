/** @version $Id: AddAuthor.java,v 1.8 2015/11/26 03:44:16 ist181861 Exp $ */
package edt.textui.main;

import edt.core.Document;
import edt.core.DocumentEditor;
import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;

import java.io.IOException;

/**
 * §2.1.3.
 */
public class AddAuthor extends Command<DocumentEditor> {
	public AddAuthor(DocumentEditor w) {
		super(MenuEntry.ADD_AUTHOR, w);
	}

	@Override
	public final void execute() throws DialogException, IOException {
		Document recvDoc = _receiver.getCurrentDocument();
		String name = IO.readString(Message.requestAuthorName());
		String email = IO.readString(Message.requestEmail());
 		try {
			if (recvDoc.addAuthor(name, email)) {
				IO.println(Message.duplicateAuthor(name));
			} else {
				_receiver.setDirtyBit();
			}
		} catch (NullPointerException ex) {
			//caso o nome/email do autor seja null. Nao ha definicao para isto ainda
		}
	}
}
