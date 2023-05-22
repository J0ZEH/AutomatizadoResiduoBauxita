package automatizado.teste;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.Keys;

import automatizado.pageObject.Pages.TrabalhosPublicadosPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TrabalhosPublicadosTeste extends Testes_testebase {

    public static TrabalhosPublicadosPO trabalhosPublicadosPage;

    @BeforeClass
    public static void prepararTestes(){
        driver.get("https://bauxiteresidue.ufma.br/pages/works.php");
        trabalhosPublicadosPage = new TrabalhosPublicadosPO(driver);
    }

    @Test
    public void TC001_deveAcessarAPaginaDeInicioAoClicarNaLogoDoHeader(){
        //TODO: botao da logo do Header nao funciona
        trabalhosPublicadosPage.buttonLogoHeader.click();
        assertEquals("https://bauxiteresidue.ufma.br/index.php#", driver.getCurrentUrl());

    }
    
    @Test
    public void TC002_deveMostarOpcoesDeIdiomas(){
        
        trabalhosPublicadosPage.selecionarIdiomaElement.click();

        String portugues = trabalhosPublicadosPage.idiomaPortuguesElement.getText();
        assertEquals("Português", portugues);
        String ingles = trabalhosPublicadosPage.idiomaInglesElement.getText();
        assertEquals("Inglês", ingles);

        trabalhosPublicadosPage.selecionarIdiomaElement.click();
    }

    @Test
    public void TC003_deveMostrarOpcoesDeIdiomasEDeixarAPaginaEmPortugues(){

        trabalhosPublicadosPage.selecionarIdiomaElement.click();
        trabalhosPublicadosPage.idiomaPortuguesElement.click();

        String msgIncio = trabalhosPublicadosPage.buttonInicio.getText();
        assertEquals("Início", msgIncio);


    }

    @Test
    public void TC004_deveMostrarOpcoesDeIdiomasEDeixarAPaginaEmIngles(){

        trabalhosPublicadosPage.selecionarIdiomaElement.click();
        trabalhosPublicadosPage.idiomaInglesElement.click();
        //TODO: Mensagem em ingles
        String msgIncio = trabalhosPublicadosPage.buttonInicio.getText();
        assertEquals("Início", msgIncio);


    }

    @Test
    public void TC005_deveAcessarAPáginaDeInicioAoClicarNoCampoInicioEVoltarParaTrabalhosPublicados(){

        trabalhosPublicadosPage.buttonInicio.click();
        assertEquals("https://bauxiteresidue.ufma.br/index.php", driver.getCurrentUrl());

        trabalhosPublicadosPage.buttonTrabalhosPublicados.click();
        assertEquals("https://bauxiteresidue.ufma.br/pages/works.php", driver.getCurrentUrl());

    }

    @Test
    public void TC006_deveClilcarNoBotaoSobreEExibirAsOpcoes(){

        trabalhosPublicadosPage.buttonSobre.click();

        String sobreNosString = trabalhosPublicadosPage.buttonSobreNos.getText();
        assertEquals("Sobre nós", sobreNosString);
        String sobreIntegrantesString = trabalhosPublicadosPage.buttonSobreIntegrantes.getText();
        assertEquals("Integrantes", sobreIntegrantesString);

        trabalhosPublicadosPage.buttonSobre.click();

    }

    @Test 
    public void TC007_deveClicarNoBotaoSobreClicarEmSobreNosAbrirAPaginaEVoltarParaTrabalhosPublicados(){

        trabalhosPublicadosPage.buttonSobre.click();
        trabalhosPublicadosPage.buttonSobreNos.click();
        assertEquals("https://bauxiteresidue.ufma.br/pages/about.php", driver.getCurrentUrl());
        
        trabalhosPublicadosPage.buttonTrabalhosPublicados.click();
        assertEquals("https://bauxiteresidue.ufma.br/pages/works.php", driver.getCurrentUrl());

    }

    @Test
    public void TC008_deveClicarNoBotaoSobreClicarEmIntegrantesAbrirAPaginaEVoltarParaTrabalhosPublicados(){

        trabalhosPublicadosPage.buttonSobre.click();
        trabalhosPublicadosPage.buttonSobreIntegrantes.click();
        assertEquals("https://bauxiteresidue.ufma.br/pages/members.php", driver.getCurrentUrl());

        trabalhosPublicadosPage.buttonTrabalhosPublicados.click();
        assertEquals("https://bauxiteresidue.ufma.br/pages/works.php", driver.getCurrentUrl());

    }

    @Test
    public void TC009_deveClicarNoBotaoTrabalhosPublicadosEContinuarNaPagina(){

        trabalhosPublicadosPage.buttonTrabalhosPublicados.click();
        assertEquals("https://bauxiteresidue.ufma.br/pages/works.php", driver.getCurrentUrl());
    }

    @Test
    public void TC010_deveClicarNoBotaoNoticiasAbrirAPaginaEVoltarParaTrabalhosPublicados(){

        trabalhosPublicadosPage.buttonNoticias.click();
        assertEquals("https://bauxiteresidue.ufma.br/pages/news.php", driver.getCurrentUrl());

        trabalhosPublicadosPage.buttonTrabalhosPublicados.click();
        assertEquals("https://bauxiteresidue.ufma.br/pages/works.php", driver.getCurrentUrl());


    }

    @Test
    public void TC011_deveBuscarTrabalhoPorTitulo() throws InterruptedException{

        trabalhosPublicadosPage.inputTitulo.sendKeys("minerais" + Keys.TAB);
        trabalhosPublicadosPage.buttonPesquisar.click();

        trabalhosPublicadosPage.buttonVerMais.click();
        assertEquals("RESUMO:", trabalhosPublicadosPage.textoResumo.getText());//verifica se abriu o resumo
        trabalhosPublicadosPage.buttonVerMais.click();
        assertEquals("", trabalhosPublicadosPage.textoResumo.getText());//verifica se fechou o resumo

        String identificadorJanelaBauxite = driver.getWindowHandle(); //salva o identificado da página de trabalhos publicados para poder voltar para ela no final do caso de teste

        trabalhosPublicadosPage.buttonAcesse.click();
        Thread.sleep(500); //espera um segundo para que a janela seja aberta

        int numeroFinalJanelasAbertas = driver.getWindowHandles().size(); //armezena a quantidade de janelas abertas após clicar em Acesse
        assertEquals(2, numeroFinalJanelasAbertas); //verifica se existem 2 janelas abertas
    
        driver.switchTo().window(identificadorJanelaBauxite); //retorna para a janela inicial


    }
    
    @Test
    public void TC012_deveBuscarTrabalhoPorAutor() throws InterruptedException{

        trabalhosPublicadosPage.inputAutor.sendKeys("viegas" + Keys.TAB);
        trabalhosPublicadosPage.buttonPesquisar.click();

        trabalhosPublicadosPage.buttonVerMais.click();
        assertEquals("RESUMO:", trabalhosPublicadosPage.textoResumo.getText());
        trabalhosPublicadosPage.buttonVerMais.click();
        assertEquals("", trabalhosPublicadosPage.textoResumo.getText());

        String identificadorJanelaBauxite = driver.getWindowHandle(); 

        trabalhosPublicadosPage.buttonAcesse.click();
        Thread.sleep(500); 

        int numeroFinalJanelasAbertas = driver.getWindowHandles().size(); 
        assertEquals(2, numeroFinalJanelasAbertas); 
    
        driver.switchTo().window(identificadorJanelaBauxite);

    }

    @Test
    public void TC013_deveBuscarTrabalhoPorPalavraChave() throws InterruptedException{

        trabalhosPublicadosPage.inputPalavraChave.sendKeys("titanio" + Keys.TAB);
        trabalhosPublicadosPage.buttonPesquisar.click();

        trabalhosPublicadosPage.buttonVerMais.click();
        assertEquals("RESUMO:", trabalhosPublicadosPage.textoResumo.getText());
        trabalhosPublicadosPage.buttonVerMais.click();
        assertEquals("", trabalhosPublicadosPage.textoResumo.getText());

        String identificadorJanelaBauxite = driver.getWindowHandle(); 

        trabalhosPublicadosPage.buttonAcesse.click();
        Thread.sleep(500); 

        int numeroFinalJanelasAbertas = driver.getWindowHandles().size(); 
        assertEquals(2, numeroFinalJanelasAbertas); 
    
        driver.switchTo().window(identificadorJanelaBauxite);
        

    }

    @Test
    public void TC014_deveBuscarTrabalhoPorAnoDePublicacao() throws InterruptedException{

        trabalhosPublicadosPage.inputAnoDePublicacao.sendKeys("2020" + Keys.TAB);
        trabalhosPublicadosPage.buttonPesquisar.click();

        trabalhosPublicadosPage.buttonVerMais.click();
        assertEquals("RESUMO:", trabalhosPublicadosPage.textoResumo.getText());
        trabalhosPublicadosPage.buttonVerMais.click();
        assertEquals("", trabalhosPublicadosPage.textoResumo.getText());

        String identificadorJanelaBauxite = driver.getWindowHandle(); 

        trabalhosPublicadosPage.buttonAcesse.click();
        Thread.sleep(500); 

        int numeroFinalJanelasAbertas = driver.getWindowHandles().size(); 
        assertEquals(2, numeroFinalJanelasAbertas); 
    
        driver.switchTo().window(identificadorJanelaBauxite);

 
    }

    @Test
    public void TC015_deveBuscarTrabalhoPorTituloEPorAutor() throws InterruptedException{
        
        trabalhosPublicadosPage.inputTitulo.sendKeys("minerais" + Keys.TAB);
        trabalhosPublicadosPage.inputAutor.sendKeys("viegas" + Keys.TAB);
        trabalhosPublicadosPage.buttonPesquisar.click();

        trabalhosPublicadosPage.buttonVerMais.click();
        assertEquals("RESUMO:", trabalhosPublicadosPage.textoResumo.getText());
        trabalhosPublicadosPage.buttonVerMais.click();
        assertEquals("", trabalhosPublicadosPage.textoResumo.getText());

        String identificadorJanelaBauxite = driver.getWindowHandle(); 

        trabalhosPublicadosPage.buttonAcesse.click();
        Thread.sleep(500); 

        int numeroFinalJanelasAbertas = driver.getWindowHandles().size(); 
        assertEquals(2, numeroFinalJanelasAbertas); 
    
        driver.switchTo().window(identificadorJanelaBauxite);

    }

    @Test
    public void TC016_deveBuscarTrabalhoPorTituloEPalavraChave() throws InterruptedException{

        trabalhosPublicadosPage.inputTitulo.sendKeys("minerais" + Keys.TAB);
        trabalhosPublicadosPage.inputPalavraChave.sendKeys("titanio" + Keys.TAB);
        trabalhosPublicadosPage.buttonPesquisar.click();

        trabalhosPublicadosPage.buttonVerMais.click();
        assertEquals("RESUMO:", trabalhosPublicadosPage.textoResumo.getText());
        trabalhosPublicadosPage.buttonVerMais.click();
        assertEquals("", trabalhosPublicadosPage.textoResumo.getText());

        String identificadorJanelaBauxite = driver.getWindowHandle(); 

        trabalhosPublicadosPage.buttonAcesse.click();
        Thread.sleep(500); 

        int numeroFinalJanelasAbertas = driver.getWindowHandles().size(); 
        assertEquals(2, numeroFinalJanelasAbertas); 
    
        driver.switchTo().window(identificadorJanelaBauxite);

    }

    @Test
    public void TC017_deveBuscarTrabalhoPorTituloEAnoDePublicacao() throws InterruptedException{

        trabalhosPublicadosPage.inputTitulo.sendKeys("minerais" + Keys.TAB);
        trabalhosPublicadosPage.inputAnoDePublicacao.sendKeys("2020" + Keys.TAB);
        trabalhosPublicadosPage.buttonPesquisar.click();

        Thread.sleep(500);
        trabalhosPublicadosPage.buttonVerMais.click();
        assertEquals("RESUMO:", trabalhosPublicadosPage.textoResumo.getText());
        trabalhosPublicadosPage.buttonVerMais.click();
        assertEquals("", trabalhosPublicadosPage.textoResumo.getText());

        String identificadorJanelaBauxite = driver.getWindowHandle(); 

        trabalhosPublicadosPage.buttonAcesse.click();
        Thread.sleep(500);

        int numeroFinalJanelasAbertas = driver.getWindowHandles().size(); 
        assertEquals(2, numeroFinalJanelasAbertas); 
    
        driver.switchTo().window(identificadorJanelaBauxite);

    }

    @Test
    public void TC018_deveBuscarTrabalhoPorAutorEPalavraChave() throws InterruptedException{

        trabalhosPublicadosPage.inputAutor.sendKeys("viegas" + Keys.TAB);
        trabalhosPublicadosPage.inputPalavraChave.sendKeys("titanio" + Keys.TAB);
        trabalhosPublicadosPage.buttonPesquisar.click();

        trabalhosPublicadosPage.buttonVerMais.click();
        assertEquals("RESUMO:", trabalhosPublicadosPage.textoResumo.getText());
        trabalhosPublicadosPage.buttonVerMais.click();
        assertEquals("", trabalhosPublicadosPage.textoResumo.getText());

        String identificadorJanelaBauxite = driver.getWindowHandle(); 

        trabalhosPublicadosPage.buttonAcesse.click();
        Thread.sleep(500); 

        int numeroFinalJanelasAbertas = driver.getWindowHandles().size(); 
        assertEquals(2, numeroFinalJanelasAbertas); 
    
        driver.switchTo().window(identificadorJanelaBauxite);

    }

    @Test
    public void TC019_deveBuscarTrabalhoPorAutorEAnoDePublicacao() throws InterruptedException{

        trabalhosPublicadosPage.inputAutor.sendKeys("viegas" + Keys.TAB);
        trabalhosPublicadosPage.inputAnoDePublicacao.sendKeys("2020" + Keys.TAB);
        trabalhosPublicadosPage.buttonPesquisar.click();

        trabalhosPublicadosPage.buttonVerMais.click();
        assertEquals("RESUMO:", trabalhosPublicadosPage.textoResumo.getText());
        trabalhosPublicadosPage.buttonVerMais.click();
        assertEquals("", trabalhosPublicadosPage.textoResumo.getText());

        String identificadorJanelaBauxite = driver.getWindowHandle(); 

        trabalhosPublicadosPage.buttonAcesse.click();
        Thread.sleep(500); 

        int numeroFinalJanelasAbertas = driver.getWindowHandles().size(); 
        assertEquals(2, numeroFinalJanelasAbertas); 
    
        driver.switchTo().window(identificadorJanelaBauxite);

    }

    @Test
    public void TC020_deveBuscarTrabalhoPorPalavraChaveEAnoDePublicacao() throws InterruptedException{

        trabalhosPublicadosPage.inputPalavraChave.sendKeys("titanio" + Keys.TAB);
        trabalhosPublicadosPage.inputAnoDePublicacao.sendKeys("2020" + Keys.TAB);
        trabalhosPublicadosPage.buttonPesquisar.click();

        trabalhosPublicadosPage.buttonVerMais.click();
        assertEquals("RESUMO:", trabalhosPublicadosPage.textoResumo.getText());
        trabalhosPublicadosPage.buttonVerMais.click();
        assertEquals("", trabalhosPublicadosPage.textoResumo.getText());

        String identificadorJanelaBauxite = driver.getWindowHandle(); 

        trabalhosPublicadosPage.buttonAcesse.click();
        Thread.sleep(500); 

        int numeroFinalJanelasAbertas = driver.getWindowHandles().size(); 
        assertEquals(2, numeroFinalJanelasAbertas); 
    
        driver.switchTo().window(identificadorJanelaBauxite);

    }

    @Test
    public void TC021_deveBuscarTrabalhoPorTituloAutorEPalavraChave() throws InterruptedException{

        trabalhosPublicadosPage.inputTitulo.sendKeys("minerais" + Keys.TAB);
        trabalhosPublicadosPage.inputAutor.sendKeys("viegas" + Keys.TAB);
        trabalhosPublicadosPage.inputPalavraChave.sendKeys("titanio" + Keys.TAB);
        trabalhosPublicadosPage.buttonPesquisar.click();

        trabalhosPublicadosPage.buttonVerMais.click();
        Thread.sleep(500);
        assertEquals("RESUMO:", trabalhosPublicadosPage.textoResumo.getText());
        trabalhosPublicadosPage.buttonVerMais.click();
        assertEquals("", trabalhosPublicadosPage.textoResumo.getText());

        String identificadorJanelaBauxite = driver.getWindowHandle(); 

        trabalhosPublicadosPage.buttonAcesse.click();
        Thread.sleep(500); 

        int numeroFinalJanelasAbertas = driver.getWindowHandles().size(); 
        assertEquals(2, numeroFinalJanelasAbertas); 
    
        driver.switchTo().window(identificadorJanelaBauxite);


    }

    @Test
    public void TC022_deveBuscarTrabalhoPorTituloAutorEAnoDePublicacao() throws InterruptedException{

        trabalhosPublicadosPage.inputTitulo.sendKeys("minerais" + Keys.TAB);
        trabalhosPublicadosPage.inputAutor.sendKeys("viegas" + Keys.TAB);
        trabalhosPublicadosPage.inputAnoDePublicacao.sendKeys("2020" + Keys.TAB);
        trabalhosPublicadosPage.buttonPesquisar.click();

        Thread.sleep(500);
        trabalhosPublicadosPage.buttonVerMais.click();
        assertEquals("RESUMO:", trabalhosPublicadosPage.textoResumo.getText());
        trabalhosPublicadosPage.buttonVerMais.click();
        assertEquals("", trabalhosPublicadosPage.textoResumo.getText());

        String identificadorJanelaBauxite = driver.getWindowHandle(); 

        trabalhosPublicadosPage.buttonAcesse.click();
        Thread.sleep(500); 

        int numeroFinalJanelasAbertas = driver.getWindowHandles().size(); 
        assertEquals(2, numeroFinalJanelasAbertas); 
    
        driver.switchTo().window(identificadorJanelaBauxite);

    }

    @Test
    public void TC023_deveBuscarTrabalhoPorTituloPalavraChaveEAnoDePublicacao() throws InterruptedException{

        trabalhosPublicadosPage.inputTitulo.sendKeys("minerais" + Keys.TAB);
        trabalhosPublicadosPage.inputPalavraChave.sendKeys("titanio" + Keys.TAB);
        trabalhosPublicadosPage.inputAnoDePublicacao.sendKeys("2020" + Keys.TAB);
        trabalhosPublicadosPage.buttonPesquisar.click();

        Thread.sleep(500);
        trabalhosPublicadosPage.buttonVerMais.click();
        assertEquals("RESUMO:", trabalhosPublicadosPage.textoResumo.getText());
        trabalhosPublicadosPage.buttonVerMais.click();
        assertEquals("", trabalhosPublicadosPage.textoResumo.getText());

        String identificadorJanelaBauxite = driver.getWindowHandle(); 

        trabalhosPublicadosPage.buttonAcesse.click();
        Thread.sleep(500); 

        int numeroFinalJanelasAbertas = driver.getWindowHandles().size(); 
        assertEquals(2, numeroFinalJanelasAbertas); 
    
        driver.switchTo().window(identificadorJanelaBauxite);

    }

    @Test
    public void TC024_deveBuscarTrabalhoPorAutorPalavraChaveEAnoDePublicacao() throws InterruptedException{

        trabalhosPublicadosPage.inputAutor.sendKeys("viegas" + Keys.TAB);
        trabalhosPublicadosPage.inputPalavraChave.sendKeys("titanio" + Keys.TAB);
        trabalhosPublicadosPage.inputAnoDePublicacao.sendKeys("2020" + Keys.TAB);
        trabalhosPublicadosPage.buttonPesquisar.click();

        Thread.sleep(500);
        trabalhosPublicadosPage.buttonVerMais.click();
        assertEquals("RESUMO:", trabalhosPublicadosPage.textoResumo.getText());
        trabalhosPublicadosPage.buttonVerMais.click();
        assertEquals("", trabalhosPublicadosPage.textoResumo.getText());

        String identificadorJanelaBauxite = driver.getWindowHandle(); 

        trabalhosPublicadosPage.buttonAcesse.click();
        Thread.sleep(500); 

        int numeroFinalJanelasAbertas = driver.getWindowHandles().size(); 
        assertEquals(2, numeroFinalJanelasAbertas); 
    
        driver.switchTo().window(identificadorJanelaBauxite);

    }

    @Test
    public void TC025_deveBuscarTrabalhoPorTituloAutorPalavraChaveEAnoDePublicacao() throws InterruptedException{

        trabalhosPublicadosPage.inputTitulo.sendKeys("minerais" + Keys.TAB);
        trabalhosPublicadosPage.inputAutor.sendKeys("viegas" + Keys.TAB);
        trabalhosPublicadosPage.inputPalavraChave.sendKeys("titanio" + Keys.TAB);
        trabalhosPublicadosPage.inputAnoDePublicacao.sendKeys("2020" + Keys.TAB);

        trabalhosPublicadosPage.buttonPesquisar.click();

        
        trabalhosPublicadosPage.buttonVerMais.click();
        Thread.sleep(500);
        assertEquals("RESUMO:", trabalhosPublicadosPage.textoResumo.getText());
        trabalhosPublicadosPage.buttonVerMais.click();
        assertEquals("", trabalhosPublicadosPage.textoResumo.getText());

        String identificadorJanelaBauxite = driver.getWindowHandle(); 

        trabalhosPublicadosPage.buttonAcesse.click();
        Thread.sleep(500); 

        int numeroFinalJanelasAbertas = driver.getWindowHandles().size(); 
        assertEquals(2, numeroFinalJanelasAbertas); 
    
        driver.switchTo().window(identificadorJanelaBauxite);
    
    }

    @Test
    public void TC026_deveAcessarAPaginaDoFormularioDeContatoEVoltarParaTrabalhosPublicados(){

        trabalhosPublicadosPage.buttonInicioFormulariodeContato.click();
        assertEquals("https://bauxiteresidue.ufma.br/pages/contact-us.php", driver.getCurrentUrl());

        trabalhosPublicadosPage.buttonTrabalhosPublicados.click();
        assertEquals("https://bauxiteresidue.ufma.br/pages/works.php?page=1", driver.getCurrentUrl());

    }


}



