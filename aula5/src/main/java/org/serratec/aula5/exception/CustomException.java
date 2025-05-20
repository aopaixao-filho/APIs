package org.serratec.aula5.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomException extends RuntimeException{

    private final String status;
    private final Object titulo;
    private final LocalDateTime timestamp;
    private final String mensagem;

    public CustomException(String status, Object titulo, LocalDateTime timestamp, String mensagem) {
        this.status = status;
        this.titulo = titulo;
        this.timestamp = timestamp;
        this.mensagem = mensagem;
    }

    public String getStatus() {
        return status;
    }

    public Object getTitulo() {
        return titulo;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getMensagem() {
        return mensagem;
    }

}
