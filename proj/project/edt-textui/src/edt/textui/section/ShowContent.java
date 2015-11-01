/** @version $Id: ShowContent.java,v 1.4 2015/10/18 02:07:21 ist181861 Exp $ */
package edt.textui.section;

import edt.core.Section;
import edt.core.DocumentWorker;
import static ist.po.ui.Dialog.IO;
import ist.po.ui.DialogException;

import java.io.IOException;
import java.util.Iterator;

/**
 * §2.2.3.
 */
public class ShowContent extends SectionCommand {
	public ShowContent(Section s, DocumentWorker w) {
		super(MenuEntry.SHOW_CONTENT, s, w);
	}

	@Override
	public final void execute() throws DialogException, IOException {
		Iterator<Section> it = _receiver.getPrefixIterator();
		while (it.hasNext()) {
			Section s = it.next();
			String currId = s.getId();
			IO.println(Message.sectionIndexEntry(currId != null ? currId : "", s.getTitle()));
			for (int j = 0; j < s.getParagraphsCount(); j++) {
				IO.println(s.getNthParagraph(j).getText());
			}
		}
	}
}
