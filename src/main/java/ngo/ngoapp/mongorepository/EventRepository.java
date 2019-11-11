package ngo.ngoapp.mongorepository;

import ngo.ngoapp.model.Donation;
import ngo.ngoapp.model.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EventRepository extends MongoRepository<Event,String> {

}
