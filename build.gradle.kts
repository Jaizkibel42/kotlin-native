plugins {
    kotlin("multiplatform") version "2.0.0"
}

repositories {
    mavenCentral()
}

dependencies {
    // kotlin deps have to be defined elsewhere
}

kotlin {
    macosArm64("mac") { // on macOS
        binaries {
            executable("hello")
        }
    }
    sourceSets {
        nativeMain.dependencies {
            // no java libs here !!!!
            implementation("com.github.ajalt.clikt:clikt:4.4.0")
// https://mvnrepository.com/artifact/com.lordcodes.turtle/turtle
        }
    }
    jvmToolchain(21)
}

tasks.withType<Wrapper> {
    gradleVersion = "8.9"
    distributionType = Wrapper.DistributionType.BIN
}