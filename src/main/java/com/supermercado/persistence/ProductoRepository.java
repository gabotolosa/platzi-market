package com.supermercado.persistence;

import com.supermercado.persistence.crud.ProductoCrudRepository;
import com.supermercado.persistence.entity.Producto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository {

    private ProductoCrudRepository productoCrudRepository;

    public List<Producto> getAllProductos(){
        return (List<Producto>) productoCrudRepository.findAll();
    }

    public List<Producto> getByCategoria(Long idCategoria){
        return productoCrudRepository.findByIdCategoria(idCategoria);
    }

    public List<Producto> getByCategoriaOrderByNombreAsc(Long idCategoria){
        return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }

    public Optional<List<Producto>> getEscasos(int cantidadStock, boolean estado){
        return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidadStock, true);
    }

    public Optional<Producto> getProducto(long idProducto){
        return productoCrudRepository.findById(idProducto);
    }

    public Producto saveProducto(Producto producto){
        return productoCrudRepository.save(producto);
    }

    public void deleteProducto(long idProducto){
        productoCrudRepository.deleteById(idProducto);
    }

}
