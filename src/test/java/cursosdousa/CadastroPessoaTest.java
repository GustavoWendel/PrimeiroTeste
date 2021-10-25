package cursosdousa;

import com.cursosdousa.CadastroPessoas;
import com.cursosdousa.CadastroVazioException;
import com.cursosdousa.Pessoa;
import com.cursosdousa.PessoaSemNomeException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CadastroPessoaTest {

    @Test
    @DisplayName("Deve criar o cadastro de pessoas")
    public void deveCriarCadastroDePessoas(){
        //Cenário e Execução
        CadastroPessoas cadastro = new CadastroPessoas();

        //Verificação
        Assertions.assertThat(cadastro.getPessoas()).isEmpty();
    }

    @Test
    @DisplayName("Deve adicionar uma pessoa")
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

    @Test
    @DisplayName("Não deve adicionar uma pessoa com nome vazio")
    public void naoDeveAdicionarPessoaComNomeVazio(){
        //Cenário
        CadastroPessoas cadastro = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();

        //Execução
        org.junit.jupiter.api.Assertions.assertThrows(PessoaSemNomeException.class, () -> cadastro.adicionar(pessoa));

    }

    @Test
    @DisplayName("Deve remover uma pessoas")
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

    @Test
    @DisplayName("Deve lançar erro ao tentar remover pessoa inexistente")
    public void deveLancarErroAoTentarRemoverPessoaInexistente(){
        //Cenário
        CadastroPessoas cadastro = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();

        //Execução
        org.junit.jupiter.api.Assertions.assertThrows(CadastroVazioException.class, () -> cadastro.remover(pessoa));
    }
}
