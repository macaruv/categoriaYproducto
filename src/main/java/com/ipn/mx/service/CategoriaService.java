	package com.ipn.mx.service;
	
	import java.util.List;
	
	import com.ipn.mx.domain.entity.Categoria;
	
	public interface CategoriaService {
		Categoria save(Categoria categoria);
	    void deleteById(Long id);
		public List<Categoria> findAll();
	    Categoria findById(Long id);
	    Categoria findRandom();
	}
