dependencies {
    api(project(":server:libs:core:tag:tag-api"))

    implementation("org.springframework.data:spring-data-jdbc")
    implementation(project(":server:libs:core:commons:commons-data"))
    implementation(project(":server:libs:core:commons:commons-util"))
}
