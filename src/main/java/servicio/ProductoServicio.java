/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import dominio.Producto;
import java.util.List;
import javax.ejb.Local;

@Local
public interface ProductoServicio {
    public List<Producto> listarProductos();
    
    public Producto encontrarProductoPorId(int id);
    
    public Producto encontrarProductoPorNombre(Producto producto);
    
    public void registrarProducto(Producto producto);
    
    public void modificarProducto(Producto producto);
    
    public void eliminarProducto(Producto producto);
}
