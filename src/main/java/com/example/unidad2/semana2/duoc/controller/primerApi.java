package com.example.unidad2.semana2.duoc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class primerApi {
    @GetMapping("/hola")
    public String holaMundo(){
        return "Hola mundo";
    }

    @GetMapping("/nombre")
    public String nombre(@RequestParam String name){
        return "Hola, "+name;
    }

    @GetMapping("/calculadora")
    public String calculadora(@RequestParam String tipo, @RequestParam Float A, @RequestParam float B) {
        float res;
        switch (tipo.toLowerCase()){
            case "suma":
                res = A+B;
                break;
            case "resta":
                res = A-B;
                break;
            case "multiplicacion":
                res = A*B;
                break;
            case "division":
                res = A/B;
                break;
            default:
                return "Operación no válida";
            
        }
        return "El resultado es: "+res;
    }
    
}
