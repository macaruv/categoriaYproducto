package com.ipn.mx.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ipn.mx.domain.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria,Long>{
	/*
	 delimiter $$
	 create procedure spProductosCategoria()
	 begin
	 select c.nombreCategoria as categoria, 
	 count(*) as cantidad from Producto p,
	 Categoria as c where c.idCategoria = p.idCategoria
	 group by c.idCategoria;
	 end $$
	 delimiter ; 
	 
	 select idProdcuto, nombreProducto, idCategoria from producto;
	 
	 */
}
