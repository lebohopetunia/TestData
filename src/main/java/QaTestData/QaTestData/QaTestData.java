package QaTestData.QaTestData;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.util.UUID;

public class QaTestData {

    @Id

    UUID _id;
    String environment;
    Document document;
    String scenario;
    String featureTeam;
    String dataUsed;

    public QaTestData(UUID _id, String environment, Document document, String scenario, String featureTeam, String dataUsed) {

        this._id = UUID.randomUUID();
        this.environment = environment;
        this.document=document;
        this.scenario = scenario;
        this.featureTeam = featureTeam;
        this.dataUsed = "N";
    }

    public QaTestData() {
        _id = UUID.randomUUID();
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public String getScenario() {
        return scenario;
    }

    public void setScenario(String scenario) {
        this.scenario = scenario;
    }

    public String getFeatureTeam() {
        return featureTeam;
    }

    public void setFeatureTeam(String featureTeam) {
        this.featureTeam = featureTeam;
    }

    public String getDataUsed() {
        return dataUsed;
    }

    public void setDataUsed(String dataUsed) {
        this.dataUsed = dataUsed;
    }


    @Override
    public String toString() {
        return "QaTestData{" +
                "_id=" + _id +
                ", environment='" + environment + '\'' +
                ", scenario='" + scenario + '\'' +
                ", featureTeam='" + featureTeam + '\'' +
                ", dataUsed='" + dataUsed + '\'' +
                '}';
    }
}
