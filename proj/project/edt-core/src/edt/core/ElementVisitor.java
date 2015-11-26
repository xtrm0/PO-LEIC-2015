package edt.core;

public interface ElementVisitor {
  public void visit(Paragraph r);
  public void visit(Section r);
  public void visit(Document r);
}
