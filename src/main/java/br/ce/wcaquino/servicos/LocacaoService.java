package br.ce.wcaquino.servicos;

import static br.ce.wcaquino.utils.DataUtils.adicionarDias;

import java.util.Date;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.utils.DataUtils;

public class LocacaoService {
	
	public Locacao alugarFilme(Usuario usuario, Filme filme) {
		Locacao locacao = new Locacao();
		locacao.setFilme(filme);
		locacao.setUsuario(usuario);
		locacao.setDataLocacao(new Date());
		locacao.setValor(filme.getPrecoLocacao());

		//Entrega no dia seguinte
		Date dataEntrega = new Date();
		dataEntrega = adicionarDias(dataEntrega, 1);
		locacao.setDataRetorno(dataEntrega);
		
		//Salvando a locacao...	
		//TODO adicionar mÃ©todo para salvar
		
		return locacao;
	}

	public static void main(String[] args) {
		//F - First
		//I - Indepedent
		//R - Repeatable
		//S -  Self verification
		//T - Timely
		
		
		//Cenario
		Usuario usuario = new Usuario();
		Filme filme = new Filme();
		LocacaoService locacaoService = new LocacaoService();
		
		usuario.setNome("José da Silva");
		filme.setNome("E o vento levou");
		filme.setPrecoLocacao(1.0);
		filme.setEstoque(10);
		
		//Acao
		Locacao locacao = locacaoService.alugarFilme(usuario, filme);
		
		
		//Verificacao
		if(locacao != null){
			System.out.println(locacao.getValor()>0);
			System.out.println(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
			
		}else{
			System.out.println("Não funcionou!!!");
		}
		
	}
}