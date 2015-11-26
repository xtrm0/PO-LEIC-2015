/** @version $Id: NameSection.java,v 1.7 2015/11/26 03:44:16 ist181861 Exp $ */
package edt.textui.section;

import edt.core.Section;
import edt.core.Document;
import edt.core.DocumentEditor;
import static ist.po.ui.Dialog.IO;
import ist.po.ui.DialogException;

import java.io.IOException;

/**
 * §2.2.6.
 */
public class NameSection extends SectionCommand {
	public NameSection(Section s, DocumentEditor w) {
		super(MenuEntry.NAME_SECTION, s, w);
	}

	@Override
	public final void execute() throws DialogException, IOException {
		int sectId = IO.readInteger(Message.requestSectionId());
		String newUniqId = IO.readString(Message.requestUniqueId());
		Section targetSection = _receiver.getNthSection(sectId);

		if (targetSection == null) {
			IO.println(Message.noSuchSection(sectId));
			return;
		}
		if (targetSection.getId() != null) {
			IO.println(Message.sectionNameChanged());
		}

		Document doc = docW.getCurrentDocument();
		doc.addElementId(newUniqId,targetSection);
		docW.setDirtyBit();
	}
}
