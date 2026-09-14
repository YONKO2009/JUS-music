---
name: task-2-brief
description: Brief for Open Source/Release, Task 2: Configure CI Pipeline (Build Validation)
metadata:
  type: reference
---

# Task 2: Configure CI Pipeline (Build Validation)

**Files:**
- Create: `.github/workflows/android-ci.yml`

**Interfaces:**
- Consumes: Standard Android Gradle build process
- Produces: Automated build verification on every push.

- [ ] **Step 1: Write `android-ci.yml`**
  - Use ubuntu-latest.
  - Setup JDK 17 (or compatible).
  - Run `./gradlew assembleDebug`.
- [ ] **Step 2: Commit workflow**
- [ ] **Step 3: Commit**
