/** @version $Id: ChangeTitle.java,v 1.8 2015/11/30 23:17:08 ist181861 Exp $ */
package edt.textui.section;

import edt.core.Section;
import edt.core.DocumentEditor;
import static ist.po.ui.Dialog.IO;
import ist.po.ui.DialogException;

import java.io.IOException;

/**
 * §2.2.1.
 */
public class ChangeTitle extends SectionCommand {
	public ChangeTitle(Section s, DocumentEditor w) {
		super(MenuEntry.CHANGE_TITLE, s, w);
	}

	@Override
	public final void execute() throws DialogException, IOException {
		String inp = IO.readString(Message.requestSectionTitle());
		_receiver.setTitle(inp);
		docW.setDirtyBit();
	}
}
