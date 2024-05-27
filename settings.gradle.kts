include(":app")

rootProject.name = "panopticon"

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            version("gradle", "8.2.0")
            version("kotlin", "1.9.24")
            val ksp = version("ksp", "1.9.24-1.0.20")
            version("coreKtx", "1.10.1")
            version("multidex", "2.0.1")
            version("appCompat", "1.4.0")
            version("material", "1.4.0")
            version("compose", "1.5.14")
            version("activityCompose", "1.4.3")
            version("runtimeCompose", "1.4.3")
            version("materialCompose", "1.4.3")
            version("uiCompose", "1.4.3")
            version("koin", "3.5.0")
            version("accompanist", "0.23.0")
            version("navigation", "2.6.0")
            version("coilCompose", "2.4.0")
            version("retrofit", "2.9.0")
            version("retrofitCoroutinesAdapter", "0.9.2")
            version("okhttpInterceptor", "4.9.3")
            version("gson", "2.9.0")
            version("room", "2.5.2")
            version("kotlinCoroutines", "1.6.0")

            plugin("ksp", "com.google.devtools.ksp").versionRef(ksp)

            library("ksp-symbolProcessing", "com.google.devtools.ksp", "symbol-processing-api").versionRef(ksp)

            library("android-core-ktx", "androidx.core", "core-ktx").versionRef("coreKtx")
            library("android-appcompat", "androidx.appcompat", "appcompat").versionRef("appCompat")
            library("android-material", "com.google.android.material", "material").versionRef("material")
            library("compose-ui", "androidx.compose.ui", "ui").versionRef("uiCompose")
            library("compose-material", "androidx.compose.material", "material").versionRef("materialCompose")
            library("compose-ui-tooling-preview", "androidx.compose.ui", "ui-tooling-preview").versionRef("uiCompose")
            library("compose-material-icons-extended", "androidx.compose.material", "material-icons-extended").versionRef("materialCompose")
            library("compose-runtime-livedata", "androidx.compose.runtime", "runtime-livedata").versionRef("runtimeCompose")
            library("activity-compose", "androidx.activity", "activity-compose").versionRef("activityCompose")
            library("compose-ui-tooling", "androidx.compose.ui", "ui-tooling").versionRef("uiCompose")
            library("compose-ui-test-junit4", "androidx.compose.ui", "ui-test-junit4").versionRef("uiCompose")

            library("koin-android", "io.insert-koin", "koin-android").versionRef("koin")
            library("koin-android-compat", "io.insert-koin", "koin-android-compat").versionRef("koin")
            library("koin-androidx-workmanager", "io.insert-koin", "koin-androidx-workmanager").versionRef("koin")
            library("koin-androidx-compose", "io.insert-koin", "koin-androidx-compose").versionRef("koin")
            library("koin-test", "io.insert-koin", "koin-test").versionRef("koin")

            library("accompanist-navigation-animation", "androidx.navigation", "navigation-compose").versionRef("navigation")
            library("accompanist-swiperefresh", "com.google.accompanist", "accompanist-swiperefresh").versionRef("accompanist")

            library("coil-compose", "io.coil-kt", "coil-compose").versionRef("coilCompose")

            library("retrofit-core", "com.squareup.retrofit2", "retrofit").versionRef("retrofit")
            library("retrofit-converter-gson", "com.squareup.retrofit2", "converter-gson").versionRef("retrofit")
            library("retrofit-coroutines-adapter", "com.jakewharton.retrofit", "retrofit2-kotlin-coroutines-adapter").versionRef("retrofitCoroutinesAdapter")
            library("okhttp-logging-interceptor", "com.squareup.okhttp3", "logging-interceptor").versionRef("okhttpInterceptor")
            library("gson-core", "com.google.code.gson", "gson").versionRef("gson")

            library("room", "androidx.room", "room-ktx").versionRef("room")
            library("room-runtime", "androidx.room", "room-runtime").versionRef("room")
            library("room-compiler", "androidx.room", "room-compiler").versionRef("room")

            library("kotlinx-coroutines-core", "org.jetbrains.kotlinx", "kotlinx-coroutines-core").versionRef("kotlinCoroutines")
            library("kotlinx-coroutines-android", "org.jetbrains.kotlinx", "kotlinx-coroutines-android").versionRef("kotlinCoroutines")
            library("kotlinx-coroutines-test", "org.jetbrains.kotlinx", "kotlinx-coroutines-test").version("1.4.1")

            library("mockk-core", "io.mockk", "mockk").version("1.12.0")
            library("junit-core", "junit", "junit").version("4.12")
            library("androidx-arch-core-testing", "androidx.arch.core", "core-testing").version("2.1.0")
            library("mockk-android", "io.mockk", "mockk-android").version("2.1.0")
            library("androidx-test-runner", "androidx.test", "runner").version("1.2.0")
            library("espresso-contrib", "androidx.test.espresso", "espresso-contrib").version("3.2.0")
            library("androidx-test-rules", "androidx.test", "rules").version("1.2.0")
            library("androidx-test-ext-junit-ktx", "androidx.test.ext", "junit-ktx").version("1.1.1")

            bundle("android-basic", listOf("android-core-ktx", "android-appcompat", "android-material"))

            bundle("compose", listOf(
                "compose-ui",
                "compose-material",
                "compose-ui-tooling-preview",
                "compose-material-icons-extended",
                "compose-runtime-livedata",
                "activity-compose",
                "coil-compose",
            ))

            bundle("koin", listOf(
                "koin-android",
                "koin-android-compat",
                "koin-androidx-workmanager",
                "koin-androidx-compose",
            ))

            bundle("accompanist", listOf(
                "accompanist-navigation-animation",
                "accompanist-swiperefresh",
            ))

            bundle("retrofit", listOf(
                "retrofit-core",
                "retrofit-converter-gson",
                "retrofit-coroutines-adapter",
                "okhttp-logging-interceptor",
                "gson-core",
            ))

            bundle("room", listOf("room", "room-runtime"))

            bundle("coroutines", listOf(
                "kotlinx-coroutines-core",
                "kotlinx-coroutines-android",
            ))

            bundle("testing", listOf(
                "mockk-core",
                "junit-core",
                "androidx-arch-core-testing",
                "kotlinx-coroutines-test",
            ))

            bundle("android-tests", listOf(
                "mockk-android",
                "androidx-test-runner",
                "espresso-contrib",
                "androidx-test-rules",
                "androidx-test-ext-junit-ktx",
            ))
        }
    }
}
