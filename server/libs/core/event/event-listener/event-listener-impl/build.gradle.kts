dependencies {
    api(project(":server:libs:core:event:event-listener:event-listener-api"))

    implementation("org.slf4j:slf4j-api")
    implementation("org.springframework:spring-context")
    implementation("org.springframework.boot:spring-boot")
    implementation(project(":server:libs:core:message-broker:message-broker-api"))
}
