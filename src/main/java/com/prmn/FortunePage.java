package com.prmn;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import java.time.LocalDateTime;

public class FortunePage extends WebPage {

    private static final long serialVersionUID = 1L;

    public FortunePage(final PageParameters parameters) {
        super(parameters);

        add(new Link<Void>("toFortunePage") {
            @Override
            public void onClick() {
                setResponsePage(HomePage.class);
            }
        });
    }

}
