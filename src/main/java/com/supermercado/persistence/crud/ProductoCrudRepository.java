package com.supermercado.persistence.crud;


import com.supermercado.persistence.entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto, Long> {

    List<Producto> findByIdCategoria(long idCategoria);

    //otra manera de usar el metodo es usando anotacion Qerry ambos hace lo mismo eso es de manera nativa
    @Query(value = "SELECT * FROM productos WHERE id_categoria = ? ", nativeQuery = true)
    List<Producto> getByCategoria(long idCategoria);

    List<Producto> findByIdCategoriaOrderByNombreAsc(Long idCategoria);

    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);
}
