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
