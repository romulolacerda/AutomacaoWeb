package br.com.romulo.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageNetshoes extends BasePage {

	private WebDriver driver;

	public LoginPageNetshoes(WebDriver navegador) {
		super(navegador);
	}

	public LoginPageNetshoes digitarLogin(String login) {
		navegador.findElement(By.xpath("//input[@id='username']")).sendKeys(login);
		
		return this;
	}

	public LoginPageNetshoes digitarSenha(String senha) {
		navegador.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(senha);
		
		return this;
	}	
	
	public HomePageNetshoes clicarAcessarConta() {
		navegador.findElement(By.xpath("//button[@id='login-button']")).click();
		
		return new HomePageNetshoes(navegador);
	}
	
	public HomePageNetshoes fazerLogin(String login, String senha) {
		digitarLogin(login);
		digitarSenha(senha);
		clicarAcessarConta();
		System.out.println("Logou no site");
		
		return new HomePageNetshoes(navegador);
	}

}
