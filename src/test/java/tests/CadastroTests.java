package tests;

import baseUtil.BaseUtil;
import io.cucumber.java.After;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import pages.CadastroPages;

public class CadastroTests extends BaseUtil {
    private CadastroPages cadastro = new CadastroPages();

    @After
    public void fecharBrowser(){
        cadastro.fecharNavegador();
    }

    @Dado("que estou acessando a aplicação")
    public void que_estou_acessando_a_aplicação() {
        cadastro.loginPage();
    }

    @Quando("informo o usuário {string}")
    public void informo_o_usuário(String string) {
        cadastro.inseriEmail(string);
    }

    @Quando("a senha {string}")
    public void a_senha(String string) {
       cadastro.inseriSenha(string);
    }

    @Quando("seleciono entrar")
    public void seleciono_entrar() {
        cadastro.botao();
    }

    @Então("visualizo a página inicial")
    public void visualizo_a_página_inicial() {
        Assert.assertEquals("Bem vindo, Testadora!", cadastro.validarPaginaInicial());
    }

    @Quando("seleciono Contas")
    public void seleciono_contas() {
       cadastro.selecionarLink("Contas");
    }

    @Quando("seleciono Adicionar")
    public void seleciono_adicionar() {
        cadastro.selecionarLink("Adicionar");
    }

    @Quando("informo a conta {string}")
    public void informo_a_conta(String string) {
       cadastro.inserirConta(string);
    }

    @Quando("seleciono Salvar")
    public void seleciono_salvar() {
       cadastro.botao();
    }

    @Então("a conta é inserida com sucesso")
    public void a_conta_é_inserida_com_sucesso() {
        Assert.assertEquals("Conta adicionada com sucesso!", cadastro.validarInserirConta());
    }

    @Então("sou notificar que o nome da conta é obrigatório")
    public void sou_notificar_que_o_nome_da_conta_é_obrigatório() {
       Assert.assertEquals("Informe o nome da conta", cadastro.validarInserirContaSemNome());
       cadastro.fecharNavegador();
    }

    @Então("sou notificado que já existe uma conta com esse nome")
    public void sou_notificado_que_já_existe_uma_conta_com_esse_nome() {
        Assert.assertEquals("Já existe uma conta com esse nome!", cadastro.validarInserirContaNomeExistente());
    }

    @Quando("informo a conta com nome aleatorio")
    public void informo_a_conta_com_nome_aleatorio() {
        cadastro.inserirContaRamdom();
    }





}
