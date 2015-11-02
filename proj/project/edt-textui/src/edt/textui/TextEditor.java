/** @version $Id: TextEditor.java,v 1.7 2015/11/01 23:02:59 ist181861 Exp $ */
package edt.textui;

import static ist.po.ui.Dialog.IO;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.nio.charset.Charset;

import edt.core.Document;
import edt.core.DocumentWorker;

/**
 * Class that starts the application's textual interface.
 */
public class TextEditor {
	public static void main(String[] args) {
		DocumentWorker mainWorker = new DocumentWorker();

		String datafile = System.getProperty("import"); //$NON-NLS-1$
		if (datafile != null) {
			/* FIXME: tell core object(s) to import data into core */
			try {
				Document doc = mainWorker.getCurrentDocument();
				String tmp;
				InputStream fis = new FileInputStream(datafile);
    		InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
    		BufferedReader br = new BufferedReader(isr);
				tmp = br.readLine();
				doc.setTitle(tmp);
				//FIXME: Nao percebo como o ficheiro esta definido :S.
				while ((tmp = br.readLine()) != null) {

				}
			} catch (Exception e) {
			 	//MAYBE: nao faz nada, mas o ficheiro nao foi lido como deve de ser. O que fazer?
				mainWorker.newDocument();

			}
		}
		try {
			mainWorker.getCurrentDocument().addAuthor(null, null);
		}	catch (Exception e) {
			System.out.println("EXception caught!!!");
		}

		edt.textui.main.MenuBuilder.menuFor(mainWorker);
		IO.closeDown();
	}
}
