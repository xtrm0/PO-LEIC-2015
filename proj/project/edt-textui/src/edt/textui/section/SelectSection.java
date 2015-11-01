/** @version $Id: SelectSection.java,v 1.5 2015/10/22 21:20:48 ist181861 Exp $ */
package edt.textui.section;

import edt.core.Section;
import edt.core.DocumentWorker;
import static ist.po.ui.Dialog.IO;
import ist.po.ui.DialogException;

import java.io.IOException;

/**
 * §2.2.4.
 */
public class SelectSection extends SectionCommand {
	public SelectSection(Section s, DocumentWorker w) {
		super(MenuEntry.SELECT_SECTION, s, w);
	}

	@Override
	public final void execute() throws DialogException, IOException {
		int newSectId = IO.readInteger(Message.requestSectionId());
		Section newWorker = _receiver.getNthSection(newSectId);
		if (newWorker == null) {
			IO.println(Message.noSuchSection(newSectId));
			return;
		}
		IO.println(Message.newActiveSection(newSectId));
		edt.textui.section.MenuBuilder.menuFor(newWorker, docW);
	}
}
