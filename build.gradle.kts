plugins {
	java
	id("org.springframework.boot") version "4.0.1"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "com.jonasdurau"
version = "0.0.1-SNAPSHOT"
description = "API Marketplace de Tutoria"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-flyway")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.flywaydb:flyway-database-postgresql")

    // 1. HIBERNATE SPATIAL (Crucial para o PostGIS)
    // Permite usar tipos como Point, Polygon nas Entidades JPA
    implementation("org.hibernate.orm:hibernate-spatial")

    // 2. JACKSON JTS (Para JSON)
    // Faz o Spring saber converter um objeto Point do Java para JSON "latitude/longitude" automaticamente
    implementation("org.n52.jackson:jackson-datatype-jts:2.0.0")

    // 3. AWS SDK (Para o Magalu Cloud / S3)
    // Usaremos para upload de fotos de perfil e documentos
    implementation("io.awspring.cloud:spring-cloud-aws-starter-s3:4.0.0-M1")

	runtimeOnly("org.postgresql:postgresql")
	testImplementation("org.springframework.boot:spring-boot-starter-data-jpa-test")
	testImplementation("org.springframework.boot:spring-boot-starter-flyway-test")
	testImplementation("org.springframework.boot:spring-boot-starter-security-test")
	testImplementation("org.springframework.boot:spring-boot-starter-validation-test")
	testImplementation("org.springframework.boot:spring-boot-starter-webmvc-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
