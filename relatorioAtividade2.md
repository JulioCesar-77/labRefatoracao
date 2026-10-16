# Relatório de Arquitetura — Padrão Strategy e Princípios SOLID

## 1. Aplicação do padrão Strategy e redução da Complexidade Ciclomática

O padrão Strategy foi aplicado para separar as regras de cálculo de frete em classes independentes: `FreteVipStrategy`, `FreteSudesteStrategy` e `FreteNacionalStrategy`, todas implementando a interface `EstrategiaFrete`.

Na implementação anterior, a classe `CalculadoraFrete` utilizava várias estruturas condicionais (`if/else`) para decidir o valor do frete. Com a refatoração, essas decisões foram distribuídas entre as estratégias concretas, simplificando o processamento da venda e reduzindo a complexidade ciclomática associada às regras de frete.

## 2. Princípio Aberto/Fechado (OCP)

O OCP estabelece que uma classe deve estar aberta para extensão, mas fechada para modificação.

A nova arquitetura respeita esse princípio porque novas modalidades de frete podem ser adicionadas por meio de novas classes que implementam `EstrategiaFrete`, sem exigir alterações no código interno de `ProcessadorDeVendas`. Dessa forma, é possível adicionar novas regras de cálculo sem modificar a lógica principal do processamento.

## 3. Princípio da Inversão de Dependência (DIP)

O DIP estabelece que módulos de alto nível devem depender de abstrações, e não de implementações concretas.

O `ProcessadorDeVendas` deixou de depender diretamente da classe concreta `CalculadoraFrete` e passou a depender da interface `EstrategiaFrete`. A estratégia é fornecida por meio do construtor, utilizando injeção de dependência.

Assim, o processador não precisa conhecer os detalhes de cada cálculo de frete, tornando o sistema mais flexível, extensível e fácil de manter.

## Conclusão

A aplicação do padrão Strategy permitiu separar as regras de frete, reduzir a complexidade das decisões condicionais e tornar o sistema mais flexível. A solução também demonstra a aplicação dos princípios OCP e DIP, facilitando a inclusão de novas modalidades de frete sem modificar o processamento principal das vendas.