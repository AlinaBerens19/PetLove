apply {
    from("$rootDir/library-build.gradle")
}

plugins {
    kotlin(KotlinPlugins.serialization) version Kotlin.version
    id(SqlDelight.plugin)
}

dependencies {
    "implementation"(Ktor.core)
    "implementation"(Ktor.clientSerialization)
    "implementation"(Ktor.android)

    "implementation"(SqlDelight.runtime)

    "implementation"(project(Modules.petDomain))

}

sqldelight {
    database("PetDatabase") {
        packageName = "com.example.hero_datasource.cache"
        sourceFolders = listOf("sqldelight")
    }
}