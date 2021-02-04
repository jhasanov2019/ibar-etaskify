package az.ibar.etaskify.etaskify.service;

import az.ibar.etaskify.etaskify.dto.BaseResponse;
import az.ibar.etaskify.etaskify.dto.TaskDTO;
import az.ibar.etaskify.etaskify.dto.TaskUserDTO;
import az.ibar.etaskify.etaskify.entity.TaskEntity;
import az.ibar.etaskify.etaskify.entity.UserEntity;
import az.ibar.etaskify.etaskify.enums.StatusCode;
import az.ibar.etaskify.etaskify.enums.TaskStatus;
import az.ibar.etaskify.etaskify.repository.TaskRepository;
import az.ibar.etaskify.etaskify.repository.UserRepository;
import az.ibar.etaskify.etaskify.util.EmailSender;
import lombok.AllArgsConstructor;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class TaskService {
    private TaskRepository taskRepository;
    private UserRepository userRepository;
    private JavaMailSender javaMailSender;

    public BaseResponse addTask(TaskDTO taskDTO) {
        BaseResponse br = new BaseResponse(StatusCode.SUCCESS);
        TaskEntity taskEntity = new TaskEntity();


        taskEntity.setTitle(taskDTO.getTitle());
        taskEntity.setDescription(taskDTO.getDescription());
        taskEntity.setDeadline(taskDTO.getDeadline());
        taskEntity.setStatus(taskDTO.getStatus());
        br.setData(taskRepository.save(taskEntity));

        return br;
    }

    @Transactional
    public BaseResponse assignUser(TaskUserDTO taskUserDTO) {
        BaseResponse br = new BaseResponse(StatusCode.SUCCESS);
        EmailSender emailSender = new EmailSender(javaMailSender);
        TaskEntity taskEntity = taskRepository.findById(taskUserDTO.getTaskId()).get();
        for (Long id : taskUserDTO.getUserId()){
            UserEntity userEntity = userRepository.findById(id).get();
            taskEntity.getUsers().add(userEntity);
            emailSender.sendMail(userEntity.getEmail(),taskEntity.getTitle(),taskEntity.getDescription());
        }
        br.setData(taskRepository.save(taskEntity));

        return br;
    }


}
