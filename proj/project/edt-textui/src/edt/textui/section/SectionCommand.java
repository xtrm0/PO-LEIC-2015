/** @version $Id: SectionCommand.java,v 1.5 2015/10/22 21:20:48 ist181861 Exp $ */
package edt.textui.section;

import edt.core.Section;
import edt.core.Document;
import ist.po.ui.Command;

/* FIXME: import core classes here */

/**
 * Superclass of all section-context commands.
 */
public abstract class SectionCommand extends Command<Section> {

	Document doc;

	public SectionCommand(String title, Section receiver, Document w) {
		super(title, receiver);
		doc = w;
		/* FIXME: initialize second receiver */
	}

}
