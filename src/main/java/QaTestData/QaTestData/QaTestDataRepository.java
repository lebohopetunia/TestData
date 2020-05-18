package QaTestData.QaTestData;

import org.bson.Document;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface QaTestDataRepository extends MongoRepository<QaTestData, UUID> {


    @Query(value = "{environment: ?0,featureTeam:?1}")
    public List<QaTestData> findByEnvironmentAndFeatureTeam(String environment, String featureTeam);
    @Query(value = "{scenario:?0}")
    public QaTestData deleteByScenario(String scenario);


    @Query(value = "{featureTeam:?0}")
    public QaTestData findByFeatureTeam(String featureTeam);
}
