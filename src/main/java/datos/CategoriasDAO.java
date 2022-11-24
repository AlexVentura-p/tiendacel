/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import dominio.Categorias;
import java.util.List;

public interface CategoriasDAO {
    
    public List<Categorias> findAllCategorias();
    
    public Categorias findCategoriasById(int id);
    
    public Categorias findCategoriasByNombre(Categorias categorias);
    
    public void insertarCategorias(Categorias categorias);
    
    public void updateCategorias(Categorias categorias);
    
    public void deleteCategorias(Categorias categorias);
}
