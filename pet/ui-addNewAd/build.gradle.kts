apply {
    from("$rootDir/android-library-build.gradle")
}


dependencies {
    "implementation"(project(Modules.core))
    "implementation"(project(Modules.components))
    "implementation"(project(Modules.petDatasource))
    "implementation"(project(Modules.petDomain))
    "implementation"(project(Modules.petInteractors))

    "implementation"(Coil.coil)

    // CameraX core library using the camera2 implementation
//    val cameraxversion = "1.0.2"
//    // The following line is optional, as the core library is included indirectly by camera-camera2
//    "implementation"("androidx.camera:camera-core:${cameraxversion}")
//    "implementation"("androidx.camera:camera-camera2:${cameraxversion}")
//    // If you want to additionally use the CameraX Lifecycle library
//    "implementation"("androidx.camera:camera-lifecycle:${cameraxversion}")
//    // If you want to additionally use the CameraX VideoCapture library
//    "implementation"("androidx.camera:camera-video:1.1.0-beta01")
//    // If you want to additionally use the CameraX View class
//    "implementation"("androidx.camera:camera-view:1.1.0-beta01")
//    // If you want to additionally use the CameraX Extensions library
    "implementation"("com.github.skydoves:landscapist-glide:1.5.1")
    "implementation" ("com.chargemap.compose:numberpicker:1.0.3")

    "implementation" ("androidx.activity:activity-ktx:1.5.0-alpha01")
    "implementation" ("dev.chrisbanes.accompanist:accompanist-glide:0.4.2")
    //"implementation"(project(mapOf("path" to ":app")))
}
