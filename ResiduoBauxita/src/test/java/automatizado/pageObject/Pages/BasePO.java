
package automatizado.pageObject.Pages;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Classe base para criacao das novas PageObjects;
 * Todas as pages devem ser herdadas deta classe;
 */

public abstract class BasePO {
    
    /**Driver base que será usado pelas pages */
    protected WebDriver driver;

    /**
     * Construtor base para criação da fabrica de elementos (PageFactory)
     * @param driver driver da página atual
     */ 
    protected BasePO(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this); //Inicializando a fábrica pra trabalhar com PageFactory
    }


    /**
     * Método que retorna o titulo da pagina atual 
     * @return
     */
    public String obterTituloPagina(){
        return driver.getTitle();
    }


    /**
     * Método escreve em qualquer WebElement do tipo input e da um TAB ao final
     * @param input input a qual será escrito
     * @param texto texto que sera escrito no input
     */
    public void escrever(WebElement input, String texto){
        input.clear();
        input.sendKeys(texto + Keys.TAB);
    }

    protected WebElement esperarElementoVisivel(WebElement elemento, int segundos) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.visibilityOf(elemento));
    }



}