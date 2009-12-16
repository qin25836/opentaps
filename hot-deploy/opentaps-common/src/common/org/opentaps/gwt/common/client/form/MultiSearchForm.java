/*
 * Copyright (c) 2009 Open Source Strategies, Inc.
 *
 * Opentaps is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Affero General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Opentaps is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with Opentaps.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.opentaps.gwt.common.client.form;

import java.util.ArrayList;
import java.util.List;

import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.Window;
import com.gwtext.client.widgets.form.TextField;
import com.gwtext.client.widgets.layout.HorizontalLayout;
import com.gwtext.client.widgets.layout.RowLayout;
import org.opentaps.gwt.common.client.UtilUi;
import org.opentaps.gwt.common.client.form.base.BaseFormPanel;
import org.opentaps.gwt.common.client.listviews.EntityListView;
import org.opentaps.gwt.common.client.listviews.SearchResultsListViewInterface;
import org.opentaps.gwt.common.client.lookup.configuration.SearchLookupConfiguration;

/**
 * A generic search form.
 * This contains a simple text input and a searchhbutton.
 * Results are presented in a popup window with one result grid by search type.
 */
public class MultiSearchForm extends BaseFormPanel {

    private final Window win;
    private final TextField searchInput;
    private List<SearchResultsListViewInterface> resultGrids = new ArrayList<SearchResultsListViewInterface>();

    private static final int RESULT_HEIGHT = 700;
    private static final int RESULT_WIDTH = 900;

    /**
     * Default constructor.
     */
    public MultiSearchForm() {
        super();
        setBorder(false);
        setHideLabels(true);

        // using an inner panel to customize the layout
        Panel innerPanel = new Panel();
        innerPanel.setBorder(false);
        innerPanel.setLayout(new HorizontalLayout(5));

        searchInput = new TextField();
        searchInput.setName(SearchLookupConfiguration.IN_QUERY);
        searchInput.setWidth(200);  // width of search input box
        setFieldListeners(searchInput);
        innerPanel.add(searchInput);

        Button submitButton = makeStandardSubmitButton(UtilUi.MSG.search());
        innerPanel.add(submitButton);

        add(innerPanel);

        win = new Window(UtilUi.MSG.searchResults());
        win.setModal(false);
        win.setResizable(true);
        win.setMinHeight(RESULT_HEIGHT);
        win.setWidth(RESULT_WIDTH);
        win.setLayout(new RowLayout());
        win.setCloseAction(Window.HIDE);
    }

    public <T extends EntityListView & SearchResultsListViewInterface> void addResultsGrid(T grid) {
        resultGrids.add(grid);
        grid.setFrame(false);
        grid.setAutoHeight(false);
        grid.setBorder(false);
        grid.setWidth(RESULT_WIDTH);
        win.add(grid);
    }

    @Override public void submit() {
        search();
    }

    private void search() {
        int ph = com.google.gwt.user.client.Window.getClientHeight();
        int pw = com.google.gwt.user.client.Window.getClientWidth();

        int h = win.getHeight();
        if (h < RESULT_HEIGHT) {
            h = RESULT_HEIGHT;
        }
        // make sure the window is not bigger than the page
        // because the popup does not have scrollbars
        if (h > ph) {
            h = ph - 50;
        }
        win.setHeight(h);

        int w = win.getWidth();
        if (w < RESULT_WIDTH) {
            w = RESULT_WIDTH;
        }
        // make sure the window is not bigger than the page
        // because the popup does not have scrollbars
        if (w > pw) {
            w = pw - 50;
        }
        win.setWidth(w);

        win.show();
        win.center();
        for (SearchResultsListViewInterface grid : resultGrids) {
            grid.search(searchInput.getText());
        }
    }

}
