/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import dominio.Roles;
import java.util.List;
import javax.ejb.Local;

@Local
public interface RolesServ {
    public List<Roles> listarRoles();
    
    public Roles buscarRolesPorId(int id);
    
    public Roles buscarRolesPorNombre(Roles role);
    
    public void registrarRoles(Roles role);
    
    public void modificarRoles(Roles role);
    
    public void eliminarRoles(Roles role);

}
