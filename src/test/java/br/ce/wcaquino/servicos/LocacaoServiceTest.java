package br.ce.wcaquino.servicos;

import java.util.Date;

import org.junit.Assert;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.utils.DataUtils;

public class LocacaoServiceTest {

	@org.junit.Test
	public void teste() {
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
		
		
		Assert.assertTrue("Teste do AssertTrue", true);
		Assert.assertFalse("Teste do assertFalse", false);
		Assert.assertEquals(1.0344, 1.034, 0.001);
		
		
		//Verificacao
		if(locacao != null){
		 Assert.assertTrue("Problema no valor",locacao.getValor()>0);
		 Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
			
		}else{
			System.out.println("Não funcionou!!!");
		}
		
	}
}
