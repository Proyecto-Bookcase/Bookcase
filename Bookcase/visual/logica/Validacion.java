package logica;

public class Validacion {

	/**TODO
	 * hace falta hacer un metodo para ver si es un estudainte(false) o un profesor(true) 
	 * 
	 */
	
	// para esto se asume que los profesores siempre comenzaran su usuario con "pr" y los estudiantes con "ce"
	public boolean isProfesor(String user) {
		String a = user.substring(0, 2);
		boolean esc = false;
		if(user.substring(0,2).equals("pr"))
		{
			esc = true;
		}
		return esc;
	}
	/**TODO
	 * validar que el usuario y la contrasena sean correctos
	 */
	//asumiremos un usuario incorrecto con mas de 10 careacteres y que no comience con
	//pro para profesor o ce para estudiante
	public boolean isCorrectUsername(String user) {
		boolean esc = true;
		if (user.length() > 10 || user.length() <5) 
		{
			esc = false;
		}
		else if ( user.substring(0, 2).equals("pr")
				|| user.substring(0, 2).equals("ce")) {
			esc = false;
			
		}
		
		return esc;
	}
	//asumimos en esta validacion que el pasword debe ser igual al user 
	public boolean isCorrectPasword(String pasword, String user)
	{
		return pasword.equals(user) ? true : false;
	}
	
	/**TODO
	 * hace faltan los  metodos para crear tanto la carrera, año, asignarura y materiales y 
	 * que se muestre en la interfaz 
	 * 
	 */
	
}
