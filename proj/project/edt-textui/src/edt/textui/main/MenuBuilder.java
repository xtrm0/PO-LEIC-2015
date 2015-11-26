/** @version $Id: MenuBuilder.java,v 1.8 2015/11/26 03:44:16 ist181861 Exp $ */
package edt.textui.main;

import edt.core.DocumentEditor;
import edt.core.Document;
import ist.po.ui.Command;
import ist.po.ui.Menu;

public abstract class MenuBuilder {
  public static void menuFor(DocumentEditor w) {
    Menu menu = new Menu(MenuEntry.TITLE,
        new Command<?>[] { //
            new New(w), //1
            new Open(w), //2
            new Save(w), //3
            new ShowMetadata(w), //4
            new AddAuthor(w), //5
            new ShowIndex(w), //6
            new ShowTextElement(w), //7
            new Edit(w), //8
    });
    menu.open();
  }
}
