/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import datos.ProductoDAO;
import dominio.Producto;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author alexv
 */
public class ProductoServicioImpl implements ProductoServicio{

    @Inject
    private ProductoDAO productodao;    
    
    @Override
    public List<Producto> listarProductos() {
        return productodao.findAllProductos();
    }

    @Override
    public Producto encontrarProductoPorId(int id) {
        return productodao.findProductoById(id);
    }

    @Override
    public Producto encontrarProductoPorNombre(Producto producto) {
        return productodao.findProductoByNombre(producto);
    }

    @Override
    public void registrarProducto(Producto producto) {
        productodao.insertarProducto(producto);
    }

    @Override
    public void modificarProducto(Producto producto) {
        productodao.updateProducto(producto);
    }

    @Override
    public void eliminarProducto(Producto producto) {
        productodao.deleteProducto(producto);
    }
    
}
