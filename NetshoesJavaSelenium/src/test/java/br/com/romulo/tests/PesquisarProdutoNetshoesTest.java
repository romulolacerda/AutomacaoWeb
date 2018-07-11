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
import br.com.romulo.suporte.Generator;
import br.com.romulo.suporte.Screenshot;
import br.com.romulo.suporte.Web;

@RunWith(DataDrivenTestRunner.class) // chama a metodologia de teste DataDrivenTest
@DataLoader(filePaths = "ConsultaProduto.csv") // define o nome do arquivo que será informada a massa
																	// para o teste

public class PesquisarProdutoNetshoesTest {
	private WebDriver navegador;

	@Before
	public void setUp() {
		navegador = Web.createChrome();
	}

	@Test
	public void testPesquisarProdutoNetshoes(
			@Param(name = "nomeProduto") String nomeProduto
			) throws InterruptedException {

		
		new HomePageNetshoes(navegador)
		.pesquisarProdutos(nomeProduto)
		.clicarProduto()
		.validarProduto();
		
	}

	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(4000);
		navegador.quit();
	}
}
