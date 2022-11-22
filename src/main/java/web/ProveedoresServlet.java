/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web;

import dominio.Proveedores;
import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servicio.ProveedoresServ;

@WebServlet("/proveedores")
public class ProveedoresServlet extends HttpServlet {

    @Inject
    ProveedoresServ proveedoresServ;

    protected void accionDefault(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Proveedores> proveedores = proveedoresServ.listarProveedores();
        System.out.println("proveedores = " + proveedores);
        request.setAttribute("proveedores", proveedores);
        request.getRequestDispatcher("paginas/listaProveedores.jsp").forward(request, response);

    }

    protected void editarPagina(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idProveedor = request.getParameter("idProveedor");
        int Id = Integer.parseInt(idProveedor);
        Proveedores proveedor = proveedoresServ.buscarProveedorPorId(Id);
        request.setAttribute("pvd", proveedor);
        request.getRequestDispatcher("paginas/editarProveedor.jsp").forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "modificar":
                    this.editarPagina(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    this.insertarProveedor(request, response);
                    break;
                case "editar":
                    this.modificarProveedor(request, response);
                    break;
                case "eliminar":
                    this.eliminarProveedor(request, response);
                    break;
                default:
            }
        } else {

        }
    }

    public void insertarProveedor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String telefono = request.getParameter("telefono");
        Proveedores proveedores = new Proveedores(nombre, telefono);
        proveedoresServ.registrarProveedores(proveedores);
        //int registrosmodificados =new ProveedoresDAOImpl().insertar(proveedores);
        //System.out.println("registrosmodificados = " + registrosmodificados);
        this.accionDefault(request, response);
    }

    public void eliminarProveedor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("idProveedor");
        int Id = Integer.parseInt(id);
        Proveedores proveedores = proveedoresServ.buscarProveedorPorId(Id);
        System.out.print(proveedores);
        proveedoresServ.eliminarProveedores(proveedores);
        this.doGet(request, response);
    }

    public void modificarProveedor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id_proveedor");
        int Id = Integer.parseInt(id);
        String nombre = request.getParameter("nombre");
        String telefono = request.getParameter("telefono");
        Proveedores proveedores = proveedoresServ.buscarProveedorPorId(Id);
        proveedores.setNombre(nombre);
        proveedores.setTelefono(telefono);
        //System.out.print(proveedores);
        //String jspEditar = "/WEB-INF/modales/proveedores/modificarProveedores.jsp";
        //request.getRequestDispatcher(jspEditar).forward(request, response);
        //Proveedores proveedores = new Proveedores(Id, nombre, telefono);
        //request.setAttribute("idProveedor", Id);
        //request.setAttribute("nombre", nombre);
        //request.setAttribute("telefono", telefono);
        proveedoresServ.modificarProveedores(proveedores);
        this.accionDefault(request, response);
    }
}
