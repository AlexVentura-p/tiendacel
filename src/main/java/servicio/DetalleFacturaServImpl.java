/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;


import datos.DetalleFacturaDAO;
import dominio.DetalleFactura;
import java.util.List;
import javax.inject.Inject;
/**
 *
 * @author Allan
 */
public class DetalleFacturaServImpl implements DetalleFacturaServicio {
    
    @Inject
     DetalleFacturaDAO detalle ;
     
    @Override
    public List<DetalleFactura> listarDetalle() {
        return detalle.findAllDetalles();
    }

    @Override
    public DetalleFactura EncontrarDetallePorId(int id) {
       return detalle.findDetalleById(id);
    }

    @Override
    public void registrarDetalle(DetalleFactura df) {
        detalle.insertarDetalle(df);
    }

    @Override
    public void modificarDetalle(DetalleFactura df) {
        detalle.updateDetalle(df);
    }

    @Override
    public void eliminarDetalle(DetalleFactura df) {
        detalle.deleteDetalle(df);
    }
    
}
