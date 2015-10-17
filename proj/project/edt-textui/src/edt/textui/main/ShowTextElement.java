/** @version $Id: ShowTextElement.java,v 1.1 2015/10/05 16:00:36 david Exp $ */
package edt.textui.main;

import edt.core.DocumentWorker;
import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;

import java.io.IOException;

/* FIXME: import core classes here */

/**
 * §2.1.5.
 */
public class ShowTextElement extends Command<DocumentWorker> {
  public ShowTextElement(DocumentWorker w) {
    super(MenuEntry.SHOW_TEXT_ELEMENT, w);
  }

  @Override
  public final void execute() throws DialogException, IOException {
    /* FIXME: implement command */
  }
}
