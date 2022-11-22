/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import dominio.Proveedores;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class ProveedoresDAOImpl implements ProveedoresDAO{
    @PersistenceContext(unitName = "tiencaCel")
    EntityManager em;

    @Override
    public List<Proveedores> findAllProveedores() {
        return em.createNamedQuery("Proveedores.findAll").getResultList();
    }

    @Override
    public Proveedores findProveedoresById(int id) {
        return em.find(Proveedores.class, id);
    }

    @Override
    public Proveedores findProveedoresByNombre(Proveedores proveedores) {
        Query query = em.createQuery("from Proveedores p where p.nomb_proveedor =:nombre");
        query.setParameter("nombre", proveedores.getNombre());
        return (Proveedores) query.getSingleResult();
    }

    @Override
    public void insertarProveedores(Proveedores proveedores) {
        em.persist(proveedores);
    }

    @Override
    public void updateProveedores(Proveedores proveedores) {
        em.merge(proveedores);
    }

    @Override
    public void deleteProveedores(Proveedores proveedores) {
        em.remove(em.merge(proveedores));
    }

    public int insertar(Proveedores proveedores) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
