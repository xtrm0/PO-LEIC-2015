package edt.core;

public interface SectionOperator {
  /*Executa uma operacao quando entra num novo nivel da recursao*/
  public void onCall(Section s);
  /*Executa uma operacao antes de fazer return do nivel da recursao*/
  public void onRet(Section s);
}
