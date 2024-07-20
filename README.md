<h1 align="center" style="font-weight: bold;">Desafio Técnico Picpay - Backend</h1>

<h2 id="about">Enunciado do Desafio</h2>

O PicPay Simplificado é uma plataforma de pagamentos simplificada. Nela é possível depositar e realizar transferências de dinheiro entre usuários. Temos 2 tipos de usuários, os comuns e lojistas, ambos têm carteira com dinheiro e realizam transferências entre eles.]

<h2 id="about">Sobre o projeto</h2>

Aplicação backend desenvolvida em Java utilizando o Spring Framework, com as seguintes dependências: Spring JPA, Spring Web, Flyway Migration, Lombok e PostgreSQL Driver.

O desafio podia ser realizado em qualquer linguagem ou framework, e eu escolhi Java Spring por ser a tecnologia com a qual tenho mais familiaridade.

<h3 id="prerequisites">Pré Requisitos para instalação</h3>

É necessário ter o Java 22 instalado em sua máquina, além do Git para clonar o repositório.

<h2 id="routes">Endpoints</h2>

​
| Rota               | Descrição                                          
|----------------------|-----------------------------------------------------
| <kbd>POST /</kbd>     | Insere um usuario atraves de um request
| <kbd>POST /transfer</kbd>     | Realiza uma transferência utilizando um request body que informa o pagador, o destinatário e o valor da transação.

<h3>POST /</h3>

**REQUEST**
```json
{
  "identificador": "123.456.789-10",
  "nome_completo": "Kauã Lima de Souza",
  "email": "kaualimadesouza@gmail.com",
  "senha": "password5665778",
  "saldo": 100
}
```

<h3>POST /transfer</h3>

**REQUEST**
```json
{
  "value": 2,
  "payer": "12345678910",
  "payee": "84548788000165"
}
```

<h2 id="contato">Contato</h2>

Linkedin [@kaualimadesouza](https://www.linkedin.com/in/kaualimadesouza/) &nbsp;&middot;&nbsp;

