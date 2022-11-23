/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web;

import dominio.Roles;
import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servicio.RolesServ;

@WebServlet("/roles")
public class RolesServlet extends HttpServlet {

    @Inject
    RolesServ rolesServicio;

    protected void accionDefault(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Roles> roles = rolesServicio.listarRoles();
        request.setAttribute("roles", roles);
        request.getRequestDispatcher("paginas/roles/listaRoles.jsp").forward(request, response);
    }

    protected void editarPagina(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idRole = request.getParameter("idRole");
        int Id = Integer.parseInt(idRole);
        Roles role = rolesServicio.buscarRolesPorId(Id);
        request.setAttribute("role", role);
        request.getRequestDispatcher("paginas/roles/editarRole.jsp").forward(request, response);

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
                    this.insertarRole(request, response);
                    break;
                case "editar":
                    this.modificarRole(request, response);
                    break;
                case "eliminar":
                    this.eliminarRole(request, response);
                    break;
                default:
            }
        } else {

        }
    }

    public void insertarRole(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        Roles role = new Roles();
        role.setName(nombre);
        rolesServicio.registrarRoles(role);
        this.accionDefault(request, response);
    }

    public void eliminarRole(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("idRole");
        int Id = Integer.parseInt(id);
        Roles role = rolesServicio.buscarRolesPorId(Id);
        rolesServicio.eliminarRoles(role);
        this.doGet(request, response);
    }

    public void modificarRole(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("idRole");
        int Id = Integer.parseInt(id);
        String nombre = request.getParameter("name");
        Roles role = rolesServicio.buscarRolesPorId(Id);
        role.setName(nombre);
        rolesServicio.modificarRoles(role);
        this.accionDefault(request, response);
    }
}
