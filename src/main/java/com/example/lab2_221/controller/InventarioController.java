package com.example.lab2_221.controller;


import com.example.lab2_221.entity.*;
import com.example.lab2_221.repository.InventarioRepository;
import com.example.lab2_221.repository.MarcasRepository;
import com.example.lab2_221.repository.SedesRepository;
import com.example.lab2_221.repository.TiposRepository;
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
@RequestMapping("/inventario")

public class InventarioController {

    @Autowired
    InventarioRepository inventarioRepository;

    @Autowired
    SedesRepository sedesRepository;

    @Autowired
    MarcasRepository marcasRepository;

    @Autowired
    TiposRepository tiposRepository;

    @GetMapping("/lista")
    public String listarInventario(Model model) {
        List<Inventario>  inventarioList = inventarioRepository.findAll();
        model.addAttribute("inventarioList", inventarioList);
        return "inventario/lista";
    }

    @GetMapping("/newform")
    public String newform(Model model){
        List<Inventario> inventarioList = inventarioRepository.findAll();
        model.addAttribute("inventarioList",inventarioList);
        List<Sedes> sedesList = sedesRepository.findAll();
        model.addAttribute("sedesList",sedesList);
        List<Marcas> marcasList = marcasRepository.findAll();
        model.addAttribute("marcasList",marcasList);
        List<Tipos> tiposList = tiposRepository.findAll();
        model.addAttribute("tiposList",tiposList);
        return "inventario/newform";
    }

    @PostMapping("/save")
    public String saveinventario( Inventario inventario){
        inventarioRepository.save(inventario);
        return "redirect:/inventario/lista";
    }

    @GetMapping("/borrar")
    public String borrar(@RequestParam("idinventario") int idinventario){
        Optional<Inventario> optionalInventario = inventarioRepository.findById(idinventario);
        if(optionalInventario.isPresent()){
            inventarioRepository.deleteById(idinventario);
        }
        return "redirect:/inventario/lista";

    }

}