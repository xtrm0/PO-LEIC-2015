/** @version $Id: ShowContent.java,v 1.4 2015/10/18 02:07:21 ist181861 Exp $ */
package edt.textui.section;

import edt.core.Section;
import edt.core.Document;
import static ist.po.ui.Dialog.IO;
import ist.po.ui.DialogException;

import java.io.IOException;
import java.util.Iterator;

/* FIXME: import core classes here */

/**
 * §2.2.3.
 */
public class ShowContent extends SectionCommand {
	public ShowContent(Section s, Document w) {
		super(MenuEntry.SHOW_CONTENT, s, w);
	}

	@Override
	public final void execute() throws DialogException, IOException {
		Iterator<Section> it = _receiver.getPrefixIterator();
		while (it.hasNext()) {
			Section s = it.next();
			IO.println(Message.sectionIndexEntry(s.getId(), s.getTitle()));
			for (int j = 0; j < s.getParagraphsCount(); j++) {
				IO.println(s.getNthParagraph(j).getText());
			}
		}
	}
}
