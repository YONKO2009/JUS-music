---
name: task-2-brief
description: Brief for Project Restructuring, Task 2: Create bitchord-lib and Migrate Backend
metadata:
  type: reference
---

# Task 2: Create bitchord-lib and Migrate Backend

**Files:**
- Create: `bitchord-lib/` (module structure)
- Modify: `settings.gradle.kts` (include `:bitchord-lib`)
- Migrate: `BitChord/app/src/main/java/com/music/bitchord/data/` -> `bitchord-lib/src/main/java/com/music/bitchord/data/`
- Migrate: `BitChord/app/src/main/java/com/music/bitchord/playback/` -> `bitchord-lib/src/main/java/com/music/bitchord/playback/`

**Interfaces:**
- Produces: `bitchord-lib` library module for JUSMusic `app`.

- [ ] **Step 1: Create module structure (`bitchord-lib/build.gradle.kts`)**
- [ ] **Step 2: Update `settings.gradle.kts` to include `:bitchord-lib`**
- [ ] **Step 3: Move core backend Java/Kotlin files to library**
- [ ] **Step 4: Commit.**
