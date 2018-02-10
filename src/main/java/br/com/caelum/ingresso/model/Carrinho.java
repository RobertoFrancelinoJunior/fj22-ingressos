package br.com.caelum.ingresso.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@SessionScope
@Component
public class Carrinho {
	private List<Ingresso> ingressos = new ArrayList<>();
	
	public void add(Ingresso ingresso)
	{
		this.ingressos.add(ingresso);
	}
}
