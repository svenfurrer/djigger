/*******************************************************************************
 * (C) Copyright  2016 Jérôme Comte and others.
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 *  Contributors:
 *    - Jérôme Comte
 *******************************************************************************/
package io.djigger.ui;

import io.djigger.ui.analyzer.AnalyzerPane;

import java.awt.Component;

import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SessionGroupPane extends JTabbedPane implements ChangeListener {

	private final MainFrame main;

    public SessionGroupPane(MainFrame main) {
		super();
		this.main = main;
		addChangeListener(this);
	}

	public void addSession(Session session) {
        add(session.getName(), session);
    }
	
	public void selectSession(Session session) {
		if(getCurrentTab()!=session) {
			setSelectedComponent(session);
		}
	}
	
	public void removeSession(Session session) {
		remove(session);
	}

    public Session getCurrentTab() {
        Component _component = getSelectedComponent();
        if(_component instanceof Session) {
            return (Session) _component;
        }
        return null;
    }

	@Override
	public void stateChanged(ChangeEvent e) {
		main.selectSession(getCurrentTab());
	}
}