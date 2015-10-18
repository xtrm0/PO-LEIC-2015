/** @version $Id: ChangeTitle.java,v 1.2 2015/10/17 19:58:54 ist181861 Exp $ */
package edt.textui.section;

import edt.core.Section;
import edt.core.Document;
import static ist.po.ui.Dialog.IO;
import ist.po.ui.DialogException;

import java.io.IOException;

/* FIXME: import core classes here */

/**
 * §2.2.1.
 */
public class ChangeTitle extends SectionCommand {
	public ChangeTitle(Section s, Document w) {
		super(MenuEntry.CHANGE_TITLE, s, w);
	}

	@Override
	public final void execute() throws DialogException, IOException {
		String inp = IO.readString(Message.requestSectionTitle());
  	_receiver.setTitle(inp);
	}
}
