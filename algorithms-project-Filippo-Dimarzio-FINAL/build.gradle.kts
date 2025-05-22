import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin("jvm")
    id("org.jetbrains.compose")
    id("org.jetbrains.kotlin.plugin.compose")
}

group = "ie.setu"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    google()
}

dependencies {
    // For Compose Desktop UI
    implementation(compose.desktop.currentOs)

    // Material3 for Jetpack Compose
    implementation("org.jetbrains.compose.material3:material3-desktop:1.4.3")
    //implementation("androidx.compose.ui:ui:1.5.0") // Use the latest stable version
    //implementation("androidx.compose.foundation:foundation:1.5.0") // Use the latest stable version

    // Add other dependencies as required

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.0")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.7.0")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.7.0")
    testImplementation(kotlin("test"))
}

compose.desktop {
    application {
        mainClass = "MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "algorithms-project"
            packageVersion = "1.0.0"
        }
    }
}
