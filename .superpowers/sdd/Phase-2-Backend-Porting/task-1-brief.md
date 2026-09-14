### Task 1: Backend Dependencies & Config

**Files:**
- Modify: `app/build.gradle.kts`

- [ ] **Step 1: Add Ktor and Serialization dependencies**
Add required Ktor client, content-negotiation, serialization, and websockets dependencies.

```kotlin
    implementation("io.ktor:ktor-client-core:3.0.3")
    implementation("io.ktor:ktor-client-okhttp:3.0.3")
    implementation("io.ktor:ktor-client-content-negotiation:3.0.3")
    implementation("io.ktor:ktor-serialization-kotlinx-json:3.0.3")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.3")
    implementation("io.ktor:ktor-client-websockets:3.0.3")
```

- [ ] **Step 2: Add NewPipeExtractor and misc dependencies**
Add the refined NewPipeExtractor setup (stripped lib) and required protobuf/rhino deps. (Re-reference existing stripped library logic if applicable).

- [ ] **Step 3: Sync project and verify build**
