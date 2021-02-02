package az.ibar.etaskify.etaskify.dto;

import az.ibar.etaskify.etaskify.enums.StatusCode;
import lombok.Data;

@Data
public class BaseResponse {
    public BaseResponse() {

    }

    public BaseResponse(StatusCode status) {
        this.status = status;
    }

    StatusCode status = StatusCode.SUCCESS;
    Object data;
    String error;
}
