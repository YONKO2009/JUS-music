# Backend Porting & API Integration Implementation Plan

> **For agentic workers:** REQUIRED SUB-SKILL: Use superpowers:subagent-driven-development (recommended) or superpowers:executing-plans to implement this plan task-by-task. Steps use checkbox (`- [ ]`) syntax for tracking.

**Goal:** Port the BitChord backend architecture (Ktor-based Innertube API client and data models) to the JUS music app project.

**Architecture:** We will replicate BitChord's modular design, incorporating Ktor for API communication, `kotlinx.serialization` for protocol buffers/JSON parsing, and the NewPipeExtractor for YouTube stream resolution.

**Tech Stack:** Kotlin, Ktor, kotlinx.serialization, NewPipeExtractor.

**Spec:** `docs/superpowers/specs/2026-09-14-jus-music-design.md`

## Global Constraints
- Package: com.jusmusic
- MinSdk: 26
- TargetSdk: 36
- Theme Rule: Pure monochrome (Background:#FFFFFF, Text:#0A0A0A)

---

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
```

- [ ] **Step 2: Add NewPipeExtractor and misc dependencies**
Add the refined NewPipeExtractor setup (stripped lib) and required protobuf/rhino deps.

- [ ] **Step 3: Sync project and verify build**

---

### Task 2: Network Client Framework
**Files:**
- Create: `app/src/main/java/com/jusmusic/api/JUSNetworkClient.kt`

- [ ] **Step 1: Define HttpClient configuration**
Implement the client setup using `OkHttp` engine, JSON serialization.

- [ ] **Step 2: Implement generic request/response handlers**

---

### Task 3: API Models (Innertube)
**Files:**
- Create: `app/src/main/java/com/jusmusic/api/models/`

- [ ] **Step 1: Define Serialization classes for Search/Browse**
Create data classes for Innertube API responses.

---

### Task 4: API Endpoint Integration
**Files:**
- Create: `app/src/main/java/com/jusmusic/api/JUSApiEndpoints.kt`

- [ ] **Step 1: Implement search endpoint**
- [ ] **Step 2: Implement browse endpoint**
- [ ] **Step 3: Implement playback resolution endpoint**
