package org.sealife.skos.editor.views;

import org.protege.editor.owl.ui.framelist.OWLFrameList;
import org.protege.editor.owl.ui.framelist.OWLFrameListRenderer;
import org.protege.editor.owl.ui.view.individual.AbstractOWLIndividualViewComponent;
import org.sealife.skos.editor.frames.SKOSObjectPropertyAssertionsFrame;
import org.semanticweb.owlapi.model.OWLNamedIndividual;

import javax.swing.*;
import java.awt.*;
/*
 * Copyright (C) 2007, University of Manchester
 *
 * Modifications to the initial code base are copyright of their
 * respective authors, or their employers as appropriate.  Authorship
 * of the modifications may be determined from the ChangeLog placed at
 * the end of this file.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.

 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.

 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */

/**
 * Author: Simon Jupp<br>
 * The University Of Manchester<br>
 * Bio-Health Informatics Group<br>
 * Date: 30-Jan-2007<br><br>
 */
public class SKOSObjectPropertyAssertionsViewComponent extends AbstractOWLIndividualViewComponent {

    private OWLFrameList<OWLNamedIndividual> list;
    private SKOSObjectPropertyAssertionsFrame frame;

    public void initialiseIndividualsView() throws Exception {
        list = new OWLFrameList<OWLNamedIndividual>(getOWLEditorKit(),
                                                frame = new SKOSObjectPropertyAssertionsFrame(getOWLEditorKit()));
        setLayout(new BorderLayout());
        add(new JScrollPane(list));
        OWLFrameListRenderer renderer = new OWLFrameListRenderer(getOWLEditorKit());
        renderer.setHighlightKeywords(false);
        list.setCellRenderer(renderer);
    }


    public void disposeView() {
        list.dispose();
        frame.dispose();
    }


    public OWLNamedIndividual updateView(OWLNamedIndividual selectedIndividual) {
        list.setRootObject(selectedIndividual);
        return selectedIndividual;
    }
}
