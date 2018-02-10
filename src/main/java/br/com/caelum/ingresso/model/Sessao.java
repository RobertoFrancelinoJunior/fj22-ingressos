package br.com.caelum.ingresso.model;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Sessao {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private LocalTime horario;
	
	@ManyToOne
	private Sala sala;
	
	@ManyToOne
	private Filme filme;

	private BigDecimal preco;
	
	@OneToMany(mappedBy="sessao", fetch=FetchType.EAGER)
	private Set<Ingresso> ingressos = new HashSet<>();
	
	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public boolean isDisponivel(Lugar lugarSelecionado)
	{
		return ingressos.stream().map(Ingresso::getLugar).noneMatch(lugar -> lugar.equals(lugarSelecionado));
	}
	
	public Sessao()
	{
	}

	public Sessao(LocalTime horario, Filme filme, Sala sala)
	{
		this.horario = horario;
		this.filme = filme;
		this.sala = sala;
	}
	
	public void setId(Integer id)
	{
		this.id = id;
	}
	
	public Integer getId()
	{
		return this.id;
	}
	
	public void setSala(Sala sala)
	{
		this.sala = sala;
	}
	
	public Sala getSala()
	{
		return this.sala;
	}
	
	public void setFilme(Filme filme)
	{
		this.filme = filme;
	}
	
	public Filme getFilme()
	{
		return this.filme;
	}
	
	public void setHorario(LocalTime horario)
	{
		this.horario = horario;
	}
	
	public LocalTime getHorario()
	{
		return this.horario;
	}
	
	public Map<String, List<Lugar>> getMapaDeLugares()
	{
		return sala.getMapaDeLugares();
	}
}