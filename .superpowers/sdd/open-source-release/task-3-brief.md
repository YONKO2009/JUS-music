---
name: task-3-brief
description: Brief for Open Source/Release, Task 3: Configure Release Pipeline (Automated APK)
metadata:
  type: reference
---

# Task 3: Configure Release Pipeline (Automated APK)

**Files:**
- Create: `.github/workflows/android-release.yml`

**Interfaces:**
- Consumes: Tags (triggered by `v*` tag)
- Produces: GitHub Release with attached `app-release.apk`

- [ ] **Step 1: Write `android-release.yml`**
  - Use `ubuntu-latest`.
  - Setup JDK 17.
  - Run `./gradlew assembleRelease` (Note: Ensure no signing/obfuscation requirement conflicts, or explicitly use default release build).
  - Use `softprops/action-gh-release` or standard `actions/create-release` to attach the APK.
- [ ] **Step 2: Commit workflow**
- [ ] **Step 3: Commit**
