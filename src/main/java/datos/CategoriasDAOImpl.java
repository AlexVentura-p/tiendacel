/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import dominio.Categorias;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class CategoriasDAOImpl implements CategoriasDAO{
    @PersistenceContext(unitName = "tiencaCel")
    EntityManager em;

    @Override
    public List<Categorias> findAllCategorias() {
        return em.createNamedQuery("Categorias.findAll").getResultList();
    }

    @Override
    public Categorias findCategoriasById(int id) {
        return em.find(Categorias.class, id);
    }

    @Override
    public Categorias findCategoriasByNombre(Categorias categorias) {
        Query query = em.createQuery("from Categorias p where p.nombre_categoria =:nombre");
        query.setParameter("nombre", categorias.getNombre());
        return (Categorias) query.getSingleResult();
    }

    @Override
    public void insertarCategorias(Categorias categorias) {
        em.persist(categorias);
    }

    @Override
    public void updateCategorias(Categorias categorias) {
        em.merge(categorias);
    }

    @Override
    public void deleteCategorias(Categorias categorias) {
        em.remove(em.merge(categorias));
    }

    public int insertar(Categorias categorias) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
