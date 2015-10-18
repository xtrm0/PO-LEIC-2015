/** @version $Id: MenuBuilder.java,v 1.3 2015/10/17 19:58:54 ist181861 Exp $ */
package edt.textui.main;

import edt.core.Document;
import ist.po.ui.Command;
import ist.po.ui.Menu;

/* FIXME: import core classes here */

public abstract class MenuBuilder {
  public static void menuFor(Document w) {
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
