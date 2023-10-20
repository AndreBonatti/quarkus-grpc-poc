### Projeto prova de conceito cliente servidor utilizando GRPC e programação reativa

Para subir os 2 projetos e debugar utilize o comando abaixo e troque a porta para cada projeto.

```shell script
./mvnw quarkus:dev -Ddebug=5005
```

Porta 9001 utilizada para a comunicação grpc

Para funcionar o GRPC necessário o arquivo .proto ele cria as interfaces de comunicação e a partir dele compilando o projeto se cria as classes necessárias em "target/generated-sources/grpc". 

Necessário o arquivo nos dois projetos que vão se comunicar.

No exemplo é criado um projeto cliente com uma interface rest com sincrona e assincrona, com interfaces diferentes de comunicação com outro projeto server que tem implementação do serviço GPRC.


#### Uma explanação maior sobre GRPC

https://www.youtube.com/watch?v=t1L0ocYYruY&list=PLkX9oUrQ1ev6g-0Hx2iNmYohYg4L1H8vg&ab_channel=Zup
