package Ada_School.Proyecto_Integrador.service;

import Ada_School.Proyecto_Integrador.dto.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserDto save(UserDto user);
    Optional<UserDto> findById(String id);
    List<UserDto> all();
    void deleteById(String id);
    UserDto update(UserDto user, String userId);
}
