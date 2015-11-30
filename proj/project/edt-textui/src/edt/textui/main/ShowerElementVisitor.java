package edt.textui.main;
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
import java.util.ArrayList;
import java.util.List;

public final class ShowerElementVisitor implements ElementVisitor {
  private List<String> ret = new ArrayList<String>();

  public void visit(Paragraph p) {
    if (p == null) return;
    ret.add(p.getText());
  }

  public void visit(Section s) {
    if (s == null) return;
    String currId = s.getId();
    ret.add(Message.sectionIndexEntry(currId != null ? currId : "", s.getTitle()));
    for (int j = 0; j < s.getParagraphsCount(); j++) {
      s.getNthParagraph(j).accept(this);
    }
    for (int j = 0; j < s.getSectionsCount(); j++) {
      s.getNthSection(j).accept(this);
    }
  }

  public void visit(Document d) {
    if (d == null) return;
    ret.add("{" + d.getTitle() + "}");
    for (int j = 0; j < d.getParagraphsCount(); j++) {
      d.getNthParagraph(j).accept(this);
    }
    for (int j = 0; j < d.getSectionsCount(); j++) {
      d.getNthSection(j).accept(this);
    }
  }

  public List<String> getReturn() {
    return ret;
  }
}
