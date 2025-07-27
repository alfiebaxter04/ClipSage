plugins {
  kotlin("jvm") version "2.1.21"
  id("org.jetbrains.compose") version "1.8.2"
}

repositories {
  mavenCentral()
  maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
  google()
}

dependencies {
  implementation("org.jetbrains.compose.desktop:desktop-jvm-windows:1.8.2")
}

compose.desktop {
  application {
    mainClass = "MainKt"
  }
}
