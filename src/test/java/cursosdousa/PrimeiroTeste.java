package cursosdousa;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class PrimeiroTeste {

    private Calculadora calculadora = new Calculadora();
    int numero1 = 10, numero2 = 5;;


    @Before
    public void setUp() {
        Calculadora calculadora = new Calculadora();
    }

    @Test
    public void deveSomar2Numeros(){
        // cenário do teste

        //execução
        int resultado = calculadora.somar(numero1, numero2);;

        //verificação

        Assertions.assertThat(resultado).isEqualTo(15);
    }

    @Test(expected = RuntimeException.class)
    public void naoDeveSomarNumerosNegativos(){
        // cenário do teste
        int num1 = -10, num2 = -5;

        //execução
        calculadora.somar(num1, num2);;
    }

    @Test
    public void deveSubtrair2Numeros(){
        // cenário do teste

        //execução
        int resultado = calculadora.subtrair( numero1, numero2);

        Assertions.assertThat(resultado).isEqualTo(5);
    }

    @Test
    public void deveMultiplicar2Numeros(){
        // cenário do teste

        //execução
        int resultado = calculadora.multiplicar(numero1, numero2);

        //verificação
        Assertions.assertThat(resultado).isEqualTo(50);
    }

    @Test
    public void dividir2Numeros(){
        // cenário do teste

        //execução
        float resultado = calculadora.dividir(numero1, numero2);

        //Verificação
        Assertions.assertThat(resultado).isEqualTo(2);
    }

    @Test(expected = ArithmeticException.class)
    public void naoDeveDividirNumerosIgualZero(){
        // cenário do teste
        int numero1 = 10, numero2 = 0;
        //execução
        float resultado = calculadora.dividir(numero1, numero2);

        //Verificação
        Assertions.assertThat(resultado).isZero();
    }
}

class Calculadora{

    int somar(int num, int num2){
        if(num < 0 || num2 < 0)
            throw new RuntimeException("Não é permitido somar números negativos");
        return num + num2;
    }

    public int subtrair(int num, int num2){
        return num - num2;
    }

    public int multiplicar(int num, int num2){
        return num * num2;
    }

    public float dividir(int num, int num2){
        return num / num2;
    }
}
