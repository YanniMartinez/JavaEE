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

## Correr proyecto
Para correr nuestro proyecto debemos irnos a `edit configurations` despues de darle en Run. **add new** --> **maven**:

* name: tomcat7
* Command Line:tomcat7:redeploy

Y finalmente dar en **apply**.

Veremos que ahora si nos da la opción de ejecutar nuestro server, pero antes de eso hay que levantar appache, para ello debemos abrir una terminal, buscar nuestro directorio donde almacenamos appache 10 y ejecutamos un comando como el siguiente:

```
cd tomcatPath/bin
startup.bat
```

Finalmente ejecutar en el IntelliJ, si marca error hay que agregar el siguiente pluggin:
```
<!-- Maven War pluggin -->
<plugin>
    <artifactId>maven-war-plugin</artifactId>
    <version>3.3.2</version>
    <configuration>
        <failOnMissingWebXml>false</failOnMissingWebXml>
    </configuration>
</plugin>
```



## Respaldo de variables de entorno anteriores al curso
C:\ProgramData\Oracle\Java\javapath

C:\Program Files\Common Files\Oracle\Java\javapath

### Creación de plantillas en IntelliJ
Presionando Ctl + alt + s. Editor --> Live Templates --> New