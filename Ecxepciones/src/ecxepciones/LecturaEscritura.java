/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecxepciones;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class LecturaEscritura {
    
    public static List<Persona> lectura(String file) {
        List<Persona> personas = new ArrayList<>();
        try(BufferedReader bf = new BufferedReader(new FileReader(file))){
            String linea;
            while((linea=bf.readLine()) != null) {
                String[] datos = linea.split(",");
                personas.add(new Persona(datos[0], Integer.parseInt(datos[1])));
            }
        }catch(IOException ex){
            System.out.println("Error al leer el archivo");
        }
        return personas;
    }
    
    public static void escritura(String file, List<Persona> personas) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))){
            for(Persona p: personas) {
                bw.write(p.getNombre()+","+p.getEdad()); 
                bw.newLine();
            }
        }catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static List<Persona> leerBinario(String file) {
        List<Persona> lista = new ArrayList<>();
        try(ObjectInputStream os = new ObjectInputStream(new FileInputStream(file))) {
            try{
                lista = (List<Persona>)os.readObject();
//                os.readBoolean();
//                os.readUTF();
//                os.readInt();
            }catch(ClassNotFoundException ex){
                System.out.println(ex.getMessage());
            }catch(EOFException ex) {
                System.out.println("Fin del archivo");
            }
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        return lista;
    }
    
    public static void escribirBinario(String file, List<Persona> personas) {
        try(ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file))) {
            os.writeObject(personas);
//            os.writeUTF("String");
//            os.writeInt(10);
//            os.writeBoolean(true); 
            
        }catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
