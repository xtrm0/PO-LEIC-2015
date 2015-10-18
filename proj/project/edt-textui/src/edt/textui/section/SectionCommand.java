/** @version $Id: SectionCommand.java,v 1.2 2015/10/17 19:58:55 ist181861 Exp $ */
package edt.textui.section;

import edt.core.Section;
import edt.core.Document;
import ist.po.ui.Command;

/* FIXME: import core classes here */

/**
 * Superclass of all section-context commands.
 */
public abstract class SectionCommand extends Command<Section> {

  Document docWork;

	public SectionCommand(String title, Section receiver, Document w) {
		super(title, receiver);
    docWork = w;
		/* FIXME: initialize second receiver */
	}

}
