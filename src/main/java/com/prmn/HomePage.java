package com.prmn;

import com.prmn.bean.Report;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class HomePage extends WebPage {

	private static final long serialVersionUID = 1L;

	public HomePage(final PageParameters parameters) {
		super(parameters);

		// TODO Add your page's components here

		String studentNumber = "b2181930";    // xxxxの部分は自分の学籍番号
		IModel<String> studentNumberModel = Model.of(studentNumber);      // studentNumberのモデル
		Label studentNumberLabel = new Label("studentNumber", studentNumberModel);
		add(studentNumberLabel);

		String currentTime = LocalDateTime.now().toString();
		IModel<String> currentTimeModel = Model.of(currentTime);
		Label currentTimeLabel = new Label("currentTimeLabel", currentTimeModel);
		add(currentTimeLabel);


		add(new Link<Void>("updateCurrentTimeLink"){
			@Override
			public void onClick() {
				System.out.println("Link clicked.");
				currentTimeModel.setObject(LocalDateTime.now().toString());
				setResponsePage(FortunePage.class);
			}
		});

		List<Report> reports = new ArrayList<>();
		reports.add(new Report());
		reports.add(new Report());
		reports.add(new Report());
		IModel<List<Report>> reportsModel = Model.ofList(reports);
		ListView<Report> reportListView = new ListView<Report>("reportListView", reportsModel) {
			@Override
			protected void populateItem(ListItem<Report> listItem) {
				listItem.add(new Label("reportId", listItem.getModelObject().getId()));
				listItem.add(new Label("reportAuthorName", listItem.getModelObject().getAuthorName()));
				listItem.add(new Label("reportTitle", listItem.getModelObject().getTitle()));
				listItem.add(new Label("reportDetails", listItem.getModelObject().getDetails()));
				listItem.add(new Label("reportPostedAt", listItem.getModelObject().getPostedAt()));
			}
		};
		add(reportListView);

		String gakuseki = "1930";
		Form reportForm = new Form("reportForm");
		IModel<String> reportTitleModel = Model.of("");
		reportForm.add(new TextField<>("reportTitle", reportTitleModel));
		IModel<String> userPasswordModel = Model.of("");
		reportForm.add(new PasswordTextField("userPasswordTextField", userPasswordModel));
		reportForm.add(new Button("submitButton") {
			@Override
				public void onSubmit(){
				super.onSubmit();
				System.out.println("Form clicked.");
				System.out.println(reportTitleModel.getObject());

				if (reportTitleModel.getObject().equals(gakuseki) && userPasswordModel.getObject().equals(gakuseki)) {
					System.out.println("学籍");
				}
			}
		});
		add(reportForm);
	}

}
