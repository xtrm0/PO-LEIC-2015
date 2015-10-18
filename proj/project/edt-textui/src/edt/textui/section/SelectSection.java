/** @version $Id: SelectSection.java,v 1.4 2015/10/18 02:07:21 ist181861 Exp $ */
package edt.textui.section;

import edt.core.Section;
import edt.core.Document;
import static ist.po.ui.Dialog.IO;
import ist.po.ui.DialogException;

import java.io.IOException;

/* FIXME: import core classes here */

/**
 * §2.2.4.
 */
public class SelectSection extends SectionCommand {
	public SelectSection(Section s, Document w) {
		super(MenuEntry.SELECT_SECTION, s, w);
	}

	@Override
	public final void execute() throws DialogException, IOException {
		int newSectId = IO.readInteger(Message.requestSectionId());
		if (newSectId < 0 || newSectId >= _receiver.getSectionsCount()) {
			IO.println(Message.noSuchSection(newSectId));
		}
		Section newWorker = _receiver.getNthSection(newSectId);
		IO.println(Message.newActiveSection(newSectId));
		edt.textui.section.MenuBuilder.menuFor(newWorker, docWork);
	}
}
