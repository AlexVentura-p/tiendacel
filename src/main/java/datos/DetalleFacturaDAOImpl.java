/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import dominio.DetalleFactura;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 *
 * @author Allan
 */
@Stateless
public class DetalleFacturaDAOImpl implements DetalleFacturaDAO {

    @PersistenceContext(unitName = "tiencaCel")
    EntityManager em;

    @Override
    public List<DetalleFactura> findAllDetalles() {
        return em.createNamedQuery("DetalleFactura.findAll").getResultList();
    }

    @Override
    public DetalleFactura findDetalleById(int id) {
       return em.find(DetalleFactura.class, id);
    }

    @Override
    public void insertarDetalle(DetalleFactura df) {
        em.persist(df);
    }

    @Override
    public void updateDetalle(DetalleFactura df) {
        em.merge(df);
    }

    @Override
    public void deleteDetalle(DetalleFactura df) {
        em.remove(em.merge(df));
    }
    
}
