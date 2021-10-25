package cursosdousa;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PrimeiroTeste {

    private Calculadora calculadora = new Calculadora();
    int numero1 = 10, numero2 = 5;;


    @BeforeEach
    public void setUp() {
        Calculadora calculadora = new Calculadora();
    }

    @Test
    @DisplayName("Deve somar 2 números")
    public void deveSomar2Numeros(){
        // cenário do teste

        //execução
        int resultado = calculadora.somar(numero1, numero2);;

        //verificação

        Assertions.assertThat(resultado).isEqualTo(15);
    }

    @Test//(expected = RuntimeException.class)
    @DisplayName("Não deve somar números negativos")
    public void naoDeveSomarNumerosNegativos(){
        // cenário do teste
        int num1 = -10, num2 = -5;

        //execução
        org.junit.jupiter.api.Assertions.assertThrows(RuntimeException.class, () ->calculadora.somar(num1, num2));
    }

    @Test
    @DisplayName("Deve subtrair 2 números")
    public void deveSubtrair2Numeros(){
        // cenário do teste

        //execução
        int resultado = calculadora.subtrair( numero1, numero2);

        Assertions.assertThat(resultado).isEqualTo(5);
    }

    @Test
    @DisplayName("Deve multiplicar 2 números")
    public void deveMultiplicar2Numeros(){
        // cenário do teste

        //execução
        int resultado = calculadora.multiplicar(numero1, numero2);

        //verificação
        Assertions.assertThat(resultado).isEqualTo(50);
    }

    @Test
    @DisplayName("Deve dividir 2 números")
    public void dividir2Numeros(){
        // cenário do teste

        //execução
        float resultado = calculadora.dividir(numero1, numero2);

        //Verificação
        Assertions.assertThat(resultado).isEqualTo(2);
    }

    @Test
    @DisplayName("Deve multiplicar 2 números")
    public void naoDeveDividirNumerosIgualZero(){
        // cenário do teste
        int numero1 = 10, numero2 = 0;

        //Verificação
        org.junit.jupiter.api.Assertions
                .assertThrows(ArithmeticException.class, ()-> calculadora.dividir(numero1, numero2));
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
