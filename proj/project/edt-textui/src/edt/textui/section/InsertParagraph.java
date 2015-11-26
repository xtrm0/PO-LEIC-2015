/** @version $Id: InsertParagraph.java,v 1.5 2015/11/26 03:44:16 ist181861 Exp $ */
package edt.textui.section;

import edt.core.Section;
import edt.core.DocumentEditor;
import static ist.po.ui.Dialog.IO;
import ist.po.ui.DialogException;

import java.io.IOException;

/**
 * §2.2.8.
 */
public class InsertParagraph extends SectionCommand {
	public InsertParagraph(Section s, DocumentEditor w) {
		super(MenuEntry.INSERT_PARAGRAPH, s, w);
	}

	@Override
	public final void execute() throws DialogException, IOException {
		int parId = IO.readInteger(Message.requestParagraphId());
		String text = IO.readString(Message.requestParagraphContent());
		if (parId < 0 || parId >= _receiver.getParagraphsCount()) {
			parId = _receiver.getParagraphsCount();
		}
		_receiver.insertParagraph(text, parId);
		docW.setDirtyBit();
	}

}
