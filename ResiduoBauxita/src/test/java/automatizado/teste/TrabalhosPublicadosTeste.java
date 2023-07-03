package automatizado.teste;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import automatizado.pageObject.Pages.TrabalhosPublicadosPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TrabalhosPublicadosTeste extends Testes_testebase {

    public static TrabalhosPublicadosPO trabalhosPublicadosPage;

    @BeforeClass
    public static void prepararTestes(){
        driver.get("https://bauxiteresidue.ufma.br/pages/trabalhos.php?page=1");
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
    public void TC004_deveMostrarOpcoesDeIdiomasEDeixarAPaginaEmIngles(){

        trabalhosPublicadosPage.selecionarIdiomaElement.click();
        trabalhosPublicadosPage.idiomaInglesElement.click();

        String msgIncio = trabalhosPublicadosPage.buttonInicio.getText();
        assertEquals("Home", msgIncio);

    }

    @Test
    public void TC004_deveMostrarOpcoesDeIdiomasEDeixarAPaginaEmPortugues(){

        trabalhosPublicadosPage.selecionarIdiomaElement.click();
        trabalhosPublicadosPage.idiomaPortuguesElement.click();

        String msgIncio = trabalhosPublicadosPage.buttonInicio.getText();
        assertEquals("Início", msgIncio);


    }


    @Test
    public void TC005_deveAcessarAPáginaDeInicioAoClicarNoCampoInicioEVoltarParaTrabalhosPublicados(){

        trabalhosPublicadosPage.buttonInicio.click();
        assertEquals("https://bauxiteresidue.ufma.br/index.php", driver.getCurrentUrl());

        trabalhosPublicadosPage.buttonTrabalhosPublicados.click();
        assertEquals("https://bauxiteresidue.ufma.br/pages/trabalhos.php?page=1", driver.getCurrentUrl());

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
        assertEquals("https://bauxiteresidue.ufma.br/pages/sobre.php", driver.getCurrentUrl());
        
        trabalhosPublicadosPage.buttonTrabalhosPublicados.click();
        assertEquals("https://bauxiteresidue.ufma.br/pages/trabalhos.php?page=1", driver.getCurrentUrl());

    }

    @Test
    public void TC008_deveClicarNoBotaoSobreClicarEmIntegrantesAbrirAPaginaEVoltarParaTrabalhosPublicados(){

        trabalhosPublicadosPage.buttonSobre.click();
        trabalhosPublicadosPage.buttonSobreIntegrantes.click();
        assertEquals("https://bauxiteresidue.ufma.br/pages/membros.php", driver.getCurrentUrl());

        trabalhosPublicadosPage.buttonTrabalhosPublicados.click();
        assertEquals("https://bauxiteresidue.ufma.br/pages/trabalhos.php?page=1", driver.getCurrentUrl());

    }

    @Test
    public void TC009_deveClicarNoBotaoTrabalhosPublicadosEContinuarNaPagina(){

        trabalhosPublicadosPage.buttonTrabalhosPublicados.click();
        assertEquals("https://bauxiteresidue.ufma.br/pages/trabalhos.php?page=1", driver.getCurrentUrl());
    }

    @Test
    public void TC010_deveClicarNoBotaoNoticiasAbrirAPaginaEVoltarParaTrabalhosPublicados(){

        trabalhosPublicadosPage.buttonNoticias.click();
        assertEquals("https://bauxiteresidue.ufma.br/pages/noticias.php", driver.getCurrentUrl());

        trabalhosPublicadosPage.buttonTrabalhosPublicados.click();
        assertEquals("https://bauxiteresidue.ufma.br/pages/trabalhos.php?page=1", driver.getCurrentUrl());


    }

    @Test
    public void TC011_deveBuscarTrabalhoPorTitulo() throws InterruptedException{

        trabalhosPublicadosPage.limparCampos();
        trabalhosPublicadosPage.inputTitulo.sendKeys("producao do agregado" + Keys.TAB);
        trabalhosPublicadosPage.buttonPesquisar.click();

        
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        //jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);"); //rola a página inteira para baixo
        jsExecutor.executeScript("window.scrollTo(0, 400);"); //rola 0 pixels na horizontal e 400 pixels na vertical

        Thread.sleep(500);
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

        trabalhosPublicadosPage.limparCampos();
        trabalhosPublicadosPage.inputAutor.sendKeys("souza" + Keys.TAB);
        trabalhosPublicadosPage.buttonPesquisar.click();


        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, 400);");
        
        Thread.sleep(500);
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
    public void TC013_deveBuscarTrabalhoPorPalavraChave() throws InterruptedException{

        trabalhosPublicadosPage.limparCampos();
        trabalhosPublicadosPage.inputPalavraChave.sendKeys("lama vermelha" + Keys.TAB);
        trabalhosPublicadosPage.buttonPesquisar.click();

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, 400);");
        
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
    public void TC014_deveBuscarTrabalhoPorAnoDePublicacao() throws InterruptedException{

        trabalhosPublicadosPage.limparCampos();
        trabalhosPublicadosPage.inputAnoDePublicacao.sendKeys("2022" + Keys.TAB);
        trabalhosPublicadosPage.buttonPesquisar.click();
  
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, 400);");
        
        Thread.sleep(500);   
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
    public void TC015_deveBuscarTrabalhoPorTituloEPorAutor() throws InterruptedException{
        
        trabalhosPublicadosPage.limparCampos();
        trabalhosPublicadosPage.inputTitulo.sendKeys("producao do agregado" + Keys.TAB);
        trabalhosPublicadosPage.inputAutor.sendKeys("souza" + Keys.TAB);
        trabalhosPublicadosPage.buttonPesquisar.click();

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, 400);");
        
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
    public void TC016_deveBuscarTrabalhoPorTituloEPalavraChave() throws InterruptedException{

        trabalhosPublicadosPage.limparCampos();
        trabalhosPublicadosPage.inputTitulo.sendKeys("producao do agregado" + Keys.TAB);
        trabalhosPublicadosPage.inputPalavraChave.sendKeys("lama vermelha" + Keys.TAB);
        trabalhosPublicadosPage.buttonPesquisar.click();

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, 400);");
        
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
    public void TC017_deveBuscarTrabalhoPorTituloEAnoDePublicacao() throws InterruptedException{

        trabalhosPublicadosPage.limparCampos();
        trabalhosPublicadosPage.inputTitulo.sendKeys("producao do agregado" + Keys.TAB);
        trabalhosPublicadosPage.inputAnoDePublicacao.sendKeys("2022" + Keys.TAB);
        trabalhosPublicadosPage.buttonPesquisar.click();

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, 400);");
        
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
        
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, 0);");

        trabalhosPublicadosPage.limparCampos();
        trabalhosPublicadosPage.inputAutor.sendKeys("souza" + Keys.TAB);
        trabalhosPublicadosPage.inputPalavraChave.sendKeys("lama vermelha" + Keys.TAB);
        trabalhosPublicadosPage.buttonPesquisar.click();

        jsExecutor.executeScript("window.scrollTo(0, 400);");
        
        Thread.sleep(500);
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
    public void TC019_deveBuscarTrabalhoPorAutorEAnoDePublicacao() throws InterruptedException{

        trabalhosPublicadosPage.limparCampos();
        trabalhosPublicadosPage.inputAutor.sendKeys("souza" + Keys.TAB);
        trabalhosPublicadosPage.inputAnoDePublicacao.sendKeys("2022" + Keys.TAB);
        trabalhosPublicadosPage.buttonPesquisar.click();

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, 400);");
        
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
    public void TC020_deveBuscarTrabalhoPorPalavraChaveEAnoDePublicacao() throws InterruptedException{

        trabalhosPublicadosPage.limparCampos();
        trabalhosPublicadosPage.inputPalavraChave.sendKeys("lama vermelha" + Keys.TAB);
        trabalhosPublicadosPage.inputAnoDePublicacao.sendKeys("2022" + Keys.TAB);
        trabalhosPublicadosPage.buttonPesquisar.click();

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, 400);");
        
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
    public void TC021_deveBuscarTrabalhoPorTituloAutorEPalavraChave() throws InterruptedException{

        trabalhosPublicadosPage.limparCampos();
        trabalhosPublicadosPage.inputTitulo.sendKeys("producao do agregado" + Keys.TAB);
        trabalhosPublicadosPage.inputAutor.sendKeys("souza" + Keys.TAB);
        trabalhosPublicadosPage.inputPalavraChave.sendKeys("lama vermelha" + Keys.TAB);
        trabalhosPublicadosPage.buttonPesquisar.click();

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, 400);");
        
        Thread.sleep(500);
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

        trabalhosPublicadosPage.limparCampos();
        trabalhosPublicadosPage.inputTitulo.sendKeys("producao do agregado" + Keys.TAB);
        trabalhosPublicadosPage.inputAutor.sendKeys("souza" + Keys.TAB);
        trabalhosPublicadosPage.inputAnoDePublicacao.sendKeys("2022" + Keys.TAB);
        trabalhosPublicadosPage.buttonPesquisar.click();

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, 400);");
        
        Thread.sleep(500);
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
    public void TC023_deveBuscarTrabalhoPorTituloPalavraChaveEAnoDePublicacao() throws InterruptedException{

        trabalhosPublicadosPage.limparCampos();
        trabalhosPublicadosPage.inputTitulo.sendKeys("producao do agregado" + Keys.TAB);
        trabalhosPublicadosPage.inputPalavraChave.sendKeys("lama vermelha" + Keys.TAB);
        trabalhosPublicadosPage.inputAnoDePublicacao.sendKeys("2022" + Keys.TAB);
        trabalhosPublicadosPage.buttonPesquisar.click();

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, 400);");
        
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

        trabalhosPublicadosPage.limparCampos();
        trabalhosPublicadosPage.inputAutor.sendKeys("souza" + Keys.TAB);
        trabalhosPublicadosPage.inputPalavraChave.sendKeys("lama vermelha" + Keys.TAB);
        trabalhosPublicadosPage.inputAnoDePublicacao.sendKeys("2022" + Keys.TAB);
        trabalhosPublicadosPage.buttonPesquisar.click();

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, 400);");
        
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

        trabalhosPublicadosPage.limparCampos();
        trabalhosPublicadosPage.inputTitulo.sendKeys("producao do agregado" + Keys.TAB);
        trabalhosPublicadosPage.inputAutor.sendKeys("souza" + Keys.TAB);
        trabalhosPublicadosPage.inputPalavraChave.sendKeys("lama vermelha" + Keys.TAB);
        trabalhosPublicadosPage.inputAnoDePublicacao.sendKeys("2022" + Keys.TAB);
        trabalhosPublicadosPage.buttonPesquisar.click();

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, 400);");
        
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
    public void TC026_deveAcessarAPaginaDoFormularioDeContatoEVoltarParaTrabalhosPublicados() throws InterruptedException{

        trabalhosPublicadosPage.limparCampos();

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        
        Thread.sleep(500);
        trabalhosPublicadosPage.buttonFormulariodeContato.click();
        assertEquals("https://bauxiteresidue.ufma.br/pages/contact.php", driver.getCurrentUrl());

        trabalhosPublicadosPage.buttonTrabalhosPublicados.click();
        assertEquals("https://bauxiteresidue.ufma.br/pages/trabalhos.php?page=1", driver.getCurrentUrl());

    }


}



