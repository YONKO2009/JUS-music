---
name: task-1-brief
description: Brief for Project Restructuring, Task 1: Initialize Unified Project Root
metadata:
  type: reference
---

# Task 1: Initialize Unified Project Root

**Files:**
- Create: `settings.gradle.kts` (Root)
- Create: `build.gradle.kts` (Root)
- Create: `gradlew` / `gradlew.bat` (Copy from BitChord/)
- Create: `gradle/` (Copy from BitChord/)

**Interfaces:**
- Produces: A unified project root capable of building modules.

- [ ] **Step 1: Copy Gradle wrapper and tools from `BitChord/` to Root**
  - `gradlew`, `gradlew.bat`, `gradle/` folder.
- [ ] **Step 2: Create root `settings.gradle.kts`**
  - Includes `:app` and maps the library module.
- [ ] **Step 3: Create root `build.gradle.kts`**
  - Setup plugin management for Android.
- [ ] **Step 4: Commit.**
