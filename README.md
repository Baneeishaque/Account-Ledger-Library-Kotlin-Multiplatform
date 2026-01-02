<p align="center">
  <img src="https://img.shields.io/badge/Kotlin-2.2.20-blue?logo=kotlin" alt="Kotlin Version">
  <img src="https://img.shields.io/badge/Gradle-9.1.0-02303A?logo=gradle" alt="Gradle Version">
  <img src="https://img.shields.io/badge/Platform-JVM%20%7C%20Android%20%7C%20Linux%20%7C%20Windows%20%7C%20macOS-success" alt="Platforms">
  <img src="https://img.shields.io/badge/License-MIT-yellow.svg" alt="License">
</p>

# Account Ledger Library - Kotlin Multiplatform

A **Kotlin Multiplatform** library for account ledger management that provides cross-platform functionality for parsing, processing, and managing financial transaction data from GitHub Gists. Built with modern Kotlin features and designed for seamless integration across JVM, Android, and native platforms (Linux, Windows, macOS).

---

## 📋 Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Architecture](#architecture)
- [Technology Stack](#technology-stack)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Building](#building)
- [Project Structure](#project-structure)
- [API Reference](#api-reference)
- [C/C++ Interoperability](#cc-interoperability)
- [Testing](#testing)
- [CI/CD](#cicd)
- [Configuration](#configuration)
- [Contributing](#contributing)
- [License](#license)

---

## Overview

Account Ledger Library is a Kotlin Multiplatform library that enables developers to:

- **Parse account ledger data** from GitHub Gists in multiple format versions (V2, V3, V4)
- **Process financial transactions** with support for dates, balances, and transaction particulars
- **Generate serialized output** in JSON format for API consumption
- **Cross-platform deployment** as a native static library for C/C++ interoperability

The library uses **Ktor** for HTTP client functionality, **kotlinx.serialization** for JSON processing, and **Klock** (korlibs) for date/time operations.

---

## Features

### Core Functionality
- ✅ **Multi-format Gist Processing** - Support for V2, V3, and V4 ledger formats
- ✅ **Transaction Parsing** - Parse transaction particulars, amounts, dates, and balances
- ✅ **Account Management** - Handle multiple accounts with unique identifiers
- ✅ **Date/Time Manipulation** - Increment/decrement support for hours, minutes, seconds, and days
- ✅ **Balance Tracking** - Initial and final balance calculation per date
- ✅ **JSON Serialization** - Full kotlinx.serialization support for API output

### Platform Support
- ✅ **JVM** (Java 21+)
- ✅ **Android** (API level support with SDK 35)
- ✅ **Linux x64** (Native with Curl HTTP client)
- ✅ **Windows x64** (MinGW with WinHTTP client)
- ✅ **macOS ARM64** (Native with Darwin HTTP client)

### Developer Features
- ✅ **C Interoperability** - Compile to static library for C/C++ integration
- ✅ **Development Mode** - Verbose logging for debugging
- ✅ **Gradle Build Cache** - Optimized incremental builds
- ✅ **Configuration Cache** - Faster build configuration

---

## Architecture

```
┌─────────────────────────────────────────────────────────────────┐
│                    Account Ledger Library                       │
├─────────────────────────────────────────────────────────────────┤
│  ┌─────────────────┐  ┌─────────────────┐  ┌─────────────────┐ │
│  │ account_ledger_ │  │ common_utils_   │  │   Platform      │ │
│  │     library     │  │    library      │  │   Specific      │ │
│  ├─────────────────┤  ├─────────────────┤  ├─────────────────┤ │
│  │ • Constants     │  │ • Constants     │  │ • Ktor Curl     │ │
│  │ • Enums         │  │ • Models        │  │ • Ktor WinHTTP  │ │
│  │ • Models        │  │ • DateTimeUtils │  │ • Ktor Darwin   │ │
│  │ • Utils         │  │ • GistUtils     │  │                 │ │
│  └─────────────────┘  └─────────────────┘  └─────────────────┘ │
├─────────────────────────────────────────────────────────────────┤
│                         Common Main                              │
│  ┌─────────────────────────────────────────────────────────────┐│
│  │  kotlinx-serialization │ kotlinx-coroutines │ Ktor │ Klock ││
│  └─────────────────────────────────────────────────────────────┘│
└─────────────────────────────────────────────────────────────────┘
```

---

## Technology Stack

| Category | Technology | Version |
|----------|------------|---------|
| **Language** | Kotlin | 2.2.20 |
| **Build System** | Gradle | 9.1.0 |
| **Serialization** | kotlinx-serialization-json | 1.9.0 |
| **Coroutines** | kotlinx-coroutines-core | 1.10.2 |
| **HTTP Client** | Ktor | 3.3.1 |
| **Date/Time** | korlibs-klock | 4.0.10 |
| **Android Gradle Plugin** | AGP | 8.13.0 |
| **Target JVM** | Java | 21 |
| **Android SDK** | compileSdk | 35 |

---

## Prerequisites

### General Requirements
- **JDK 21** or higher
- **Gradle 9.1.0** (wrapper included)
- **Git** for version control

### Platform-Specific Requirements

#### Linux (x64)
- **libcurl** development libraries
  ```bash
  # Ubuntu/Debian
  sudo apt-get install libcurl4-openssl-dev
  
  # Fedora/RHEL
  sudo dnf install libcurl-devel
  ```
- **GCC** for C compilation (optional, for C interop)
  ```bash
  sudo apt-get install build-essential
  ```

#### Windows (x64)
- **MinGW-w64** toolchain
- **Microsoft Visual Studio 2022** (for C compilation with MSVC)
- WinHTTP is used natively (no additional dependencies)

#### macOS (ARM64)
- **Xcode Command Line Tools**
  ```bash
  xcode-select --install
  ```

#### Android
- **Android SDK** with API level 35
- **Android NDK** (if building native components)

---

## Installation

### Clone the Repository

```bash
git clone https://github.com/Baneeishaque/Account-Ledger-Library-Kotlin-Multiplatform.git
cd Account-Ledger-Library-Kotlin-Multiplatform
```

### Using as a Dependency

#### Gradle (Kotlin DSL)

```kotlin
// In your settings.gradle.kts
dependencyResolutionManagement {
    repositories {
        mavenCentral()
        maven { url = uri("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/dev") }
    }
}

// In your build.gradle.kts
dependencies {
    implementation("ndk.banee:account-ledger-lib:1.0-SNAPSHOT")
}
```

#### For Local Development

```kotlin
// Include as a composite build
includeBuild("../Account-Ledger-Library-Kotlin-Multiplatform")
```

---

## Building

### Quick Start

```bash
# Build all targets for current platform
./gradlew build

# Build with parallel execution (recommended)
./gradlew build --parallel
```

### Platform-Specific Builds

#### JVM
```bash
./gradlew jvmJar
```

#### Android
```bash
./gradlew assembleRelease
```

#### Linux (Native)
```bash
# Static library
./gradlew linkDebugStaticLinuxX64

# Shared library
./gradlew linkDebugSharedLinuxX64
```

#### Windows (Native)
```powershell
# Static library (for Azure Pipelines or local)
.\gradlew.bat linkDebugStaticMingwX64

# Shared library
.\gradlew.bat linkDebugSharedMingwX64
```

#### macOS ARM64 (Native)
```bash
./gradlew linkDebugStaticMacosArm64
```

### Build Outputs

| Target | Output Location |
|--------|----------------|
| JVM JAR | `lib/build/libs/` |
| Android AAR | `lib/build/outputs/aar/` |
| Linux Static | `lib/build/bin/linuxX64/debugStatic/` |
| Linux Shared | `lib/build/bin/linuxX64/debugShared/` |
| Windows Static | `lib/build/bin/mingwX64/debugStatic/` |
| Windows Shared | `lib/build/bin/mingwX64/debugShared/` |
| macOS Static | `lib/build/bin/macosArm64/debugStatic/` |

### Build Options

```bash
# Enable verbose logging
./gradlew build --info

# Clean build
./gradlew clean build

# Skip tests
./gradlew build -x test

# Continuous build
./gradlew build --continuous
```

---

## Project Structure

```
Account-Ledger-Library-Kotlin-Multiplatform/
├── lib/                                    # Main library module
│   ├── build.gradle.kts                    # Library build configuration
│   └── src/
│       └── commonMain/
│           └── kotlin/
│               ├── account_ledger_library/
│               │   ├── constants/
│               │   │   └── ConstantsNative.kt     # Library constants
│               │   ├── enums/
│               │   │   └── BajajRewardTypeEnum.kt # Reward type enums
│               │   ├── models/
│               │   │   ├── AccountLedgerGistModelForJson.kt
│               │   │   ├── AccountLedgerGistModelV3.kt
│               │   │   └── AccountLedgerGistTransactionModel.kt
│               │   └── utils/
│               │       ├── GistUtilsNative.kt           # Gist content fetching
│               │       ├── GistUtilsInteractiveNative.kt # Data processing
│               │       └── TextAccountLedgerUtils.kt    # Text parsing
│               └── common_utils_library/
│                   ├── constants/
│                   │   └── ConstantsCommonNative.kt     # Common constants
│                   ├── models/
│                   │   └── GistResponseModel.kt         # Gist API models
│                   └── utils/
│                       ├── DateTimeUtilsCommonNative.kt # Date utilities
│                       ├── GistUtilsCommonNative.kt     # HTTP client
│                       └── GistUtilsInteractiveCommonNative.kt
├── gradle/
│   ├── libs.versions.toml                  # Version catalog
│   └── wrapper/                            # Gradle wrapper
├── build.gradle.kts                        # Root build configuration
├── settings.gradle.kts                     # Project settings
├── gradle.properties                       # Gradle properties
├── main_linux.c                            # C example for Linux
├── main_windows.c                          # C example for Windows
├── compileMainCFile.bash                   # Linux C compilation script
├── compileMainCFile.ps1                    # Windows C compilation script
├── runMainCFile.bash                       # Linux run script
├── runMainCFile.ps1                        # Windows run script
└── azure-pipelines-windows.yml             # Azure DevOps CI config
```

---

## API Reference

### Core Classes

#### `GistUtilsInteractiveNative`

Main class for processing GitHub Gist data into account ledger format.

```kotlin
class GistUtilsInteractiveNative {
    
    // Process Gist data to V2 format
    fun processGistIdForDataV2(
        userName: String,
        userId: UInt,
        gitHubAccessToken: String,
        gistId: String,
        isDevelopmentMode: Boolean,
        isApiCall: Boolean = true,
        isVersion3: Boolean = false
    ): AccountLedgerGistModelV2
    
    // Process Gist data to V3 format
    fun processGistIdForDataV3(
        userName: String,
        userId: UInt,
        gitHubAccessToken: String,
        gistId: String,
        isDevelopmentMode: Boolean,
        isApiCall: Boolean = true,
        isVersion3: Boolean = false
    ): AccountLedgerGistModelV3
    
    // Process Gist data to V4 format
    fun processGistIdForDataV4(
        userName: String,
        userId: UInt,
        gitHubAccessToken: String,
        gistId: String,
        isDevelopmentMode: Boolean
    ): Unit
    
    // Convert V3 format to V4 format
    fun processGistIdForDataV3ToV4(
        userName: String,
        userId: UInt,
        gitHubAccessToken: String,
        gistId: String,
        isDevelopmentMode: Boolean
    ): Unit
}
```

#### `GistUtilsNative`

Static utility for fetching Gist content from GitHub.

```kotlin
class GistUtilsNative {
    companion object {
        @JvmStatic
        fun getGistContent(
            gitHubAccessToken: String,
            gistId: String,
            isDevelopmentMode: Boolean
        ): List<String>
    }
}
```

### Data Models

#### `AccountLedgerGistModelV3`

```kotlin
@Serializable
data class AccountLedgerGistModelV3(
    val userName: String,
    val userId: UInt,
    val accountLedgerPages: MutableList<AccountLedgerPage>
)

@Serializable
data class AccountLedgerPage(
    val accountId: UInt,
    val transactionDatePages: MutableList<TransactionDatePage>
)

@Serializable
data class TransactionDatePage(
    val transactionDate: String,
    val initialBalance: Double?,
    val transactions: List<AccountLedgerGistTransactionModel>?,
    val finalBalance: Double?
)

@Serializable
data class AccountLedgerGistTransactionModel(
    val transactionParticulars: String,
    val transactionAmount: Double
)
```

### Usage Example

```kotlin
import account_ledger_library.utils.GistUtilsInteractiveNative

fun main() {
    val gistUtils = GistUtilsInteractiveNative()
    
    val ledgerData = gistUtils.processGistIdForDataV3(
        userName = "your_username",
        userId = 1u,
        gitHubAccessToken = "your_github_token",
        gistId = "your_gist_id",
        isDevelopmentMode = false,
        isApiCall = true
    )
    
    // Process ledgerData...
}
```

---

## C/C++ Interoperability

This library can be compiled to a native static library and used from C/C++ applications.

### Building Native Library

#### Linux
```bash
./gradlew linkDebugSharedLinuxX64
```

#### Windows
```powershell
.\gradlew.bat linkDebugSharedMingwX64
```

### C Integration Example (Linux)

```c
#include "lib/build/bin/linuxX64/debugShared/libaccount_ledger_lib_api.h"
#include "stdio.h"
#include "stdbool.h"

int main(int argc, char **argv) {
    // Get library symbols
    libaccount_ledger_lib_ExportedSymbols *lib = libaccount_ledger_lib_symbols();

    // Create GistUtils instance
    libaccount_ledger_lib_kref_account_ledger_library_utils_GistUtils newInstance = 
        lib->kotlin.root.account_ledger_library.utils.GistUtils.GistUtils();
    
    // Process Gist data
    const char *accountLedgerGistText = 
        lib->kotlin.root.account_ledger_library.utils.GistUtils.processGistIdForTextData(
            newInstance, 
            "USERNAME", 
            0, 
            "GITHUB_ACCESS_TOKEN", 
            "GIST_ID", 
            false, 
            false
        );
    
    // Print result before cleanup
    printf("Gist Data: %s", accountLedgerGistText);

    // Clean up
    lib->DisposeStablePointer(newInstance.pinned);
    lib->DisposeString(accountLedgerGistText);
    return 0;
}
```

### Compiling C Code

#### Linux
```bash
# Using the provided script
./compileMainCFile.bash

# Or manually
./gradlew linkDebugSharedLinuxX64
gcc main_linux.c lib/build/bin/linuxX64/debugShared/libaccount_ledger_lib.so -o main
```

#### Windows
```powershell
# Using the provided script
.\compileMainCFile.ps1

# Or manually with Visual Studio Developer Command Prompt
.\gradlew.bat linkDebugSharedMingwX64
lib /DEF:lib\build\bin\mingwX64\debugShared\account_ledger_lib.def /OUT:lib\build\bin\mingwX64\debugShared\account_ledger_lib.lib
cl.exe main_windows.c lib\build\bin\mingwX64\debugShared\account_ledger_lib.lib /Fe:lib\build\bin\mingwX64\debugShared\main.exe
```

### Running C Application

#### Linux
```bash
./runMainCFile.bash
# Or
./a.out
```

#### Windows
```powershell
.\runMainCFile.ps1
# Or
.\lib\build\bin\mingwX64\debugShared\main.exe
```

---

## Testing

### Running Tests

```bash
# Run all tests
./gradlew test

# Run JVM tests only
./gradlew jvmTest

# Run with test logging
./gradlew test --info

# Generate test report
./gradlew test jacocoTestReport
```

### Test Configuration

Tests use JUnit Platform (JUnit 5). Test dependencies are automatically configured:

```kotlin
val commonTest by getting {
    dependencies {
        implementation(kotlin("test"))
    }
}
```

---

## CI/CD

### Azure Pipelines (Windows)

The project includes Azure DevOps pipeline configuration for Windows builds:

**`azure-pipelines-windows.yml`**

```yaml
pool:
  vmImage: 'windows-latest'

variables:
  GRADLE_USER_HOME: $(Pipeline.Workspace)/.gradle

steps:
  - checkout: self
    submodules: recursive

  - task: Cache@2.198.0
    inputs:
      key: 'gradle | "$(Agent.OS)"'
      restoreKeys: gradle
      path: $(GRADLE_USER_HOME)
    displayName: Gradle Build Cache

  - task: JavaToolInstaller@0
    inputs:
      versionSpec: '21'
      jdkArchitectureOption: 'x64'
      jdkSourceOption: 'PreInstalled'
      
  - task: Gradle@3.208.0
    displayName: 'Gradle Build: Static Library for MinGW-w64'
    inputs:
      gradleOptions: '-Xmx3072m'
      tasks: linkDebugStaticMingwX64

  - script: 'gradlew --stop'
    displayName: Stop Gradle Daemon
```

### GitHub Actions

For GitHub-based CI, you can use similar configuration:

```yaml
name: Build
on: [push, pull_request]

jobs:
  build:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v4
      - uses: actions/setup-java@v4
        with:
          java-version: '21'
          distribution: 'temurin'
      - name: Build
        run: ./gradlew build
```

### Automated Branch Cleanup

The repository uses **delete-merged-branch** GitHub App with the following configuration:

```yaml
# .github/delete-merged-branch-config.yml
exclude:
  - main
  - common-lib-multi-platform
delete_closed_pr: false
```

---

## Configuration

### Gradle Properties

**`gradle.properties`**

| Property | Value | Description |
|----------|-------|-------------|
| `org.gradle.parallel` | `true` | Enable parallel project execution |
| `org.gradle.caching` | `true` | Enable build caching |
| `kotlin.code.style` | `official` | Use official Kotlin code style |
| `org.gradle.vfs.watch` | `true` | Enable file system watching |
| `org.gradle.configureondemand` | `true` | Configure projects on demand |
| `org.gradle.configuration-cache` | `true` | Enable configuration cache |
| `org.gradle.configuration-cache.problems` | `warn` | Warn on configuration cache problems |
| `kotlin.mpp.import.enableKgpDependencyResolution` | `true` | Enable KGP dependency resolution |
| `kotlin.compiler.preciseCompilationResultsBackup` | `true` | Precise compilation results backup |
| `kotlin.build.report.output` | `file` | Output build report to file |
| `org.gradle.jvmargs` | `-Xmx1024M` | JVM arguments for Gradle |
| `kotlin.daemon.useFallbackStrategy` | `false` | Disable fallback strategy |

### Environment Variables

| Variable | Description | Required |
|----------|-------------|----------|
| `GITHUB_ACCESS_TOKEN` | GitHub personal access token for Gist API | Yes |
| `GIST_ID` | Target Gist identifier | Yes |
| `USERNAME` | GitHub username | Yes |
| `USER_ID` | User identifier (integer) | No |

---

## Contributing

We welcome contributions! Please follow these guidelines:

### Getting Started

1. **Fork the repository** on GitHub
2. **Clone your fork** locally:
   ```bash
   git clone https://github.com/YOUR_USERNAME/Account-Ledger-Library-Kotlin-Multiplatform.git
   ```
3. **Create a branch** for your feature:
   ```bash
   git checkout -b feature/your-feature-name
   ```

### Development Workflow

1. **Set up your development environment**:
   - Install JDK 21+
   - Import the project in IntelliJ IDEA or your preferred IDE
   - Run `./gradlew build` to verify the setup

2. **Make your changes**:
   - Follow Kotlin coding conventions
   - Add tests for new functionality
   - Update documentation as needed

3. **Test your changes**:
   ```bash
   ./gradlew build test
   ```

4. **Commit your changes**:
   ```bash
   git add .
   git commit -m "feat: add your feature description"
   ```

### Commit Message Convention

Use conventional commits format:
- `feat:` - New feature
- `fix:` - Bug fix
- `docs:` - Documentation changes
- `refactor:` - Code refactoring
- `test:` - Adding tests
- `chore:` - Maintenance tasks

### Pull Request Process

1. **Push your branch** to your fork:
   ```bash
   git push origin feature/your-feature-name
   ```

2. **Open a Pull Request** against the `main` branch

3. **Describe your changes** in the PR description:
   - What problem does this PR solve?
   - What changes were made?
   - Are there any breaking changes?

4. **Address review feedback** if any

### Code Style

- Use official Kotlin code style
- Maximum line length: 120 characters
- Use meaningful variable and function names
- Add KDoc comments for public APIs

### Dependency Management

- Dependencies are managed using Renovate bot
- Avoid adding unnecessary dependencies
- Check for security vulnerabilities before adding new dependencies

### Issue Reporting

When reporting issues, please include:
- A clear description of the problem
- Steps to reproduce
- Expected vs actual behavior
- Environment details (OS, JDK version, etc.)

---

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

## Acknowledgments

- [Kotlin Multiplatform](https://kotlinlang.org/docs/multiplatform.html) - Cross-platform development
- [Ktor](https://ktor.io/) - Asynchronous HTTP client
- [kotlinx.serialization](https://github.com/Kotlin/kotlinx.serialization) - JSON serialization
- [korlibs/klock](https://korlibs.soywiz.com/klock/) - Date/time library

---

<p align="center">
  Made with ❤️ using Kotlin Multiplatform
</p>
