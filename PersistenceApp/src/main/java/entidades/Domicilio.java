package entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "domicilio")
public class Domicilio implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "nombreCalle")
	private String nombreCalle;
	
	@Column(name = "altura")
	private int altura;
	
	@OneToOne(mappedBy = "domicilio")
	private Cliente cliente;
	///////////////////
	public Domicilio(String nombreCalle, int altura) {
		this.nombreCalle = nombreCalle;
		this.altura = altura;
	}

	public Domicilio(String nombreCalle, int altura, Cliente cliente) {
		this.nombreCalle = nombreCalle;
		this.altura = altura;
		this.cliente = cliente;
	}

	public Domicilio() {
	}
	////////////////////
	public long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	//////
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	////////
	public String getNombreCalle() {
		return nombreCalle;
	}
	public void setNombreCalle(String nombreCalle) {
		this.nombreCalle = nombreCalle;
	}
	////////
	public int getAltura() {
		return altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	
	
}
