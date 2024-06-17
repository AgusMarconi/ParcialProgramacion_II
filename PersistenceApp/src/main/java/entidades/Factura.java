package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "factura")
public class Factura implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "fecha")
	private String fecha;
	
	@Column(name = "numero")
	private int numero;
	
	@Column(name = "total")
	private double total;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "fk_cliente")
	private Cliente cliente;
	
	//@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	//private List<DetalleFactura> detalles = new ArrayList<DetalleFactura>();
	
	@OneToMany(mappedBy = "factura",cascade = CascadeType.ALL, orphanRemoval = true)
	private List<DetalleFactura> detalles = new ArrayList<DetalleFactura>();
	
	////////////////////////
	public Factura(String fecha, int numero, double total) {
		this.fecha = fecha;
		this.numero = numero;
		this.total = total;
	}
	public Factura(String fecha, int numero, double total, Cliente cliente) {
		this.fecha = fecha;
		this.numero = numero;
		this.total = total;
		this.cliente = cliente;
	}
	
	public Factura(String fecha, int numero, double total, Cliente cliente, List<DetalleFactura> detalles) {

		this.fecha = fecha;
		this.numero = numero;
		this.total = total;
		this.cliente = cliente;
		this.detalles = detalles;
	}
	public Factura() {
	}
	////////////////////////
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	/////
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	/////
	public List<DetalleFactura> getDetalles() {
		return detalles;
	}
	public void setDetalles(List<DetalleFactura> detalles) {
		this.detalles = detalles;
	}
	/////
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	/////
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	/////
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
}
