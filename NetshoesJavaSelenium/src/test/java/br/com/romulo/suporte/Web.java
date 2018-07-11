package br.com.romulo.suporte;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Web {
	public static WebDriver createChrome() {
		System.setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe"); //seleciona o diretorio do chromedrive.exe
		WebDriver navegador = new ChromeDriver();	// abrindo navegador	
		navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // inicia uma espera implicita e espera 5 segundos até os elementos estarem prontos para o click	
		navegador.get("https://www.netshoes.com.br/"); // navegando para a pagina do Taskit
		
		System.out.println("Abrindo a página desejada");
		return navegador;
	}
}
