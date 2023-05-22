package automatizado.pageObject.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FaleConoscoPO extends BasePO {

    @FindBy(css = "body > footer > div > div.social > a > button")
    public WebElement buttonContactUs;

    @FindBy(css = "body > div.container > main > main > div > h2")
    public WebElement faleConosco;

    @FindBy(id = "nome")
    public WebElement inputNome;

    @FindBy(id = "email")
    public WebElement inputEmail;

    @FindBy(id = "mensagem")
    public WebElement inputMensagem;

    @FindBy(css = "body > div.container > main > main > button")
    public WebElement buttonEnviar;


    public FaleConoscoPO(WebDriver driver) {
        super(driver);
        
    }

    public String obterTexto(){
        return this.faleConosco.getText();
    }
    
}
