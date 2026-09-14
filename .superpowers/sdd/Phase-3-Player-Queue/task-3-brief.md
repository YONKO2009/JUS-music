---
name: task-3-brief
description: Brief for Phase 3, Task 3: UI-Backend Hookup
metadata:
  type: reference
---

# Task 3: UI-Backend Hookup

**Files:**
- Modify: `app/src/main/java/com/jusmusic/ui/screens/PlayerScreen.kt`

**Interfaces:**
- Consumes: `com.jusmusic.player.JUSPlayerController`
- Produces: Live `PlayerScreen` UI connected to controller state.

- [ ] **Step 1: Inject/Provide `JUSPlayerController` to `PlayerScreen`**
  - Use simple constructor injection or pass through Compose `provide` if necessary for now.

- [ ] **Step 2: Connect `PlayerScreen` to controller state**
  - Collect states: `isPlaying` (boolean), `currentTrack` (string?), `playbackProgress` (Long).
  - Use `collectAsStateWithLifecycle` or `collectAsState`.

- [ ] **Step 3: Replace placeholder UI with live widgets**
  - Connect Play/Pause button to `controller.play()`/`pause()`.
  - Connect Progress Bar to `playbackProgress`.
  - Update track title/artist info.

- [ ] **Step 4: Commit**
