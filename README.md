# Importador de arquivos XML
## Principais tecnologias utilizadas na importação

- Banco de Dados H2
- Spring Batch
- Maven
- JPA

## Funcionalidades

- Importação de arquivo XML
- Controlador importação de arquivos
- Geracao de dados consolidados da importação do arquivo XML

## Características
Para facilidades os arquivos importados são armazenados dentro do próprio projeto da pasta resources.
O limite de importação dos arquivos é de 100M mas poderá ser alterado no properties.


## Para rodar o projeto

Você pode rodar o projeto usando /mvnw spring-boot:run.
Ou você pode buildar o projeto com o arquivo JAR com ./mvnw clean package  e rodar o jar com o seguinte comando:
>java -jar target/challenge-0.0.1.jar

## Saídas do projeto

Logs são impressos os códgos dos Agentes

![image](https://user-images.githubusercontent.com/1148082/212896604-03a325a4-db7c-4920-9a69-c5078e2ff6ab.png)

Tabela Agente:
![image](https://user-images.githubusercontent.com/1148082/212897409-4b896864-3aef-4d82-b4ec-9f5d45c0f562.png)

Tabela Regiao com o código do Agente responsável

![image](https://user-images.githubusercontent.com/1148082/212897136-54d8fd6e-d029-41a4-bda5-443eb49fe754.png)

Os valores de geração e compra foram sumarizados



