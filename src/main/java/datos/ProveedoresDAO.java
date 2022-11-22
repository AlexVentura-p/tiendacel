/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import dominio.Proveedores;
import java.util.List;

/**
 *
 * @author alexv
 */
public interface ProveedoresDAO {
    
    public List<Proveedores> findAllProveedores();
    
    public Proveedores findProveedoresById(int id);
    
    public Proveedores findProveedoresByNombre(Proveedores proveedores);
    
    public void insertarProveedores(Proveedores proveedores);
    
    public void updateProveedores(Proveedores proveedores);
    
    public void deleteProveedores(Proveedores proveedores);
}
