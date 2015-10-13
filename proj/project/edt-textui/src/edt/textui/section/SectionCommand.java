/** @version $Id: SectionCommand.java,v 1.1 2015/10/05 16:00:37 david Exp $ */
package edt.textui.section;

import ist.po.ui.Command;

/* FIXME: import core classes here */

/**
 * Superclass of all section-context commands.
 */
public abstract class SectionCommand extends Command</* FIXME: core class for section-context (main receiver) */> {
  
  /* FIXME: put here the declaration of the second receiver: the document-context one */
  
	public SectionCommand(String title, /* FIXME: decls of argument(s) for receiver(s) */) {
		super(title, receiver);
		/* FIXME: initialize second receiver */
	}

}
