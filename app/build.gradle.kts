import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    alias(libs.plugins.ksp)
}

android {
    namespace = "ltd.ucode.panopticon"
    compileSdk = 33

    defaultConfig {
        applicationId = "ltd.ucode.panopticon"
        minSdk = 23
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
        multiDexEnabled = true

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
        getByName("debug") {
            enableUnitTestCoverage = true
            enableAndroidTestCoverage = true
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.get() as String
    }

    packaging {
        resources {
            excludes += "/META-INF/MPL2.0"
        }
    }

    testOptions {
        unitTests.all {
            it.testLogging {
                events = setOf(TestLogEvent.FAILED, TestLogEvent.PASSED, TestLogEvent.SKIPPED)
            }
        }
    }
}

val androidExclusion = arrayOf(
    "**/databinding/**/*.*",
    "**/android/databinding/*Binding.*",
    "**/BR.*",
    "**/R.*",
    "**/R$*.*",
    "**/BuildConfig.*",
    "**/Manifest*.*",
    "**/*_MembersInjector.*",
    "**/Dagger*Component.*",
    "**/Dagger*Component\$Builder.*",
    "**/*Module_*Factory.*",
    "**/*Fragment*.*",
    "**/*Activity*.*",
    "**/*Adapter*.*",
    "**/*ViewPager*.*",
    "**/*ViewHolder*.*",
    "**/*Module*.*"
)

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation(libs.bundles.android.basic)
    implementation(libs.bundles.compose)
    implementation(libs.bundles.koin)
    implementation(libs.bundles.accompanist)
    implementation(libs.bundles.retrofit)
    implementation(libs.bundles.room)
    //annotationProcessor(libs.room.compiler)
    //kapt(libs.room.compiler)
    ksp(libs.room.compiler)
    implementation(libs.bundles.coroutines)
    testImplementation(libs.bundles.testing)
    androidTestImplementation(libs.bundles.android.tests)

    implementation("androidx.multidex:multidex:${libs.versions.multidex.get()}")
}
