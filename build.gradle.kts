plugins {
    kotlin("jvm") version "1.6.10"
    kotlin("kapt") version "1.6.10"
    id("org.jetbrains.kotlin.plugin.allopen") version "1.6.10"

    id("io.micronaut.application") version "3.3.0"
}

version = "0.1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.micronaut.views:micronaut-views-thymeleaf")
}

tasks.withType<JavaCompile>().configureEach {
    targetCompatibility = "11"
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = "11"
    }
}

application {
    mainClass.set("me.samoylenko.examples.vulnerable.Application")
}

micronaut {
    version("2.4.2")
    runtime("netty")
}
