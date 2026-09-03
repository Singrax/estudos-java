package com.ronron.catcafe.controllers;

import com.ronron.catcafe.entities.Cat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController // Avisa o Spring: "Essa classe responde requisições da web!"
public class CatController {

    @GetMapping("/gatos") // Avisa o Spring: "Se alguém digitar /gatos no navegador, rode essa função"
    public List<Cat> listarGatos() {

        List<Cat> residentCats = new ArrayList<>();
        residentCats.add(new Cat("Frajola", "Ama dormir no sol e odeia carinho na barriga.", 4));
        residentCats.add(new Cat("Luna", "A mais agitada da casa, caça qualquer laser.", 2));
        residentCats.add(new Cat("Garfield", "Só acorda para comer sachê.", 6));

        // Apenas devolvemos a lista. O Spring converte para JSON sozinho!
        return residentCats;
    }
}