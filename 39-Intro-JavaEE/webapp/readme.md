# Proyecto inicial

## WAR
Añadiendo el tipo de empaquetado como WAR Web ARchive.

`<packaging>war</packaging>`

## Insertando dependencias
Para poder continuar tendremos la inserción de dependencias. `alt+insert` y buscamos `jakartaee`  y seleccionamos: 

```
<dependencies>
    <dependency>
        <groupId>jakarta.platform</groupId>
        <artifactId>jakarta.jakartaee-api</artifactId>
        <version>9.0.0</version>
    </dependency>
</dependencies>
```

Además le indicamos `<scope>provided</scope>` debido a que será proveido por nuestro servidor, en este caso Apache Tomacat.

La otra manera de buscar todas estas dependencias es buscandolo directamente en **MVN Repository** por ejemplo el caso de [Jakarta EE](https://mvnrepository.com/artifact/jakarta.platform/jakarta.jakartaee-api)


Y finalmente añadimos la carpeta con los plugins para hacer uso de apache:

```
<!-- Incluyendo Plugins para su trabajo -->
<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-compiler-plugin</artifactId>
            <version>3.8.1</version>
        </plugin>

        <!-- Plugin de Tomcat-->
        <plugin>
            <groupId>org.apache.tomcat.maven</groupId>
            <artifactId>tomcat7-maven-plugin</artifactId>
            <version>2.2</version>

            <configuration>
                <url>http://localhost:8080/manager/text</url>
                <username>admin</username>
                <password>12345</password>
            </configuration>
        </plugin>
    </plugins>
</build>
```

## Creación de carpeta para recursos web
Una vez implementadas las dependencias y plugins hay que crear una carpeta dentro de src/main para almacenar todos los recursos web como HTML, CSS, JS. Vistas JSP.