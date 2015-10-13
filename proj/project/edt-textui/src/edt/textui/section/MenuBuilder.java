/** @version $Id: MenuBuilder.java,v 1.1 2015/10/05 16:00:37 david Exp $ */
package edt.textui.section;

import ist.po.ui.Command;
import ist.po.ui.Menu;

/* FIXME: import core classes here */

/**
 * Menu builder for search operations.
 */
public class MenuBuilder {
  public static void menuFor(/* FIXME: decls of argument(s) for receiver(s) */) {
    Menu menu = new Menu(MenuEntry.TITLE,
        new Command<?>[] { //
            new ChangeTitle(/* FIXME: receiver(s) */), //
            new ListSections(/* FIXME: receiver(s) */), //
            new ShowContent(/* FIXME: receiver(s) */), //
            new SelectSection(/* FIXME: receiver(s) */), //
            new InsertSection(/* FIXME: receiver(s) */), //
            new NameSection(/* FIXME: receiver(s) */), //
            new RemoveSection(/* FIXME: receiver(s) */), //
            new InsertParagraph(/* FIXME: receiver(s) */), //
            new NameParagraph(/* FIXME: receiver(s) */), //
            new EditParagraph(/* FIXME: receiver(s) */), //
            new RemoveParagraph(/* FIXME: receiver(s) */), //
    });
    menu.open();
  }
}
