package com.ipn.mx.integration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

//import com.ipn.mx.domain.dto.ProductosCategoria;
import com.ipn.mx.domain.entity.Producto;
import com.ipn.mx.service.ProductoService;


//Localhost:8080/apiProducto/productosPorCategoria

@CrossOrigin(origins = {"http://localhost:4200"}, allowCredentials = "true")
@RestController
@RequestMapping("/apiProducto")
public class ProductoController {

	@Autowired
	ProductoService service;
	
//	@GetMapping("/productosPorCategoria")
//	public List<ProductosCategoria> ProductoxCategoria(){
//		return service.ProductoxCategoria();
//	}
	
	@GetMapping("/productos")
	public List<Producto> mostrarProductos(){
		return service.findAll();
	}
	
	@PostMapping("/productos")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto save(@RequestBody Producto producto) {
		return service.save(producto);
	}
	
	@DeleteMapping("/productos/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }
	
	@GetMapping("/productos/{id}")
    public Producto findOne(@PathVariable Long id) {
        return service.findById(id);
    }
	
	@PutMapping("/productos/{id}")
    public Producto updateProducto(@PathVariable Long id, @RequestBody Producto producto) {
        return service.update(id, producto);
    }


	
}
