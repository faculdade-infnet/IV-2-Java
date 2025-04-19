package org.example;

import org.example.model.CarrinhoCompras;
import org.example.model.Cliente;
import org.example.model.Endereco;
import org.example.model.Produto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestFixtureTecnicas {

    @Test
    @DisplayName("Teste sem setup method")
    void testCarrinhoSemSetup() {
        // Arrange
        Cliente cliente = new Cliente("João Silva", "joao@email.com", "11987654321", true);
        Endereco endereco = new Endereco("Rua das Flores", "123", "Apto 101", "Centro", "São Paulo", "SP", "01234-567");
        cliente.adicionarEndereco(endereco);

        var carrinho = new CarrinhoCompras(cliente);

        Produto camiseta = new Produto("Camiseta", "Camiseta de algodão", 50.0, 10, "Vestuário");
        carrinho.adicionarItem(camiseta, 2);
        var expectedValue = 100.0;

        // ACT
        var total = carrinho.getTotal();

        // ASSERT
        Assertions.assertEquals(expectedValue, total);
    }
}