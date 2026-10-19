plugins {
    kotlin("jvm") version "2.0.21"
    application
}

repositories {
    mavenCentral()
}

// Run one question:  gradlew run -PmainClass=lab01.part1.q1.WhoAmIKt
application {
    mainClass.set((project.findProperty("mainClass") as String?) ?: "lab01.part1.q1.WhoAmIKt")
}
