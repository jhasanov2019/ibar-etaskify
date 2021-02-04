package az.ibar.etaskify.etaskify;


import az.ibar.etaskify.etaskify.dto.BaseResponse;
import az.ibar.etaskify.etaskify.dto.TaskDTO;
import az.ibar.etaskify.etaskify.enums.StatusCode;
import az.ibar.etaskify.etaskify.enums.TaskStatus;
import az.ibar.etaskify.etaskify.service.CustomerService;
import az.ibar.etaskify.etaskify.service.TaskService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;


import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskServiceTest {
    @Autowired
    TaskService ts;

    @Test
    public void testAddTask(){
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setStatus(TaskStatus.DONE);
        taskDTO.setDeadline(LocalDateTime.now());
        taskDTO.setDescription("desc");
        taskDTO.setTitle("title");

        BaseResponse br = ts.addTask(taskDTO);
        assertThat(br.getStatus()).isEqualTo(StatusCode.SUCCESS);
    }

}
