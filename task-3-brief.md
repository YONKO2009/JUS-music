---
name: task-3-brief
description: Brief for Phase 1, Task 3: Navigation Shell & Components
metadata:
  type: reference
---

# Task 3: Navigation Shell & Components

**Files:**
- Create: `app/src/main/java/com/jusmusic/ui/components/BottomTabBar.kt`
- Create: `app/src/main/java/com/jusmusic/ui/components/MiniPlayer.kt`
- Create: `app/src/main/java/com/jusmusic/navigation/JUSNavHost.kt`
- Modify: `app/src/main/java/com/jusmusic/MainActivity.kt` (setup navigation shell)

**Interfaces:**
- Consumes: `com.jusmusic.ui.theme.JUSTheme`
- Produces: `BottomTabBar` (UI), `MiniPlayer` (UI), `JUSNavHost` (Navigation graph shell).

- [ ] **Step 1: Create `BottomTabBar` composable (Material 3 NavigationBar)**
  - monochrome theme compliant: Background White, Active icon Black, Inactive icon GrayInactive.
  - Icons: Home (house), Search (search), Library (library_music), Liked (favorite).
- [ ] **Step 2: Create `MiniPlayer` composable**
  - Monochrome style. Placeholders: Text "Song Title" (bodyLarge), Play/Pause icon (image_button), Progress bar (linear).
- [ ] **Step 3: Define `JUSNavHost` containing 8 screen placeholders**
  - Use `NavHost` with `startDestination = "home"`.
  - Placeholder screens (Composable functions) returning simple texts to verify routing.
- [ ] **Step 4: Update `MainActivity.kt` to call `JUSTheme` and `JUSNavHost(scaffold containing BottomTabBar + MiniPlayer)**
- [ ] **Step 5: Commit**
