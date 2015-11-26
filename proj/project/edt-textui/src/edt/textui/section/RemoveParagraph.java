/** @version $Id: RemoveParagraph.java,v 1.7 2015/11/26 03:44:16 ist181861 Exp $ */
package edt.textui.section;

import edt.core.Section;
import edt.core.Document;
import edt.core.DocumentEditor;
import static ist.po.ui.Dialog.IO;
import ist.po.ui.DialogException;

import java.io.IOException;

/**
 * §2.2.11.
 */
public class RemoveParagraph extends SectionCommand {
	public RemoveParagraph(Section s, DocumentEditor w) {
		super(MenuEntry.REMOVE_PARAGRAPH, s, w);
	}

	@Override
	public final void execute() throws DialogException, IOException {
		int parId = IO.readInteger(Message.requestParagraphId());
		if (parId < 0 || parId >= _receiver.getParagraphsCount()) {
			IO.println(Message.noSuchParagraph(parId));
			return;
		}

		Document doc = docW.getCurrentDocument();
		doc.removeParagraph(_receiver, parId);
		docW.setDirtyBit();
	}

}
