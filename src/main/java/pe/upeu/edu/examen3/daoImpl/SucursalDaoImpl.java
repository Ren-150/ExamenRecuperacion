package pe.upeu.edu.examen3.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pe.upeu.edu.examen3.config.Conexion;
import pe.upeu.edu.examen3.dao.SucursalDao;
import pe.upeu.edu.examen3.model.Sucursal;

public class SucursalDaoImpl implements SucursalDao{
	
	private PreparedStatement ps;
	private ResultSet rs;
	private Connection cx = null;
	
	@Override
	public List<Sucursal> readAll() {
		// TODO Auto-generated method stub
		List<Sucursal> lista = new ArrayList<>();
		String SQL = "select *from sucursal";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(SQL);
			rs = ps.executeQuery(SQL);
			while(rs.next()) {
				Sucursal s = new Sucursal();
				s.setIdsucursal(rs.getInt("idsucursal"));
				s.setNomsucursal(rs.getString("nomsucursal"));
				lista.add(s);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error: "+e);
		}
		return lista;
	}

}
