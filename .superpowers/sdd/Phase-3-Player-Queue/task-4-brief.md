---
name: task-4-brief
description: Brief for Phase 3, Task 4: Queue Management
metadata:
  type: reference
---

# Task 4: Queue Management

**Files:**
- Modify: `app/src/main/java/com/jusmusic/ui/screens/QueueScreen.kt`
- Modify: `app/src/main/java/com/jusmusic/player/JUSPlayerController.kt`

**Interfaces:**
- Consumes: `com.jusmusic.player.JUSPlayerController`
- Produces: Live `QueueScreen` UI connected to player queue state.

- [ ] **Step 1: Expand `JUSPlayerController` with queue management**
  - Add `queue: StateFlow<List<Track>>`.
  - Add `fun addToQueue(track: Track)` and `fun removeAt(index: Int)`.

- [ ] **Step 2: Connect `QueueScreen` to `JUSPlayerController`**
  - Inject controller.
  - Collect `queue` state.
  - Display queue list with track titles/artists.
  - Implement basic remove functionality.

- [ ] **Step 3: Commit**
