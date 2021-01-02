package Principal;

public class Celular {
	
	
	private String modelo;
	private String color;
	private int precio;
	
	
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
		

	public void llamada(String modelo, String color, int precio) {
		System.out.println(getModelo() + "-" + getColor() +"-" + getPrecio());
	}
	

}