/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import dominio.Roles;
import java.util.List;

public interface RolesDAO {
    
    public List<Roles> findAllRoles();
    
    public Roles findRolesById(int id);
    
    public Roles findRolesByNombre(Roles roles);
    
    public void insertarRoles(Roles roles);
    
    public void updateRoles(Roles roles);
    
    public void deleteRoles(Roles roles);
}
