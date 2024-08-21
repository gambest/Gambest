Esse é o repositório que contém a solução para o desafio que está no guia do DevMagro. Eu o fiz sem consultar ao chat gpt, usando apenas minhas anotações de aulas e a documentação da Oracle. No início o código estava bem mal organizado e bizarro, mas já refatorei e acredito que está dentro de um padrão melhor, apesar de eu não ter ideia de como organizar bem um projeto em Java.

Este é o desafio que se encontra em https://docs.google.com/document/d/12ek1Wsd_ibuwTOjHtLPZwEWdy5-A7cRoO2Bf-v5G1_s/edit . Acessa la, é um guia incrível!!!

Além do que foi pedido no desafio, implementei um menu de usuário com as opções para cadastrar, modificar e atualizar os usuários. 

Também implementei um método que verifica quais usuarios precisam ser atualizados que se baseia nas perguntas adicionadas ou removidas. Caso uma pergunta seja removida, o programa remove a resposta referente à mesma ou caso seja adicionada, cria um alerta para atualização dos usuários.

Implementei também um sistema de tags para consulta de usuários. Ao cadastrar uma pergunta o sistema pedirá uma tag para impressão da informação do usuário, como no exemplo:

Também criei um sistema de logs que salva as modificações que foram realizadas, assim é possível recuperar informações perdidas por conta da remoção automática das perguntas. Cada log dura 7 dias e é atualizado na inicialização do sistema.

11 - Qual sua profissão?
Tag: Profissão
12 - Qual o seu hobbie?
Tag: Hobbie

Como fica a impressão:

Nome: NomeDoUsuario
...
Profissão: ProfissãoDoUsuario
Hobbie: HobbieDoUsuario
