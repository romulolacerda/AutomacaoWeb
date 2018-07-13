package br.com.romulo.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CadastroEnderecoNetshoes extends BasePage {

	public CadastroEnderecoNetshoes(WebDriver navegador) {
		super(navegador);
	}

	public CadastroEnderecoNetshoes clicarAdicionarNovoEndereco() {
		navegador.findElement(By.xpath("//*[@id=\"address-page\"]/div/div[2]/button")).click();
		System.out.println("Clica em Adicionar Novo Endereço");

		return this;
	}

	public CadastroEnderecoNetshoes preencherCamposEndereco(String nomeEndereco, String nomeDestinatario, String cep, 
			String tipoEndereco, String nomeRua, String numero, String complemento, String bairro, String estado,
			String cidade, String pontoReferencia) throws InterruptedException {
		Thread.sleep(5000);
		navegador.findElement(By.id("address-title")).sendKeys(nomeEndereco);
		navegador.findElement(By.id("address-recipient-name")).sendKeys(nomeDestinatario);
		navegador.findElement(By.id("address-zipcode")).sendKeys(cep);
		// WebElement campoTipoEndereco =
		// navegador.findElement(By.id("address-street-type"));
		// new Select(campoTipoEndereco).selectByVisibleText(tipoEndereco);
		// navegador.findElement(By.id("address-street-name")).sendKeys(nomeRua);
		navegador.findElement(By.id("address-street-number")).sendKeys(numero);
		navegador.findElement(By.id("address-additional-info")).sendKeys(complemento);
		// navegador.findElement(By.id("address-neighborhood")).sendKeys(bairro);
		// navegador.findElement(By.id("address-state")).sendKeys(estado);
		// WebElement campoEscolheEstado =
		// navegador.findElement(By.id("address-state"));
		// new Select(campoEscolheEstado).selectByVisibleText(estado);
		// navegador.findElement(By.id("address-city")).sendKeys(cidade);
		navegador.findElement(By.id("address-reference")).sendKeys(pontoReferencia);
		System.out.println("Preencheu os campos de Endereço");

		return this;
	}
	
	public CadastroEnderecoNetshoes clicarSalvarEndereco () {
		navegador.findElement(By.id("address-submit-button")).click();
		
		System.out.println("Salvou endereço");
		return this;
	}
	
	
	public CadastroEnderecoNetshoes validaEnderecoCadastrado (String nomeEndereco) {
		String validaEndereco = navegador.findElement(By.xpath("//body/main[@id='content']/div[@class='ns-row my-account']/div[@class='ns-w10']/div[@id='address-page']/div[@class='ns-row']/div[@class='ns-w6']/div[@id='my-address-list']/div[2]/div[1]/div[1]")).getText();
		Assert.assertEquals(nomeEndereco, validaEndereco);
		System.out.println("Esperado:" + nomeEndereco + "| Atual:" + validaEndereco);
		
		System.out.println("-----------------Endereço cadastrado com sucesso---------------");
		return this;
	}
	

}
