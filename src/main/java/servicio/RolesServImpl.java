/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import datos.RolesDAO;
import dominio.Roles;
import java.util.List;
import javax.inject.Inject;
public class RolesServImpl implements RolesServ{

    @Inject
    private RolesDAO rolesdao;    
    
    @Override
    public List<Roles> listarRoles() {
        return rolesdao.findAllRoles();
    }

    @Override
    public Roles buscarRolesPorId(int id) {
        return rolesdao.findRolesById(id);
    }

    @Override
    public Roles buscarRolesPorNombre(Roles role) {
        return rolesdao.findRolesByNombre(role);
    }

    @Override
    public void registrarRoles(Roles role) {
        rolesdao.insertarRoles(role);
    }

    @Override
    public void modificarRoles(Roles role) {
        rolesdao.updateRoles(role);
    }

    @Override
    public void eliminarRoles(Roles role) {
        rolesdao.deleteRoles(role);
    }


}