import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.10"
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation "com.squareup.okhttp3:okhttp:4.6.0"
    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.5"
    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.0"
    implementation "com.apollographql.apollo:apollo-runtime:2.0.1"
    implementation "com.apollographql.apollo:apollo-coroutines-support:2.0.1”
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("MainKt")
    apply plugin: 'com.apollographql.apollo'
}

apollo {
    generateModelBuilder = true
}
