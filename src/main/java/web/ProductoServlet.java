/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web;

import dominio.Producto;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servicio.ProductoServicio;

@WebServlet("/productos")
public class ProductoServlet extends HttpServlet{
    @Inject
    ProductoServicio productoServicio;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "modificar":
                    this.editarProductoView(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }

    }
        
    protected void accionDefault( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<Producto> productos = productoServicio.listarProductos();
        System.out.println("productos = " + productos);
        request.setAttribute("productos", productos);
        request.getRequestDispatcher("paginas/listadoProductos.jsp").forward(request, response);

    }
    
    private void editarProductoView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        int idProducto = Integer.parseInt(request.getParameter("idProducto"));
        Producto producto = productoServicio.encontrarProductoPorId(idProducto);
        request.setAttribute("producto", producto);
        String jspEditar = "/paginas/producto/editarProducto.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String accion= request.getParameter("accion");
        if(accion != null){
            switch(accion){
                case "insertar":
                    this.insertarProducto(request, response);
                    break;
                case "modificar":
                    this.modificarProducto(request, response);
                    break;
                case "eliminar":
                    this.eliminarProducto(request, response);
                    break;
                default:
            }
        }else{
            
        }
    }
    
    public void insertarProducto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String categoria = request.getParameter("categoria");
        int Categoria = Integer.parseInt(categoria);
        String proveedor = request.getParameter("proveedor");
        int Proveedor = Integer.parseInt(proveedor);
        String nombre = request.getParameter("nombre");
        BigDecimal precio =  new BigDecimal(request.getParameter("precio"));
        Producto producto = new Producto(Categoria,Proveedor,nombre,precio);
        productoServicio.registrarProducto(producto);
        this.doGet(request, response);
    }
    
    public void eliminarProducto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        String id = request.getParameter("idProducto");
        int Id = Integer.parseInt(id);
        Producto producto = productoServicio.encontrarProductoPorId(Id);
        System.out.print(producto);
        productoServicio.eliminarProducto(producto);
        this.doGet(request, response);
    }

    private void modificarProducto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String idProducto = request.getParameter("idProducto");
        int IdProducto = Integer.parseInt(idProducto);
        String categoria = request.getParameter("id_categoria");
        int Categoria = Integer.parseInt(categoria);
        String proveedor = request.getParameter("id_proveedor");
        int Proveedor = Integer.parseInt(proveedor);
        String nombre = request.getParameter("nombre");
        BigDecimal precio =  new BigDecimal(request.getParameter("precio"));
        Producto producto = new Producto(IdProducto,Categoria,Proveedor,nombre,precio);
        productoServicio.modificarProducto(producto);
        this.accionDefault(request, response);
    }
    
}
