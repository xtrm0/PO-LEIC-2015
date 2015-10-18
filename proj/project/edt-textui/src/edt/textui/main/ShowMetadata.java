/** @version $Id: ShowMetadata.java,v 1.2 2015/10/17 19:58:54 ist181861 Exp $ */
package edt.textui.main;

import edt.core.Author;
import edt.core.Document;
import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;

import java.io.IOException;

/**
 * §2.1.2.
 */
public class ShowMetadata extends Command<Document> {
	public ShowMetadata(Document w) {
		super(MenuEntry.SHOW_METADATA, w);
	}

	@Override
	public final void execute() throws DialogException, IOException {
		IO.println(Message.documentTitle(_receiver.getTitle()));
		for (Author auth : _receiver.getAuthors()) {
			IO.println(Message.author(auth.getName(), auth.getContact()));
		}
		IO.println(Message.documentSections(_receiver.getSectionsCount()));
		IO.println(Message.documentBytes(_receiver.getLength()));
		IO.println(Message.documentIdentifiers(_receiver.getIdentifiersCount()));
	}

}
