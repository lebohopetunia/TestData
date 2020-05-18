package QaTestData.QaTestData;


import com.vaadin.annotations.Theme;
import com.vaadin.data.provider.DataProvider;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;


@SpringUI
@Theme("valo")

public class QaTestDataView extends UI {

    @Autowired
    private  QaTestDataAPI qaTestDataAPI;


    @Override
    protected void init(VaadinRequest vaadinRequest) {
        TextField name= new TextField("Enter Name");
        Button buttonClick= new Button("Click");

        buttonClick.addClickListener(clickEvent -> setGrid());

        VerticalLayout layout=new VerticalLayout(name,buttonClick);
        layout.setMargin(true);
        layout.setSpacing(true);
        setContent(layout);


    }
    void setGrid()
    {
        Grid<QaTestData> QComponents= new Grid<>();
        QComponents.addColumn(QaTestData::getEnvironment).setCaption("Environment");
        QComponents.addColumn(QaTestData::getFeatureTeam).setCaption("Feature Team");
        QComponents.addColumn(QaTestData::getScenario).setCaption("Scenario");
        QComponents.addColumn(QaTestData::getDataUsed).setCaption("Data Used");

    }





}
