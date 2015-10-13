/** @version $Id: SelectSection.java,v 1.1 2015/10/05 16:00:37 david Exp $ */
package edt.textui.section;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.DialogException;

import java.io.IOException;

/* FIXME: import core classes here */

/**
 * §2.2.4.
 */
public class SelectSection extends SectionCommand {
	public SelectSection(/* FIXME: decls of argument(s) for receiver(s) */) {
		super(MenuEntry.SELECT_SECTION, /* FIXME: receiver(s) */);
	}

	@Override
	public final void execute() throws DialogException, IOException  {
	 	/* FIXME: implement command */
		edt.textui.section.MenuBuilder.menuFor(/* FIXME: receiver(s) */);
	}
}
