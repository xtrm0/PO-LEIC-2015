/** @version $Id: ShowTextElement.java,v 1.2 2015/10/17 19:58:54 ist181861 Exp $ */
package edt.textui.main;

import edt.core.Node;
import edt.core.Document;
import edt.core.Paragraph;
import edt.core.Section;
import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;

import java.util.Iterator;
import java.io.IOException;

/* FIXME: import core classes here */

/**
 * §2.1.5.
 */
public class ShowTextElement extends Command<Document> {
  public ShowTextElement(Document w) {
    super(MenuEntry.SHOW_TEXT_ELEMENT, w);
  }

  @Override
  public final void execute() throws DialogException, IOException {
    String id = IO.readString(Message.requestElementId());
    Node target = _receiver.getElementById(id);
    if (target == null) {
      //is this better than throw?
    } else if (target instanceof Section) {
      Iterator<Section> it = ((Section) target).getPrefixIterator();
      it.next();
      while(it.hasNext()) {
        Section s = it.next();
        IO.println(Message.sectionIndexEntry(s.getId(), s.getTitle()));
        for (int j=0; j<s.getParagraphsCount(); j++) {
          IO.println(s.getNthParagraph(j).getText());
        }
      }
    } else if (target instanceof Paragraph){
      IO.println(((Paragraph) target).getText());
    }
  }
}
