/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web;

import dominio.Categorias;
import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servicio.CategoriasServ;

@WebServlet("/categorias")
public class CategoriasServlet extends HttpServlet {

    @Inject
    CategoriasServ categoriasServ;

    protected void accionDefault(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Categorias> categorias = categoriasServ.listarCategorias();
        System.out.println("categorias = " + categorias);
        request.setAttribute("categorias", categorias);
        request.getRequestDispatcher("paginas/listaCategorias.jsp").forward(request, response);
    }

    protected void editarPagina(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idCategoria = request.getParameter("idCategoria");
        int Id = Integer.parseInt(idCategoria);
        Categorias categoria = categoriasServ.buscarCategoriaPorId(Id);
        request.setAttribute("ctg", categoria);
        request.getRequestDispatcher("paginas/editarCategoria.jsp").forward(request, response);

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
                    this.insertarCategoria(request, response);
                    break;
                case "editar":
                    this.modificarCategoria(request, response);
                    break;
                case "eliminar":
                    this.eliminarCategoria(request, response);
                    break;
                default:
            }
        } else {

        }
    }

    public void insertarCategoria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        Categorias categorias = new Categorias(nombre);
        categoriasServ.registrarCategorias(categorias);
        this.accionDefault(request, response);
    }

    public void eliminarCategoria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("idCategoria");
        int Id = Integer.parseInt(id);
        Categorias categorias = categoriasServ.buscarCategoriaPorId(Id);
        System.out.print(categorias);
        categoriasServ.eliminarCategorias(categorias);
        this.doGet(request, response);
    }

    public void modificarCategoria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id_categoria");
        int Id = Integer.parseInt(id);
        String nombre = request.getParameter("nombre");
        Categorias categorias = categoriasServ.buscarCategoriaPorId(Id);
        categorias.setNombre(nombre);
        categoriasServ.modificarCategorias(categorias);
        this.accionDefault(request, response);
    }
}
