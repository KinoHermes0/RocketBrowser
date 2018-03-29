object Versions {
    val min_sdk = 21
    val target_sdk = 27
    val compile_sdk = 27
    val build_tools = "27.0.3"
    val version_code = 1
    val version_name = "2.0.0"
    val android_gradle_plugin = "3.0.1"
    val dicedmelon_jacoco_plugin = "0.1.2"
    val gms_oss_licenses_plugin = "0.9.1"
    val support = "27.0.2"
    val room = "1.0.0"
    val glide = "4.0.0"
    val kotlin = "1.2.30"
    val gms = "11.8.0"
    val findbugs = "3.0.1"
    val lottie = "2.2.0"
    val telemetry = "1.1.1"
    val adjust = "4.11.4"
    val junit = "4.12"
    val mockito = "2.12.0"
    val robolectric = "3.5.1"
    val espresso = "3.0.1"
    val test_runner = "1.0.1"
    val uiautomator = "2.1.3"
    val mockwebserver = "3.7.0"
}

object Libs {
    val android_gradle_plugin = "com.android.tools.build:gradle:${Versions.android_gradle_plugin}"
    val dicedmelon_jacoco_plugin = "com.dicedmelon.gradle:jacoco-android:${Versions.dicedmelon_jacoco_plugin}"
    val google_oss_licenses_plugin = "com.google.gms:oss-licenses:${Versions.gms_oss_licenses_plugin}"
    val kotlin_gradle_plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    val app_compat_v7 = "com.android.support:appcompat-v7:${Versions.support}"
    val customtabs = "com.android.support:customtabs:${Versions.support}"
    val support_v4 = "com.android.support:support-v4:${Versions.support}"
    val design = "com.android.support:design:${Versions.support}"
    val cardview_v7 = "com.android.support:cardview-v7:${Versions.support}"
    val support_annotations = "com.android.support:support-annotations:${Versions.support}"
    val room_runtime = "android.arch.persistence.room:runtime:${Versions.room}"
    val room_compiler = "android.arch.persistence.room:compiler:${Versions.room}"
    val room_testing = "android.arch.persistence.room:testing:${Versions.room}"
    val recyclerview_v7 = "com.android.support:recyclerview-v7:${Versions.support}"
    val glide_compiler = "com.github.bumptech.glide:compiler:${Versions.glide}"
    val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    val play_services_analytics = "com.google.android.gms:play-services-analytics:${Versions.gms}"
    val findbugs_annotations = "com.google.code.findbugs:annotations:${Versions.findbugs}"
    val lottie = "com.airbnb.android:lottie:${Versions.lottie}"
    val telemetry = "org.mozilla.telemetry:telemetry:${Versions.telemetry}"
    val adjust = "com.adjust.sdk:adjust-android:${Versions.adjust}"
    val junit = "junit:junit:${Versions.junit}"
    val mockito_core = "org.mockito:mockito-core:${Versions.mockito}"
    val robolectric = "org.robolectric:robolectric:${Versions.robolectric}"
    val espresso_core = "com.android.support.test.espresso:espresso-core:${Versions.espresso}"
    val espresso_idling_resource = "com.android.support.test.espresso:espresso-idling-resource:${Versions.espresso}"
    val espresso_contrib = "com.android.support.test.espresso:espresso-contrib:${Versions.espresso}"
    val espresso_web = "com.android.support.test.espresso:espresso-web:${Versions.espresso}"
    val test_runner = "com.android.support.test:runner:${Versions.test_runner}"
    val uiautomator_v18 = "com.android.support.test.uiautomator:uiautomator-v18:${Versions.uiautomator}"
    val mockwebserver = "com.squareup.okhttp3:mockwebserver:${Versions.mockwebserver}"
}