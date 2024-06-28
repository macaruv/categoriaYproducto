package com.ipn.mx.integration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipn.mx.domain.entity.Categoria; 
import com.ipn.mx.domain.entity.Producto; 
import com.ipn.mx.service.CategoriaService;
import com.ipn.mx.service.ProductoService;

//Localhost:8080/api/categorias

//@CrossOrigin(origins = {"*"})
@CrossOrigin(origins = {"http://localhost:4200"}, allowCredentials = "true")
@RestController
@RequestMapping("/api")
public class CategoriaControlador {
	@Autowired
	CategoriaService serviceC;
	
	@Autowired
    private ProductoService productoService;
	
	@PostMapping("/categorias")
	public Categoria create(@RequestBody Categoria categoria) {
	    System.out.println("Datos recibidos: " + categoria); // Añade esto para ver los datos recibidos
	    return serviceC.save(categoria);
	}


	@DeleteMapping("/categorias/{id}")
	@Transactional
	public void deleteCategoriaYProductos(@PathVariable Long id) {
	    // Obtener todos los productos
	    List<Producto> productos = productoService.findAll();
	    
	    // Eliminar cada producto asociado a la categoría con el id especificado
	    for (Producto producto : productos) {
	        if (producto.getIdCategoria().equals(id)) {
	        	productoService.deleteById(producto.getIdProducto());
	        }
	    }
	    // Luego eliminar la categoría
	    serviceC.deleteById(id);
	}

	@PutMapping("/categorias/{id}")
    public Categoria update(@PathVariable Long id, @RequestBody Categoria categoria) {
        categoria.setIdCategoria(id);
        return serviceC.save(categoria);
    }

	@GetMapping("/categorias")
	public List<Categoria> realAll(){
		return serviceC.findAll();
	}
	
    @GetMapping("/categorias/{id}")
    public Categoria findOne(@PathVariable Long id) {
        return serviceC.findById(id);
    }

    @GetMapping("/categorias/random")
    public Categoria random() {
        return serviceC.findRandom();
    }

    
}
