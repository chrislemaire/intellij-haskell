plugins {
    id("java")
    id("org.jetbrains.intellij") version "1.12.0"
    id("org.jetbrains.kotlin.jvm") version "1.8.0"
}

group = "haskellij"
version = "2.0.0"

repositories {
    mavenLocal()
    mavenCentral()
    maven("https://jitpack.io")
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
}

sourceSets["main"].java {
    srcDirs += srcDir("src/main/gen")
}

sourceSets["main"].kotlin {
    srcDirs += srcDir("src/main/gen")
}

idea {
    module {
        sourceDirs = setOf(file("src/main/kotlin"))
        generatedSourceDirs = setOf(file("src/main/gen"))
    }
}

// See https://github.com/JetBrains/gradle-intellij-plugin/
intellij {
    version.set("2022.1.4")

    plugins.set(setOf("java"))
}

tasks {
    buildSearchableOptions {
        enabled = false
    }

    patchPluginXml {
        version.set("${project.version}")
        sinceBuild.set("221")
        untilBuild.set("223.*")
    }

    compileKotlin {
        kotlinOptions.jvmTarget = "11"
    }

    compileTestKotlin {
        kotlinOptions.jvmTarget = "11"
    }

    test {
        useJUnit()
    }
}

dependencies {
    implementation("org.eclipse.lsp4j", "org.eclipse.lsp4j", "0.9.0")
}
