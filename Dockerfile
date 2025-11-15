FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app/app
#RUN mkdir -p /app/autenticar/db

# Copiar todo el código fuente del proyecto
COPY autenticar ./ 

# Construir proyecto
RUN mvn -B -DskipTests=true clean package

FROM eclipse-temurin:21-jre
WORKDIR /app/app
#RUN mkdir -p /app/autenticar/db

# Copiar el archivo jar compilado
COPY --from=build /app/app/target/*.jar app.jar

# Copiar archivo de base de datos SQLite al contenedor
#COPY app/db/usuarios.db /app/autenticar/db/usuarios.db

CMD ["sh","-c","java -Dserver.port=${PORT:-4002} -jar /app/app/app.jar"]
