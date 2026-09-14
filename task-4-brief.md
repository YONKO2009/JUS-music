---
name: task-4-brief
description: Brief for Phase 1, Task 4: Screen Components Shells (Placeholder Data)
metadata:
  type: reference
---

# Task 4: Screen Components Shells

**Files:**
- Create: `app/src/main/java/com/jusmusic/ui/screens/HomeScreen.kt`
- Create: `app/src/main/java/com/jusmusic/ui/screens/SearchScreen.kt`
- Create: `app/src/main/java/com/jusmusic/ui/screens/PlayerScreen.kt`
- Create: `app/src/main/java/com/jusmusic/ui/screens/LibraryScreen.kt`
- Create: `app/src/main/java/com/jusmusic/ui/screens/LikedSongsScreen.kt`
- Create: `app/src/main/java/com/jusmusic/ui/screens/QueueScreen.kt`
- Create: `app/src/main/java/com/jusmusic/ui/screens/SettingsScreen.kt`
- Create: `app/src/main/java/com/jusmusic/ui/screens/LoginScreen.kt`

**Goal:** Implement 8 empty composable screen shells with placeholder text to prove navigation routing and layout scaffolding.

- [ ] **Step 1: Create all 8 Composable screen functions**
  - All screens must use `JUSTheme`.
  - All screens must display a large text header identifying the screen name (e.g., "Home", "Player") using `JUSType.displayLarge`.
  - Maintain consistent monochrome background and text styling as per JUSColors.
- [ ] **Step 2: Integrate into `JUSNavHost`**
  - Map each route ("home", "search", "player", "library", "liked", "queue", "settings", "login") to its respective screen.
- [ ] **Step 3: Verification**
  - Ensure navigation works between these placeholders via the `BottomTabBar` and `MiniPlayer` (Task 3).
- [ ] **Step 4: Commit**
