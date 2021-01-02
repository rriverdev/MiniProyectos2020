package Principal;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Scanner;

public class CursoSE {
	
	public static void main(String... rriverDev) throws Exception {
		
			/*	Uso basico de Calendar	*/
		System.out.println("\n/*	Uso basico de Calendar	*/");
		Celular ce = new Celular();
		
		ce.setModelo("Samsung-A10");
		ce.setColor("Negro");
		ce.setPrecio(2500);
		
		ce.llamada("s", "DDD", 50);
		
		Calendar calendario = new GregorianCalendar();
		
		System.out.println(calendario.getTime());
		System.out.println(calendario.get(calendario.DAY_OF_MONTH));
		
			/*	Uso basico de HashMap	*/
		System.out.println("\n/*	Uso basico de HashMap	*/");
		HashMap diccionario = new HashMap<>();

		diccionario.put("userr", "rriver");
		diccionario.put("moto", "Yamaha");
		diccionario.put("auto", "Ford");
		diccionario.put("Java", "SpringBoot");
		
		System.out.println(diccionario.toString());

		String contenidoHash =  diccionario.get("Java").toString();

		boolean respuesta=  diccionario.containsValue("SpringBoot");		
		System.out.println(contenidoHash);
		System.out.println(respuesta);
		
		diccionario.remove("moto");
		diccionario.replace("Java", "SpringBoot", "Persistance");
		
		System.out.println(diccionario.toString());
		
		
			/*	Uso basico de FileReader/BufferedReader	*/
		System.out.println("\n/*	Uso basico de FileReader y BufferedReader (Lectura de Archivo)	*/");		
		
//		try { // si no deseas agregar throws a la clase se puede agregar en el catch del try
			FileReader archivoTxt = new FileReader("C:\\01_AES\\Encoded.txt");		//	permite capturar un archivo
			BufferedReader br = new BufferedReader(archivoTxt);						//	permite recorrer l¿el contenido del archivo
			String texto;
			while ((texto = br.readLine()) != null) {
				System.out.println("Contenido del Archivo: " +texto);
			}
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		 
		
			/*	Uso basico de FileInputStream	*/
		System.out.println("\n/*	Uso basico de FileReader y Scanner (Lectura de Archivo)	*/");		

		FileInputStream in = new FileInputStream("C:\\01_AES\\Decoded.txt");
		Scanner sc = new Scanner(in, "UTF-8");
		String contenido = sc.next(); 
		System.out.println(contenido);
		
		
		
		
		/*	Uso basico de FileWriter y PrintWriter	*/
		System.out.println("\n/*	Uso basico de FileWriter y PrintWriter (Escritura de Archivos)	*/");
		
		FileWriter fw = null;	//archivo - libreta
		PrintWriter pw = null;	//escritor - lapiz
		
		
		try {
			fw = new FileWriter("C:\\01_AES\\Encoded.txt",true); ///el true afirma que el archivo existe
			pw = new PrintWriter(fw);
			pw.write("Nuevo Texto");
		} catch (Exception e ) {
			//exception
		}finally {
			// TODO: handle finally clause
			if(fw != null) {
				fw.close();
			}
		}

		System.out.println(texto);
		



	}

}
