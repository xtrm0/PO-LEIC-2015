/** @version $Id: NameSection.java,v 1.5 2015/10/22 21:20:48 ist181861 Exp $ */
package edt.textui.section;

import edt.core.Section;
import edt.core.Document;
import static ist.po.ui.Dialog.IO;
import ist.po.ui.DialogException;

import java.io.IOException;

/* FIXME: import core classes here */

/**
 * §2.2.6.
 */
public class NameSection extends SectionCommand {
	public NameSection(Section s, Document w) {
		super(MenuEntry.NAME_SECTION, s, w);
	}

	@Override
	public final void execute() throws DialogException, IOException {
		int sectId = IO.readInteger(Message.requestSectionId());
		String newUniqId = IO.readString(Message.requestUniqueId());
		if (sectId < 0 || sectId >= _receiver.getSectionsCount()) {
			IO.println(Message.noSuchSection(sectId));
			return;
		}
		if (_receiver.getNthSection(sectId).getId() != null) {
			IO.println(Message.sectionNameChanged());
		}
		Section s = _receiver.getNthSection(sectId);
		doc.addElementId(newUniqId,s);
	}
}
