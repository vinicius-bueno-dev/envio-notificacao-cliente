# 1º ESTÁGIO: CONSTRUÇÃO DO APP
FROM maven:3.9.4-eclipse-temurin-21 AS builder
WORKDIR /app

# Copia o pom.xml e baixa dependências (para cache)
COPY pom.xml .
RUN mvn dependency:go-offline

# Copia o código-fonte e faz o build
COPY src ./src
RUN mvn clean package -DskipTests

# 2º ESTÁGIO: IMAGEM PARA RODAR
FROM eclipse-temurin:21-jre
WORKDIR /app

# Copia o jar do estágio anterior
COPY --from=builder /app/target/*.jar /app/app.jar

# Expõe a porta em que a aplicação roda (ajuste conforme necessário)
EXPOSE 8080

# Comando de inicialização
CMD ["java", "-jar", "/app/app.jar"]