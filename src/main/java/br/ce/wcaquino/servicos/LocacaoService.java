package br.ce.wcaquino.servicos;

import static br.ce.wcaquino.utils.DataUtils.adicionarDias;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.utils.DataUtils;

public class LocacaoService {
	
	public Locacao alugarFilme(Usuario usuario, List<Filme> filmes) throws Exception {
		
		double valorLocacao = 0;
		for(int i = 0 ; i < filmes.size(); i++){
			
			if(filmes.get(i).getEstoque() == 0){
				throw new Exception("Filme sem estoque");
			}
			
			if(i == 2){
				valorLocacao += filmes.get(i).getPrecoLocacao() * 0.75;
			} else if (i == 3){
				valorLocacao += filmes.get(i).getPrecoLocacao() * 0.5;
			} else if (i == 4){
				valorLocacao += filmes.get(i).getPrecoLocacao() * 0.25;
			} else if (i == 5){
				valorLocacao += 0;
			}else{
				valorLocacao += filmes.get(i).getPrecoLocacao();
			}
			
		}
		
		
		
		Locacao locacao = new Locacao();
		
		locacao.setFilmes(filmes);
		locacao.setUsuario(usuario);
		locacao.setDataLocacao(new Date());
		
		locacao.setValor(valorLocacao);
		//Entrega no dia seguinte
		Date dataEntrega = new Date();
		dataEntrega = adicionarDias(dataEntrega, 1);
		locacao.setDataRetorno(dataEntrega);
		
		//Salvando a locacao...	
		//TODO adicionar método para salvar
		
		return locacao;
	}

	
}