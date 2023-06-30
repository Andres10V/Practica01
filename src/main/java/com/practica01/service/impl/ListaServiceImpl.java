/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practica01.service.impl;
import com.practica01.dao.ListaDao;
import com.practica01.domain.Lista;
import com.practica01.service.ListaService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ListaServiceImpl implements ListaService  {
    //La anotacion Autowired crea un unico objeto mientras se ejecuta el app
    @Autowired
    private ListaDao listaDao;

//    @Override
//    @Transactional(readOnly = true)
//    public List<Lista> getListas(boolean activos) {
//        var lista = listaDao.findAll();
//
//        if (activos) {//se deben eliminar los que no estan activos...
//            lista.removeIf(e -> !e.isActivo());
//        }
//        return lista;
//    }

    @Override
    @Transactional(readOnly = true)
    public Lista getLista(Lista lista) {
        return listaDao.findById(lista.getId()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Lista lista) {
        listaDao.save(lista);
    }

    @Override
    @Transactional
    public void delete(Lista lista) {
        listaDao.delete(lista);
    }

    @Override
    public List<Lista> getListas(boolean activos) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

