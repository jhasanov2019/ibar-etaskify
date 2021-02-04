package az.ibar.etaskify.etaskify.service;

import az.ibar.etaskify.etaskify.dto.BaseResponse;
import az.ibar.etaskify.etaskify.dto.SignInDTO;
import az.ibar.etaskify.etaskify.entity.UserEntity;
import az.ibar.etaskify.etaskify.enums.StatusCode;
import az.ibar.etaskify.etaskify.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;


    @Transactional
    public BaseResponse signIn(SignInDTO signInDTO) {
        BaseResponse br = new BaseResponse(StatusCode.SUCCESS);
        Optional<UserEntity>entity = userRepository.findByUserNameAndPassword(signInDTO.getUserName(),signInDTO.getPassword());
        if (entity.isPresent()){
            br.setData(entity.get());
        }else {
            br.setError("Username or password are incorrect...");
            br.setStatus(StatusCode.ERROR);
        }
        return br;
    }
}
