/** @version $Id: ShowContent.java,v 1.9 2015/11/30 23:17:08 ist181861 Exp $ */
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
		ShowerElementVisitor vis = new ShowerElementVisitor();
		_receiver.accept(vis);
		for (String s : vis.getReturn()) {
			IO.println(s);
		}
	}
}
