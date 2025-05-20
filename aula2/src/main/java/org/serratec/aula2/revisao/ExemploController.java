package org.serratec.aula2.revisao;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ExemploController {

    @GetMapping
    public String teste(@RequestParam String nome) {
        return nome.toUpperCase();
    }

    @GetMapping("/teste2")
    public int teste2(@RequestParam int numero, @RequestParam int numero2) {
        return numero * numero2;
    }
    
    @GetMapping("/teste")
    public String teste2() {
        return "Spring2";
    }
}