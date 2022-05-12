package uz.pdp.task_2_6_1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uz.pdp.task_2_6_1.entity.User;
import uz.pdp.task_2_6_1.payload.ApiResponse;
import uz.pdp.task_2_6_1.payload.RegisterDto;
import uz.pdp.task_2_6_1.repository.UserRepository;

import java.util.Optional;

@Service
public class AuthService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
// ----this is for adding users
    public ApiResponse addUser(RegisterDto registerDto){
        boolean exists = userRepository.existsByEmail(registerDto.getEmail());
        if (exists){
            return new ApiResponse("email already exists",false);
        }
        User user = new User();
        user.setFirstName(registerDto.getFirstName());
        user.setLastName(registerDto.getLastName());
        user.setEmail(registerDto.getEmail());
        user.setPassword(registerDto.getPassword());
        userRepository.save(user);
        return new ApiResponse("user saved", true);
    }


//    ----this is for getting user
    public ApiResponse getUser(Integer id){
        Optional<User> optionalUser = userRepository.findById(id);
        if (!optionalUser.isPresent()){
            return new ApiResponse("User not found",false);
        }
        return new ApiResponse("Users list",true,optionalUser.get());
    }


//------this is for editing user information
    public ApiResponse editUser(Integer id,RegisterDto registerDto) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (!optionalUser.isPresent()){
            return new ApiResponse("user not found",false);
        }
        User user = optionalUser.get();
        user.setFirstName(registerDto.getFirstName());
        user.setLastName(registerDto.getLastName());
        user.setEmail(registerDto.getEmail());
        user.setPassword(registerDto.getPassword());
        userRepository.save(user);
        return new ApiResponse("user edited successfully",true);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
