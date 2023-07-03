package automatizado.pageObject.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InicioPO extends BasePO {

    //#region botoes header
    @FindBy(css = "body > header > div > div.logo-select > a > img")
    public WebElement buttonLogoHeader;
    
    @FindBy(css = "#idiomas > div.dropdown-name")
    public WebElement selecionarIdiomaElement;

    @FindBy(css = "#idiomas > div.dropdown-options > a:nth-child(1) > p")
    public WebElement idiomaPortuguesElement;

    @FindBy(css = "#idiomas > div.dropdown-options > a:nth-child(2) > p")
    public WebElement idiomaInglesElement;

    @FindBy(css = "body > header > div > div.menu-nav > ul > li:nth-child(1) > a")
    public WebElement buttonInicio;

    @FindBy(css = "#drop-about > div.dropdown-name")
    public WebElement buttonSobre;

    @FindBy(css = "#drop-about > div.dropdown-options > a:nth-child(1)")
    public WebElement buttonSobreNos;

    @FindBy(css = "#drop-about > div.dropdown-options > a:nth-child(2)")
    public WebElement buttonSobreIntegrantes;

    @FindBy(css = "body > header > div > div.menu-nav > ul > li:nth-child(5) > a")
    public WebElement buttonTrabalhosPublicados;

    @FindBy(css = "body > header > div > div.menu-nav > ul > li:nth-child(6) > a")
    public WebElement buttonNoticias;
    //#endregion botoes header

    @FindBy(css = "#banner > div > div.glide__track > div > button.glide__arrow.glide__arrow--left")
    public WebElement buttonCarrosselEsquerda;

    @FindBy(css = "#banner > div > div.glide__track > div > button.glide__arrow.glide__arrow--right")
    public WebElement buttonCarrosselDireita;

    @FindBy(css = "#banner > div > div.glide__bullets > button:nth-child(1)")
    public WebElement buttonGuiaEsquerdo;

    @FindBy(css = "#banner > div > div.glide__bullets > button:nth-child(2)")
    public WebElement buttonGuiaMeio;

    @FindBy(css = "#banner > div > div.glide__bullets > button:nth-child(3)")
    public WebElement buttonGuiaDireito;

    @FindBy(css = "#banner > div > div.glide__bullets > button.glide__bullet.glide__bullet--active")
    public WebElement buttonGuiaSelecionado;

    @FindBy(css = "#btn-ver1")
    public WebElement buttonVerMaisCimento;

    @FindBy(css = "#btn-ver2")
    public WebElement buttonVerMaisConcreto;

    @FindBy(css = "#btn-ver3")
    public WebElement buttonVerMaisCeramica;

    @FindBy(css = "#btn-ver4")
    public WebElement buttonVerMaisBiotecnologia;

    @FindBy(css = "#search_areas > div.view-more-screen > div > h6")
    public WebElement tituloCardCimento;

    @FindBy(css = "#search_areas > div.view-more-screen")
    public WebElement telaBackgroundCards;

    //#region botoes footer
    @FindBy(css = "body > footer > div > a")
    public WebElement buttonLogoFooter;

    @FindBy(css = "body > footer > div > div.social > div > a:nth-child(1)")
    public WebElement buttonEmailFooter;

    @FindBy(css = "body > footer > div > div.social > div > a:nth-child(2) > p")
    public WebElement buttonTwitterFooter;

    @FindBy(css = "body > footer > div > div.social > div > a:nth-child(3)")
    public WebElement buttonInstagramFooter;

    @FindBy(css = "body > footer > div > div.social > a > button")
    public WebElement buttonFaleConoscoFooter;

    @FindBy(css = "body > div > header > div > div.menu-nav > ul > li:nth-child(1) > a")
    public WebElement buttonInicioFormulariodeContato;
    //#endregion botoes footer

    public InicioPO(WebDriver driver) {
        super(driver);
    }

    


}
