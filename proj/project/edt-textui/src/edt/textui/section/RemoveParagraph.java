/** @version $Id: RemoveParagraph.java,v 1.4 2015/10/18 02:07:21 ist181861 Exp $ */
package edt.textui.section;

import edt.core.Section;
import edt.core.Document;
import static ist.po.ui.Dialog.IO;
import ist.po.ui.DialogException;

import java.io.IOException;

/* FIXME: import core classes here */

/**
 * §2.2.11.
 */
public class RemoveParagraph extends SectionCommand {
	public RemoveParagraph(Section s, Document w) {
		super(MenuEntry.REMOVE_PARAGRAPH, s, w);
	}

	@Override
	public final void execute() throws DialogException, IOException {
		int parId = IO.readInteger(Message.requestParagraphId());
		if (parId < 0 || parId >= _receiver.getSectionsCount()) {
			IO.println(Message.noSuchParagraph(parId));
			return;
		}
		_receiver.removeParagraph(parId);
	}

}
