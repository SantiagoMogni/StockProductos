/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.basedatos;






import java.sql.PreparedStatement;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

        
public class BaseDatos {

   
    
  
    
  public  DefaultTableModel mostrarProductos() {
       
  
      conexion con = new conexion();
       String [] columnas = {"id","codigo","nombre","precio","stock"};
       String [] registros = new String[5];
       
       DefaultTableModel modelo = new DefaultTableModel(null,columnas);
       
       String sql = "SELECT * FROM  `productos` ";
       
       Connection cn = null;
       
       PreparedStatement pst = null;
       
       ResultSet resultado = null;
      
      
       
        try {
             cn = con.conectar();
             
             pst = cn.prepareStatement(sql);
             
             resultado = pst.executeQuery();
 
         
       
        while(resultado.next()){
            registros[0] = resultado.getString("id");
            registros[1] = resultado.getString("codigo");
            registros[2] = resultado.getString("nombre");
            registros[3] = resultado.getString("precio");
            registros[4] = resultado.getString("stock");
            
            modelo.addRow(registros);
            
        }
     
        } catch (Exception ex) {
            
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally 
        {
            try{
                if(resultado != null) resultado.close();
                if(pst != null) pst.close();
                if(cn != null) cn.close();
            }catch(Exception ex){
                  Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return modelo;
       
  
    
}  

  
 
}