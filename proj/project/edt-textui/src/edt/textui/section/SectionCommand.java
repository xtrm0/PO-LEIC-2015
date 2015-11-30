/** @version $Id: SectionCommand.java,v 1.8 2015/11/30 23:17:08 ist181861 Exp $ */
package edt.textui.section;

import edt.core.Section;
import edt.core.DocumentEditor;
import ist.po.ui.Command;

/**
 * Superclass of all section-context commands.
 */
public abstract class SectionCommand extends Command<Section> {

	protected DocumentEditor docW;

	public SectionCommand(String title, Section receiver, DocumentEditor w) {
		super(title, receiver);
		docW = w;
	}

}
