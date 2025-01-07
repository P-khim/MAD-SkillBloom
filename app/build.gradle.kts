plugins {
    alias(libs.plugins.android.application)

    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.skillbloomapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.skillbloomapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        viewBinding = true
        buildConfig = true
    }

    signingConfigs {
        create("release") {
            storeFile = file("C:/Users/ASUS ROG/OneDrive/Documents/SkillBloom.jks")
            storePassword = "skill123456"
            keyAlias = "SkillBloom"
            keyPassword = "skill123456"
        }
    }

    buildTypes {
        release {
            signingConfig = signingConfigs.getByName("release")
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    flavorDimensions += "SkillBloom"
    productFlavors {
        create("dev") {
            dimension = "SkillBloom"
            applicationId = "com.example.skillbloomapp.dev"
            resValue("string", "app_name", "Skill Bloom Test")
            buildConfigField("String", "apiBaseUrl", "\"http://10.0.2.2:8000/api/images/\"")
        }
        create("prd") {
            dimension = "SkillBloom"
            applicationId = "com.example.skillbloomapp"
            resValue("string", "app_name", "Skill Bloom")
            buildConfigField("String", "apiBaseUrl", "\"http://10.0.2.2:8000/api/\"")
        }
    }

    // Ensure Java 1.8 compatibility
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }


    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation("androidx.leanback:leanback:1.0.0")
    implementation("com.github.bumptech.glide:glide:4.11.0")
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
    implementation ("androidx.fragment:fragment-ktx:1.6.1")
    implementation ("androidx.core:core-ktx:1.0.2")
    implementation ("androidx.lifecycle:lifecycle-extensions:2.0.0")
    implementation("androidx.activity:activity-ktx:1.8.2")
    implementation ("com.squareup.picasso:picasso:2.71828")
    implementation ("com.google.android.material:material:1.9.0")
    implementation ("com.squareup.okhttp3:okhttp:4.9.0")
    implementation ("androidx.navigation:navigation-fragment-ktx:2.7.1")
    implementation ("androidx.navigation:navigation-ui-ktx:2.7.1")

}

