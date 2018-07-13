package br.com.romulo.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageNetshoes extends BasePage {

	private WebDriver driver;

	public HomePageNetshoes(WebDriver navegador) {
		super(navegador);
	}

	public HomePageNetshoes digitarProduto(String nomeProduto) {
		navegador.findElement(By.name("q")).sendKeys(nomeProduto);
		System.out.println("Escreveu o nome do produto");
		
		return this;
	}

	public PaginaDeProdutos clicarBuscarProduto() {
		navegador.findElement(By.xpath("//*[@id=\"header-content\"]/header/div[1]/section[2]/section/form/div/button")).click();
		System.out.println("Clica em buscar o Produto");
		
		return new PaginaDeProdutos(navegador);
	}

	public PaginaDeProdutos pesquisarProdutos(String nomeProduto) {
		digitarProduto(nomeProduto);
		clicarBuscarProduto();

		return new PaginaDeProdutos(navegador);
	}
	
	public CadastroEnderecoNetshoes clicarEnderecos() {
		navegador.findElement(By.xpath("//*[@id=\"header-user-logged\"]")).click();
		navegador.findElement(By.xpath("//*[@id=\"header-user-logged\"]/ul/li[3]/a")).click();
		System.out.println("Clica em Endereços");
		
		return new CadastroEnderecoNetshoes(navegador);
	}
	
	public LoginPageNetshoes clicarEntrar() {
		navegador.findElement(By.xpath("//div[@id='header-user-anonymous']")).click();
		navegador.findElement(By.xpath("//a[contains(text(),'Login')]")).click();

		return new LoginPageNetshoes(navegador);
		
	}

}
