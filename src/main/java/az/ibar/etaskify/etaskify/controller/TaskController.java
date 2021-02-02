package az.ibar.etaskify.etaskify.controller;

import az.ibar.etaskify.etaskify.dto.BaseResponse;
import az.ibar.etaskify.etaskify.dto.TaskDTO;
import az.ibar.etaskify.etaskify.dto.TaskUserDTO;
import az.ibar.etaskify.etaskify.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/tasks")
@AllArgsConstructor
public class TaskController {
    private TaskService taskService;

    @PostMapping(value = "/addtask")
    public BaseResponse addTask(@RequestBody TaskDTO taskDTO){
        return taskService.addTask(taskDTO);
    }

    @PostMapping(value = "/assignuser")
    public BaseResponse assignUser(@RequestBody TaskUserDTO taskUserDTO){
        return taskService.assignUser(taskUserDTO);
    }

//    @PostMapping(value = "/assigntask")
//    public BaseResponse assignTask(@RequestBody TaskUserDTO taskUserDTO){
//        return taskService.assignTask(taskUserDTO);
//    }




}
