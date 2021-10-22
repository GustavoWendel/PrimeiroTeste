package cursosdousa;

import com.cursosdousa.CadastroPessoas;
import com.cursosdousa.CadastroVazioException;
import com.cursosdousa.Pessoa;
import com.cursosdousa.PessoaSemNomeException;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class CadastroPessoaTest {

    @Test
    public void deveCriarCadastroDePessoa(){
        //Cenário e Execução
        CadastroPessoas cadastro = new CadastroPessoas();

        //Verificação
        Assertions.assertThat(cadastro.getPessoas()).isEmpty();
    }

    @Test
    public void deveAdicionarUmaPessoa() throws PessoaSemNomeException {
        //Cenário
        CadastroPessoas cadastro = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Wilson");

        //Execução
        cadastro.adicionar(pessoa);

        //Verificação
        Assertions.assertThat(cadastro.getPessoas())
                .isNotEmpty()
                .hasSize(1)
                .contains(pessoa);
    }

    @Test(expected = PessoaSemNomeException.class)
    public void naoDeveAdicionarPessoaComNomeVazio() throws PessoaSemNomeException {
        //Cenário
        CadastroPessoas cadastro = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();

        //Execução
        cadastro.adicionar(pessoa);

    }

    @Test
    public void deveRemoverUmaPessoa() throws PessoaSemNomeException {
        //Cenário
        CadastroPessoas cadastro = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Wilson");
        cadastro.adicionar(pessoa);

        //Execução
        cadastro.remover(pessoa);

        //Verificação
        Assertions.assertThat(cadastro.getPessoas()).isEmpty();
    }

    @Test(expected = CadastroVazioException.class)
    public void deveLancarErroAoTentarRemoverPessoaInexistente(){
        //Cenário
        CadastroPessoas cadastro = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();

        //Execução
        cadastro.remover(pessoa);
    }
}
