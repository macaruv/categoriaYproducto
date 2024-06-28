package com.ipn.mx.domain.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="producto")
public class Producto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idproducto", nullable = false)
	private Long idProducto;
	
	@Column(name="nombreproducto", length=50, nullable = false)
	private String nombreProducto;
	
	@Column(name="descripcionproducto", length=250, nullable = false)
	private String descripcionProducto;
	
	@Column(name="existenciaproducto", nullable = false)
	private int existenciaProducto;
	
	@Column(name="precioproducto", nullable = false)
	private double precioProducto;

	@Column(name="idcategoria", nullable = false)
	private Long idCategoria;
}	

