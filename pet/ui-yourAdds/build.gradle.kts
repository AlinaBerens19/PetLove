apply {
    from("$rootDir/android-library-build.gradle")
}


dependencies {
    "implementation"(project(Modules.core))
    "implementation"(project(Modules.petDatasource))
    "implementation"(project(Modules.petDomain))
    "implementation"(project(Modules.petInteractors))

    "implementation"(Accompanist.version)
    "implementation"(Coil.coil)
    "implementation"(SqlDelight.androidDriver)

    "implementation" ("androidx.activity:activity-ktx:1.5.0-alpha01")
    "implementation" ("dev.chrisbanes.accompanist:accompanist-glide:0.4.2")
}
