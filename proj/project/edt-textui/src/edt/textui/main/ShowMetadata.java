/** @version $Id: ShowMetadata.java,v 1.1 2015/10/05 16:00:36 david Exp $ */
package edt.textui.main;

import edt.core.DocumentWorker;
import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;

import java.io.IOException;

/* FIXME: import core classes here */

/**
 * §2.1.2.
 */
public class ShowMetadata extends Command<DocumentWorker> {
	public ShowMetadata(DocumentWorker w) {
		super(MenuEntry.SHOW_METADATA, w);
	}

	@Override
	public final void execute() throws DialogException, IOException {
		/* FIXME: implement command */
	}

}
