package pe.upeu.edu.examen3.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import pe.upeu.edu.examen3.dao.VentaDao;
import pe.upeu.edu.examen3.daoImpl.VentaDaoImpl;
import pe.upeu.edu.examen3.model.Venta;

/**
 * Servlet implementation class VentaController
 */
public class VentaController extends HttpServlet {
	private VentaDao vdao = new VentaDaoImpl();
	private Gson gson = new Gson();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VentaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		int opcion = Integer.parseInt(request.getParameter("opc"));//opc='1'
		switch (opcion) {
		case 1://todos los roles
				out.println(gson.toJson(vdao.readAll2()));
			break;
		case 2://crear
			out.println(gson.toJson(vdao.create(new Venta(request.getParameter("fecha"), request.getParameter("tipodoc"), Integer.parseInt(request.getParameter("idsucursal")),  Integer.parseInt(request.getParameter("idcliente"))))));
			break;
		case 3://read
			out.println(gson.toJson(vdao.read(Integer.parseInt(request.getParameter("id")))));
			break;
		case 4://modificar
			Venta v = new Venta();
			v.setIdventa(Integer.parseInt(request.getParameter("id")));
			v.setFecha(request.getParameter("fecha"));
			v.setTipodoc(request.getParameter("tipodoc"));
			v.setIdsucursal(Integer.parseInt(request.getParameter("idsucursal")));
			v.setIdcliente(Integer.parseInt(request.getParameter("idcliente")));
			out.println(gson.toJson(vdao.update(v)));
			break;
		case 5://eliminar
			out.println(gson.toJson(vdao.delete(Integer.parseInt(request.getParameter("id")))));
			break;
		default:
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
