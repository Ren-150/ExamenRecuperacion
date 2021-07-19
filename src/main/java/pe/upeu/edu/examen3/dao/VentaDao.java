package pe.upeu.edu.examen3.dao;

import java.util.List;
import java.util.Map;

import pe.upeu.edu.examen3.model.Venta;


public interface VentaDao {
	int create(Venta v);
	int update(Venta v);
	int delete(int id);
	Venta read(int id);
	List<Map<String, Object>> readAll2();
}
