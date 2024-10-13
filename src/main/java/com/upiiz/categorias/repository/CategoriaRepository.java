package com.upiiz.categorias.repository;

import com.upiiz.categorias.models.Categoria;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class CategoriaRepository{
    // Almacenar en un listado las categorias: salvar, listar, eliminar
    // Generar de manera unica el id para cada categoria
    private List<Categoria> categorias = new ArrayList<Categoria>();
    private AtomicLong id = new AtomicLong();

    // Agregamos la categoria al listado y la regresamos
    public Categoria guardar(Categoria categoria){
        categoria.setId(id.incrementAndGet());
        categorias.add(categoria);
        return categoria;
    }

    // GET - Todas las categorias
    public List<Categoria> getCategorias(){
        return categorias;
    }
    // GET - Solo una categoria
    public Categoria obtenerporId(long id){
        /*
        // Estructurada
        for(Categoria categoria : categorias){
            if(categoria.getId().equals(id)){
                return categoria;
            }
        }
        return null;
        */
        // Funcional
        return categorias.stream().filter(categoria -> categoria.getId().equals(id)).findFirst().orElse(null);

    }
    // POST

    // DELETE
    public void eliminar(Long id){
        categorias.removeIf(categoria -> categoria.getId().equals(id));
    }

    // PUT
    public Categoria actualizar(Categoria categoria){
        eliminar(categoria.getId());
        categorias.add(categoria);
        return categoria;
    }

}
