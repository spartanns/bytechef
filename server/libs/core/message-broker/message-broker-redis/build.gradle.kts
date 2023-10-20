dependencies {
    api(project(":server:libs:core:message-broker:message-broker-api"))

    implementation("com.fasterxml.jackson.core:jackson-databind")
    implementation("org.slf4j:slf4j-api")
    implementation("org.springframework:spring-context")
    implementation("org.springframework.data:spring-data-redis")
    implementation("org.springframework.boot:spring-boot-autoconfigure")
    implementation("io.lettuce:lettuce-core")
    implementation(files("libs/jrsmq-2.0.0.jar"))
}
