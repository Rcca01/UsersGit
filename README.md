# GitHub Users

Uma simples aplicação desenvolvida em kotlin, consumindo a API do GITHUB para mostrar uma lista de
usuários. A aplicação realiza uma chamada http utilizando retrofit, com o escopo definido por
coroutines, sendo a viewmodel responsável em organizar o processo de comunicação dos dados com a View.
Todas as dependencias são organizadas pela biblioteca Koin.

Bibliotecas utilizadas:
- [Retrofit](https://square.github.io/retrofit/)
- [gson](https://github.com/google/gson)
- [Glide](https://bumptech.github.io/glide/)
- [Koin](https://insert-koin.io/)
-

Arquitetura utilizada/Desing Patterns:
- MVVM
- Coroutines
- Singleton
- Factory
- ...

Requisitos do projeto:
- compileSdk 33
- minSdk 24
