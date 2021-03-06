package br.com.caelum.ingresso.model.form;

import java.time.LocalTime;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.caelum.ingresso.dao.FilmeDao;
import br.com.caelum.ingresso.dao.SalaDao;
import br.com.caelum.ingresso.model.Filme;
import br.com.caelum.ingresso.model.Sala;
import br.com.caelum.ingresso.model.Sessao;

public class SessaoForm {
	
	private Integer id;
	
	@NotNull
	private Integer salaId;
	
	@DateTimeFormat(pattern="HH:mm")
	@NotNull
	private LocalTime horario;
	
	@NotNull
	private Integer filmeId;
	
	public Sessao toSessao(SalaDao salaDao, FilmeDao filmeDao)
	{
		Filme filme = filmeDao.findOne(filmeId);
		Sala sala = salaDao.findOne(salaId);
		
		Sessao sessao = new Sessao(this.horario, filme, sala);
		
		return sessao;
	}
	
	public void setId(Integer id)
	{
		this.id = id;
	}
	
	public Integer getId()
	{
		return this.id;
	}
	
	public void setSalaId(Integer salaId)
	{
		this.salaId = salaId;
	}
	
	public Integer getSalaId()
	{
		return this.salaId;
	}
	
	public void setHorario(LocalTime horario)
	{
		this.horario = horario;
	}
	
	public LocalTime getHorario()
	{
		return this.horario;
	}
	
	public void setFilmeId(Integer filmeId)
	{
		this.filmeId = filmeId;
	}
	
	public Integer getFilmeId()
	{
		return this.filmeId;
	}
}