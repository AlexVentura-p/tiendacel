/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import dominio.Users;
import java.util.List;

public interface UsersDAO {
    
    public List<Users> findAllUsers();
    
    public Users findUsersById(int id);
    
    public Users findUsersByUsername(Users roles);
    
    public void insertarUsers(Users roles);
    
    public void updateUsers(Users roles);
    
    public void deleteUsers(Users roles);
}
