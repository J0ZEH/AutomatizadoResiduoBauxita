package automatizado.teste;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import automatizado.pageObject.Pages.SobreNosPO;

public class SobreNosTeste extends Testes_testebase {

    public static SobreNosPO sobreNosPage;

    @BeforeClass
    public static void prepararTestes(){
        driver.get("https://bauxiteresidue.ufma.br/pages/works.php");
        sobreNosPage = new SobreNosPO(driver);
    }

    @Test
    public void TC001_deveMostarOpcoesDeIdiomas(){
        
        sobreNosPage.selecionarIdiomaElement.click();

        String portugues = sobreNosPage.idiomaPortuguesElement.getText();
        assertEquals("Português", portugues);
        String ingles = sobreNosPage.idiomaInglesElement.getText();
        assertEquals("Inglês", ingles);

        sobreNosPage.selecionarIdiomaElement.click();
    }

    @Test
    public void TC002_deveMostrarOpcoesDeIdiomasEDeixarAPaginaEmPortugues(){

        sobreNosPage.selecionarIdiomaElement.click();
        sobreNosPage.idiomaPortuguesElement.click();

        String msgIncio = sobreNosPage.buttonInicio.getText();
        assertEquals("Início", msgIncio);


    }

    @Test
    public void TC003_deveMostrarOpcoesDeIdiomasEDeixarAPaginaEmIngles(){

        sobreNosPage.selecionarIdiomaElement.click();
        sobreNosPage.idiomaInglesElement.click();
    
        String msgIncio = sobreNosPage.buttonInicio.getText();
        assertEquals("Home", msgIncio);


    }

    @Test
    public void TC004_deveAcessarAPáginaDeInicioAoClicarNoCampoInicioEVoltarParaSobreNos(){

        sobreNosPage.buttonInicio.click();
        assertEquals("https://bauxiteresidue.ufma.br/index.php", driver.getCurrentUrl());

        sobreNosPage.buttonSobre.click();
        sobreNosPage.buttonSobreNos.click();
        assertEquals("https://bauxiteresidue.ufma.br/pages/about.php", driver.getCurrentUrl());

    }

    @Test
    public void TC005_deveClilcarNoBotaoSobreEExibirAsOpcoes(){

        sobreNosPage.buttonSobre.click();

        String sobreNosString = sobreNosPage.buttonSobreNos.getText();
        assertEquals("Sobre nós", sobreNosString);
        String sobreIntegrantesString = sobreNosPage.buttonSobreIntegrantes.getText();
        assertEquals("Integrantes", sobreIntegrantesString);

        sobreNosPage.buttonSobre.click();

    }

    @Test 
    public void TC006_deveClicarNoBotaoSobreClicarEmSobreNosEContinuarNaPagina(){

        sobreNosPage.buttonSobre.click();
        sobreNosPage.buttonSobreNos.click();
        assertEquals("https://bauxiteresidue.ufma.br/pages/about.php", driver.getCurrentUrl());

    }

    @Test
    public void TC007_deveClicarNoBotaoSobreClicarEmIntegrantesAbrirAPaginaEVoltarParaOInicio(){

        sobreNosPage.buttonSobre.click();
        sobreNosPage.buttonSobreIntegrantes.click();
        assertEquals("https://bauxiteresidue.ufma.br/pages/members.php", driver.getCurrentUrl());
        
        sobreNosPage.buttonSobre.click();
        sobreNosPage.buttonSobreNos.click();
        assertEquals("https://bauxiteresidue.ufma.br/pages/about.php", driver.getCurrentUrl());

    }

    @Test
    public void TC008_deveClicarNoBotaoTrabalhosPublicadosAbrirAPaginaEVoltarParaSobreNos(){

        sobreNosPage.buttonTrabalhosPublicados.click();
        assertEquals("https://bauxiteresidue.ufma.br/pages/works.php?page=1", driver.getCurrentUrl());

        sobreNosPage.buttonSobre.click();
        sobreNosPage.buttonSobreNos.click();
        assertEquals("https://bauxiteresidue.ufma.br/pages/about.php", driver.getCurrentUrl());

    }

    @Test
    public void TC09_deveClicarNoBotaoNoticiasAbrirAPaginaEVoltarParaSobreNos(){

        sobreNosPage.buttonNoticias.click();
        assertEquals("https://bauxiteresidue.ufma.br/pages/news.php", driver.getCurrentUrl());

        sobreNosPage.buttonSobre.click();
        sobreNosPage.buttonSobreNos.click();
        assertEquals("https://bauxiteresidue.ufma.br/pages/about.php", driver.getCurrentUrl());


    }

    @Test
    public void TC010_deveAcessarAPaginaDoFormularioDeContatoEVoltarParaSobreNos(){

        sobreNosPage.buttonFormulariodeContato.click();
        assertEquals("https://bauxiteresidue.ufma.br/pages/contact-us.php", driver.getCurrentUrl());

        sobreNosPage.buttonSobre.click();
        sobreNosPage.buttonSobreNos.click();
        assertEquals("https://bauxiteresidue.ufma.br/pages/about.php", driver.getCurrentUrl());

    }



    
    
}
