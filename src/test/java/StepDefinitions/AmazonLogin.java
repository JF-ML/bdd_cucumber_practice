package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;


public class AmazonLogin {
	
	WebDriver driver = null;
	
	@Given("usuario dentro del navegador web")
	public void usuario_dentro_del_navegador_web() {
		
		System.out.println("Step - usuario dentro del navegador web");
		
		//Obtenemos path de projecto
		String projectPath = System.getProperty("user.dir");
		System.out.println("Project path is: " + projectPath);
		
		//Configuramos el webdriver
		System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/Drivers/chromedriver.exe");
				
		//Abrimos navegador
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

	}

	@And("usuario dentro de la pagina de amazon")
	public void usuario_dentro_de_la_pagina_de_amazon() {
		
		System.out.println("Step - usuario dentro de la pagina de amazon");
	
		//Navegamos al lugar deseado = Amazon
		driver.navigate().to("https://amazon.com");

	}

	@When("usuario entre a inicio de sesion")
	public void usuario_entre_a_inicio_de_secion() {

		System.out.println("Step - usuario entre a inicio de sesion");
		
		driver.findElement(By.id("nav-link-accountList")).click();

	}

	@Then("pagina de inicio desplegada")
	public void pagina_de_inicio_desplegada() {
		
		System.out.println("Step - pagina de inicio desplegada");
		
		//driver.navigate().to("https://www.amazon.com/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com%2F%3Fref_%3Dnav_ya_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=usflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&");
		driver.getCurrentUrl();
		
	}

	@When("usuario ingrese correo")
	public void usuario_ingrese_sus_credenciales() throws InterruptedException {

		System.out.println("Step - usuario ingresa correo");
		
		driver.findElement(By.name("email")).sendKeys("krazysocksmid@gmail.com");
		
		Thread.sleep(2000);

	}

	@And("presione continuar")
	public void presione_continuar() throws InterruptedException {
		
		System.out.println("Step - presiona continuar");

		driver.findElement(By.id("continue")).click();
		
		Thread.sleep(2000);

	}
	
	@Then("pagina para contrasenia")
	public void pagina_para_contrasenia() {
	
		System.out.println("Step - pagina para contrasenia");

		driver.getCurrentUrl();
		//driver.navigate().to("https://www.amazon.com/ap/signin");

	}
	
	@When("usuario ingrese contrasenia")
	public void usuario_ingrese_contrasenia() throws InterruptedException {

		System.out.println("Step - usuario ingrese contrasenia");
		
		driver.findElement(By.id("ap_password")).sendKeys("eloypompa");
		
		Thread.sleep(2000);

	}

	@And("presione singin")
	public void presione_singin() throws InterruptedException {
		
		System.out.println("Step - presione singin");
		
		//driver.findElement(By.id("singInSubmit")).click();
		driver.findElement(By.className("a-button-input")).click();
		
		Thread.sleep(2000);
		
	}


	@Then("usuario entra a su sesion")
	public void usuario_entra_a_su_sesion() throws InterruptedException {

		System.out.println("Step - usuario entra a su sesion");
		
		driver.getPageSource().contains("Ofertas del día");
		
		Thread.sleep(2000);
		
		driver.close();
		driver.quit();

	}

}
