package br.ce.wcaquino.servicos;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Date;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.utils.DataUtils;

public class LocacaoServiceTest {

	private LocacaoService locacaoService;
	
	
	@Rule
	public ErrorCollector error = new ErrorCollector();
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Before
	public void setup(){
		this.locacaoService = new LocacaoService();
		
	}
	
	
	
	
	@Test
	public void testeLocacao() throws Exception {
		//F - First 
		//I - Indepedent (Isolado)(Cada teste deve ter apeas uma acertiva)
		//R - Repeatable
		//S -  Self verification
		//T - Timely
		
		
		//Cenario
		Usuario usuario = new Usuario();
		Filme filme = new Filme();
		
		
		usuario.setNome("José da Silva");
		filme.setNome("E o vento levou");
		filme.setPrecoLocacao(5.0);
		filme.setEstoque(1);
		
		//Acao
		Locacao locacao;
		
			locacao = locacaoService.alugarFilme(usuario, Arrays.asList(filme));
			
			//Verificacao
			if(locacao != null){
			 error.checkThat(locacao.getValor(), is(equalTo(5.0)));
			 error.checkThat(locacao.getValor(), is(not(7.0)));
			 assertTrue("Problema no valor",locacao.getValor()>0);
			 assertTrue(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
				
			}else{
				System.out.println("Não funcionou!!!");
			}
			
		
		
		
		Assert.assertTrue("Teste do AssertTrue", true);
		Assert.assertFalse("Teste do assertFalse", false);
		Assert.assertEquals(1.0344, 1.034, 0.001);
		
		
		
		
	}
	
	
	//Forma elegante
	@Test(expected=Exception.class)
	public void testLocacao_filmeSemEstoque() throws Exception{
		//Cenario
				Usuario usuario = new Usuario();
				Filme filme = new Filme();
				
				
				usuario.setNome("José da Silva");
				filme.setNome("E o vento levou");
				filme.setPrecoLocacao(5.0);
				filme.setEstoque(0);
				
				//Acao
				Locacao locacao;
				
					locacao = locacaoService.alugarFilme(usuario, Arrays.asList(filme));
	}
	
	//Forma Robusta
	@Test
	public void testLocacao_filmeSemEstoque_2() {
		//Cenario
				Usuario usuario = new Usuario();
				Filme filme = new Filme();
				
				
				usuario.setNome("José da Silva");
				filme.setNome("E o vento levou");
				filme.setPrecoLocacao(5.0);
				filme.setEstoque(0);
				
				//Acao
				Locacao locacao;
				
					try {
						locacao = locacaoService.alugarFilme(usuario, Arrays.asList(filme));
						Assert.fail("teste");
						
					} catch (Exception e) {
						
						Assert.assertThat(e.getMessage(), is("Filme sem estoque"));
					}
	}
	
	//Forma Nova
		@Test(expected=Exception.class)
		public void testLocacao_filmeSemEstoque_3() throws Exception{
			//Cenario
					Usuario usuario = new Usuario();
					Filme filme = new Filme();
					
					
					usuario.setNome("José da Silva");
					filme.setNome("E o vento levou");
					filme.setPrecoLocacao(5.0);
					filme.setEstoque(0);
					
					//Acao
					Locacao locacao;
					
						locacao = locacaoService.alugarFilme(usuario, Arrays.asList(filme));
						exception.expect(Exception.class);
						exception.expectMessage("Filme sem estoque");
		}
}
