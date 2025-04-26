package admin.service;

import admin.dto.UserDTO;
import admin.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream().map(user -> {
            UserDTO dto = new UserDTO();
            dto.setUserId(user.getUserId());
            dto.setUserName(user.getUserName());
            dto.setAccessLevel(user.getAccessLevel());
            dto.setActive(user.getActive());
            dto.setLastLogonDate(user.getLastLogonDate());
            dto.setReportGrpId(user.getReportGrpId());
            return dto;
        }).collect(Collectors.toList());
    }
}
