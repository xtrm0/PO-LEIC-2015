/** @version $Id: MenuBuilder.java,v 1.2 2015/10/15 07:40:55 ist13500 Exp $ */
package edt.textui.main;

import edt.core.DocumentWorker;
import ist.po.ui.Command;
import ist.po.ui.Menu;

/* FIXME: import core classes here */

public abstract class MenuBuilder {
  public static void menuFor(DocumentWorker w) {
    Menu menu = new Menu(MenuEntry.TITLE,
        new Command<?>[] { //
            new New(w), //
            new Open(w), //
            new Save(w), //
            new ShowMetadata(w), //
            new AddAuthor(w), //
            new ShowIndex(w), //
            new ShowTextElement(w), //
            new Edit(w), //
    });
    menu.open();
  }
}
