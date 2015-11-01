/** @version $Id: ListSections.java,v 1.5 2015/11/01 21:42:21 ist181861 Exp $ */
package edt.textui.section;

import edt.core.Section;
import edt.core.DocumentWorker;
import static ist.po.ui.Dialog.IO;
import ist.po.ui.DialogException;

import java.io.IOException;
import java.util.Iterator;

/**
 * §2.2.2.
 */
public class ListSections extends SectionCommand {
	public ListSections(Section s, DocumentWorker w) {
		super(MenuEntry.LIST_SECTIONS, s, w);
	}

	@Override
	public final void execute() throws DialogException, IOException {
		Iterator<Section> it = _receiver.getPrefixIterator();
		it.next();
		while (it.hasNext()) {
			Section s = it.next();
			IO.println(Message.sectionIndexEntry(s.getId(), s.getTitle()));
		}
	}
}
