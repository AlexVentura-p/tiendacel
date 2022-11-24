/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({
    @NamedQuery(name = "DetalleFactura.findAll", query="SELECT d from DetalleFactura d ORDER BY d.id_detalle")
})
@Table(name = "detalle_factura")
public class DetalleFactura implements Serializable {
    
     private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_detalle_factura")
    private int id_detalle;
    
    @Column(name= "id_factura")
    private int id_factura;
    
    @Column(name="id_producto")
    private  int id_producto;
    
    @Column(name="cantidad_unidades")
    private int cantidad_unidades;

    public void setCantidad_unidades(int cantidad_unidades) {
        this.cantidad_unidades = cantidad_unidades;
    }

    public int getCantidad_unidades() {
        return cantidad_unidades;
    }
      
    @Column(name="precio_unitario")
    private double precio_unitario;
    
    @Column(name="total")
    private double total;

    public DetalleFactura() {
    }

    public DetalleFactura(int id_factura, int id_producto, int cantidad_unidades, double precio_unitario, double total) {
        this.id_factura = id_factura;
        this.id_producto = id_producto;
        this.cantidad_unidades = cantidad_unidades;
        this.precio_unitario = precio_unitario;
        this.total = total;
    }

    public DetalleFactura(int id_detalle, int id_factura, int id_producto, int cantidad_unidades, double precio_unitario, double total) {
        this.id_detalle = id_detalle;
        this.id_factura = id_factura;
        this.id_producto = id_producto;
        this.cantidad_unidades = cantidad_unidades;
        this.precio_unitario = precio_unitario;
        this.total = total;
    }

    

    public int getId_detalle() {
        return id_detalle;
    }

    public int getId_factura() {
        return id_factura;
    }

    public int getId_producto() {
        return id_producto;
    }

    public double getPrecio_unitario() {
        return precio_unitario;
    }

    public double getTotal() {
        return total;
    }

    public void setId_detalle(int id_detalle) {
        this.id_detalle = id_detalle;
    }

    public void setId_factura(int id_factura) {
        this.id_factura = id_factura;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public void setPrecio_unitario(double precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "DetalleFactura{" + "id_detalle=" + id_detalle + ", id_factura=" + id_factura + ", id_producto=" + id_producto + ", cantidad_unidades=" + cantidad_unidades + ", precio_unitario=" + precio_unitario + ", total=" + total + '}';
    }
    
    
}
