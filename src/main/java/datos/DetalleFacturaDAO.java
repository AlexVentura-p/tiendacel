
package datos;

import dominio.DetalleFactura;
import java.util.List;


public interface DetalleFacturaDAO {
     public List<DetalleFactura> findAllDetalles();
    
    public DetalleFactura findDetalleById(int id);
    
    public void insertarDetalle(DetalleFactura df);
    
    public void updateDetalle(DetalleFactura df);
    
    public void deleteDetalle(DetalleFactura df);
}
