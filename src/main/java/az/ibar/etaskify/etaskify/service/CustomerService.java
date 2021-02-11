package az.ibar.etaskify.etaskify.service;

import az.ibar.etaskify.etaskify.dto.BaseResponse;
import az.ibar.etaskify.etaskify.dto.CustomerDTO;
import az.ibar.etaskify.etaskify.dto.UserDTO;
import az.ibar.etaskify.etaskify.entity.CustomerEntity;
import az.ibar.etaskify.etaskify.entity.UserEntity;
import az.ibar.etaskify.etaskify.enums.StatusCode;
import az.ibar.etaskify.etaskify.repository.CustomerRepository;
import az.ibar.etaskify.etaskify.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerService {
    private CustomerRepository customerRepository;
    private UserRepository userRepository;


    public BaseResponse signUp(CustomerDTO customerDTO) {

        CustomerEntity customerEntity = new CustomerEntity();
        BaseResponse br = new BaseResponse(StatusCode.SUCCESS);

        customerEntity.setOrganizationName(customerDTO.getOrganizationName());
        customerEntity.setAddress(customerDTO.getAddress());
        customerEntity.setEmail(customerDTO.getEmail());
        customerEntity.setUserName(customerDTO.getUserName());
        customerEntity.setPassword(customerDTO.getPassword());
        customerEntity.setPhoneNumber(customerDTO.getPhoneNumber());

        br.setData(customerRepository.save(customerEntity));

        return br;

    }


    @Transactional
    public BaseResponse addUser(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        Optional<CustomerEntity> customerEntity = customerRepository.findById(userDTO.getCustomerId());
        BaseResponse br = new BaseResponse(StatusCode.SUCCESS);

        userEntity.setName(userDTO.getName());
        userEntity.setSurname(userDTO.getSurname());
        userEntity.setEmail(userDTO.getEmail());
        userEntity.setPassword(userDTO.getPassword());
        userEntity.setRole(userDTO.getRole());

        if (customerEntity.isPresent()){
           List<UserEntity> users =  customerEntity.get().getUsers();
           users.add(userRepository.save(userEntity));
           customerEntity.get().setUsers(users);
           br.setData(customerRepository.save(customerEntity.get()));
        }

        return br;
    }

}
