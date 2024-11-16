plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("kotlin-kapt") // Habilitar KAPT
}

android {
    namespace = "com.quispe.alonso.laboratoriocalificado03"
    compileSdk = 35 // Actualizado a la versión 35

    defaultConfig {
        applicationId = "com.quispe.alonso.laboratoriocalificado03"
        minSdk = 24
        targetSdk = 35 // Actualizado a la versión 35
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
    buildFeatures {
        viewBinding = true // Habilitar ViewBinding
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation("androidx.recyclerview:recyclerview:1.3.1") // RecyclerView
    implementation("com.squareup.retrofit2:retrofit:2.9.0") // Retrofit
    implementation("com.squareup.retrofit2:converter-gson:2.9.0") // Conversor JSON
    implementation("com.github.bumptech.glide:glide:4.15.1") // Glide para imágenes
    kapt("com.github.bumptech.glide:compiler:4.15.1") // Glide Compiler
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
