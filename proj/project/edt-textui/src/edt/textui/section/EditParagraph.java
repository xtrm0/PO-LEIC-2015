/** @version $Id: EditParagraph.java,v 1.4 2015/11/01 21:42:21 ist181861 Exp $ */
package edt.textui.section;

import edt.core.Section;
import edt.core.DocumentWorker;
import edt.core.Paragraph;
import static ist.po.ui.Dialog.IO;
import ist.po.ui.DialogException;

import java.io.IOException;

/**
 * §2.2.10.
 */
public class EditParagraph extends SectionCommand {
	public EditParagraph(Section s, DocumentWorker w) {
		super(MenuEntry.EDIT_PARAGRAPH, s, w);
	}

	@Override
	public final void execute() throws DialogException, IOException {
		int parId = IO.readInteger(Message.requestParagraphId());
		String text = IO.readString(Message.requestParagraphContent());
		Paragraph targetParagraph = _receiver.getNthParagraph(parId);
		if (targetParagraph == null) {
			IO.readString(Message.noSuchParagraph(parId));
			return;
		}
		targetParagraph.setText(text);
		docW.setDirtyBit();
	}

}
