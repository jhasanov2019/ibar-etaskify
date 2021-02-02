package az.ibar.etaskify.etaskify.dto;


import lombok.Data;

import java.util.List;

@Data
public class TaskUserDTO {

    private List<Long> userId;
    private Long taskId;

}
