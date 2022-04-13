package com.example.lab2_221.controller;


import com.example.lab2_221.entity.Tipos;
import com.example.lab2_221.repository.TiposRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/equipo")
public class TiposController {

    @Autowired
    TiposRepository tiposRepository;


    @GetMapping("/lista")
    public String listaTipos (Model model){
        List<Tipos> tiposList = tiposRepository.findAll();
        model.addAttribute("tiposList",tiposList);
        return "tipos/lista";
    }

    @GetMapping("/editar")
    public String editarTipo(@RequestParam("id") int id, Model model){
        Optional<Tipos> optionalTipos = tiposRepository.findById(id);
        if (optionalTipos.isPresent()) {
            Tipos tipos = optionalTipos.get();
            model.addAttribute("tipos", tipos);
            return "tipos/editar";
        } else {
            return "redirect:/equipo/lista";
        }
    }
    @GetMapping("/nuevo")
    public String nuevoTipo(){

        return "tipos/nuevo";
    }

    @PostMapping("/guardar")
    public String guardarTipos(Tipos tipos, RedirectAttributes attributes){
        tiposRepository.save(tipos);
        attributes.addFlashAttribute("msg", "Tipo de Equipo creado exitosamente");
        return "redirect:/equipo/lista";
    }
    @PostMapping("/actualizar")
    public String actualizarTipos(Tipos tipos, RedirectAttributes attributes){
        tiposRepository.save(tipos);
        attributes.addFlashAttribute("msg1", "Tipo de Equipo  editado exitosamente");
        return "redirect:/equipo/lista";
    }

    @GetMapping("/borrar")
    public String borrarTipo(@RequestParam("id") int id, RedirectAttributes attributes){
        Optional<Tipos> optionalTipos = tiposRepository.findById(id);
        if (optionalTipos.isPresent()) {
            tiposRepository.deleteById(id);
            attributes.addFlashAttribute("msg2", "Tipo de Equipo borrada exitosamente");
        }
        return "redirect:/equipo/lista";
    }
}
