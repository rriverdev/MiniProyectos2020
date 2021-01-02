import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

	Scanner sc  = new Scanner(System.in);
	public static void main(String... rValens) throws SQLException {
		// TODO Auto-generated method stub
		Principal principal = new Principal();
		int id = principal.solicitaId();
		String nombre = principal.solicitaNombreUsuario();
		String contrasena = principal.solicitaContrasena();
		principal.registrarEnBD(id, nombre, contrasena);
		System.out.println("\n+++++++++++++++++++++");
		
//		List<UsuarioDto> listaUsuario = principal.listaUsuario();
//		for (UsuarioDto lista: listaUsuario) {
		for (UsuarioDto lista: principal.listaUsuario())
			System.out.println(lista.getId() + "-" + lista.getNombre() +"-"+ lista.getClave());			
		 
	}
	
	private int solicitaId() {
		System.out.println("Ingresa el Id Numerico");
		int valor = sc.nextInt(); 
		return valor;			
	}
	
	private  String solicitaNombreUsuario() {
		System.out.println("Ingresa el Nombre de Usuario");
		String valor =sc.next(); 
		return valor;
	}
	
	private String solicitaContrasena() {
		System.out.println("Ingresa la Clave de Usuario");
		String v = sc.next();
		return v;
	}
	
	void registrarEnBD(int identificador, String nombre, String clave) throws SQLException {
		
		final String JDBC_DRIVER = "org.postgresql.Driver";
		final String DB_URL = "jdbc:postgresql://localhost:5432/demo";
		
		final String USER = "postgres";
		final String PASS = "root";
		
		Connection cnx = null;
		
		try {
			Class.forName(JDBC_DRIVER);
			cnx = DriverManager.getConnection(DB_URL, USER, PASS);
			
			PreparedStatement  ps  = cnx.prepareStatement("insert into usuario (id, usuario, password ) values (?,?,?)");
			ps.setInt(1, identificador);
			ps.setString(2, nombre);
			ps.setString(3, clave);
			ps.executeUpdate();
			ps.close();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		} finally {
			if (!cnx.isClosed()) {
				cnx.close();
			}
		}
	}
	
	
	List<UsuarioDto> listaUsuario() throws SQLException {
		final String JDBC_DRIVER = "org.postgresql.Driver";
		final String DB_URL = "jdbc:postgresql://localhost:5432/demo";
		
		final String USER = "postgres";
		final String PASS = "root";
		
		Connection cnx = null;
		
		List<UsuarioDto> listaUsr = new ArrayList();
		try {
			Class.forName(JDBC_DRIVER);
			cnx = DriverManager.getConnection(DB_URL, USER, PASS);
			PreparedStatement  ps  = cnx.prepareStatement("select * from usuario");
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				UsuarioDto usuarioDto = new UsuarioDto();
				usuarioDto.setId(rs.getInt("id"));
				usuarioDto.setNombre(rs.getString("usuario"));
				usuarioDto.setClave(rs.getString("password"));
				listaUsr.add(usuarioDto);
			}
			
			rs.close();
			ps.close();
			
		} catch (Exception e) {
			e.getMessage();
		} finally {
			if (!cnx.isClosed()) {
				cnx.close();
			}
		}
		return listaUsr;
	}

}
