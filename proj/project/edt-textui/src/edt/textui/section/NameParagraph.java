/** @version $Id: NameParagraph.java,v 1.4 2015/10/18 02:07:21 ist181861 Exp $ */
package edt.textui.section;

import edt.core.Section;
import edt.core.Document;
import static ist.po.ui.Dialog.IO;
import ist.po.ui.DialogException;

import java.io.IOException;

/* FIXME: import core classes here */

/**
 * §2.2.9.
 */
public class NameParagraph extends SectionCommand {
	public NameParagraph(Section s, Document w) {
		super(MenuEntry.NAME_PARAGRAPH, s, w);
	}

	@Override
	public final void execute() throws DialogException, IOException {
		int parId = IO.readInteger(Message.requestParagraphId());
		String newUniqId = IO.readString(Message.requestUniqueId());
		if (parId < 0 || parId >= _receiver.getParagraphsCount()) {
			IO.println(Message.noSuchParagraph(parId));
			return;
		}
		if (_receiver.getNthParagraph(parId).getId() != null) {
			IO.println(Message.paragraphNameChanged());
		}
		_receiver.getNthParagraph(parId).switchUniqueId(newUniqId);
	}
}
