package QaTestData.QaTestData;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/qatestdata")
public class QaTestDataAPI   {



    @Autowired
    public QaTestDataService service;


    JSONObject qaTestData;

    @RequestMapping(path = "/save",
            method = RequestMethod.POST,
            consumes = "application/json",
            produces = "application/json")
    @ResponseBody
    public String Save (@RequestBody QaTestData qaTestData)
    {

        JSONObject  jsonObject=new JSONObject();
        jsonObject.put("data",service.Save(qaTestData));
        return "saved";
    }

    @RequestMapping(path = "/list",
            method = RequestMethod.GET,
            consumes ="application/json",
            produces ="application/json")
    @ResponseBody
    public List<QaTestData> getQaTestData()
    {
        JSONObject jsonObject=new JSONObject();
      // qaTestData =service.GetTestData();
       //jsonObject.put("data",service.GetTestData());
        return service.GetTestData();
    }

    @RequestMapping(path = "/ef",method = RequestMethod.GET,consumes = "application/json",produces = "application/json")
    @ResponseBody
    public  String  getbyEnvironmentAndFeatureTeam(@RequestBody String JSONMessage)
    {

        JSONObject jsonObject = new JSONObject(JSONMessage);
        String environment= jsonObject.getString("environment");
        String featureTeam= jsonObject.getString("featureTeam");


        qaTestData=service.searchByEnvironmentAndFeature(environment, featureTeam);
        JSONObject result=new JSONObject();
        result.put("data",qaTestData);

        return result.toString();
    }
    @RequestMapping(path = "/delete",method = RequestMethod.DELETE,consumes = "application/json",produces = "application/json")
    @ResponseBody
    public String deleteByFeatureTeamAndEnvironment(@RequestBody String JSONMessage)
    {
        JSONObject jsonObject=new JSONObject(JSONMessage);
        String environment = jsonObject.getString("environment");
        String featureTeam=jsonObject.getString("featureTeam");
        service.deleteByFeatureTeamAndEnvironment(environment, featureTeam);
        return "deleted";
    }


    @RequestMapping(path = "/update",
            method = RequestMethod.POST,
            consumes = "application/json",
            produces = "application/json")
    @ResponseBody
    public List<QaTestData> updateByEeatureTeamQaTestRecord(String environment,String featureTeam) {

       // JSONObject jsonObject=new JSONObject(JSONText);


        //JSONObject result = new JSONObject();
       // result.put("data",  service.updateTestData(environment, featureTeam));
       List<QaTestData> qaTestData= service.updateTestData(environment, featureTeam);
         return qaTestData;
    }
    @RequestMapping(path = "/find",
            method = RequestMethod.GET,

            consumes = "application/json",
            produces = "application/json")
    @ResponseBody
    public String findByF ( String featureTeam)
    {
//        JSONObject jsonObject=new JSONObject(JSONText);
//        String featureTeam=jsonObject.getString("featureTeam");
//        JSONObject result=new JSONObject();

        QaTestData qaTestData= service.findByFeatureTeam(featureTeam);
        return qaTestData.toString();

    }







}
