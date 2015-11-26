/** @version $Id: ShowMetadata.java,v 1.5 2015/11/26 03:44:16 ist181861 Exp $ */
package edt.textui.main;

import edt.core.Author;
import edt.core.Document;
import edt.core.DocumentEditor;
import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;

import java.io.IOException;

/**
 * §2.1.2.
 */
public class ShowMetadata extends Command<DocumentEditor> {
	public ShowMetadata(DocumentEditor w) {
		super(MenuEntry.SHOW_METADATA, w);
	}

	@Override
	public final void execute() throws DialogException, IOException {
		Document recvDoc = _receiver.getCurrentDocument();
		IO.println(Message.documentTitle(recvDoc.getTitle()));
		for (Author auth : recvDoc.getAuthors()) {
			IO.println(Message.author(auth.getName(), auth.getContact()));
		}
		IO.println(Message.documentSections(recvDoc.getSectionsCount()));
		IO.println(Message.documentBytes(recvDoc.getLength()));
		IO.println(Message.documentIdentifiers(recvDoc.getIdsCount()));
	}

}
