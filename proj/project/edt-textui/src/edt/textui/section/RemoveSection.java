/** @version $Id: RemoveSection.java,v 1.5 2015/11/01 21:42:21 ist181861 Exp $ */
package edt.textui.section;

import edt.core.Section;
import edt.core.Document;
import edt.core.DocumentWorker;
import static ist.po.ui.Dialog.IO;
import ist.po.ui.DialogException;

import java.io.IOException;

/**
 * §2.2.7.
 */
public class RemoveSection extends SectionCommand {
	public RemoveSection(Section s, DocumentWorker w) {
		super(MenuEntry.REMOVE_SECTION, s, w);
	}

	@Override
	public final void execute() throws DialogException, IOException {
		int sectId = IO.readInteger(Message.requestSectionId());
		if (sectId < 0 || sectId >= _receiver.getSectionsCount()) {
			IO.println(Message.noSuchSection(sectId));
			return;
		}

		Document doc = docW.getCurrentDocument();
		doc.removeSection(_receiver, sectId);
		docW.setDirtyBit();
	}

}
