import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget
import org.jetbrains.kotlin.konan.target.KonanTarget

plugins {

    kotlin(module = "multiplatform")
    kotlin(module = "plugin.serialization")
    alias(notation = libs.plugins.androidLibrary)
}

group = "ndk.banee"
version = "1.0-SNAPSHOT"

val libraryName = "account_ledger_lib"

kotlin {

    applyDefaultHierarchyTemplate()

    @OptIn(ExperimentalKotlinGradlePluginApi::class)
    compilerOptions {

//        allWarningsAsErrors = true
        verbose = true

        apiVersion = KotlinVersion.KOTLIN_2_2
        languageVersion = KotlinVersion.KOTLIN_2_2
    }

    jvm().apply {

        tasks.withType<Test>().configureEach {

            useJUnitPlatform()
        }

        compilations.all {

            compileTaskProvider.configure {

                compilerOptions {

                    javaParameters = true
                    jvmTarget = JvmTarget.JVM_21
                }
            }
        }
    }

    androidTarget().apply {

        publishAllLibraryVariants()
        compilations.all {

            compileTaskProvider.configure {

                compilerOptions {

                    javaParameters = true
                    jvmTarget = JvmTarget.JVM_21
                }
            }
        }
    }

    fun getNativeTarget(): KotlinNativeTarget {

        val hostOs: String = System.getProperty("os.name")
        val isArm64: Boolean = System.getProperty("os.arch") == "aarch64"
        val isMingwX64: Boolean = hostOs.startsWith(prefix = "Windows")
        return when {

            hostOs == "Mac OS X" && isArm64 -> macosArm64()
//        hostOs == "Mac OS X" && !isArm64 -> KotlinNativeSupportedOs.MacOsX64
//        hostOs == "Linux" && isArm64 -> KotlinNativeSupportedOs.LinuxArm64
            hostOs == "Linux" && !isArm64 -> linuxX64()
            isMingwX64 -> mingwX64()
            else -> throw GradleException("Unsupported OS.")
        }
    }

    val nativeTarget: KotlinNativeTarget = getNativeTarget()
    nativeTarget.apply {

        binaries {

            staticLib {

                //TODO : Rename sub module to avoid basename property
                baseName = libraryName
            }
        }
    }

    sourceSets.all {

        languageSettings.apply {

            languageVersion = KotlinVersion.KOTLIN_2_2.version
            apiVersion = KotlinVersion.KOTLIN_2_2.version
        }
    }

    sourceSets {

        val commonMain: KotlinSourceSet by getting {

            dependencies {

                implementation(dependencyNotation = "org.jetbrains.kotlinx:kotlinx-serialization-json:1.9.0")
                implementation(dependencyNotation = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.2")
                implementation(
                    dependencyNotation = project.dependencies.platform(

                        /* notation = */ "io.ktor:ktor-bom:3.4.0-eap-1520"
                    )
                )
                implementation(dependencyNotation = "io.ktor:ktor-client-core")
                implementation(dependencyNotation = "io.ktor:ktor-client-auth")
                implementation(dependencyNotation = "io.ktor:ktor-client-content-negotiation")
                implementation(dependencyNotation = "io.ktor:ktor-client-logging")
                implementation(dependencyNotation = "io.ktor:ktor-serialization-kotlinx-json")
                implementation(dependencyNotation = "com.soywiz.korlibs.klock:klock:4.0.10")
            }
        }

        val commonTest: KotlinSourceSet by getting {

            dependencies {

                implementation(dependencyNotation = kotlin(simpleModuleName = "test"))
            }
        }

        when (nativeTarget.konanTarget) {

            KonanTarget.MINGW_X64 -> {

                val nativeMain: KotlinSourceSet by getting {

                    dependencies {

//                        implementation(dependencyNotation = "io.ktor:ktor-client-curl")
                        implementation(dependencyNotation = "io.ktor:ktor-client-winhttp")
                    }
                }
            }

            KonanTarget.LINUX_X64 -> {

                val nativeMain: KotlinSourceSet by getting {

                    dependencies {

                        implementation(dependencyNotation = "io.ktor:ktor-client-curl")
//                        implementation(dependencyNotation = "io.ktor:ktor-client-cio")
                    }
                }
            }

            KonanTarget.MACOS_ARM64 -> {

                val nativeMain: KotlinSourceSet by getting {

                    dependencies {

                        implementation(dependencyNotation = "io.ktor:ktor-client-darwin")
                    }
                }
            }

            else -> throw GradleException("Unsupported OS.")
        }
    }
}

android {

    namespace = "account_ledger_library.multi_platform"
    compileSdk = 35

    compileOptions {

        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
}
