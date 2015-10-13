/** @version $Id: Save.java,v 1.1 2015/10/05 16:00:36 david Exp $ */
package edt.textui.main;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;

import java.io.IOException;

/* FIXME: import core classes here */

/**
 * Save to file under current name (if unnamed, query for name).
 */
public class Save extends Command</* FIXME: core class */> {
	public Save(/* FIXME: decls of argument(s) for receiver(s) */) {
		super(MenuEntry.SAVE, /* FIXME: receiver(s) */);
	}

	@Override
	public final void execute() throws DialogException, IOException {
		/* FIXME: implement command */
	}
}
