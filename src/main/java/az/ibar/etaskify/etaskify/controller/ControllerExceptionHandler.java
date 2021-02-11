package az.ibar.etaskify.etaskify.controller;



import az.ibar.etaskify.etaskify.dto.BaseResponse;
import az.ibar.etaskify.etaskify.enums.StatusCode;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<BaseResponse> exceptions(Throwable e) {
        return new ResponseEntity<>(setMessage(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler({Exception.class})
    public ResponseEntity<BaseResponse> applicationException(ClassNotFoundException e){
        return new ResponseEntity<> (setMessage (e.getMessage ()), HttpStatus.NOT_FOUND);
    }




    private BaseResponse setMessage(String message) {
        BaseResponse baseResponse = new BaseResponse(StatusCode.ERROR);
        baseResponse.setError(message);
        return baseResponse;
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        BindingResult bindingResult = ex.getBindingResult();
        BaseResponse baseResponse = new BaseResponse(StatusCode.ERROR);
        if (bindingResult.getGlobalError() != null) {
            baseResponse.setError(bindingResult.getGlobalError().getDefaultMessage());
        } else if (bindingResult.getFieldError() != null) {
            baseResponse.setError(bindingResult.getFieldError().getDefaultMessage());
        }
        return new ResponseEntity<>(
                baseResponse,
                HttpStatus.BAD_REQUEST
        );
    }

}
