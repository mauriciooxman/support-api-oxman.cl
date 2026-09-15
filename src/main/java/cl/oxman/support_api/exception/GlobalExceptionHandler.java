package cl.oxman.support_api.exception;


import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice //Esta clase puede manejar errores del controller
public class GlobalExceptionHandler  {

    @ExceptionHandler(TicketNotFoundException.class) //Cuando ocurra un TicketNotFound ejecuta este metodo
    public ResponseEntity<Map<String, Object>> handleTicketNotFound(
            TicketNotFoundException ex
    ) {
        Map<String, Object> error = new HashMap<>();
        error.put("timestamp", LocalDate.now());
        error.put("status", HttpStatus.NOT_FOUND.value());
        error.put("error" , "id mala");
        error.put("message", ex.getMessage());

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(error);



    }
}
