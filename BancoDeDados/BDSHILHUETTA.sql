CREATE DATABASE BDSILHUETTA;

USE BDSILHUETTA;

/***** TABELA CLIENTES *****/
CREATE TABLE tb_clientes (
  id int auto_increment primary key,
  nome varchar(100),
  cpf varchar (20),
  celular varchar(30),
  email varchar(200),
  cep varchar(100),
  endereco varchar (255)
);
/*****************/

/***** TABELA FORNECEDORES *****/
CREATE TABLE tb_fornecedores (
  id int auto_increment primary key,
  nome varchar(100),
  cnpj varchar (100),
  email varchar(200),
  celular varchar(30),
  cep varchar(100),
  endereco varchar (255)
);
/*****************/

/***** TABELA FUNCIONARIOS *****/
CREATE TABLE tb_funcionarios (
  id int auto_increment primary key,
  nome varchar(100),
  rg varchar (30),
  cpf varchar (20),
  email varchar(200),
  senha varchar(20),
  celular varchar(30),
  cep varchar(100),
  endereco varchar (255),
  nivel_acesso varchar (20)
);
/*****************/


/***** TABELA PRODUTOS *****/
CREATE TABLE tb_produtos (
  id int auto_increment primary key,
  codigo varchar(100),
  referencia varchar(100),
  produto varchar(100),
  cor varchar(18),
  tipo varchar(20),
  tamanho varchar(20),
  preco decimal (10,2),
  qtd_estoque int,
  fornecedor varchar(100)
);
/*****************/

/***** TABELA VENDAS *****/
CREATE TABLE tb_vendas (
  id int auto_increment primary key,
  cliente_nome varchar(100),
  cliente_cpf varchar(20),
  data_venda datetime,
  total_venda decimal (10,2),
  dinheiro decimal (10,2),
  debito decimal (10,2),
  pix decimal (10,2),
  link decimal (10,2),
  credito decimal (10,2),
  parcelas varchar (2),
  cliente_endereco varchar(100),
  cliente_referencia varchar(100),
  observacoes text
);
/*****************/

/***** TABELA ITENS_VENDAS *****/
CREATE TABLE tb_itensvendas (
  id int auto_increment primary key,
  venda_id int,
  produto_id int,
  qtd int,
  subtotal decimal (10,2),

  FOREIGN KEY (venda_id) REFERENCES tb_vendas(id),
  FOREIGN KEY (produto_id) REFERENCES tb_produtos(id)
);
/*****************/