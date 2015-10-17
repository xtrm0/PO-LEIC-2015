/** @version $Id: MenuBuilder.java,v 1.2 2015/10/15 07:40:55 ist13500 Exp $ */
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
            new AddAuthor(/* FIXME: receiver(s) */), //
            new ShowIndex(/* FIXME: receiver(s) */), //
            new ShowTextElement(/* FIXME: receiver(s) */), //
            new Edit(/* FIXME: receiver(s) */), //
    });
    menu.open();
  }
}
