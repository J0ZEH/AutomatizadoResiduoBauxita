package automatizado.teste;

import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import automatizado.pageObject.Pages.InicioPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class InicioTeste extends Testes_testebase {

    public static InicioPO InicioPage;

    @BeforeClass
    public static void prepararTestes(){
        InicioPage = new InicioPO(driver);
    }

    @Test
    public void TC001_deveAcessarAPaginaDeInicioAoClicarNaLogoDoHeader(){



        assertEquals("https://bauxiteresidue.ufma.br/index.php#", driver.getCurrentUrl());

    }
    
    @Test
    public void TC002_deveMostarOpcoesDeIdiomas(){
        
        InicioPage.selecionarIdiomaElement.click();

        String portugues = InicioPage.idiomaPortuguesElement.getText();
        assertEquals("Português", portugues);
        String ingles = InicioPage.idiomaInglesElement.getText();
        assertEquals("Inglês", ingles);

        InicioPage.selecionarIdiomaElement.click();
    }

    @Test
    public void TC003_deveMostrarOpcoesDeIdiomasEDeixarAPaginaEmPortugues(){

        InicioPage.selecionarIdiomaElement.click();
        InicioPage.idiomaPortuguesElement.click();

        String msgIncio = InicioPage.buttonInicio.getText();
        assertEquals("Início", msgIncio);


    }

    @Test
    public void TC004_deveMostrarOpcoesDeIdiomasEDeixarAPaginaEmIngles(){

        InicioPage.selecionarIdiomaElement.click();
        InicioPage.idiomaInglesElement.click();
    
        String msgIncio = InicioPage.buttonInicio.getText();
        assertEquals("Home", msgIncio);


    }

    @Test
    public void TC005_deveAcessarAPáginaDeInicioAoClicarNoCampoInicio(){

        InicioPage.buttonInicio.click();
        assertEquals("https://bauxiteresidue.ufma.br/index.php", driver.getCurrentUrl());

    }

    @Test
    public void TC006_deveClilcarNoBotaoSobreEExibirAsOpcoes(){

        InicioPage.buttonSobre.click();

        String sobreNosString = InicioPage.buttonSobreNos.getText();
        assertEquals("Sobre nós", sobreNosString);
        String sobreIntegrantesString = InicioPage.buttonSobreIntegrantes.getText();
        assertEquals("Integrantes", sobreIntegrantesString);

        InicioPage.buttonSobre.click();

    }

    @Test 
    public void TC007_deveClicarNoBotaoSobreClicarEmSobreNosAbrirAPaginaEVoltarParaOInicio(){

        InicioPage.buttonSobre.click();
        InicioPage.buttonSobreNos.click();
        assertEquals("https://bauxiteresidue.ufma.br/pages/about.php", driver.getCurrentUrl());
        
        InicioPage.buttonInicio.click();
        assertEquals("https://bauxiteresidue.ufma.br/index.php", driver.getCurrentUrl());

    }

    @Test
    public void TC008_deveClicarNoBotaoSobreClicarEmIntegrantesAbrirAPaginaEVoltarParaOInicio(){

        InicioPage.buttonSobre.click();
        InicioPage.buttonSobreIntegrantes.click();
        assertEquals("https://bauxiteresidue.ufma.br/pages/members.php", driver.getCurrentUrl());

        InicioPage.buttonInicio.click();
        assertEquals("https://bauxiteresidue.ufma.br/index.php", driver.getCurrentUrl());

    }

    @Test
    public void TC009_deveClicarNoBotaoTrabalhosPublicadosAbrirAPaginaEVoltarParaOInicio(){

        InicioPage.buttonTrabalhosPublicados.click();
        assertEquals("https://bauxiteresidue.ufma.br/pages/works.php?page=1", driver.getCurrentUrl());

        InicioPage.buttonInicio.click();
        assertEquals("https://bauxiteresidue.ufma.br/index.php", driver.getCurrentUrl());

    }

    @Test
    public void TC010_deveClicarNoBotaoNoticiasAbrirAPaginaEVoltarParaOInicio(){

        InicioPage.buttonNoticias.click();
        assertEquals("https://bauxiteresidue.ufma.br/pages/news.php", driver.getCurrentUrl());

        InicioPage.buttonInicio.click();
        assertEquals("https://bauxiteresidue.ufma.br/index.php", driver.getCurrentUrl());


    }

    
    @Test
    public void TC011deveAcessarAPaginaDeInicioAoClicarNaLogoDoFooter(){

        InicioPage.buttonLogoFooter.click();
        assertEquals("https://bauxiteresidue.ufma.br/index.php", driver.getCurrentUrl());

    }

    @Test
    public void TC012_deveRedirecionarParaOEmailAposClicarNoCampoEmail(){
        //TODO: verificar se o botao deve abrir o email

        InicioPage.buttonEmailFooter.click(); //clica no botao twitter que fica no footer
        String currentWindowHandle = driver.getWindowHandle();// Armazena o identificador da janela atual (antes de clicar no botão do Twitter)

        //itera sobre cada uma das janelas abertas pelo WebDriver usando um loop for, mudando o foco do WebDriver para cada janela
        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle); //muda o foco do WebDriver para a janela atual
            
        }

        assertEquals("https://bauxiteresidue.ufma.br/index.php", driver.getCurrentUrl()); //verifica se a URL atual é a do twitter
        driver.switchTo().window(currentWindowHandle); //volta o webdriver para a janela original (página início)

    }

    @Test
    public void TC013_deveRedirecionarParaOTwitterAoClicarNoCampoTwitter() throws InterruptedException{

        InicioPage.buttonTwitterFooter.click(); //clica no botao twitter que fica no footer
        String currentWindowHandle = driver.getWindowHandle();// Armazena o identificador da janela atual (antes de clicar no botão do Twitter)

        //itera sobre cada uma das janelas abertas pelo WebDriver usando um loop for, mudando o foco do WebDriver para cada janela
        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle); //muda o foco do WebDriver para a janela atual
            
        }

        assertEquals("https://twitter.com/", driver.getCurrentUrl()); //verifica se a URL atual é a do twitter
        driver.switchTo().window(currentWindowHandle); //volta o webdriver para a janela original (página início)
        
    
    }

    @Test
    public void TC014_deveRedirecionarParaOInstagramAoClicarNoCampoTwitter(){

        InicioPage.buttonInstagramFooter.click(); //clica no botao twitter que fica no footer
        String currentWindowHandle = driver.getWindowHandle();// Armazena o identificador da janela atual (antes de clicar no botão do Twitter)

        //itera sobre cada uma das janelas abertas pelo WebDriver usando um loop for, mudando o foco do WebDriver para cada janela
        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle); //muda o foco do WebDriver para a janela atual
            
        }

        assertEquals("https://www.instagram.com/", driver.getCurrentUrl()); //verifica se a URL atual é a do twitter
        driver.switchTo().window(currentWindowHandle); //volta o webdriver para a janela original (página início)
        
    
    }

    @Test
    public void TC015_deveAcessarAPaginaDoFormularioDeContatoEVoltarParaOInicio(){

        InicioPage.buttonFaleConoscoFooter.click();
        assertEquals("https://bauxiteresidue.ufma.br/pages/contact-us.php", driver.getCurrentUrl());

        InicioPage.buttonInicioFormulariodeContato.click();
        assertEquals("https://bauxiteresidue.ufma.br/index.php", driver.getCurrentUrl());

    }

    

    


}
