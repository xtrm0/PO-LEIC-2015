/** @version $Id: ShowIndex.java,v 1.3 2015/10/18 01:59:15 ist181861 Exp $ */
package edt.textui.main;

import edt.core.Document;
import edt.core.Section;
import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;

import java.io.IOException;
import java.util.Iterator;

/* FIXME: import core classes here */

/**
 * §2.1.4.
 */
public class ShowIndex extends Command<Document> {
	public ShowIndex(Document w) {
		super(MenuEntry.SHOW_INDEX, w);
	}

	@Override
	public final void execute() throws DialogException, IOException {
		IO.println("{" + _receiver.getTitle() + "}");
		Iterator<Section> it = _receiver.getDirectIterator();
		while (it.hasNext()) {
			Section s = it.next();
			IO.println(Message.sectionIndexEntry(s.getId(), s.getTitle()));
		}
	}
}
