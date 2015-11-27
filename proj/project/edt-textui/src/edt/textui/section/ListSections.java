/** @version $Id: ListSections.java,v 1.8 2015/11/26 20:47:01 ist181861 Exp $ */
package edt.textui.section;

import edt.core.Section;
import edt.core.DocumentEditor;
import static ist.po.ui.Dialog.IO;
import ist.po.ui.DialogException;

import java.io.IOException;
import java.util.Iterator;

/**
 * §2.2.2.
 */
public class ListSections extends SectionCommand {
	public ListSections(Section s, DocumentEditor w) {
		super(MenuEntry.LIST_SECTIONS, s, w);
	}

	@Override
	public final void execute() throws DialogException, IOException {
		_receiver.accept(new ShowerSectionVisitor());
	}
}
