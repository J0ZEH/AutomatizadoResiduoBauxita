package automatizado.teste;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.Keys;

import automatizado.pageObject.Pages.FaleConoscoPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FaleConoscoTeste extends Testes_testebase {


    public static FaleConoscoPO faleConoscoPage;

    @BeforeClass
    public static void prepararTestes(){
        driver.get("https://bauxiteresidue.ufma.br/pages/contact-us.php");
        faleConoscoPage = new FaleConoscoPO(driver);

    }

    @Test
    public void TC002_deveEstarNaPaginaDoFormulariodeContato(){

        String url = driver.getCurrentUrl();
        assertEquals("https://bauxiteresidue.ufma.br/pages/contact-us.php", url);

    }

    @Test
    public void TC003_escreverNosCamposEClicarEmEnviar(){
        
        faleConoscoPage.inputNome.sendKeys("Michael Scott" + Keys.TAB);
        faleConoscoPage.inputEmail.sendKeys("michael.scott@dundermifflin.com" + Keys.TAB);
        faleConoscoPage.inputMensagem.sendKeys("Lorem ipsum dolor sit amet. Eos quia unde ut fugiat natus ab tempore totam At enim amet. Ad odit tenetur in quis voluptates in quia libero?" + Keys.TAB);
        faleConoscoPage.buttonEnviar.click();

    }



    
}
