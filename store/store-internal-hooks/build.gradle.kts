@file:Suppress("UnstableApiUsage")

import com.vanniktech.maven.publish.SonatypeHost.Companion.CENTRAL_PORTAL
import dev.mattramotar.storex.tooling.extensions.android

plugins {
    id("plugin.storex.android.library")
    id("plugin.storex.kotlin.multiplatform")
    alias(libs.plugins.maven.publish)
}

android {
    namespace = "dev.mattramotar.storex.store.internal.hooks"

    testOptions {
        unitTests {
            isReturnDefaultValues = true
        }
    }
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                api(libs.kotlinx.coroutines.core)
                implementation(projects.storexTelemetry)
            }
        }
    }
}

mavenPublishing {
    publishToMavenCentral(CENTRAL_PORTAL, automaticRelease = true)
    signAllPublications()
}

group = "dev.mattramotar.storex.store"
version = libs.versions.storex.store.core.get()