/** @version $Id: ShowIndex.java,v 1.1 2015/10/05 16:00:36 david Exp $ */
package edt.textui.main;

import edt.core.DocumentWorker;
import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;

import java.io.IOException;

/* FIXME: import core classes here */

/**
 * §2.1.4.
 */
public class ShowIndex extends Command<DocumentWorker> {
	public ShowIndex(DocumentWorker w) {
		super(MenuEntry.SHOW_INDEX, w);
	}

	@Override
	public final void execute() throws DialogException, IOException {
		/* FIXME: implement command */
	}
}
