package principal;

import java.util.ArrayList;
import java.util.List;

public class PruebaEncriptBanregio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
//		List <String> meses = new ArrayList();
//		List <String> anio = new ArrayList();
//		List<String> fechaa = new ArrayList();
//		
//			meses.add("01");
//			meses.add("12");
//			meses.add("08");
//			
//			anio.add("2020");
//			anio.add("2019");
//			anio.add("2019");
//			
//			for(int i = 0; i < meses.size(); i++){//comentar
//				String MesAnio = meses.get(i)+ anio.get(i);
//				System.out.println(MesAnio);
//				System.out.println(MesAnio);
//				fechaa.add(MesAnio);
//				System.out.println("MesAño:"+fechaa.get(i));
//				
//			}
//			
//			System.out.println( "tamaño de arreglo: '"+fechaa.size() +"' espacios.");
//			fechaa.hashCode();
//			fechaa.hashCode();
		
		String enlanceHash = "[{\"cliente\":\"01201200\",\"hash\":\"2wMUBAuWfIbDdZx56PI7VhpyYqvYS42oVG3I2HLXL7b5Nthw3DQHYxQd7X188bkHO4nXqQLUX1eRNpZnzPE9Jg%3D%3D\"}]";
		
		int localition = enlanceHash.indexOf("hash\":");
		localition = localition + 7;
		System.out.println(localition);
		String cleanLink = enlanceHash.substring(localition, enlanceHash.length()-3);
		int length= enlanceHash.length();
		System.out.println(cleanLink+"-"+length);
		

	}

}
