package br.com.romulo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaginaDeProdutos extends BasePage{

	public PaginaDeProdutos(WebDriver navegador) {
		super(navegador);
		// TODO Auto-generated constructor stub
	}

	public ProdutoDesejado clicarProduto() {
		navegador.findElement(By.xpath("//*[@id=\"item-list\"]/div/div[1]/div[1]/a/span")).click();
		System.out.println("Clica no produto pesquisado");
		
		return new ProdutoDesejado(navegador);
	}
	
}
