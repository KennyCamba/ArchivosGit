/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecxepciones;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;


public class Ecxepciones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
//        String archivo = Ecxepciones.class.getResource("archivo.txt").toExternalForm();
//        System.out.println(archivo);

        String ubicacion = new File("").getAbsolutePath();
        System.out.println(ubicacion);
        ubicacion = Paths.get(ubicacion, "src", "ecxepciones", "archivo.txt").toString();
        
        System.out.println(ubicacion);
        String file = "src/ecxepciones/archivo.txt";
        List<Persona> p = LecturaEscritura.lectura(ubicacion);
        for(Persona per: p) {
            System.out.println(per.getNombre() + " " +per.getEdad());
        }
        
        int a = 0;
        while(a != 2){
            System.out.print("Nombre: ");
            String n = sc.nextLine();
            System.out.print("Edad: ");
            int ed = sc.nextInt();
            sc.nextLine();
            a++;
            p.add(new Persona(n, ed));
        }
       
        
        LecturaEscritura.escritura(file, p);
        LecturaEscritura.escribirBinario("src/ecxepciones/file.dat", p);
        System.out.println("----------------------------------");
        for(Persona per: LecturaEscritura.leerBinario("src/ecxepciones/file.dat")){
            System.out.println(per.getNombre() + ", " + per.getEdad());
        } 
    }
    
    public static void metodo(int a) throws IOException, NullPointerException {
        if(a == 0){
            throw new NullPointerException();
        }
        BufferedReader bf = new BufferedReader(new FileReader("")); 
    }
    
}
