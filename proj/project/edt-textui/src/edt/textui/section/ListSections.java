/** @version $Id: ListSections.java,v 1.6 2015/11/24 00:15:04 ist181861 Exp $ */
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
			String sid = s.getId();
			IO.println(Message.sectionIndexEntry(sid!=null ? sid : "", s.getTitle()));
		}
	}
}
