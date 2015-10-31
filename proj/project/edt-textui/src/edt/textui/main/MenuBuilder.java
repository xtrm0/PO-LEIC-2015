/** @version $Id: MenuBuilder.java,v 1.6 2015/10/22 21:20:48 ist181861 Exp $ */
package edt.textui.main;

import edt.core.DocumentWorker;
import edt.core.Document;
import ist.po.ui.Command;
import ist.po.ui.Menu;

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
