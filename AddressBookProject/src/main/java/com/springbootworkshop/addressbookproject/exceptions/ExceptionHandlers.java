package com.springbootworkshop.addressbookproject.exceptions;

import com.springbootworkshop.addressbookproject.DTO.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionHandlers
{
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDTO> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exception){
        List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
        List<String> errMsg = errorList.stream().map(objectError -> objectError.getDefaultMessage()).collect(Collectors.toList());

        ResponseDTO responseDTO = new ResponseDTO("Exception While processing  REST  REquest",errMsg);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler({HttpMessageNotReadableException.class})
    protected ResponseEntity<ResponseDTO> handleHttpMessageNotReadable(HttpMessageNotReadableException ex)
    {
        String error = "Data Should not be NULL ";
        ResponseDTO response =new ResponseDTO("Invalid JSON request",error);

    return new ResponseEntity<ResponseDTO>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ContactException.class)
    public ResponseEntity<ResponseDTO> handleContactException(ContactException exception)
    {
        ResponseDTO responseDTO = new ResponseDTO("Exception While processing  REST  REquest",exception.getMessage());
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AddressException.class)
    public ResponseEntity<ResponseDTO> handleAddressException(AddressException exception)
    {
        ResponseDTO responseDTO = new ResponseDTO("Exception While processing  REST  REquest",exception.getMessage());
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
    }
}
