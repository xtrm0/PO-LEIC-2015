/** @version $Id: ListSections.java,v 1.2 2015/10/17 19:58:54 ist181861 Exp $ */
package edt.textui.section;

import edt.core.Section;
import edt.core.Document;
import static ist.po.ui.Dialog.IO;
import ist.po.ui.DialogException;

import java.io.IOException;
import java.util.Iterator;

/**
 * §2.2.2.
 */
public class ListSections extends SectionCommand {
	public ListSections(Section s, Document w) {
		super(MenuEntry.LIST_SECTIONS, s, w);
	}

	@Override
	public final void execute() throws DialogException, IOException {
		Iterator<Section> it = _receiver.getPrefixIterator();
		it.next();
		while(it.hasNext()) {
			Section s = it.next();
			IO.println(Message.sectionIndexEntry(s.getId(), s.getTitle()));
		}
	}
}
