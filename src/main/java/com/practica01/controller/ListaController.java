/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practica01.controller;


import com.practica01.domain.Lista;
import com.practica01.service.ListaService;
import com.practica01.service.FirebaseStorageService;
import org.hibernate.query.results.ResultsHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author User
 */
@Controller
@RequestMapping("/lista")


public class ListaController {
    
    
    @Autowired
    private ListaService listaService;
    
    @GetMapping("/listado")
    public String listado(Model model){
        var listas =listaService.getListas(false);
        
        model.addAttribute("listas",listas);
        model.addAttribute("totalListas",listas.size());
        
        
    return "/lista/listado";
    }
       @GetMapping("/nuevo")
    public String listaNuevo(Lista lista) {
        return "/lista/modifica";
    }

    @Autowired
    private FirebaseStorageService firebaseStorageService;
    
    @PostMapping("/guardar")
    public String listaGuardar(Lista lista,
            @RequestParam("imagenFile") MultipartFile imagenFile) {        
        if (!imagenFile.isEmpty()) {
            listaService.save(lista);
            lista.setRuta_imagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile, 
                            "lista", 
                            lista.getId()));
        }
        listaService.save(lista);
        return "redirect:/lista/listado";
    }

    @GetMapping("/eliminar/{idLista}")
    public String listaEliminar(Lista lista) {
        listaService.delete(lista);
        return "redirect:/lista/listado";
    }

    @GetMapping("/modificar/{idLista}")
    public String listaModificar(Lista lista, Model model) {
        lista = listaService.getLista(lista);
        model.addAttribute("lista", lista);
        return "/lista/modifica";
    }
    
}