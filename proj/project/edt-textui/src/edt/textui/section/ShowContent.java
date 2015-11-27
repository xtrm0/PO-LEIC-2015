/** @version $Id: ShowContent.java,v 1.8 2015/11/26 20:47:01 ist181861 Exp $ */
package edt.textui.section;

import edt.core.Section;
import edt.core.DocumentEditor;
import static ist.po.ui.Dialog.IO;
import ist.po.ui.DialogException;

import java.io.IOException;
import java.util.Iterator;

/**
 * §2.2.3.
 */
public class ShowContent extends SectionCommand {
	public ShowContent(Section s, DocumentEditor w) {
		super(MenuEntry.SHOW_CONTENT, s, w);
	}

	@Override
	public final void execute() throws DialogException, IOException {
		_receiver.accept(new ShowerElementVisitor());
	}
}
