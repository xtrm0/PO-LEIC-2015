package edt.core;

/*The ideia of this interface is to force everyvisitor to be reimplemented
in case the core gets a new type of element.
So when someone implements a class that is visitable, it gets added here*/
public interface ElementVisitor {
  public void visit(Paragraph r);
  public void visit(Section r);
  public void visit(Document r);
}
