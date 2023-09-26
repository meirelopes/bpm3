package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TurmaTest {

    Turma turma;

    public TurmaTest() {
    }

    @BeforeEach
    public void setUp() throws Exception {
        Pessoa pessoa1 = new Pessoa(1, "Fulano");
        Pessoa pessoa2 = new Pessoa(2, "Beltrano");
        Pessoa pessoa3 = new Pessoa(3, "Ciclano");
        this.turma = new Turma();
        this.turma.adicionarPessoa(pessoa1);
        this.turma.adicionarPessoa(pessoa2);
        this.turma.adicionarPessoa(pessoa3);
    }

    @AfterEach
    public void tearDown() {
        this.turma.removerTodasPessoas();
    }

    @Test
    @DisplayName("deve adicionar uma pessoa com dados validos")
    public void test1() throws Exception {

        //cenario

        Pessoa pessoa4 = new Pessoa(4, "Meire");

        //acao e validacao

        this.turma.adicionarPessoa(pessoa4);

        assertEquals(4, this.turma.pessoas.size());

    }

    @Test
    @DisplayName("deve retornar excecao com mensagem objeto pessoa invalido se id for menor ou igual a 0")
    public void test2() throws Exception {

        //cenario

        Pessoa pessoa4 = new Pessoa(0, "Meire");

        //acao e validacao

        try {
            this.turma.adicionarPessoa(pessoa4);
        } catch (Exception e) {
            assert e.getMessage().equals("Objeto pessoa inválido");
        }

        assertEquals(3, this.turma.pessoas.size());

    }

    @Test
    @DisplayName("deve retornar excecao com mensagem Objeto pessoa já está atribuido a turma ao adicionar pessoa com mesmo Id")
    public void test3() throws Exception {

        //cenario

        Pessoa pessoa4 = new Pessoa(1, "Meire");

        //acao e validacao

        try {
            this.turma.adicionarPessoa(pessoa4);
        } catch (Exception e) {
            assert e.getMessage().equals("Objeto pessoa já está atribuido a turma");
        }

        assertEquals(3, this.turma.pessoas.size());

    }
    @Test
    @DisplayName("deve retornar excecao com mensagem objeto pessoa invalido ao adicionar pessoa com nome vazio")
    public void test4() throws Exception {

        //cenario

        Pessoa pessoa4 = new Pessoa(4, "");

        //acao e validacao

        try {
            this.turma.adicionarPessoa(pessoa4);
        } catch (Exception e) {
            assert e.getMessage().equals("Objeto pessoa inválido");
        }

        assertEquals(3, this.turma.pessoas.size());

    }

    @Test
    @DisplayName("deve remover todas as pessoas da turma")
    public void teste5() throws Exception {

        //acao e validacao

        this.turma.removerTodasPessoas();

        assert this.turma.getPessoas().isEmpty();

    }




}

