package com.ipn.mx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import com.ipn.mx.domain.dto.ProductosCategoria;
import com.ipn.mx.domain.entity.Producto;
import com.ipn.mx.domain.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService{
	@Autowired
	ProductoRepository repository;

    ProductoServiceImpl(ProductoRepository repository) {
        this.repository = repository;
    }
	
//	@Override
//	@Transactional(readOnly = true)
//	public List<ProductosCategoria> ProductoxCategoria(){
//		List<Object[]> resultados = repository.contarProdcutoxCategoria();
//		List<ProductosCategoria> lista = new ArrayList<>();
//		for (Object[] registro : resultados) {
//			ProductosCategoria pc = new ProductosCategoria();
//			pc.setCategoria((String) registro[0]);
//			pc.setCantidad((Long) registro[1]);
//			lista.add(pc);
//		}
//		return lista;
//	}

	@Override
	@Transactional(readOnly = true)
	public List<Producto> findAll() {
		return (List<Producto> )repository.findAll();
	}

	@Override
	public Producto findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public Producto save(Producto producto) {
		// TODO Auto-generated method stub
		return repository.save(producto);
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);		
	}
}
