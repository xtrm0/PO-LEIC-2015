/** @version $Id: ShowIndex.java,v 1.5 2015/11/01 21:42:21 ist181861 Exp $ */
package edt.textui.main;

import edt.core.Document;
import edt.core.DocumentWorker;
import edt.core.Section;
import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;

import java.io.IOException;
import java.util.Iterator;

/**
 * §2.1.4.
 */
public class ShowIndex extends Command<DocumentWorker> {
	public ShowIndex(DocumentWorker w) {
		super(MenuEntry.SHOW_INDEX, w);
	}

	@Override
	public final void execute() throws DialogException, IOException {
		Document recvDoc = _receiver.getCurrentDocument();
		IO.println("{" + recvDoc.getTitle() + "}");
		Iterator<Section> it = recvDoc.getDirectIterator();
		while (it.hasNext()) {
			Section s = it.next();
			String currId = s.getId();
			IO.println(Message.sectionIndexEntry(currId != null ? currId : "", s.getTitle()));
		}
	}
}
