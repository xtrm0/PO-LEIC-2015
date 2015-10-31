/** @version $Id: NameParagraph.java,v 1.5 2015/10/22 21:20:48 ist181861 Exp $ */
package edt.textui.section;

import edt.core.Paragraph;
import edt.core.Section;
import edt.core.Document;
import static ist.po.ui.Dialog.IO;
import ist.po.ui.DialogException;

import java.io.IOException;

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
		Paragraph p = _receiver.getNthParagraph(parId);
		doc.addElementId(newUniqId,p);
	}
}
