/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web;

import dominio.Roles;
import dominio.Users;
import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servicio.RolesServ;
import servicio.UsersServ;

@WebServlet("/users")
public class UsersServlet extends HttpServlet {

    @Inject
    UsersServ usersServicio;
    
    @Inject
    RolesServ rolesServicio;

    protected void accionDefault(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Roles> roles = rolesServicio.listarRoles();
        List<Users> users = usersServicio.listarUsers();
        request.setAttribute("roles", roles);
        request.setAttribute("users", users);
        request.getRequestDispatcher("paginas/users/listaUsers.jsp").forward(request, response);
    }

    protected void editarPagina(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idUser = request.getParameter("idUser");
        int Id = Integer.parseInt(idUser);
        Users user = usersServicio.buscarUsersPorId(Id);
        List<Roles> roles = rolesServicio.listarRoles();
        request.setAttribute("roles", roles);
        request.setAttribute("user", user);
        request.getRequestDispatcher("paginas/users/editarUser.jsp").forward(request, response);

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
                    this.insertarUser(request, response);
                    break;
                case "editar":
                    this.modificarUser(request, response);
                    break;
                case "eliminar":
                    this.eliminarUser(request, response);
                    break;
                default:
            }
        } else {

        }
    }

    public void insertarUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String correo = request.getParameter("correo");
        String idRole = request.getParameter("idRole");
        int IdRole = Integer.parseInt(idRole);
        Users user = new Users(username,password,correo,IdRole);
        usersServicio.registrarUsers(user);
        this.accionDefault(request, response);
    }

    public void eliminarUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("idUser");
        int Id = Integer.parseInt(id);
        Users user = usersServicio.buscarUsersPorId(Id);
        usersServicio.eliminarUsers(user);
        this.doGet(request, response);
    }

    public void modificarUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("idUser");
        int IdUser = Integer.parseInt(id);
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String correo = request.getParameter("correo");
        String idRole = request.getParameter("idRole");
        int IdRole = Integer.parseInt(idRole);
        Users user = new Users(IdUser,username,password,correo,IdRole);
        usersServicio.modificarUsers(user);
        this.accionDefault(request, response);
    }
}
