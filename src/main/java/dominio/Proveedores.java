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
    @NamedQuery(name = "Proveedores.findAll", query="SELECT p from Proveedores p ORDER BY p.id_proveedor")
})
@Table(name = "proveedores")
public class Proveedores implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proveedor")
    private int id_proveedor;
        
    @Column(name = "nomb_proveedor")
    private String nombre;
    
    @Column(name = "tel_proveedor")
    private String telefono;

    public Proveedores(){
        
    }
    
    public Proveedores(int id_proveedor, String nombre, String telefono) {
        this.id_proveedor = id_proveedor;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public Proveedores(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;

    }
    
    /*public Proveedores(int id_proveedor, String nombre, String telefono) {
        this.id_proveedor = id_proveedor;
        this.nombre = nombre;
        this.telefono = telefono;
    }*/
    
    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
}
