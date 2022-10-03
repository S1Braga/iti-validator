
# Validator

Micro serviço de validação de senhas, documentos etc



## FAQ

#### Detalhes sobre a solução, e pensamento nas decisões;

A ideia na criação desse projeto foi criar um serviço de validação geral. Nesse primeiro momento foi implementado a validação de senha mas podendo evoluir de forma prática para validação de vários tipos de senhas, documentos etc.



## Documentação da API

```http
  POST v1/validate/password
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `password` | `string` | **Obrigatório**. Senha a ser analizada |

#### Retorna true ou false


## Rodando localmente

Para executar a aplicação é necessário seguir os seguintes passos:

```bash
  Abrir o terminal do git-bash ou de sua preferência
```
```bash
  Fazer o clone do projeto
```

```bash
  git clone 
```

Importe o projet na IDE de sua preferência

```bash
  Através do plugin do gradle execute o _application_ **bootRun**
```

Para a documentação da API, acesse o Swagger através

```bash
  http://localhost:8080/swagger-ui/index.html
```


## Stack utilizada

**Back-end:** Java, Spring, Gradle


## Autores

- [Saulo Braga](https://github.com/S1Braga)
