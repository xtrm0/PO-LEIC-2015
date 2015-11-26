/** @version $Id: SectionCommand.java,v 1.7 2015/11/26 03:44:16 ist181861 Exp $ */
package edt.textui.section;

import edt.core.Section;
import edt.core.DocumentEditor;
import ist.po.ui.Command;

/**
 * Superclass of all section-context commands.
 */
public abstract class SectionCommand extends Command<Section> {

	DocumentEditor docW;

	public SectionCommand(String title, Section receiver, DocumentEditor w) {
		super(title, receiver);
		docW = w;
	}

}
