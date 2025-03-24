plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)

    // safe args
    id ("androidx.navigation.safeargs.kotlin")
}

android {
    namespace = "com.example.quizmvp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.quizmvp"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures{
        viewBinding = true
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.core.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    // ViewBinding Krich Javohir Oromov     implementation("com.github.kirich1409:viewbindingpropertydelegate:1.5.9")
    implementation(libs.viewbindingpropertydelegate)

    // Navigation Component Javohir Oromov  implementation("androidx.navigation:navigation-fragment-ktx:2.7.6")
    //    implementation("androidx.navigation:navigation-ui-ktx:2.7.6")
    implementation(libs.navigation.fragment.ktx)
    implementation(libs.navigation.ui.ktx)
}