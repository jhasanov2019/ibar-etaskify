package az.ibar.etaskify.etaskify;


import az.ibar.etaskify.etaskify.dto.BaseResponse;
import az.ibar.etaskify.etaskify.dto.SignInDTO;
import az.ibar.etaskify.etaskify.enums.StatusCode;
import az.ibar.etaskify.etaskify.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    UserService us;

    @Test
    public void testSignIn(){
        SignInDTO signInDTO = new SignInDTO();
        signInDTO.setUserName("Jalil");
        signInDTO.setPassword("AAAAA");

        BaseResponse br = us.signIn(signInDTO);
        assertThat(br.getStatus()).isEqualTo(StatusCode.SUCCESS);

    }
}
