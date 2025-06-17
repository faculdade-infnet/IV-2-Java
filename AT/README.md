# Desenvolvimento de Serviços Web e Testes com Java
# Resolução da Etapa 1
### 1. Configure um projeto com Gradle e adicione a dependência do Javalin. Crie uma aplicação básica que inicia na porta 7000 e exponha o endpoint /hello, retornando "Hello, Javalin!".<br>
Código:
![Etapa1](documentos/imagens/Etapa1.png)

![Etapa1](documentos/imagens/Etapa1_1_b.png)
<br>Postman:
![Etapa1](documentos/imagens/Etapa1_1_c.png)
### 2. Implemente um endpoint GET chamado /status que retorna um JSON contendo status: ok e timestamp com a hora atual no formato ISO-8601.<br>
Código:
![Etapa1](documentos/imagens/Etapa1.png)

![Etapa1](documentos/imagens/Etapa1_2_b.png)
<br>Postman:
![Etapa1](documentos/imagens/Etapa1_2_c.png)
### 3. Implemente um endpoint POST chamado /echo, que recebe um JSON com a chave mensagem e retorna o mesmo conteúdo como resposta.<br>
Código:
![Etapa1](documentos/imagens/Etapa1.png)

![Etapa1](documentos/imagens/Etapa1_3_b.png)
<br>Postman:
![Etapa1](documentos/imagens/Etapa1_3_c.png)
### 4. Implemente um endpoint GET com path parameter /saudacao/{nome} que retorna:
{ "mensagem": "Olá, <nome>!" }<br>
Código:
![Etapa1](documentos/imagens/Etapa1.png)

![Etapa1](documentos/imagens/Etapa1_4_b.png)
<br>Postman:
![Etapa1](documentos/imagens/Etapa1_4_c.png)
### 5. Com base no caso de uso definido pelo professor, implemente um endpoint POST que receba um JSON com os atributos necessários (ex: nome, email, idade) e armazene os dados em uma estrutura em memória (como uma lista). Retorne status 201 ao criar com sucesso.
Código:
![Etapa1](documentos/imagens/Etapa1_5_a.png)
Classe Tarefa
![Etapa1](documentos/imagens/Etapa1_tarefas.png)
<br>Postman:
![Etapa1](documentos/imagens/Etapa1_5_c.png)
### 6. Implemente dois endpoints GET que:
#### 1- retorne todos os registros armazenados até o momento (ex: /usuarios, /tarefas, etc.).
Código:
![Etapa1](documentos/imagens/Etapa1_6_a1.png)
<br>Postman:
![Etapa1](documentos/imagens/Etapa1_6_a2.png)
#### 2- busque um item pelo identificador principal (ex: email, id ou nome) e retorne os dados em JSON. Caso não exista, retorne status 404.<br>
Código:
![Etapa1](documentos/imagens/Etapa1_6_b1.png)
<br>Postman:
![Etapa1](documentos/imagens/Etapa1_6_b2.png)

# Resolução da Etapa 2
### 1. Escreva um teste para o endpoint /hello, validando status 200 e a resposta "Hello, Javalin!".
Código e Teste:
![Etapa2](documentos/imagens/Etapa2_1.png)
### 2. Escreva um teste para o endpoint de criação (POST), simulando o envio de um novo item e verificando se o status retornado é 201.
Código e Teste:
![Etapa2](documentos/imagens/Etapa2_2.png)
### 3. Escreva um teste para o endpoint de busca (GET com path param), verificando se um item recém-cadastrado pode ser recuperado corretamente.
Código:
![Etapa2](documentos/imagens/Etapa2_3a.png)
Teste:
![Etapa2](documentos/imagens/Etapa2_3b.png)
### 4. Escreva um teste para o endpoint de listagem (GET), garantindo que ele retorne um array JSON não vazio após a criação de pelo menos um item.
Código:
![Etapa2](documentos/imagens/Etapa2_4.png)

# Resolução da Etapa 3
Para testar Todos os exercicios da Etapa3 deixe descomentado conforme a imagem abaixo:
![Etapa2](documentos/imagens/Etapa3.png)
### 1. Crie um cliente Java que envie uma requisição POST para o endpoint de criação, com um JSON representando um novo item do seu sistema (de acordo com o caso de uso definido pelo professor).
Na classe Etapa3 no main deixe descomentado somente o exercicio que quer testar:
![Etapa2](documentos/imagens/Etapa3_1.png)
### 2. Crie um cliente Java que realize uma requisição GET para o endpoint de listagem e imprima os dados retornados no console.
Na classe Etapa3 no main deixe descomentado somente o exercicio que quer testar:
![Etapa2](documentos/imagens/Etapa3_2_a.png)
Código da requisição
![Etapa2](documentos/imagens/Etapa3_2_b.png)
### 3. Crie um cliente Java que envie uma requisição GET com path param, buscando um item pelo identificador definido. Imprima a resposta e o código HTTP.
Na classe Etapa3 no main deixe descomentado somente o exercicio que quer testar:
![Etapa2](documentos/imagens/Etapa3_3_a.png)
Código da requisição
![Etapa2](documentos/imagens/Etapa3_3_b.png)
### 4. Crie um cliente Java que envie uma requisição GET para o endpoint /status e imprima o JSON com o status e timestamp.Na classe Etapa3 no main deixe descomentado somente o exercicio que quer testar:
Na classe Etapa3 no main deixe descomentado somente o exercicio que quer testar:
![Etapa2](documentos/imagens/Etapa3_4_a.png)
Código da requisição
![Etapa2](documentos/imagens/Etapa3_4_b.png)