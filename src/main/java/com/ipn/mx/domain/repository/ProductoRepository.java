package com.ipn.mx.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ipn.mx.domain.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto,Long>{
//	@Transactional
//	@Query(value = "call spProductosCategoria()",nativeQuery = true)
//	public List<Object[]> contarProdcutoxCategoria();
	
}
