package automatizado.teste;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


/**
 * Classe base que serve de herança para todas as classe de teste
 */
public abstract class Testes_testebase {

    /**Driver do navegado da pagina atual */
    protected static WebDriver driver;
    /**Caminho base da URL do sistema */
    //private static final String URL_BASE = "file:///C:/Users/netto/Desktop/sistema/login.html";
    private static final String URL_BASE = "https://bauxiteresidue.ufma.br/index.php";
    /**Caminho relativo do driver ao projeto referente ao path(src) */
    protected static final String CAMINHO_DRIVER = "src/test/java/automatizado/resource/chromedriver-114-0-5735-90.exe";

    /**
     * Método para iniciar o driver do navegador antes de qualquer classe de teste
     */
    @BeforeClass
    public static void iniciar(){

        System.setProperty("webdriver.chrome.driver", CAMINHO_DRIVER);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL_BASE);


    }
    
    /**
     * Método para fechar o driver do navegador depois de qualquer classe de teste
     */
    @AfterClass
    public static void finalizar(){
        driver.quit();
    }

    

}
