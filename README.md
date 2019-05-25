# Dillinger


#### Atividade Blackboard 02
- Projeto Estações de Autoatendimento - PEA
- Para driblar a crise, o dono de uma concessionária está querendo inovar no seu negócio de vendas de automóveis (carros,
vans, motos, caminhões e etc...). Ele teve a ideia de substituir os vendedores da concessionária por estações de
autoatendimento. A ideia é que o cliente possa usá-lo para consultar os automóveis existentes na loja, realizar suas compras
e receber o pedido.
- Diante disso, o projeto deve ser composto por um sistema de carrinho de compras automatizado e
inteligente, que permite o usuário listar todos os automóveis cadastrados no sistema e escolher quais
automóveis serão adicionados ao carrinho.
- Na adição de um automóvel ao carrinho, o usuário deve escolher a sua quantidade e cor, respeitando
a regra de que uma cor fosca aumenta em 3% o valor do automóvel. Um automóvel pode não ter a
opção de cores foscas, portanto um tratamento especial deve ser dado quando isso ocorrer. Além
disso, o usuário pode remover ou visualizar os itens do seu carrinho, com seus respectivos preços e valor total da compra.
- Por fim, o sistema deve permitir que o cliente finalize a sua compra e um número de pedido é gerado, acompanhado do
prazo de entrega de cada automóvel. Esta compra deve ser armazenada e o sistema deve retornar para o seu estado inicial,
permitindo que outro usuário também faça sua compra. Para evitar fraudes, o sistema deve permitir a compra de, no máximo,
10 itens de cada automóvel. Este tratamento deve ser feito quando o cliente finalizar a compra.
- Portanto, o sistema deve possuir as seguintes funcionalidades:
    1. Cadastrar automóveis (acesso restrito com senha: 123)
    2. Listar automóveis
    3. Adicionar automóveis ao carrinho com sua quantidade e cor
    4. Visualizar o carrinho
    5. Excluir automóvel do carrinho
    6. Finalizar a compra
    7. Consultar pedido (usando o número gerado)
    8. Listar compras realizadas (acesso restrito com senha: 123)
    9. Controlar estoque (opcional) (acesso restrito com senha: 123)
- Além disso, a coleção utilizada deve ser implementada pelo aluno. O Aluno deve criar uma nova classe concreta, que represente uma coleção e que implemente uma das interfaces do Framework Collections.
- Para a implementação do sistema, utilizar as seguintes regras (implementar a funcionalidade sem suas respectivas regras
implica na perda de 50% da sua pontuação):
    • Utilizar Interfaces e Herança
    • Utilizar coleções (nova coleção criada pelo aluno);
    • Utilizar exceções nos seguintes casos:
    - Ao cadastrar um automóvel já existente;
    - Ao escolher uma cor metalizada não disponível para um veículo;
    - Ao finalizar a compra e houver um automóvel acima do limite máximo permitido (10);
    - Efetuar a compra de um automóvel que não tem em estoque (opcional)
- Atenção:
    • Trabalho individual
    • Apresentação oral de todos os alunos
    • A ausência do aluno implica em redução de 50% na nota do projeto
    • Trabalhos semelhantes terão pesos reduzidos

### Tecnologias

  - Java 8
  