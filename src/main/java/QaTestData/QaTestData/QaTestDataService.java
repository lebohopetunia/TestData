package QaTestData.QaTestData;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service

public class QaTestDataService {

        @Autowired
        private QaTestDataRepository qaTestDataRepository;
        List<QaTestData> qaTestData;





    public String Save(QaTestData qaTestData)
    {

        qaTestData.setDataUsed("N");
        qaTestData=qaTestDataRepository.save(qaTestData);

        return "saved";
    }

    public List<QaTestData> GetTestData()
    {
        JSONObject jsonObject= new JSONObject();
       qaTestData=qaTestDataRepository.findAll();
       //jsonObject.put("data",qaTestData);
        return qaTestData;
    }

    public JSONObject searchByEnvironmentAndFeature(String environment,String featureTeam)
    {
        JSONObject jsonObject=new JSONObject();

        qaTestData =qaTestDataRepository.findByEnvironmentAndFeatureTeam(environment,featureTeam);
        jsonObject.put("data",qaTestData);
        return jsonObject;
    }
    public String deleteByFeatureTeamAndEnvironment(String environment,String featureTeam)
    {
        qaTestDataRepository.delete(qaTestDataRepository.findByEnvironmentAndFeatureTeam(environment, featureTeam));

        return "deleted";
    }

    public String deleteByScenario(String scenario)
    {
              qaTestDataRepository.deleteByScenario(scenario);

             return "deleted";
    }
    public String deleteQaTestRecord(UUID id)
    {
        qaTestDataRepository.delete(id);
        return "deleted";
    }
    public QaTestData findByFeatureTeam(String featureTeam)
    {
        QaTestData qaTestData1=qaTestDataRepository.findByFeatureTeam(featureTeam);
        return qaTestData1;
    }

   public List<QaTestData> updateTestData(String environment, String featureTeam)
   {

       List<QaTestData> qaTestData1=qaTestDataRepository.save(qaTestDataRepository.findByEnvironmentAndFeatureTeam(environment, featureTeam));
       return qaTestData1;
   }










}
