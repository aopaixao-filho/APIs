package org.serratec.aula5.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<Map<String, Object>> handleCustomException(CustomException e) {
        Map<String, Object> errorDetails = new HashMap<>();
        errorDetails.put("status", e.getStatus());
        errorDetails.put("titulo", e.getTitulo());
        errorDetails.put("dataHora", e.getTimestamp().toString());
        errorDetails.put("mensagem", e.getMensagem());

        return ResponseEntity.status(org.springframework.http.HttpStatus.NOT_FOUND).body(errorDetails);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<Map<String, Object>> handleMethodNotSupported(HttpRequestMethodNotSupportedException e) {
        Map<String, Object> errorDetails = new HashMap<>();
        errorDetails.put("status", 405);
        errorDetails.put("titulo", "Método não permitido");
        errorDetails.put("dataHora", LocalDateTime.now().toString());
        errorDetails.put("mensagem", "Method '" + e.getMethod() + "' is not supported for this endpoint.");
        return ResponseEntity.status(405).body(errorDetails);
    }
}