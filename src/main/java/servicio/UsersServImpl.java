/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import datos.UsersDAO;
import dominio.Users;
import java.util.List;
import javax.inject.Inject;
public class UsersServImpl implements UsersServ{

    @Inject
    private UsersDAO usersdao;    
    
    @Override
    public List<Users> listarUsers() {
        return usersdao.findAllUsers();
    }

    @Override
    public Users buscarUsersPorId(int id) {
        return usersdao.findUsersById(id);
    }

    @Override
    public Users buscarUsersPorUsername(Users users) {
        return usersdao.findUsersByUsername(users);
    }

    @Override
    public void registrarUsers(Users users) {
        usersdao.insertarUsers(users);
    }

    @Override
    public void modificarUsers(Users users) {
        usersdao.updateUsers(users);
    }

    @Override
    public void eliminarUsers(Users users) {
        usersdao.deleteUsers(users);
    }


}