dependencies {
    api("org.springframework.data:spring-data-commons")
    api(project(":server:libs:core:message-broker:message-broker-api"))

    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml")
    implementation("org.springframework.data:spring-data-relational")
    implementation(project(":server:libs:core:commons:commons-util"))
}
