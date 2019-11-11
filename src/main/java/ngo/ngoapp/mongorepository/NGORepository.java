package ngo.ngoapp.mongorepository;


import ngo.ngoapp.model.NGO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface NGORepository extends MongoRepository<NGO,String> {
    public NGO findByEmail(String email);


}
