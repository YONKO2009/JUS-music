---
name: task-2-brief
description: Brief for Phase 3, Task 2: Player Controller Integration
metadata:
  type: reference
---

# Task 2: Player Controller Integration

**Files:**
- Create: `app/src/main/java/com/jusmusic/player/JUSPlayerController.kt`

**Interfaces:**
- Produces: `JUSPlayerController` (ExoPlayer wrapper)

- [ ] **Step 1: Implement `JUSPlayerController`**
  - Use `Media3` (ExoPlayer).
  - Expose StateFlow: `isPlaying`, `currentTrack`, `playbackProgress`.
  - Methods: `play()`, `pause()`, `seekTo(position)`, `loadTrack(track)`.

- [ ] **Step 2: Configure ExoPlayer instance**
  - Dependency Injection setup (ready for constructor injection).

- [ ] **Step 3: Commit**
