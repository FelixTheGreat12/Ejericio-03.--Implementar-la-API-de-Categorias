package com.upiiz.categorias.services;

import com.upiiz.categorias.models.Categoria;
import com.upiiz.categorias.repository.CategoriaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

// Se crea una instancia
@Service

public class CategoriasService {
    // Requirimos REPO - Categoria

    CategoriaRepository categoriaRepository;


    public CategoriasService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    // GET - Todas las categorias
    public List<Categoria> getAllCategorias(){
        return categoriaRepository.getCategorias();
    }
    // GET - Categoria por ID
    public Categoria getCategoriaById(Long id){
        return categoriaRepository.obtenerporId(id);
    }
    // POST - Crear categoria
    public Categoria createCategoria(Categoria categoria){
        return categoriaRepository.guardar(categoria);
    }
    // PUT - Actualizar categoria
    public Categoria updateCategoria(Categoria categoria){
        return categoriaRepository.actualizar(categoria);
    }
    // DELETE
    public void deleteCategoria(Long id){
        categoriaRepository.eliminar(id);
    }


}
