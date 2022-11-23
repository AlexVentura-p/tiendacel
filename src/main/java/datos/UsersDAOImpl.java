/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import dominio.Users;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class UsersDAOImpl implements UsersDAO{
    @PersistenceContext(unitName = "tiencaCel")
    EntityManager em;

    @Override
    public List<Users> findAllUsers() {
        return em.createNamedQuery("Users.findAll").getResultList();
    }

    @Override
    public Users findUsersById(int id) {
        return em.find(Users.class, id);
    }

    @Override
    public Users findUsersByUsername(Users users) {
        Query query = em.createQuery("from Users u where u.username =:username");
        query.setParameter("username", users.getUsername());
        return (Users) query.getSingleResult();
    }

    @Override
    public void insertarUsers(Users users) {
        em.persist(users);
    }

    @Override
    public void updateUsers(Users users) {
        em.merge(users);
    }

    @Override
    public void deleteUsers(Users users) {
        em.remove(em.merge(users));
    }


}
