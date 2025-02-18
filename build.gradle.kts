

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    id("org.sonarqube") version "6.0.1.5171"
}

sonarqube {
    properties {
        property("sonar.projectKey", "MTprogramer_Testing_U")
        property("sonar.organization", "mtprogramer")
        property("sonar.host.url", "https://sonarcloud.io")
    }
}

// sonar qube version 6 create problem of bouncy castle during instrument test or builds
// you can resolve this by adding the block in your gradle
buildscript {
    dependencies {
        classpath("org.bouncycastle:bcutil-jdk18on:1.79")
    }
}