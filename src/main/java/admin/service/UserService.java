package admin.service;

import admin.dto.UserDTO;
import admin.model.User;
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
        return userRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<UserDTO> getUsersByFdrid(String fdrid) {
        List<User> users = userRepository.findByFdrid(fdrid);
        return users.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private UserDTO convertToDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setUserId(user.getUserId());
        dto.setUserName(user.getUserName());
        dto.setCurrentPassword(user.getCurrentPassword());
        dto.setAccessLevel(user.getAccessLevel());
        dto.setFdrid(user.getFdrid());
        dto.setFdrpwd(user.getFdrpwd());
        dto.setFdrpwdexp(user.getFdrpwdexp());
        dto.setActive(user.getActive());
        dto.setOperatorCD(user.getOperatorCD());
        dto.setLastLogonDate(user.getLastLogonDate());
        dto.setReportGrpId(user.getReportGrpId());
        dto.setPassword(user.getPassword());
        dto.setPassword2(user.getPassword2());
        dto.setPassword3(user.getPassword3());
        dto.setPassword4(user.getPassword4());
        dto.setPassword5(user.getPassword5());
        dto.setPassword6(user.getPassword6());
        dto.setPassword7(user.getPassword7());
        dto.setPassword8(user.getPassword8());
        dto.setPassword9(user.getPassword9());
        dto.setPassword10(user.getPassword10());
        dto.setPassword11(user.getPassword11());
        dto.setPassword12(user.getPassword12());
        dto.setPassword13(user.getPassword13());
        dto.setPassword14(user.getPassword14());
        dto.setPassword15(user.getPassword15());
        dto.setPassword16(user.getPassword16());
        dto.setPassword17(user.getPassword17());
        dto.setPassword18(user.getPassword18());
        dto.setPassword19(user.getPassword19());
        dto.setPassword20(user.getPassword20());
        dto.setTimedPassword(user.getTimedPassword());
        dto.setLogedIn(user.getLogedIn());
        return dto;
    }
}
