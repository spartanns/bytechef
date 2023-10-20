dependencies {
    api(project(":server:libs:hermes:hermes-component:hermes-component-context:hermes-component-context-api"))
    api(project(":server:libs:hermes:hermes-connection:hermes-connection-api"))
    api(project(":server:libs:hermes:hermes-definition-registry:hermes-definition-registry-api"))

    implementation("org.springframework:spring-context")
    implementation(project(":server:libs:core:commons:commons-util"))
    implementation(project(":server:libs:hermes:hermes-execution:hermes-execution-api"))
}
