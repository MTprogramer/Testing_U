plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    kotlin("kapt")

}

android {
    namespace = "com.example.unittesting"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.unittesting"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    testImplementation(libs.junit.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation ("androidx.test.ext:junit-ktx:1.2.1")

    val roomVersion = "2.6.1"
    implementation ("androidx.room:room-runtime:$roomVersion")
    kapt ("androidx.room:room-compiler:$roomVersion")
    implementation ("androidx.room:room-ktx:$roomVersion")

    // For Testing Room
    testImplementation ("androidx.room:room-testing:$roomVersion")

    // Optional: For Android Instrumented Tests
    androidTestImplementation ("androidx.room:room-testing:$roomVersion")

    //Mock
    testImplementation("org.mockito.kotlin:mockito-kotlin:3.2.0")
    testImplementation ("org.mockito:mockito-core:5.6.0")
//    testImplementation ("org.mockito:mockito-inline:2.13.0")

    androidTestImplementation ("android.arch.core:core-testing:1.0.0")
    androidTestImplementation ("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.3") // Update version as needed

}