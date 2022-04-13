package com.example.lab2_221.controller;

import com.example.lab2_221.entity.Marcas;
import com.example.lab2_221.repository.MarcasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/marcas")
public class MarcasController {


    @Autowired
    MarcasRepository marcasRepository;

    @GetMapping("/lista")
    public String listaMarcas (Model model){
        List<Marcas> marcasList = marcasRepository.findAll();
        model.addAttribute("marcasList",marcasList);
        return "marcas/lista";
    }

    @GetMapping("/editar")
    public String editarMarcas(@RequestParam("id") int id, Model model){
        Optional<Marcas> optionalMarcas = marcasRepository.findById(id);
        if (optionalMarcas.isPresent()) {
            Marcas marcas = optionalMarcas.get();
            model.addAttribute("marcas", marcas);
            return "marcas/editar";
        } else {
            return "redirect:/marcas/lista";
        }
    }
    @GetMapping("/nuevo")
    public String nuevaMarca(){

        return "marcas/nuevo";
    }

    @PostMapping("/guardar")
    public String guardarMarca(Marcas marcas){
        marcasRepository.save(marcas);
        return "redirect:/marcas/lista";
    }

    @GetMapping("/borrar")
    public String borrarMarca(@RequestParam("id") int id){
        Optional<Marcas> optionalMarcas = marcasRepository.findById(id);
        if (optionalMarcas.isPresent()) {
            marcasRepository.deleteById(id);
        }
        return "redirect:/marcas/lista";
    }


}
