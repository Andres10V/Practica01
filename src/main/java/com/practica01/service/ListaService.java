/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.practica01.service;

import com.practica01.domain.Lista;
import java.util.List;

/**
 *
 * @author User
 */
public interface ListaService {
    
    //se declara un metodo para obtener un Array list de Objetos Lista
    //Los objetos vienen de la tabla lista
    //Son todos los registros o solo los activos
    public List<Lista> getListas(boolean activos);
    
//Abajo se colocaran los metodos para un crud de listas pero en semana 6

 
   // Se obtiene un Lista, a partir del id de un lista
    public Lista getLista(Lista lista);
    
    // Se inserta un nuevo lista si el id del lista esta vacío
    // Se actualiza un lista si el id del lista NO esta vacío
    public void save(Lista lista);
    
    // Se elimina el lista que tiene el id pasado por parámetro
    public void delete(Lista lista);    
}
