/** @version $Id: RemoveSection.java,v 1.4 2015/10/18 02:07:21 ist181861 Exp $ */
package edt.textui.section;

import edt.core.Section;
import edt.core.Document;
import static ist.po.ui.Dialog.IO;
import ist.po.ui.DialogException;

import java.io.IOException;

/* FIXME: import core classes here */

/**
 * §2.2.7.
 */
public class RemoveSection extends SectionCommand {
	public RemoveSection(Section s, Document w) {
		super(MenuEntry.REMOVE_SECTION, s, w);
	}

	@Override
	public final void execute() throws DialogException, IOException {
		int sectId = IO.readInteger(Message.requestSectionId());
		if (sectId < 0 || sectId >= _receiver.getSectionsCount()) {
			IO.println(Message.noSuchSection(sectId));
			return;
		}

		_receiver.removeSection(sectId);
	}

}
