/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import datos.CategoriasDAO;
import dominio.Categorias;
import java.util.List;
import javax.inject.Inject;
public class CategoriasServImpl implements CategoriasServ{

    @Inject
    private CategoriasDAO categoriasdao;    
    
    @Override
    public List<Categorias> listarCategorias() {
        return categoriasdao.findAllCategorias();
    }

    @Override
    public Categorias buscarCategoriaPorId(int id) {
        return categoriasdao.findCategoriasById(id);
    }

    @Override
    public Categorias buscarCategoriaPorNombre(Categorias categorias) {
        return categoriasdao.findCategoriasByNombre(categorias);
    }

    @Override
    public void registrarCategorias(Categorias categorias) {
        categoriasdao.insertarCategorias(categorias);
    }

    @Override
    public void modificarCategorias(Categorias categorias) {
        categoriasdao.updateCategorias(categorias);
    }

    @Override
    public void eliminarCategorias(Categorias categorias) {
        categoriasdao.deleteCategorias(categorias);
    }

    @Override
    public void insertarCategorias(Categorias categorias) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateCategorias(Categorias categorias) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}