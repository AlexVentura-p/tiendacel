/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package servicio;

import dominio.DetalleFactura;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Allan
 */
@Local
public interface DetalleFacturaServicio {
   public List<DetalleFactura> listarDetalle();
   public DetalleFactura EncontrarDetallePorId (int id);
   public void registrarDetalle (DetalleFactura df);
   public void modificarDetalle (DetalleFactura df);
   public void eliminarDetalle (DetalleFactura df);
   
}
