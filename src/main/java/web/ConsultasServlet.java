/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web;

import dominio.Categorias;
import dominio.Producto;
import dominio.Proveedores;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servicio.CategoriasServ;
import servicio.ProductoServicio;
import servicio.ProveedoresServ;

@WebServlet("/consultas")
public class ConsultasServlet extends HttpServlet{
    @Inject
    ProductoServicio productoServicio;
    
    @Inject
    CategoriasServ categoriaServicio;
    
    @Inject
    ProveedoresServ proveedoresServicio;
    
    @PersistenceContext(unitName = "tiencaCel")
    EntityManager em;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }

    }
        
    protected void accionDefault( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<Producto> productos = productoServicio.listarProductos();
        List<Categorias> categorias = categoriaServicio.listarCategorias();
        List<Proveedores> proveedores = proveedoresServicio.listarProveedores();
        request.setAttribute("categorias", categorias);
        request.setAttribute("proveedores", proveedores);
        request.setAttribute("productos", productos);
        request.getRequestDispatcher("paginas/consultas/listadoConsultas.jsp").forward(request, response);

    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String accion= request.getParameter("accion");
        if(accion != null){
            switch(accion){
                case "consultaUno":
                    this.consultaUno(request, response);
                    break;
                default:
            }
        }else{
            
        }
    }

    private void consultaUno(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int idProveedor = Integer.parseInt(request.getParameter("idProveedor"));
        int idCategoria = Integer.parseInt(request.getParameter("idCategoria"));
        
        List<Producto> productos = productoServicio.findProductosPorCategoriaYProveedor(idCategoria, idProveedor);
        request.setAttribute("productos", productos);
        request.getRequestDispatcher("paginas/consultas/listadoProductosConsulta.jsp").forward(request, response);
        
    }
    
}
