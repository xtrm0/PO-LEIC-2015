/** @version $Id: Edit.java,v 1.4 2015/10/18 02:07:21 ist181861 Exp $ */
package edt.textui.main;

import edt.core.Section;
import edt.core.Document;
import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;

import java.io.IOException;

/* FIXME: import core classes here */

/**
 * §2.3.1.
 */
public class Edit extends Command<Document> {
	public Edit(Document w) {
		super(MenuEntry.OPEN_DOCUMENT_EDITOR, w);
	}

	@Override
	public final void execute() throws DialogException, IOException {
		Section s = (Section) _receiver;
		edt.textui.section.MenuBuilder.menuFor(s, _receiver);
	}

}
