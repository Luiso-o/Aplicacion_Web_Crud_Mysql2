plugins {
	java
	id("org.springframework.boot") version "3.1.1"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
}

group = "cat.itacademy.barcelonactiva.TrujilloPortillo.Luis.s05.t01.n02"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
	maven("https://repo1.maven.org/maven2/")
	maven("https://repo.mysql.com/")
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springdoc:springdoc-openapi:2.0.4")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	implementation("mysql:mysql-connector-java:8.0.32")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	implementation("javax.servlet:javax.servlet-api:3.1.0")

	//Swagger dependency's
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.0.0")

}

tasks.withType<Test> {
	useJUnitPlatform()
}
