# Test-API-Rest-assured

Antes de executar os testes automatizados, deve subir a API-Rest-assured
disponibilizada. 
Na raiz do projeto API, através de seu Prompt de Commando/Terminal/Console 
execute o comando, para que a API suba com a porta 8080.

mvn clean spring-boot:run

### Executando os Testes

##### Acessar src\test\java\br\com\automacaoAPI\teste
 Clicando com o botão direito do mouse em cima do package teste e clicando "Run 'Test in '..." para rodar todos os testes criados
 
##### Para executar os de cada endpoint deve abrir a classe de cada um conforme abaixo:
 - GetConsultaRestricaoTeste
 - GetRetornaSimulacaoTeste
 - PostInsereNovaSimulacaoTeste
 - PutAtualizaSimulacaoCPF
 - DeleteSimulacaoTeste
 
 E executar seus testes individuais.


### COM BASE NA DOCUMENTAÇÃO DISPONIBILIZADA SEGUE ABAIXO AS SEGUINTES CONSIDERAÇÕES SOBRE OS RETORNOS DIVERGENTES À DOCUMENTAÇÃO


####GET <host>/api/v1/simulacoes
##### Retorna HTTP Status 204 se não existir simulações cadastradas 
- NÃO RECEBO ESSE RETORNO QUANDO NÃO EXISTE SIMULAÇÃO CADASTRADA


####POST <host>/api/v1/simulacoes
##### Uma simulação para um mesmo CPF retorna um HTTP Status 409 com a mensagem "CPF já existente" 
- NO CASO DE CADASTRO DE PESSOAS JA EXISTENTE, O RETORNO QUE RECEBO É "CPF DUPLICADO"
- E O HTTP Status QUE ME RETORNA É 400 E NÃO 409


####PUT <host>/api/v1/simulacoes/{cpf}
#####Se o CPF não possuir uma simulação o HTTP Status 404 é retornado com a
mensagem "CPF não encontrado" 
- MENSAGEM DE RETORNO É "CPF 99999999999 não encontrado" E NÃO "CPF não encontrado"


####DELETE <host>/api/v1/simulacoes/{id}
#####Retorna o HTTP Status 404 com a mensagem "Simulação não encontrada" se não
existir a simulação pelo ID informado
- AO INSERIR UM ID NÃO EXISTENDE PARA DELETE, O RETORNO NO HTTP Status É 200 E NÃO 404, E A MENSAGEM DE RETORNO É "OK" E NÃO "Simulação não encontrada".

#####Retorna o HTTP Status 204 se simulação for removida com sucesso 
- AO DELETAR UM COF EXISTENTE O RETORNO HTTP Status É 200 E NÃO 204 E A MENSAGEM DE RETORNO É "OK"