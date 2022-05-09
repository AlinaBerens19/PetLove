apply {
    from("$rootDir/library-build.gradle")
}

plugins {
    kotlin(KotlinPlugins.serialization) version Kotlin.version
}

dependencies {
    "implementation"(project(Modules.core))

    "implementation"(project(Modules.petDatasource))
    "implementation"(project(Modules.petDomain))

    "implementation"(KotlinX.coroutinesCore) // need for flows
}