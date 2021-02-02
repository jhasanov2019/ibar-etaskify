package az.ibar.etaskify.etaskify.dto;

import az.ibar.etaskify.etaskify.enums.TaskStatus;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class TaskDTO {

    private String title;
    private String description;
    private LocalDateTime deadline;
    private TaskStatus status;
    private Long id;

}
