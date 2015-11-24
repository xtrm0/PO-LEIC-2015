/** @version $Id: ShowTextElement.java,v 1.7 2015/11/24 00:15:04 ist181861 Exp $ */
package edt.textui.main;

import edt.core.Element;
import edt.core.Document;
import edt.core.DocumentWorker;
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
public class ShowTextElement extends Command<DocumentWorker> {
	public ShowTextElement(DocumentWorker w) {
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
		} else if (target instanceof Section) {
			Iterator<Section> it = ((Section) target).getPrefixIterator();
			while (it.hasNext()) {
				Section s = it.next();
				String currId = s.getId();
				IO.println(Message.sectionIndexEntry(currId != null ? currId : "", s.getTitle()));
				for (int j = 0; j < s.getParagraphsCount(); j++) {
					IO.println(s.getNthParagraph(j).getText());
				}
			}
		} else if (target instanceof Paragraph) {
			IO.println(((Paragraph) target).getText());
		} else {
			//MAYBE: Put something here
		}
	}
}
