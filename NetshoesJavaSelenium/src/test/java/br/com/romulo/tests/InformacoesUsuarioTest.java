//package br.com.romulo.tests;
//
//import static org.junit.Assert.*;
//import java.util.concurrent.TimeUnit;
//
//import org.easetech.easytest.annotation.DataLoader;
//import org.easetech.easytest.annotation.Param;
//import org.easetech.easytest.runner.DataDrivenTestRunner;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Rule;
//import org.junit.Test;
//import org.junit.rules.TestName;
//import org.junit.runner.RunWith;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import br.com.romulo.suporte.Generator;
//import br.com.romulo.suporte.Screenshot;
//import br.com.romulo.suporte.Web;
//
//
//@RunWith(DataDrivenTestRunner.class) // chama a metodologia de teste DataDrivenTest
//@DataLoader(filePaths = "InformacoesUsuarioTestData.csv") //define o nome do arquivo que será informada a massa para o teste
//
//public class InformacoesUsuarioTest {
//	private WebDriver navegador;
//	
//	@Rule
//	public TestName test = new TestName();
//	
//	@Before
//	public void setUp() {
//		navegador = Web.createChrome();
//		navegador.findElement(By.linkText("Sign in")).click(); // clicar "Sign in"
//		WebElement formularioSignInBox = navegador.findElement(By.id("signinbox")); // indentificando formulario signinbox
//		formularioSignInBox.findElement(By.name("login")).sendKeys("julio0001"); // escrever login
//		formularioSignInBox.findElement(By.name("password")).sendKeys("123456"); // escrever senha		
//		formularioSignInBox.findElement(By.linkText("SIGN IN")).click(); // clicar "Sign in"
//		navegador.findElement(By.className("me")).click(); //clicar em "Hi, Julio"
//		navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click(); //clicar em "More Data About You"
//	}
//
//	//@Test
//	public void testAdicionarUmaInformacaoAdicionalDoUsuario(@Param(name="tipo")String tipo, @Param(name="contato")String contato, @Param(name="mensagem")String mensagemEsperada) {
//		navegador.findElement(By.xpath("//button[@data-target='addmoredata']")).click(); // clicar no botão "+ADD MORE DATA"
//		WebElement popupAddMoreData = navegador.findElement(By.id("addmoredata")); // identifica o formulario onde está presente o campo type
//		WebElement campoType = popupAddMoreData.findElement(By.name("type")); // localiza o campo 'type' dentro do formulario addMoreData
//		new Select(campoType).selectByVisibleText(tipo); // seleciona a opção 'Phone' dentro do combobox 'type'
//		popupAddMoreData.findElement(By.name("contact")).sendKeys(contato); // insere um numero no campo 'contact'
//		popupAddMoreData.findElement(By.linkText("SAVE")).click(); // clica no botão 'SAVE'
//		WebElement mensagemPop = navegador.findElement(By.id("toast-container")); // idenfifica a mensagem pop que aparece na tela
//		String mensagem = mensagemPop.getText(); // pega o texto da mensagem pop
//		assertEquals(mensagemEsperada, mensagem); // valida se a mensagem exibida é igual a esperada
//	}
//	
//	
//	//@Test
//	public void testRemoverUmContatoDeUmUsuario() {
//		navegador.findElement(By.xpath("//span[text()='+5511993153876']/following-sibling::a")).click(); //clica no link da lixeira do numero inserido na xpath
//		navegador.switchTo().alert().accept(); // aceita o alerta do navegador
//		WebElement mensagemPop = navegador.findElement(By.id("toast-container")); // idenfifica a mensagem pop que aparece na tela
//		String mensagem = mensagemPop.getText(); // pega o texto da mensagem pop
//		assertEquals("Rest in peace, dear phone!", mensagem); // valida se a mensagem exibida é igual a esperada
//		
//		String screenshotArquivo = "C://report-curso//" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png";
//		Screenshot.tirar(navegador, screenshotArquivo); // tira screenshot
//		
//		WebDriverWait aguardar = new WebDriverWait(navegador, 10); // cria uma espera explicita no navegador de 10 segundos
//		aguardar.until(ExpectedConditions.stalenessOf(mensagemPop)); // espera até 10 segundos para que a mensagem pop desapareça
//		navegador.findElement(By.linkText("Logout")).click(); // clica em fazer logout
//	}
//	
//
//	@After
//	public void tearDown() {
//		navegador.quit(); // fechar o navegador
//	}
//}
