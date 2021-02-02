package az.ibar.etaskify.etaskify.controller;


import az.ibar.etaskify.etaskify.dto.BaseResponse;
import az.ibar.etaskify.etaskify.dto.CustomerDTO;
import az.ibar.etaskify.etaskify.dto.TaskDTO;
import az.ibar.etaskify.etaskify.dto.UserDTO;
import az.ibar.etaskify.etaskify.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/customers")
@AllArgsConstructor
public class CustomerController {
    private CustomerService customerService;


    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public BaseResponse signUp(@RequestBody CustomerDTO customerDTO){
        return customerService.signUp(customerDTO);
    }

    @PostMapping(value = "/adduser/{id}")
    public BaseResponse addUser(@RequestBody UserDTO userDTO){
        return customerService.addUser(userDTO);
    }


}
