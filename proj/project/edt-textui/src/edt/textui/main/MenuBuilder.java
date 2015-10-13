/** @version $Id: MenuBuilder.java,v 1.1 2015/10/05 16:00:36 david Exp $ */
package edt.textui.main;

import ist.po.ui.Command;
import ist.po.ui.Menu;

/* FIXME: import core classes here */

public abstract class MenuBuilder {
  public static void menuFor(/* FIXME: decls of argument(s) for receiver(s) */) {
    Menu menu = new Menu(MenuEntry.TITLE,
        new Command<?>[] { //
            new New(/* FIXME: receiver(s) */), //
            new Open(/* FIXME: receiver(s) */), //
            new Save(/* FIXME: receiver(s) */), //
            new ShowMetadata(/* FIXME: receiver(s) */), //
            new ShowIndex(/* FIXME: receiver(s) */), //
            new ShowTextElement(/* FIXME: receiver(s) */), //
            new Edit(/* FIXME: receiver(s) */), //
    });
    menu.open();
  }
}
