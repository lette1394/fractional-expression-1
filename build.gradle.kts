plugins {
    id("org.jetbrains.kotlin.jvm") version "1.5.31" apply false
    application
    java
}

subprojects {
    apply {
        plugin("org.gradle.java")
        plugin("org.gradle.application")
        plugin("org.jetbrains.kotlin.jvm")
    }

    repositories {
        mavenCentral()
    }

    dependencies {
        implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
        implementation("com.google.guava:guava:30.1.1-jre")
        implementation("io.arrow-kt:arrow-core:1.0.1")

        testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
        testImplementation("org.junit.jupiter:junit-jupiter-engine:5.8.2")

        testImplementation("io.kotest:kotest-runner-junit5:5.1.0")
        testImplementation("io.kotest:kotest-assertions-core:5.1.0")
        testImplementation("io.kotest:kotest-property:5.1.0")
    }

    application {
        mainClass.set("com.github.lette1394.fractional.expression.AppKt")
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}
