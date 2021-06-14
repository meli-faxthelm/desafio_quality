## Desafio Quality

---

### Instruções:
1. Baixar o repositório.
2. Importar o repositório pelo IntelliJ utilizando o maven.

---
### Considerações:
* A implementação foi feita utilizando somente um endpoint que retorna um DTO único com todos os valores solicitados nas especificações visto o sistema possuir somente um DTO de entrada.
> [POST] localhost:8080/valuate
* Os testes de integração encontram-se no diretório /integration enquanto os de unidade estão no diretório /unit, foi criado um dir /util para a criação de métodos auxiliares para a criação de entradas para os testes.
* O tratamento de exceptions e validações retorna um DTO de erro que contém o campo que o gerou, o valor que foi rejeitado e a mensagem de erro especificada no documento de requisitos. Caso a chamada tenha mais de um erro é retornada uma lista dessa estrutura. O nome dos campos segue o valor definido no Java, dessa forma não sendo 100% fiel aos nomes nos retornos, mas ajudando a encontrar em qual campo está o erro.
---
O exemplo de entrada utilizado para os testes:
```
{
    "prop_name": "Casa amarela",
    "prop_district": "Brooklin",
    "prop_rooms": [
        {
            "room_name": "Banheiro",
            "room_width": 2.0,
            "room_length": 1.0
        },
        {
            "room_name": "Cozinha",
            "room_width": 3.0,
            "room_length": 3.0
        },
        {
            "room_name": "Sala",
            "room_width": 4.0,
            "room_length": 3.0
        }
    ]
}
```