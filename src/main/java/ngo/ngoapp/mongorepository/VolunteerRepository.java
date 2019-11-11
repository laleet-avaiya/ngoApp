package ngo.ngoapp.mongorepository;


import ngo.ngoapp.model.Admin;
import ngo.ngoapp.model.Volunteer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VolunteerRepository extends MongoRepository<Volunteer,String> {

}
