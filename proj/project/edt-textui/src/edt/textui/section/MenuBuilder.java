/** @version $Id: MenuBuilder.java,v 1.6 2015/11/26 20:47:01 ist181861 Exp $ */
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
            new ChangeTitle(s, w), //1
            new ListSections(s, w), //2
            new ShowContent(s, w), //3
            new SelectSection(s, w), //4
            new InsertSection(s, w), //5
            new NameSection(s, w), //6
            new RemoveSection(s, w), //7
            new InsertParagraph(s, w), //8
            new NameParagraph(s, w), //9
            new EditParagraph(s, w), //10
            new RemoveParagraph(s, w), //11
    });
    menu.open();
  }
}
