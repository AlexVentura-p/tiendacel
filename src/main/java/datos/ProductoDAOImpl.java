/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import dominio.Producto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class ProductoDAOImpl implements ProductoDAO{
    @PersistenceContext(unitName = "tiencaCel")
    EntityManager em;

    @Override
    public List<Producto> findAllProductos() {
        return em.createNamedQuery("Producto.findAll").getResultList();
    }

    @Override
    public Producto findProductoById(int id) {
        return em.find(Producto.class, id);
    }

    @Override
    public Producto findProductoByNombre(Producto producto) {
        Query query = em.createQuery("from Productos p where p.nomb_producto =:nombre");
        query.setParameter("nombre", producto.getNombre());
        return (Producto) query.getSingleResult();
    }

    @Override
    public void insertarProducto(Producto producto) {
        em.persist(producto);
    }

    @Override
    public void updateProducto(Producto producto) {
        em.merge(producto);
    }

    @Override
    public void deleteProducto(Producto producto) {
        em.remove(em.merge(producto));
    }

    @Override
    public List<Producto> findProductosPorCategoriaYProveedor(int idCategoria,int idProveedor) {
        //Query query = em.createQuery("from Productos p where p.id_categoria =:id_categoria and p.id_proveedor=:id_proveedor");
        Query query = em.createNamedQuery("Producto.findCategoryProveedor");
        query.setParameter("id_categoria", idCategoria);
        query.setParameter("id_proveedor", idProveedor);
        return query.getResultList();
    }
    
}
