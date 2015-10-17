/** @version $Id: MenuBuilder.java,v 1.1 2015/10/05 16:00:37 david Exp $ */
package edt.textui.section;

import edt.core.Section;
import edt.core.DocumentWorker;
import ist.po.ui.Command;
import ist.po.ui.Menu;

/* FIXME: import core classes here */

/**
 * Menu builder for search operations.
 */
public class MenuBuilder {
  public static void menuFor(Section s, DocumentWorker w) {
    Menu menu = new Menu(MenuEntry.TITLE,
        new Command<?>[] { //
            new ChangeTitle(s, w), //
            new ListSections(s, w), //
            new ShowContent(s, w), //
            new SelectSection(s, w), //
            new InsertSection(s, w), //
            new NameSection(s, w), //
            new RemoveSection(s, w), //
            new InsertParagraph(s, w), //
            new NameParagraph(s, w), //
            new EditParagraph(s, w), //
            new RemoveParagraph(s, w), //
    });
    menu.open();
  }
}
