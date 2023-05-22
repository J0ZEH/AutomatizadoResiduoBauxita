package automatizado.teste;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import automatizado.pageObject.Pages.SobreIntegrantesPO;

public class SobreIntegrantesTeste extends Testes_testebase {

    public static SobreIntegrantesPO sobreIntegrantesPage;

    @BeforeClass
    public static void prepararTestes(){
        driver.get("https://bauxiteresidue.ufma.br/pages/members.php");
        sobreIntegrantesPage = new SobreIntegrantesPO(driver);
    }

    @Test
    public void TC001_deveMostarOpcoesDeIdiomas(){
        
        sobreIntegrantesPage.selecionarIdiomaElement.click();

        String portugues = sobreIntegrantesPage.idiomaPortuguesElement.getText();
        assertEquals("Português", portugues);
        String ingles = sobreIntegrantesPage.idiomaInglesElement.getText();
        assertEquals("Inglês", ingles);

        sobreIntegrantesPage.selecionarIdiomaElement.click();
    }

    @Test
    public void TC002_deveMostrarOpcoesDeIdiomasEDeixarAPaginaEmPortugues(){

        sobreIntegrantesPage.selecionarIdiomaElement.click();
        sobreIntegrantesPage.idiomaPortuguesElement.click();

        String msgIncio = sobreIntegrantesPage.buttonInicio.getText();
        assertEquals("Início", msgIncio);


    }

    @Test
    public void TC003_deveMostrarOpcoesDeIdiomasEDeixarAPaginaEmIngles(){

        sobreIntegrantesPage.selecionarIdiomaElement.click();
        sobreIntegrantesPage.idiomaInglesElement.click();
    
        String msgIncio = sobreIntegrantesPage.buttonInicio.getText();
        assertEquals("Home", msgIncio);


    }

    @Test
    public void TC004_deveAcessarAPáginaDeInicioAoClicarNoCampoInicioEVoltarParaSobreIntegrantes(){

        sobreIntegrantesPage.buttonInicio.click();
        assertEquals("https://bauxiteresidue.ufma.br/index.php", driver.getCurrentUrl());

        sobreIntegrantesPage.buttonSobre.click();
        sobreIntegrantesPage.buttonSobreIntegrantes.click();
        assertEquals("https://bauxiteresidue.ufma.br/pages/members.php", driver.getCurrentUrl());

    }

    @Test
    public void TC005_deveClicarNoBotaoSobreEExibirAsOpcoes(){

        sobreIntegrantesPage.buttonSobre.click();

        String sobreNosString = sobreIntegrantesPage.buttonSobreNos.getText();
        assertEquals("Sobre nós", sobreNosString);
        String sobreIntegrantesString = sobreIntegrantesPage.buttonSobreIntegrantes.getText();
        assertEquals("Integrantes", sobreIntegrantesString);

        sobreIntegrantesPage.buttonSobre.click();

    }

    @Test 
    public void TC006_deveClicarNoBotaoSobreClicarEmSobreNosAbriAPaginaEVoltarParaSobreIntegrantes(){

        sobreIntegrantesPage.buttonSobre.click();
        sobreIntegrantesPage.buttonSobreNos.click();
        assertEquals("https://bauxiteresidue.ufma.br/pages/about.php", driver.getCurrentUrl());

        sobreIntegrantesPage.buttonSobre.click();
        sobreIntegrantesPage.buttonSobreIntegrantes.click();
        assertEquals("https://bauxiteresidue.ufma.br/pages/members.php", driver.getCurrentUrl());

    }

    @Test
    public void TC007_deveClicarNoBotaoSobreClicarEmIntegrantesEContinuarNaPagina(){

        sobreIntegrantesPage.buttonSobre.click();
        sobreIntegrantesPage.buttonSobreIntegrantes.click();
        assertEquals("https://bauxiteresidue.ufma.br/pages/members.php", driver.getCurrentUrl());

    }

    @Test
    public void TC008_deveClicarNoBotaoTrabalhosPublicadosAbrirAPaginaEVoltarParaSobreIntegrantes(){

        sobreIntegrantesPage.buttonTrabalhosPublicados.click();
        assertEquals("https://bauxiteresidue.ufma.br/pages/works.php?page=1", driver.getCurrentUrl());

        sobreIntegrantesPage.buttonSobre.click();
        sobreIntegrantesPage.buttonSobreIntegrantes.click();
        assertEquals("https://bauxiteresidue.ufma.br/pages/members.php", driver.getCurrentUrl());

    }

    @Test
    public void TC09_deveClicarNoBotaoNoticiasAbrirAPaginaEVoltarParaSobreIntegrantes(){

        sobreIntegrantesPage.buttonNoticias.click();
        assertEquals("https://bauxiteresidue.ufma.br/pages/news.php", driver.getCurrentUrl());

        sobreIntegrantesPage.buttonSobre.click();
        sobreIntegrantesPage.buttonSobreIntegrantes.click();
        assertEquals("https://bauxiteresidue.ufma.br/pages/members.php", driver.getCurrentUrl());


    }

    @Test
    public void TC010_deveAcessarAPaginaDoFormularioDeContatoEVoltarParaSobreIntegrantes(){

        sobreIntegrantesPage.buttonFormulariodeContato.click();
        assertEquals("https://bauxiteresidue.ufma.br/pages/contact-us.php", driver.getCurrentUrl());

        sobreIntegrantesPage.buttonSobre.click();
        sobreIntegrantesPage.buttonSobreIntegrantes.click();
        assertEquals("https://bauxiteresidue.ufma.br/pages/members.php", driver.getCurrentUrl());

    }

    
}
