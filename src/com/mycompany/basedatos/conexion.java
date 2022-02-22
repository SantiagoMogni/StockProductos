/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.basedatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mogni
 */
public class conexion {
     
 public Connection conectar() {
        String baseDeDatos = "stockproductos";
        String usuario = "root";
        String password = "";
        String host = "localhost";
        String puerto = "3306";
        String driver = "com.mysql.cj.jdbc.Driver";
        String conexionURL = "jdbc:mysql://" + host + ": " + puerto + "/" +  baseDeDatos + "?useSSL=false";
        
        Connection conexion = null;
           
        try {
            Class.forName(driver);
          conexion = DriverManager.getConnection(conexionURL, usuario, password);
        System.out.println("CONEXION EXITOSA");
        } catch (Exception ex) {
            System.out.println("ERROR AL CONECTAR");
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
          return conexion;
      
    }

  
  
}
