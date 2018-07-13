package br.com.romulo.suporte;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import br.com.romulo.tests.AdicionarNovoEndereçoNetshoesTest;
import br.com.romulo.tests.PesquisarProdutoNetshoesTest;

@RunWith(Suite.class)

@Suite.SuiteClasses({
   //PesquisarProdutoNetshoesTest.class,
   AdicionarNovoEndereçoNetshoesTest.class  
})

public class JunitTestSuite {   
}  