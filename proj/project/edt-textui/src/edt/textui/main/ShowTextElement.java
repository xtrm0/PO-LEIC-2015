/** @version $Id: ShowTextElement.java,v 1.10 2015/11/30 23:17:08 ist181861 Exp $ */
package edt.textui.main;

import edt.core.Element;
import edt.core.Document;
import edt.core.DocumentEditor;
import edt.core.Paragraph;
import edt.core.Section;
import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;

import java.util.Iterator;
import java.io.IOException;

/**
 * §2.1.5.
 */
public class ShowTextElement extends Command<DocumentEditor> {
	public ShowTextElement(DocumentEditor w) {
		super(MenuEntry.SHOW_TEXT_ELEMENT, w);
	}

	@Override
	public final void execute() throws DialogException, IOException {
		Document recvDoc = _receiver.getCurrentDocument();
		String id = IO.readString(Message.requestElementId());
		Element target = recvDoc.getElementById(id);
		if (target == null) {
			IO.println(Message.noSuchTextElement(id));
			return;
		} else {
			ShowerElementVisitor vis = new ShowerElementVisitor();
			target.accept(vis);
			for (String s: vis.getReturn()) {
				IO.println(s);
			}
		}
	}
}
