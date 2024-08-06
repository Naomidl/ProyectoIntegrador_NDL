package Ada_School.Proyecto_Integrador.service;



import Ada_School.Proyecto_Integrador.dto.UserDto;
import Ada_School.Proyecto_Integrador.entity.UserMongoEntity;
import Ada_School.Proyecto_Integrador.exception.UserNotFoundException;
import Ada_School.Proyecto_Integrador.repository.UserMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UsersServiceMap implements UsersService {

    @Autowired
    private UserMongoRepository userMongoRepository;

    @Override
    public List<UserDto> all() {
        return this.userMongoRepository.findAll().stream()
                .map(this::toDto)
                .toList();
    }

    @Override
    public Optional<UserDto> findById(String id) {
        UserMongoEntity entity = this.userMongoRepository.findById(id)
                .orElseThrow(() -> new com.example.integrador.exception.UserNotFoundException(id));
        return Optional.of(toDto(entity));
    }

    @Override
    public UserDto save(UserDto user) {
        UserMongoEntity entity = new UserMongoEntity();
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        UserMongoEntity entitySaved = this.userMongoRepository.save(entity);
        return this.toDto(entitySaved);
    }

    @Override
    public UserDto update(UserDto user, String id) {
        UserMongoEntity entity = this.userMongoRepository.findById(id)
                .orElseThrow(() -> new com.example.integrador.exception.UserNotFoundException(id));
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        UserMongoEntity entitySaved = this.userMongoRepository.save(entity);
        return this.toDto(entitySaved);
    }

    @Override
    public void deleteById(String id) {
        UserMongoEntity entity = this.userMongoRepository.findById(id)
                .orElseThrow(() -> new com.example.integrador.exception.UserNotFoundException(id));
        this.userMongoRepository.delete(entity);
    }

    private UserDto toDto(UserMongoEntity entity) {
        return new UserDto(entity.getId(), entity.getName(), entity.getEmail());
    }
}

