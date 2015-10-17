/** @version $Id: RemoveParagraph.java,v 1.1 2015/10/05 16:00:37 david Exp $ */
package edt.textui.section;

import edt.core.Section;
import edt.core.DocumentWorker;
import static ist.po.ui.Dialog.IO;
import ist.po.ui.DialogException;

import java.io.IOException;

/* FIXME: import core classes here */

/**
 * §2.2.11.
 */
public class RemoveParagraph extends SectionCommand {
	public RemoveParagraph(Section s, DocumentWorker w) {
		super(MenuEntry.REMOVE_PARAGRAPH, s, w);
	}

	@Override
	public final void execute() throws DialogException, IOException {
      		/* FIXME: implement command */
	}

}
