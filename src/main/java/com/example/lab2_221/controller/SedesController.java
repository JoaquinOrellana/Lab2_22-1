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

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/sedes")


public class SedesController {

    @Autowired
    SedesRepository sedesRepository;

    @Autowired
    TrabajadoresRepository trabajadoresRepository;

    @GetMapping("/lista")
    public String listarSedes(Model model) {
        List<Sedes> sedesList = sedesRepository.findAll();
        model.addAttribute("sedesList", sedesList);
        return "sedes/lista";
    }

    @GetMapping("/newform")
    public String newform(Model model){
        List<Sedes> sedesList = sedesRepository.findAll();
        model.addAttribute("sedesList",sedesList);
        return "sedes/newform";
    }

    @PostMapping("/save")
    public String savesedes( Sedes sedes){
        sedesRepository.save(sedes);
        return "redirect:/sedes/lista";
    }

    @GetMapping("/editar")
    public String editarsedes(@RequestParam("idsede") Integer idsede, Model model) {
        Optional<Sedes> optionalSedes = sedesRepository.findById(idsede);
        if (optionalSedes.isPresent()) {
            Sedes sedes = optionalSedes.get();
            model.addAttribute("sedes", sedes);
            List<Trabajadores> listaTrabajadoresporSede = trabajadoresRepository.findByIdsede(idsede);
            model.addAttribute("listaTrabajadoresporSede", listaTrabajadoresporSede);
            return "sedes/editform";
        } else {
            return "redirect:/sedes/listar";
        }
    }

    @GetMapping("/borrar")
    public String borrar(@RequestParam("idsede") int ididsede){
        Optional<Sedes> optionalSedes = sedesRepository.findById(ididsede);
        if(optionalSedes.isPresent()){
            sedesRepository.deleteById(ididsede);
        }
        return "redirect:/sedes/lista";

    }

}
