/** @version $Id: SectionCommand.java,v 1.5 2015/10/22 21:20:48 ist181861 Exp $ */
package edt.textui.section;

import edt.core.Section;
import edt.core.DocumentWorker;
import ist.po.ui.Command;

/**
 * Superclass of all section-context commands.
 */
public abstract class SectionCommand extends Command<Section> {

	DocumentWorker docW;

	public SectionCommand(String title, Section receiver, DocumentWorker w) {
		super(title, receiver);
		docW = w;
	}

}
