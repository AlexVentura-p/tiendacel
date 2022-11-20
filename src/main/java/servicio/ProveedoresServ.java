/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import dominio.Proveedores;
import java.util.List;
import javax.ejb.Local;

@Local
public interface ProveedoresServ {
    public List<Proveedores> listarProveedores();
    
    public Proveedores buscarProveedorPorId(int id);
    
    public Proveedores buscarProveedorPorNombre(Proveedores proveedores);
    
    public void registrarProveedores(Proveedores proveedores);
    
    public void modificarProveedores(Proveedores proveedores);
    
    public void eliminarProveedores(Proveedores proveedores);

    public void insertarProveedores(Proveedores proveedores);

    public void updateProveedores(Proveedores proveedores);
}
