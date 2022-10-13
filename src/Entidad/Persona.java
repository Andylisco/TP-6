package Entidad;

public class Persona {

	private String Dni;
	private String Nombre;
	private String Apellido;
	public String getDni() {
		return Dni;
	}
	public void setDni(String dni) {
		Dni = dni;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	
	
	public Persona() {		
		Dni = null;
		Nombre = null;
		Apellido = null;
	}
	public Persona(String dni, String nombre, String apellido) {		
		Dni = dni;
		Nombre = nombre;
		Apellido = apellido;
	}
	
	@Override
	public String toString() {
		return  (this.getNombre() + " "  + this.getApellido() + " " + this.getDni());
	}
	
}
