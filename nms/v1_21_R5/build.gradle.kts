import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.convention.paperweight)
}

dependencies {
    paperweight.paperDevBundle("1.21.8-R0.1-SNAPSHOT")
}

tasks {
    compileJava {
        options.release = 21
    }
    compileKotlin {
        compilerOptions.jvmTarget = JvmTarget.JVM_21
    }
}

// BoxMC fork: the codebook remapper in 1.21.x dev bundles cannot read JDK 25 class files
// ("Unsupported class file major version 69"), so run paperweight's setup tools on JDK 21.
// Build-time only: the plugin classes are still compiled by the JDK 25 toolchain for release 21.
paperweight {
    javaLauncher = javaToolchains.launcherFor {
        languageVersion = JavaLanguageVersion.of(21)
    }
}
