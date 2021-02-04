package az.ibar.etaskify.etaskify;


import az.ibar.etaskify.etaskify.dto.BaseResponse;
import az.ibar.etaskify.etaskify.dto.CustomerDTO;
import az.ibar.etaskify.etaskify.dto.UserDTO;
import az.ibar.etaskify.etaskify.enums.StatusCode;
import az.ibar.etaskify.etaskify.enums.UserRole;
import az.ibar.etaskify.etaskify.service.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;




@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest {
    @Autowired
    CustomerService customerService;

    @Test
    public void testSignUp(){
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setAddress("JKhandan42");
        customerDTO.setEmail("jhasanov2019@gmail.com");
        customerDTO.setPassword("j2019");
        customerDTO.setUserName("Jalil");
        customerDTO.setOrganizationName("XXXX");
        customerDTO.setPhoneNumber("+994556935092");

        BaseResponse br = customerService.signUp(customerDTO);
        assertThat(br.getStatus()).isEqualTo(StatusCode.SUCCESS);
    }

    @Test
    public void testAddUser(){
        UserDTO userDTO = new UserDTO();
        userDTO.setCustomerId(1L);
        userDTO.setEmail("jhasanov2019@gmail.com");
        userDTO.setName("Jalil");
        userDTO.setPassword("pwd2019");
        userDTO.setSurname("Hasanov");

        BaseResponse br = customerService.addUser(userDTO);
        assertThat(br.getStatus()).isEqualTo(StatusCode.SUCCESS);
    }

}
