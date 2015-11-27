package edt.textui.section;
import edt.core.Element;
import edt.core.Document;
import edt.core.DocumentEditor;
import edt.core.Paragraph;
import edt.core.Section;
import edt.core.ElementVisitor;
import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;

import java.util.Iterator;
import java.io.IOException;

public class ShowerSectionVisitor implements ElementVisitor {
  public void visit(Paragraph p){;}
  public void visit(Document d) {
    visit((Section) d);
  }
  public void visit(Section s) {
    if (s == null) return;
    for (int j = 0; j < s.getSectionsCount(); j++) {
      Section target = s.getNthSection(j);
      String currId = target.getId();
      IO.println(Message.sectionIndexEntry(currId != null ? currId : "", target.getTitle()));
      target.accept(this);
    }
  }
}
