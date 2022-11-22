/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import dominio.Producto;
import java.util.List;

/**
 *
 * @author alexv
 */
public interface ProductoDAO {
    
    public List<Producto> findAllProductos();
    
    public Producto findProductoById(int id);
    
    public Producto findProductoByNombre(Producto producto);
    
    public void insertarProducto(Producto producto);
    
    public void updateProducto(Producto producto);
    
    public void deleteProducto(Producto producto);
}
