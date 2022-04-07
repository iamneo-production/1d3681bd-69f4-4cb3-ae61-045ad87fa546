package exception;
import java.sql.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalException {

	 public ResponseEntity<ErrorDetail> resourceNotFound(ResourceNotFound ex,WebRequest req){
		 ErrorDetail error=new ErrorDetail(ex.getMessage(),"605",new Date(10));
		 return new ResponseEntity<ErrorDetail>(error,HttpStatus.NOT_FOUND);
	 }
}
