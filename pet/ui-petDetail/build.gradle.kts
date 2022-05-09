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

    "implementation"("com.github.skydoves:landscapist-glide:1.5.1")
}
