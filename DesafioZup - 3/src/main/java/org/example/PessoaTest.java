package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PessoaTest {
    @Test
    @DisplayName("deve retornar true se id da pessoa for maior que zero e nome for diferente de vazio")
    public void teste1() {

        //cenario
        Pessoa pessoa1 = new Pessoa(1, "Meire");

        //acao e validacao

        assertTrue(pessoa1.valido());
    }

    @Test
    @DisplayName("deve retornar false se id da pessoa não for maior que zero")
    public void teste2() {

        //cenario
        Pessoa pessoa1 = new Pessoa(-1, "Meire");

        //acao e validacao

        assertFalse(pessoa1.valido());
    }
    @Test
    @DisplayName("deve retornar false se nome da pessoa for diferente de vazio")
    public void teste3() {

        //cenario
        Pessoa pessoa1 = new Pessoa(1, "");

        //acao e validacao

        assertFalse(pessoa1.valido());
    }
}