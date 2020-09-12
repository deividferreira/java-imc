# Para executar
Configure o seu banco de dados postgres com o seguinte comando:
```sql
--o usuário
CREATE USER sa_teste WITH
    LOGIN
    NOSUPERUSER
    INHERIT
    NOCREATEDB
    NOCREATEROLE
    NOREPLICATION
    ENCRYPTED PASSWORD 'sa_teste';

--a base de dados
CREATE DATABASE db_imc
    WITH 
    OWNER = sa_teste
    ENCODING = 'UTF8'
    LC_COLLATE = 'en_US.utf8'
    LC_CTYPE = 'en_US.utf8'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;
```

Após a configuração, navegue até a pasta raiz do projeto e execute o seguinte comando:
```shell script
mvnw clean compile quarkus:dev
```

Com o processo concluído a aplicação já está disponível na porta 8080 do seu localhost.
````
http://localhost:8080/imc
````

# Para testar
Você pode importar o arquivo ``teste-imc.postman_collection`` que está na raíz, para o seu Postman e realizar
as requisições.



# Informações sobre o ``Quarkus``:


## teste-dev-java-imc project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

### Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```
./mvnw quarkus:dev
```

### Packaging and running the application

The application can be packaged using `./mvnw package`.
It produces the `teste-dev-java-imc-1.0.0-SNAPSHOT-runner.jar` file in the `/target` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/lib` directory.

The application is now runnable using `java -jar target/teste-dev-java-imc-1.0.0-SNAPSHOT-runner.jar`.

### Creating a native executable

You can create a native executable using: `./mvnw package -Pnative`.

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: `./mvnw package -Pnative -Dquarkus.native.container-build=true`.

You can then execute your native executable with: `./target/teste-dev-java-imc-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/building-native-image.