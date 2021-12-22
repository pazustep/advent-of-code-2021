plugins {
    kotlin("jvm") version "1.6.0"
}

group = "to.bri"
version = "1"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(kotlin("reflect"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.2")
    testImplementation("com.willowtreeapps.assertk:assertk-jvm:0.25")
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}
