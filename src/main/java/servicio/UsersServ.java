/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import dominio.Users;
import java.util.List;
import javax.ejb.Local;

@Local
public interface UsersServ {
    public List<Users> listarUsers();
    
    public Users buscarUsersPorId(int id);
    
    public Users buscarUsersPorUsername(Users users);
    
    public void registrarUsers(Users users);
    
    public void modificarUsers(Users users);
    
    public void eliminarUsers(Users users);

}
