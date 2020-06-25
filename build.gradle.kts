import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask
// Top-level build file where you can add configuration options common to all sub-projects/modules.

plugins {
    id(Plugins.versions) version Versions.versionsPlugin
}

allprojects {
    repositories {
        maven("https://nexus.inventale.com/repository/maven-public/") {
            name = "nexusInventale"
            credentials {
                username = (findProperty("inventale.nexus.user") ?: System.getenv("NEXUS_LOGIN")) as? String
                password = (findProperty("inventale.nexus.password") ?: System.getenv("NEXUS_PWD")) as? String
            }
        }
        mavenCentral()
    }
}

subprojects {
    tasks.register<Copy>("copyConfigsNearJar") {
        from("$projectDir/../config/")
        into("$buildDir/libs/")
    }
}

fun isNonStable(version: String): Boolean {
    val stableKeyword = listOf("RELEASE", "FINAL", "GA").any { version.toUpperCase().contains(it) }
    val regex = "^[0-9,.v-]+(-r)?$".toRegex()
    val isStable = stableKeyword || regex.matches(version)
    return isStable.not()
}


// You can see all outdated dependencies using the command `./gradlew dependencyUpdates`
tasks {
    named<DependencyUpdatesTask>("dependencyUpdates") {
        resolutionStrategy {
            componentSelection {
                all {
                    if (isNonStable(candidate.version) && !isNonStable(currentVersion)) {
                        reject("Release candidate")
                    }
                }
            }
        }
        checkForGradleUpdate = true
        outputFormatter = "json"
        outputDir = "build/dependencyUpdates"
        reportfileName = "report"
    }
}
