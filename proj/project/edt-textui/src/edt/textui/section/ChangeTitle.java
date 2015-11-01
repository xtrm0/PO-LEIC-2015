/** @version $Id: ChangeTitle.java,v 1.5 2015/11/01 21:42:21 ist181861 Exp $ */
package edt.textui.section;

import edt.core.Section;
import edt.core.DocumentWorker;
import static ist.po.ui.Dialog.IO;
import ist.po.ui.DialogException;

import java.io.IOException;

/**
 * §2.2.1.
 */
public class ChangeTitle extends SectionCommand {
	public ChangeTitle(Section s, DocumentWorker w) {
		super(MenuEntry.CHANGE_TITLE, s, w);
	}

	@Override
	public final void execute() throws DialogException, IOException {
		String inp = IO.readString(Message.requestSectionTitle());
		_receiver.setTitle(inp);
		docW.setDirtyBit();
	}
}
