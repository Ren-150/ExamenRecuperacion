package pe.upeu.edu.examen3.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pe.upeu.edu.examen3.config.Conexion;
import pe.upeu.edu.examen3.dao.VentaDao;
import pe.upeu.edu.examen3.model.Venta;

public class VentaDaoImpl implements VentaDao{
	
	private PreparedStatement ps;
	private ResultSet rs;
	private Connection cx = null;
	
	@Override
	public int create(Venta v) {
		int x = 0;
		String SQL = "insert into venta (fecha, tipodoc, idsucursal, idcliente) values(?,?,?,?)";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(SQL);
			ps.setString(1, v.getFecha());
			ps.setString(2, v.getTipodoc());
			ps.setInt(3, v.getIdsucursal());
			ps.setInt(4, v.getIdcliente());
			x = ps.executeUpdate();
			System.out.println(x);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return x;
	}

	@Override
	public int update(Venta v) {
		// TODO Auto-generated method stub
		int x = 0;
		String SQL = "update venta set fecha = ?, tipodoc = ?, idsucursal = ?, idcliente = ? where idventa = ?";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(SQL);
			ps.setString(1, v.getFecha());
			ps.setString(2, v.getTipodoc());
			ps.setInt(3, v.getIdsucursal());
			ps.setInt(4, v.getIdcliente());
			ps.setInt(5, v.getIdventa());
			x = ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return x;
	}

	@Override
	public int delete(int id) {
		int x = 0;
		String SQL = "delete from venta where idventa=?";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(SQL);
			ps.setInt(1, id);
			x = ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return x;
	}

	@Override
	public Venta read(int id) {
		// TODO Auto-generated method stub
		Venta v = new Venta();
		String SQL = "select *from venta where idventa=?";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(SQL);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {				
				v.setIdventa(rs.getInt("idventa"));
				v.setFecha(rs.getString("fecha"));
				v.setTipodoc(rs.getString("tipodoc"));
				v.setIdsucursal(rs.getInt("idsucursal"));
				v.setIdcliente(rs.getInt("idcliente"));
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return v;
	}

	@Override
	public List<Map<String, Object>> readAll2() {
		// TODO Auto-generated method stub
		List<Map<String, Object>> lista = new ArrayList<>();
		String SQL = "SELECT v.idventa, v.fecha, v.tipodoc, s.idsucursal, s.nomsucursal as sucursal, c.idcliente, c.nombres as cliente from venta as v inner join sucursal as s on v.idsucursal = s.idsucursal "
				+ "inner join cliente as c on v.idcliente = c.idcliente;";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(SQL);
			rs = ps.executeQuery(SQL);
			while(rs.next()) {
				 Map<String, Object> map = new HashMap<>();
	                map.put("idventa", rs.getInt("idventa"));
	                map.put("fecha", rs.getString("fecha"));
	                map.put("tipodoc", rs.getString("tipodoc"));
	                map.put("idsucursal", rs.getInt("idsucursal"));
	                map.put("sucursal", rs.getString("sucursal"));
	                map.put("idcliente", rs.getInt("idcliente"));
	                map.put("cliente", rs.getString("cliente"));
	                lista.add(map);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error: "+e);
		}
		
		return lista;
	}

}
