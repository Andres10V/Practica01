/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.practica01.dao;

import org.springframework.data.jpa.repository.JpaRepository;
 import com.practica01.domain.Lista;



public interface  ListaDao extends JpaRepository<Lista, Long>{
    
}

