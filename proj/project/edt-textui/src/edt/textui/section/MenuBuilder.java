/** @version $Id: MenuBuilder.java,v 1.5 2015/11/26 03:44:16 ist181861 Exp $ */
package edt.textui.section;

import edt.core.Section;
import edt.core.DocumentEditor;
import ist.po.ui.Command;
import ist.po.ui.Menu;

/**
 * Menu builder for search operations.
 */
public class MenuBuilder {
  public static void menuFor(Section s, DocumentEditor w) {
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
