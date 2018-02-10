package br.com.caelum.ingresso.model;

import java.math.BigDecimal;

import javax.persistence.*;


import br.com.caelum.ingresso.model.descontos.Desconto;

@Entity
public class Ingresso {
	@Id
	@GeneratedValue
	private Integer id;
	
	@ManyToOne
	private Sessao sessao;
	
	private BigDecimal preco;

	@ManyToOne
	private Lugar lugar;
	
	@Enumerated(EnumType.STRING)
	private TipoDeIngresso tipoDeIngresso;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public TipoDeIngresso getTipoDeIngresso() {
		return tipoDeIngresso;
	}

	public void setTipoDeIngresso(TipoDeIngresso tipoDeIngresso) {
		this.tipoDeIngresso = tipoDeIngresso;
	}

	public Sessao getSessao() {
		return sessao;
	}

	public Lugar getLugar() {
		return lugar;
	}

	public void setLugar(Lugar lugar) {
		this.lugar = lugar;
	}

	public void setSessao(Sessao sessao) {
		this.sessao = sessao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Ingresso(){
	}
	
	public Ingresso(Sessao sessao, Desconto tipoDeDesconto, Lugar lugar, TipoDeIngresso tipoIngresso)
	{
		this.sessao = sessao;
		this.preco = tipoDeDesconto.aplicarDescontoSobre(sessao.getPreco());
		this.lugar = lugar;
		this.tipoDeIngresso = tipoIngresso;
	}
	
	public Ingresso(Sessao sessao, TipoDeIngresso tipoIngresso, Lugar lugar)
	{
		this.sessao = sessao;
		this.lugar = lugar;
		this.tipoDeIngresso = tipoIngresso;
	}
}