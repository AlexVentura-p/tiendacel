/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import datos.ProveedoresDAO;
import dominio.Proveedores;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author alexv
 */
public class ProveedoresServImpl implements ProveedoresServ{

    @Inject
    private ProveedoresDAO proveedoresdao;    
    
    @Override
    public List<Proveedores> listarProveedores() {
        return proveedoresdao.findAllProveedores();
    }

    @Override
    public Proveedores buscarProveedorPorId(int id) {
        return proveedoresdao.findProveedoresById(id);
    }

    @Override
    public Proveedores buscarProveedorPorNombre(Proveedores proveedores) {
        return proveedoresdao.findProveedoresByNombre(proveedores);
    }

    @Override
    public void registrarProveedores(Proveedores proveedores) {
        proveedoresdao.insertarProveedores(proveedores);
    }

    @Override
    public void modificarProveedores(Proveedores proveedores) {
        proveedoresdao.updateProveedores(proveedores);
    }

    @Override
    public void eliminarProveedores(Proveedores proveedores) {
        proveedoresdao.deleteProveedores(proveedores);
    }

    @Override
    public void insertarProveedores(Proveedores proveedores) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateProveedores(Proveedores proveedores) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}