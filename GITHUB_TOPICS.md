# GitHub Topics and Tags

This document provides recommended GitHub topics for the **Account-Ledger-Library-Kotlin-Multiplatform** repository along with instructions on how to add them.

## Recommended Topics

Based on the analysis of this repository, the following GitHub topics are recommended:

### Core Technology Topics
- `kotlin` - Primary programming language
- `kotlin-multiplatform` - Kotlin Multiplatform project
- `kotlin-native` - Uses Kotlin/Native for native platform targets
- `gradle` - Build system used

### Platform Topics
- `android` - Targets Android platform
- `jvm` - Targets JVM platform
- `linux` - Targets Linux (linuxX64)
- `windows` - Targets Windows (mingwX64)
- `macos` - Targets macOS (macosArm64)

### Library/Framework Topics
- `ktor` - Uses Ktor HTTP client
- `kotlinx-serialization` - Uses kotlinx.serialization for JSON
- `kotlinx-coroutines` - Uses Kotlin Coroutines

### Domain Topics
- `accounting` - Related to accounting/ledger functionality
- `finance` - Financial domain
- `ledger` - Ledger management
- `library` - This is a reusable library

### API/Integration Topics
- `github-api` - Integrates with GitHub Gist API
- `gist` - Uses GitHub Gist for data storage

### Project Type Topics
- `multiplatform` - Cross-platform project
- `cross-platform` - Works across multiple platforms

---

## Complete Topic List for This Repository

```
kotlin
kotlin-multiplatform
kotlin-native
gradle
android
jvm
linux
windows
macos
ktor
kotlinx-serialization
kotlinx-coroutines
accounting
finance
ledger
library
github-api
gist
multiplatform
cross-platform
```

---

## How to Add GitHub Topics

### Method 1: Using GitHub Web Interface

1. Navigate to your repository: https://github.com/Baneeishaque/Account-Ledger-Library-Kotlin-Multiplatform
2. Click on the ⚙️ gear icon next to "About" on the right sidebar
3. In the "Topics" field, type each topic and press Enter
4. Click "Save changes"

### Method 2: Using GitHub CLI (`gh`)

First, ensure you have the GitHub CLI installed and authenticated:

```bash
# Install GitHub CLI (if not already installed)
# On macOS:
brew install gh

# On Ubuntu/Debian:
sudo apt install gh

# On Windows:
winget install GitHub.cli

# Authenticate with GitHub
gh auth login
```

#### Add Topics Using GitHub CLI

```bash
# Add all recommended topics at once
gh repo edit Baneeishaque/Account-Ledger-Library-Kotlin-Multiplatform \
  --add-topic kotlin \
  --add-topic kotlin-multiplatform \
  --add-topic kotlin-native \
  --add-topic gradle \
  --add-topic android \
  --add-topic jvm \
  --add-topic linux \
  --add-topic windows \
  --add-topic macos \
  --add-topic ktor \
  --add-topic kotlinx-serialization \
  --add-topic kotlinx-coroutines \
  --add-topic accounting \
  --add-topic finance \
  --add-topic ledger \
  --add-topic library \
  --add-topic github-api \
  --add-topic gist \
  --add-topic multiplatform \
  --add-topic cross-platform
```

Or add topics individually:

```bash
gh repo edit Baneeishaque/Account-Ledger-Library-Kotlin-Multiplatform --add-topic kotlin
gh repo edit Baneeishaque/Account-Ledger-Library-Kotlin-Multiplatform --add-topic kotlin-multiplatform
gh repo edit Baneeishaque/Account-Ledger-Library-Kotlin-Multiplatform --add-topic kotlin-native
gh repo edit Baneeishaque/Account-Ledger-Library-Kotlin-Multiplatform --add-topic gradle
gh repo edit Baneeishaque/Account-Ledger-Library-Kotlin-Multiplatform --add-topic android
gh repo edit Baneeishaque/Account-Ledger-Library-Kotlin-Multiplatform --add-topic jvm
gh repo edit Baneeishaque/Account-Ledger-Library-Kotlin-Multiplatform --add-topic linux
gh repo edit Baneeishaque/Account-Ledger-Library-Kotlin-Multiplatform --add-topic windows
gh repo edit Baneeishaque/Account-Ledger-Library-Kotlin-Multiplatform --add-topic macos
gh repo edit Baneeishaque/Account-Ledger-Library-Kotlin-Multiplatform --add-topic ktor
gh repo edit Baneeishaque/Account-Ledger-Library-Kotlin-Multiplatform --add-topic kotlinx-serialization
gh repo edit Baneeishaque/Account-Ledger-Library-Kotlin-Multiplatform --add-topic kotlinx-coroutines
gh repo edit Baneeishaque/Account-Ledger-Library-Kotlin-Multiplatform --add-topic accounting
gh repo edit Baneeishaque/Account-Ledger-Library-Kotlin-Multiplatform --add-topic finance
gh repo edit Baneeishaque/Account-Ledger-Library-Kotlin-Multiplatform --add-topic ledger
gh repo edit Baneeishaque/Account-Ledger-Library-Kotlin-Multiplatform --add-topic library
gh repo edit Baneeishaque/Account-Ledger-Library-Kotlin-Multiplatform --add-topic github-api
gh repo edit Baneeishaque/Account-Ledger-Library-Kotlin-Multiplatform --add-topic gist
gh repo edit Baneeishaque/Account-Ledger-Library-Kotlin-Multiplatform --add-topic multiplatform
gh repo edit Baneeishaque/Account-Ledger-Library-Kotlin-Multiplatform --add-topic cross-platform
```

