/** @version $Id: InsertSection.java,v 1.6 2015/11/26 03:44:16 ist181861 Exp $ */
package edt.textui.section;

import edt.core.Section;
import edt.core.DocumentEditor;
import static ist.po.ui.Dialog.IO;
import ist.po.ui.DialogException;

import java.io.IOException;

/**
 * §2.2.5.
 */
public class InsertSection extends SectionCommand {
	public InsertSection(Section s, DocumentEditor w) {
		super(MenuEntry.INSERT_SECTION, s, w);
	}

	@Override
	public final void execute() throws DialogException, IOException {
		int sectId = IO.readInteger(Message.requestSectionId());
		String title = IO.readString(Message.requestSectionTitle());
		if (sectId < 0 || sectId >= _receiver.getSectionsCount()) {
			sectId = _receiver.getSectionsCount();
		}
		_receiver.insertSection(title, sectId);
		docW.setDirtyBit();
	}
}
