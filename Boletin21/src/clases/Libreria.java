/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.Collections;

/**
 *
 * @author aparcerozas
 */
public class Libreria {
    public void crearLibro(ArrayList<Libro> lista){
        String titulo = JOptionPane.showInputDialog("Título:");
        String autor = JOptionPane.showInputDialog("Autor:");
        String isbn = JOptionPane.showInputDialog("ISBN:");
        double prezo = Double.parseDouble(JOptionPane.showInputDialog("Prezo:"));
        int numUnid = Integer.parseInt(JOptionPane.showInputDialog("Número de unidades:"));
        Libro l = new Libro(titulo, autor, isbn, prezo, numUnid);
        lista.add(l);
    }
    
    public void engadirLibros(ArrayList<Libro> lista){
        int comprobar = 0;
        String isbn = JOptionPane.showInputDialog("Introduzca el ISBN del libro:");
        for(Libro l : lista){
            if(isbn.equalsIgnoreCase(l.getISBN())){
                l.setNumUnid(l.getNumUnid()+Integer.parseInt(JOptionPane.showInputDialog("Introduzca el número de unidades a añadir:")));
                comprobar = 1;
            }
        }
        if(comprobar==0){
            JOptionPane.showMessageDialog(null, "No se encontró un libro con ese ISBN");
        }
    }
    
    public void venderLibros(ArrayList<Libro> lista){
        try{
            int comprobar = 0;
            String isbn = JOptionPane.showInputDialog("Introduzca el ISBN del libro:");
            for(Libro l : lista){
                if(isbn.equalsIgnoreCase(l.getISBN())){
                    int num = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el número de unidades a vender:"));
                    if(num>l.getNumUnid()){
                        l.setNumUnid(0);
                    }
                    else{
                        l.setNumUnid(l.getNumUnid()-num);
                    }
                    comprobar = 1;
                }
            }
            if(comprobar==0){
                JOptionPane.showMessageDialog(null, "No se encontró un libro con ese ISBN");
            }
        }
        catch(NullPointerException e){
            JOptionPane.showMessageDialog(null, "El array indicado es nulo");
        }
    }
    
    public void ver(ArrayList<Libro> lista){
        try{
            ArrayList<Libro> lista2 = lista;
            Collections.sort(lista2);
            for(Libro l : lista2){
                System.out.println(l.toString());
            }
        }
        catch(NullPointerException e){
            JOptionPane.showMessageDialog(null, "El array indicado es nulo");
        }
    }
    
    public void baixa(ArrayList<Libro> lista){
        try{
            for(Libro l : lista){
                if(0==l.getNumUnid()){
                    lista.remove(l);
                }
            }
        }
        catch(Exception e){
            
        }
    }
    
    public void consultar(ArrayList<Libro> lista){
        try{
            int comprobar = 0;
            String isbn = JOptionPane.showInputDialog("Introduzca el ISBN del libro:");
            for(Libro l : lista){
                if(l.getISBN().equalsIgnoreCase(isbn)){
                    JOptionPane.showMessageDialog(null, l.toString());
                    comprobar = 1;
                }
            }
            if(comprobar==0){
                JOptionPane.showMessageDialog(null, "No se encontró un libro con ese ISBN");
            }
        }
        catch(NullPointerException e){
            JOptionPane.showMessageDialog(null, "El array indicado es nulo");
        }
    }
    
}
