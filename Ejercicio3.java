package examen;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Ejercicio3 {

    static Scanner sc = new Scanner(System.in);
 
    static ArrayList<String> Plataformas = new ArrayList();
    
	private static void informacionVideojuegos(String original) {
		
		File file = new File(original);
		String[] platform;
		int cuenta=0;
		
		try {Scanner f = new Scanner(file);
			 while(f.hasNextLine()) {
				String linea = f.nextLine();
				if (cuenta!=0) {
				  platform = linea.split(",");
				  Plataformas.add(platform[2]);
				}
				cuenta++;
			 }

			f.close();
			
		} catch(FileNotFoundException e) {
			System.out.println("El fichero " + original + " no ha podido ser abierto.");
		}
	}
	
	public static void main(String[] args) {
    	System.out.println("Escriba la ruta del fichero que contiene la lista a evaluar");
		String fichero = sc.nextLine();
		informacionVideojuegos(fichero);
    } 
    
}