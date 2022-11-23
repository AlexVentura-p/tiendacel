/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import dominio.Roles;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class RolesDAOImpl implements RolesDAO{
    @PersistenceContext(unitName = "tiencaCel")
    EntityManager em;

    @Override
    public List<Roles> findAllRoles() {
        return em.createNamedQuery("Roles.findAll").getResultList();
    }

    @Override
    public Roles findRolesById(int id) {
        return em.find(Roles.class, id);
    }

    @Override
    public Roles findRolesByNombre(Roles roles) {
        Query query = em.createQuery("from Roles r where r.name =:name");
        query.setParameter("name", roles.getName());
        return (Roles) query.getSingleResult();
    }

    @Override
    public void insertarRoles(Roles roles) {
        em.persist(roles);
    }

    @Override
    public void updateRoles(Roles roles) {
        em.merge(roles);
    }

    @Override
    public void deleteRoles(Roles roles) {
        em.remove(em.merge(roles));
    }


}
