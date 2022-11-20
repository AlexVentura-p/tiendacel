/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import dominio.Categorias;
import java.util.List;
import javax.ejb.Local;

@Local
public interface CategoriasServ {
    public List<Categorias> listarCategorias();
    
    public Categorias buscarCategoriaPorId(int id);
    
    public Categorias buscarCategoriaPorNombre(Categorias categorias);
    
    public void registrarCategorias(Categorias categorias);
    
    public void modificarCategorias(Categorias categorias);
    
    public void eliminarCategorias(Categorias categorias);

    public void insertarCategorias(Categorias categorias);

    public void updateCategorias(Categorias categorias);
}
