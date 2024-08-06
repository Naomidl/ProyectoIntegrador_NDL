package Ada_School.Proyecto_Integrador.repository;



import Ada_School.Proyecto_Integrador.entity.UserMongoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserMongoRepository extends MongoRepository<UserMongoEntity, String> {

    Optional<UserMongoEntity> findByEmail(String email);


}