package com.kosal.my_upload_video_authority.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {
	@ExceptionHandler(ApiException.class)
	public ResponseEntity<?>handleApiException(ApiException e){
		ErrorResponse response=new ErrorResponse(e.getStatus(),e.getMessage());
		return ResponseEntity
				.status(e.getStatus())
				.body(response);
	}
	

}
