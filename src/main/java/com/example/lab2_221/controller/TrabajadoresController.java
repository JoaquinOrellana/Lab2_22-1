package com.example.lab2_221.controller;


import com.example.lab2_221.entity.Sedes;
import com.example.lab2_221.entity.Trabajadores;
import com.example.lab2_221.repository.SedesRepository;
import com.example.lab2_221.repository.TrabajadoresRepository;
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
@RequestMapping("/trabajadores")
public class TrabajadoresController {

    @Autowired
    TrabajadoresRepository trabajadoresRepository;

    @Autowired
    SedesRepository sedesRepository;

    @GetMapping("/lista")
    public String listaTrabajadores (Model model){
        List<Trabajadores> listaTraba = trabajadoresRepository.findAll();
        model.addAttribute("listaTraba",listaTraba);
        return "trabajadores/lista";
    }

    @GetMapping("/new")
    public String  nuevoTrabajador(Model model){
        List<Sedes> listaProd = sedesRepository.findAll();
        model.addAttribute("listaProd",listaProd);
        return "trabajadores/newform";
    }

    @PostMapping("/guardar")
    public String guardarNuevoTrabajador(Trabajadores trabajadores, RedirectAttributes attr){
        attr.addFlashAttribute("msg","Trabajador creado exitosamente");
        trabajadoresRepository.save(trabajadores);
        return "redirect:/trabajadores/lista";
    }

    @PostMapping("/update")
    public String actualizarNuevoTrabajador(Trabajadores trabajadores, RedirectAttributes attr){
        attr.addFlashAttribute("msg1","Trabajador actualizado exitosamente");
        trabajadoresRepository.save(trabajadores);
        return "redirect:/trabajadores/lista";
    }

    @GetMapping("/editar")
    public String editarTrabajador(Model model,@RequestParam("id") String id){
        Optional<Trabajadores> optTrab = trabajadoresRepository.findById(id);
        if(optTrab.isPresent()){
            Trabajadores trabajadores = optTrab.get();
            model.addAttribute("trabajador",trabajadores);
            List<Sedes> listaProd = sedesRepository.findAll();
            model.addAttribute("listaProd",listaProd);
            return "trabajadores/editFrm";
        }
        else{
            return "redirect:/trabajadores/lista";
        }
    }

    @GetMapping("/borrar")
    public String borrarTrabajador(Model model,@RequestParam("id") String id,RedirectAttributes attr){
        Optional<Trabajadores> optTrab = trabajadoresRepository.findById(id);
        if(optTrab.isPresent()){
            trabajadoresRepository.deleteById(id);
            attr.addFlashAttribute("msg2","Trabajador borrado exitosamente");
        }
        return "redirect:/trabajadores/lista";
    }
}
