package com.ipn.mx.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ipn.mx.domain.entity.Categoria;
import com.ipn.mx.domain.repository.CategoriaRepository;

@Service
public class CategoriaServiceImpl implements CategoriaService{

	@Autowired
	CategoriaRepository repository;

	@Override
	@Transactional
	public Categoria save(Categoria categoria) {
		return repository.save(categoria);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		repository.deleteById(id);	
		
		
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Categoria> findAll() {
		return (List<Categoria>) repository.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
    public Categoria findById(Long id) {
        return repository.findById(id).orElse(null);
    }
	
	@Override
	@Transactional(readOnly = true)
    public Categoria findRandom() {
        List<Categoria> categorias = (List<Categoria>) repository.findAll();
        return categorias.isEmpty() ? null : categorias.get(new Random().nextInt(categorias.size()));
    }
	
	
	
	
	
}
