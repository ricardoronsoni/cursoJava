package com.ricardoronsoni.curso;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ricardoronsoni.curso.domain.Categoria;
import com.ricardoronsoni.curso.domain.Cidade;
import com.ricardoronsoni.curso.domain.Cliente;
import com.ricardoronsoni.curso.domain.Endereco;
import com.ricardoronsoni.curso.domain.Estado;
import com.ricardoronsoni.curso.domain.Produto;
import com.ricardoronsoni.curso.domain.enums.TipoCliente;
import com.ricardoronsoni.curso.repositories.CategoriaRepository;
import com.ricardoronsoni.curso.repositories.CidadeRepository;
import com.ricardoronsoni.curso.repositories.ClienteRepository;
import com.ricardoronsoni.curso.repositories.EnderecoRepository;
import com.ricardoronsoni.curso.repositories.EstadoRepository;
import com.ricardoronsoni.curso.repositories.ProdutoRepository;


//o commandlinerunner é apenas para inserir os valores no banco antes do rodar a aplicacao
@SpringBootApplication
public class CursoApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	public static void main(String[] args) {
		SpringApplication.run(CursoApplication.class, args);
	}

	//esse metodo é apenas para inserir os valores no banco antes do rodar a aplicacao
	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "informatica");
		Categoria cat2 = new Categoria(null, "escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		//precisa fazer as duas associaçoes pq é N..N
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));		
		p1.getCategoria().addAll(Arrays.asList(cat1));
		p2.getCategoria().addAll(Arrays.asList(cat1, cat2));
		p3.getCategoria().addAll(Arrays.asList(cat1));
		
		
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlancia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		//precisa fazer so uma associacao pq é N..1 e a associao de cidade e estado foi feito nas linhas de cima
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "teste@gmail.com", "12345678900", TipoCliente.PESSOAFISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("981610305", "98765432"));
		
		Endereco e1 = new Endereco(null, "Rua Terara", "256", "sem fim", "Centro", "70680451", cli1, c1);
		Endereco e2 = new Endereco(null, "Rua Teradsdra", "22256", "sem ", "Centro", "70680331", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
	}

}
