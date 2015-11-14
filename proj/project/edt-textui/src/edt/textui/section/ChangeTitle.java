/** @version $Id: ChangeTitle.java,v 1.6 2015/11/03 23:04:40 ist181861 Exp $ */
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
