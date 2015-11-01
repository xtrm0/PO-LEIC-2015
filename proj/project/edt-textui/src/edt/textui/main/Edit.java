/** @version $Id: Edit.java,v 1.6 2015/11/01 21:42:21 ist181861 Exp $ */
package edt.textui.main;

import edt.core.Section;
import edt.core.Document;
import edt.core.DocumentWorker;
import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;

import java.io.IOException;

/**
 * §2.3.1.
 */
public class Edit extends Command<DocumentWorker> {
	public Edit(DocumentWorker w) {
		super(MenuEntry.OPEN_DOCUMENT_EDITOR, w);
	}

	@Override
	public final void execute() throws DialogException, IOException {
		Document recvDoc = _receiver.getCurrentDocument();
		Section s = (Section) recvDoc;
		edt.textui.section.MenuBuilder.menuFor(s, _receiver);
	}

}
