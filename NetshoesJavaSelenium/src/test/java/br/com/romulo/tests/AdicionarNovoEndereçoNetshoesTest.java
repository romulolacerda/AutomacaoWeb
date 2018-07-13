package br.com.romulo.tests;

import static org.junit.Assert.*;

import java.util.List;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.romulo.pages.HomePageNetshoes;
import br.com.romulo.pages.LoginPageNetshoes;
import br.com.romulo.suporte.Generator;
import br.com.romulo.suporte.Screenshot;
import br.com.romulo.suporte.Web;

@RunWith(DataDrivenTestRunner.class) // chama a metodologia de teste DataDrivenTest
@DataLoader(filePaths = "CadastroEndereco.csv") // define o nome do arquivo que será informada a massa para o teste
																	 

public class AdicionarNovoEndereçoNetshoesTest {
	private WebDriver navegador;

	@Before
	public void setUp() {
		navegador = Web.createChrome();
	}

	@Test
	public void testAdicionarNovoEndereçoNetshoes(
			@Param(name = "login") String login,
			@Param(name = "senha") String senha,
			@Param(name = "nomeEndereco") String nomeEndereco,
			@Param(name = "nomeDestinatario") String nomeDestinatario,
			@Param(name = "cep") String cep,
			@Param(name = "tipoEndereco") String tipoEndereco,
			@Param(name = "nomeRua") String nomeRua,
			@Param(name = "numero") String numero,
			@Param(name = "complemento") String complemento,
			@Param(name = "bairro") String bairro,
			@Param(name = "estado") String estado,
			@Param(name = "cidade") String cidade,
			@Param(name = "pontoReferencia") String pontoReferencia
			) throws InterruptedException {

		
		new HomePageNetshoes(navegador)
		.clicarEntrar()
		.fazerLogin(login, senha)
		.clicarEnderecos()
		.clicarAdicionarNovoEndereco()
		.preencherCamposEndereco(nomeEndereco, nomeDestinatario, cep, tipoEndereco, nomeRua, numero, complemento, bairro, estado, cidade, pontoReferencia)
		.clicarSalvarEndereco()
		.validaEnderecoCadastrado(nomeEndereco);
	}

	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(4000);
		navegador.quit();
	}
}
