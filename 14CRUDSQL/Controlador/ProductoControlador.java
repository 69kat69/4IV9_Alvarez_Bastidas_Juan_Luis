package Controlador;

/**
 *
 * @author demon
 */

import Modelo.Producto;
import Modelo.ProductoDAO;
import Vista.ProductoVista;
import java.sql.*;
import java.util.*;
import javax.swing.*;

public class ProductoControlador {
    /*
    El controlador es el intermediario, entre la vista y 
    el modelo, recibe los eventos del usuario, los clic, seleccion
    eventos de teclado, y este ejecuta la logica, la cual 
    corresponde al modelo
    
    
    */
    
    private ProductoDAO dao;
    private ProductoVista vista;
    
    //necesita su propio constructor
    public ProductoControlador(ProductoDAO dao, ProductoVista vista){
        this.dao = dao;
        this.vista = vista;
        
        //como se van a registrar cada uno de los eventos
        //un metodo para iniciarlizar los eventos de la vista
        //inicializarEventos();
    }
    
    //un metodo para cada comportamiento
    //agregar
    private void agregar(){
        try{
            //instancia del producto
            Producto producto = construirProductoFormulario();
            
            if(producto == null) return;
            
            dao.agregar(producto);
            //validamos mostrando los productos
            cargarTabla();
            
            
        }catch(NumberFormatException ex){
            System.out.println("Verifique que los campos "
                    + "numericos sean validos");
        
        }catch(SQLException e){
            System.out.println("Error al agregar " 
                    + e.getMessage());
        }
    }

    private Producto construirProductoFormulario() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void cargarTabla() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}