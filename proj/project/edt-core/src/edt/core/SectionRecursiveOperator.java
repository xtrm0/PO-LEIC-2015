package edt.core;

/*
 * SectRecurOp -> Section Recursive Operator
 */
public interface SectionRecursiveOperator {
	public void execute(Section s);
	public void executePostCall(Section s);
}
