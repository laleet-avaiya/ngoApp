package ngo.ngoapp.mongorepository;

import ngo.ngoapp.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PostRepository extends MongoRepository<Post,String> {

}