### Method 3: Using GitHub REST API

You can use the GitHub REST API with `curl`:

```bash
# Set your GitHub token
export GITHUB_TOKEN="your-personal-access-token"

# Replace all topics (this will set the topics to exactly these)
curl -X PUT \
  -H "Authorization: Bearer $GITHUB_TOKEN" \
  -H "Accept: application/vnd.github.v3+json" \
  -H "X-GitHub-Api-Version: 2022-11-28" \
  https://api.github.com/repos/Baneeishaque/Account-Ledger-Library-Kotlin-Multiplatform/topics \
  -d '{
    "names": [
      "kotlin",
      "kotlin-multiplatform",
      "kotlin-native",
      "gradle",
      "android",
      "jvm",
      "linux",
      "windows",
      "macos",
      "ktor",
      "kotlinx-serialization",
      "kotlinx-coroutines",
      "accounting",
      "finance",
      "ledger",
      "library",
      "github-api",
      "gist",
      "multiplatform",
      "cross-platform"
    ]
  }'
```

### Method 4: Using Python with PyGithub

```python
from github import Github

# Create a GitHub instance with your token
g = Github("your-personal-access-token")

# Get the repository
repo = g.get_repo("Baneeishaque/Account-Ledger-Library-Kotlin-Multiplatform")

# Set topics
topics = [
    "kotlin",
    "kotlin-multiplatform",
    "kotlin-native",
    "gradle",
    "android",
    "jvm",
    "linux",
    "windows",
    "macos",
    "ktor",
    "kotlinx-serialization",
    "kotlinx-coroutines",
    "accounting",
    "finance",
    "ledger",
    "library",
    "github-api",
    "gist",
    "multiplatform",
    "cross-platform"
]

repo.replace_topics(topics)
print("Topics added successfully!")
```

### Method 5: Using Node.js with Octokit

```javascript
const { Octokit } = require("@octokit/rest");

const octokit = new Octokit({
  auth: "your-personal-access-token"
});

async function addTopics() {
  await octokit.repos.replaceAllTopics({
    owner: "Baneeishaque",
    repo: "Account-Ledger-Library-Kotlin-Multiplatform",
    names: [
      "kotlin",
      "kotlin-multiplatform",
      "kotlin-native",
      "gradle",
      "android",
      "jvm",
      "linux",
      "windows",
      "macos",
      "ktor",
      "kotlinx-serialization",
      "kotlinx-coroutines",
      "accounting",
      "finance",
      "ledger",
      "library",
      "github-api",
      "gist",
      "multiplatform",
      "cross-platform"
    ]
  });
  console.log("Topics added successfully!");
}

addTopics();
```

---

## Topic Guidelines

GitHub topics should:
- Be lowercase
- Use hyphens instead of spaces
- Be relevant to the project
- Help users discover your repository
- Be limited to 20 topics (GitHub's maximum)

---

## Removing Topics

If you need to remove a topic:

```bash
# Using GitHub CLI
gh repo edit Baneeishaque/Account-Ledger-Library-Kotlin-Multiplatform --remove-topic topic-name

# Using GitHub REST API (replace all topics without the one you want to remove)
curl -X PUT \
  -H "Authorization: Bearer $GITHUB_TOKEN" \
  -H "Accept: application/vnd.github.v3+json" \
  -H "X-GitHub-Api-Version: 2022-11-28" \
  https://api.github.com/repos/Baneeishaque/Account-Ledger-Library-Kotlin-Multiplatform/topics \
  -d '{"names":["kotlin","kotlin-multiplatform"]}'  # List only the topics you want to keep
```

---

## Viewing Current Topics

```bash
# Using GitHub CLI
gh repo view Baneeishaque/Account-Ledger-Library-Kotlin-Multiplatform --json topics

# Using GitHub REST API
curl -H "Accept: application/vnd.github.v3+json" \
  https://api.github.com/repos/Baneeishaque/Account-Ledger-Library-Kotlin-Multiplatform/topics
```
