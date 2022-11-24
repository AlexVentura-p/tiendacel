/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web;

import dominio.DetalleFactura;
import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servicio.DetalleFacturaServicio;

/**
 *
 * @author Allan
 */
@WebServlet("/detalles")
public class DetalleFacturaServlet extends HttpServlet {
    
    @Inject
    DetalleFacturaServicio dfs;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
         String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "modificar":
                    this.editarDetalleView(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }
    
    
     protected void accionDefault( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
       
    List <DetalleFactura> detalles = dfs.listarDetalle();
        System.out.println("detalles= "+detalles);
        request.setAttribute("detalles",detalles);
        request.getRequestDispatcher("paginas/listadoDetalle.jsp").forward(request, response);
    }
    
    
      @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String accion= request.getParameter("accion");
        if(accion != null){
            switch(accion){
                case "insertar":
                    this.insertarDetalle(request,response);
                    break;
                case "modificar":
                   this.modificarDetalle(request, response);
                    break;
                case "eliminar":
                   this.eliminarDetalle(request, response);
                    break;
                default:
            }
        }else{
            
        }   
    }
    
    
    public void insertarDetalle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        String Id_factura= request.getParameter("id_factura");
        int id_factura = Integer.parseInt(Id_factura);
        String Id_producto= request.getParameter("id_producto");
        int id_producto= Integer.parseInt(Id_producto);
        String Cantidad = request.getParameter("cantidad");
        int cantidad = Integer.parseInt(Cantidad);
        String Precio = request.getParameter("precio");
        double precio = Double.parseDouble(Precio);
        String Total = request.getParameter("total");
        double total = Double.parseDouble(Total);
        DetalleFactura df = new DetalleFactura(id_factura,id_producto,cantidad,precio,total);
        dfs.registrarDetalle(df);
        this.accionDefault(request, response);
        
    }
    
    public void eliminarDetalle(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
        String Id =  request.getParameter("idDetalle");
        int id = Integer.parseInt(Id);
        DetalleFactura df =  dfs.EncontrarDetallePorId(id);
        System.out.println(id);
        dfs.eliminarDetalle(df);
        this.accionDefault(request, response);
    }
    
      private void editarDetalleView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String idDetalle = request.getParameter("idDetalle");
        int id = Integer.parseInt(idDetalle);
        DetalleFactura detalle = dfs.EncontrarDetallePorId(id);
        request.setAttribute("detalle",detalle);
        String jspEditar = "WEB-INF/modales/detalle/editarDetalle.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);
    }
      
      
     public void modificarDetalle (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String Id_detalle =  request.getParameter("idDetalle");
        int id_detalle = Integer.parseInt(Id_detalle);
        String Id_factura= request.getParameter("id_factura");
        int id_factura = Integer.parseInt(Id_factura);
        String Id_producto = request.getParameter("id_producto");
        int id_producto= Integer.parseInt(Id_producto);
        String Cantidad = request.getParameter("cantidad_unidades");
        int cantidad = Integer.parseInt(Cantidad);
        String Precio = request.getParameter("precio");
        double precio = Double.parseDouble(Precio);
        String Total = request.getParameter("total");
        double total = Double.parseDouble(Total);
        DetalleFactura df = new DetalleFactura(id_detalle,id_factura,id_producto,cantidad,precio,total);
        dfs.modificarDetalle(df);
        this.accionDefault(request, response);
      
     }
}
