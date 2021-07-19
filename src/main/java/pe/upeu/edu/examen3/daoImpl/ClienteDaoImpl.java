package pe.upeu.edu.examen3.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pe.upeu.edu.examen3.config.Conexion;
import pe.upeu.edu.examen3.dao.ClienteDao;
import pe.upeu.edu.examen3.model.Cliente;

public class ClienteDaoImpl implements ClienteDao {
	private PreparedStatement ps;
	private ResultSet rs;
	private Connection cx = null;
	
	
	@Override
	public List<Cliente> readAll() {
		List<Cliente> lista = new ArrayList<>();
		String SQL = "select *from cliente";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(SQL);
			rs = ps.executeQuery(SQL);
			while(rs.next()) {
				Cliente c = new Cliente();
				c.setIdcliente(rs.getInt("idcliente"));
				c.setNombres(rs.getString("nombres"));
				c.setApellidos(rs.getString("apellidos"));
				c.setTelefono(rs.getString("telefono"));
				lista.add(c);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error: "+e);
		}
		return lista;
	}
	
	
}
