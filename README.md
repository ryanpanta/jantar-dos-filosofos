# Problema dos Filósofos - Solução com Threads em Java e C++

## Descrição
Este repositório contém a implementação de duas soluções para o clássico problema dos filósofos utilizando threads. O problema dos filósofos é um cenário comum em programação concorrente, onde um grupo de filósofos está sentado em uma mesa redonda, cada um com um prato de espaguete e um garfo entre dois pratos. Os filósofos passam seu tempo alternando entre pensar e comer. No entanto, para comer, um filósofo precisa pegar dois garfos e, portanto, o desafio é evitar deadlock e garantir que todos os filósofos possam comer sem ficar bloqueados.

## Soluções Implementadas
### Java
A solução em Java foi desenvolvida usando a linguagem Java e a API de threads. O código está estruturado de forma a evitar condições de corrida e deadlock, garantindo a sincronização adequada para que os filósofos possam alternar entre pensar e comer de maneira segura.

### C++
A solução em C++ foi implementada utilizando a biblioteca padrão do C++ para manipulação de threads. A abordagem é semelhante à solução em Java, garantindo a exclusão mútua e a sincronização apropriada para evitar problemas de concorrência.

## Licença
Este projeto está licenciado sob a Licença MIT - consulte o arquivo [LICENSE](https://github.com/ryanpanta/jantar-dos-filosofos/blob/master/LICENSE) para obter detalhes.
