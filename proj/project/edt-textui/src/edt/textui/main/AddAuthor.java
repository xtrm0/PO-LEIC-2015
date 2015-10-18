/** @version $Id: AddAuthor.java,v 1.4 2015/10/18 02:07:21 ist181861 Exp $ */
package edt.textui.main;

import edt.core.Document;
import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;

import java.io.IOException;

/**
 * §2.1.3.
 */
public class AddAuthor extends Command<Document> {
	public AddAuthor(Document w) {
		super(MenuEntry.ADD_AUTHOR, w);
	}

	@Override
	public final void execute() throws DialogException, IOException {
		String name = IO.readString(Message.requestAuthorName());
		String email = IO.readString(Message.requestEmail());

		try {
			_receiver.addAuthor(name, email);
		} catch (Exception e) {
			// nome repetido
		}
	}
}
