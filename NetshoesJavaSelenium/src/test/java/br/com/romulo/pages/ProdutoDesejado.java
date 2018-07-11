package br.com.romulo.pages;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.romulo.suporte.Generator;
import br.com.romulo.suporte.Screenshot;

public class ProdutoDesejado extends BasePage{
	
	@Rule
	public TestName test = new TestName();

	public ProdutoDesejado(WebDriver navegador) {
		super(navegador);
	}
	
	public ProdutoDesejado validarProduto() {
		boolean texto = navegador.findElement(By.xpath("//*[@id=\"content\"]/div[1]/section/section[1]/h1")).isDisplayed();
		Assert.assertTrue(texto);
		System.out.println("Valida que o item foi encontrado com sucesso!");
		
//		List<WebElement> elementos = navegador.findElements(By.xpath("//*[@id=\"item-list\"]/div[1]"));
//		for(WebElement elemento : elementos) {
//			System.out.println(elemento.getText()+ " - "+ elemento.getClass());
//		}
//		
//		Assert.assertEquals(nomeProduto, elementos.get(0);
		
		String screenshotArquivo = "C:\\report-estudo\\" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png";
		Screenshot.tirar(navegador, screenshotArquivo); // tira screenshot
		
		return this;
	}
	
}
