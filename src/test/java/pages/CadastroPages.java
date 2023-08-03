package pages;

import baseUtil.BaseUtil;
import org.openqa.selenium.By;

import java.util.Random;

public class CadastroPages extends BaseUtil {

    Random numeroRandom = new Random();
    int numero = numeroRandom.nextInt(100);

    public void inseriEmail(String email ){
        this.browser.findElement(By.id("email")).sendKeys(email);
    }

    public void inseriSenha(String senha ){
        this.browser.findElement(By.id("senha")).sendKeys(senha);
    }

    public void inserirConta(String nome){
        this.browser.findElement(By.id("nome")).sendKeys(nome);
    }

    public void inserirContaRamdom(){
        this.browser.findElement(By.id("nome")).sendKeys("Teste" + numero);
    }

    public void botao(){
        this.browser.findElement(By.tagName("button")).click();
    }


    public String validarPaginaInicial(){
        String texto = this.browser.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
        return texto;
    }

    public String validarInserirConta(){
        String texto = this.browser.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
        return texto;
    }

    public String validarInserirContaSemNome(){
        String texto = this.browser.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
        return texto;
    }

    public String validarInserirContaNomeExistente(){
        String texto = this.browser.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
        return texto;
    }

    public void selecionarLink(String text){
        this.browser.findElement(By.linkText(text)).click();
    }
}
