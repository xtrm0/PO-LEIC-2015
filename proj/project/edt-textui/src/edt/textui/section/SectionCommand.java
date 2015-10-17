/** @version $Id: SectionCommand.java,v 1.1 2015/10/05 16:00:37 david Exp $ */
package edt.textui.section;

import edt.core.Section;
import edt.core.DocumentWorker;
import ist.po.ui.Command;

/* FIXME: import core classes here */

/**
 * Superclass of all section-context commands.
 */
public abstract class SectionCommand extends Command<Section> {

  DocumentWorker docWork;

	public SectionCommand(String title, Section receiver, DocumentWorker w) {
		super(title, receiver);
    docWork = w;
		/* FIXME: initialize second receiver */
	}

}
