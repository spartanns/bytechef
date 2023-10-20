dependencies {
    api(project(":server:libs:hermes:hermes-scheduler:hermes-scheduler-api"))

    implementation("org.springframework:spring-context")
    implementation(project(":server:libs:core:commons:commons-util"))

    implementation(project(":server:ee:libs:core:commons:commons-discovery"))
    implementation(project(":server:ee:libs:core:commons:commons-webclient"))
}
