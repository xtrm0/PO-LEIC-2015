/** @version $Id: Edit.java,v 1.7 2015/11/26 03:44:16 ist181861 Exp $ */
package edt.textui.main;

import edt.core.Section;
import edt.core.Document;
import edt.core.DocumentEditor;
import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;

import java.io.IOException;

/**
 * §2.3.1.
 */
public class Edit extends Command<DocumentEditor> {
	public Edit(DocumentEditor w) {
		super(MenuEntry.OPEN_DOCUMENT_EDITOR, w);
	}

	@Override
	public final void execute() throws DialogException, IOException {
		Document recvDoc = _receiver.getCurrentDocument();
		Section s = (Section) recvDoc;
		edt.textui.section.MenuBuilder.menuFor(s, _receiver);
	}

}
