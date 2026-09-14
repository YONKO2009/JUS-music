# Player & Queue Integration Implementation Plan

> **For agentic workers:** REQUIRED SUB-SKILL: Use superpowers:subagent-driven-development (recommended) or superpowers:executing-plans to implement this plan task-by-task. Steps use checkbox (`- [ ]`) syntax for tracking.

**Goal:** Integrate the backend player logic with the UI, replacing placeholders and enabling functional audio playback.

**Architecture:** Connect the `JUSApiEndpoints` (Backend) to the `MiniPlayer` and `PlayerScreen` (UI), utilizing the `JUSNetworkClient` to resolve stream URLs.

**Tech Stack:** Media3 (ExoPlayer), Kotlin, Jetpack Compose.

**Spec:** `docs/superpowers/specs/2026-09-14-jus-music-design.md`

## Global Constraints
- Package: com.jusmusic
- MinSdk: 26
- TargetSdk: 36
- Theme Rule: Pure monochrome (Background:#FFFFFF, Text:#0A0A0A)

---

### Task 1: Fix Font Assets
**Files:**
- Replace: `app/src/main/res/font/gasoek_one.ttf`
- Replace: `app/src/main/res/font/dela_gothic_one.ttf`
- Replace: `app/src/main/res/font/figtree.ttf`

- [ ] **Step 1: Replace placeholder HTML wrappers with valid binary `.ttf` files.**
- [ ] **Step 2: Commit cleanup.**

---

### Task 2: Player Controller Integration
**Files:**
- Create: `app/src/main/java/com/jusmusic/player/JUSPlayerController.kt`

- [ ] **Step 1: Implement `JUSPlayerController`**
- [ ] **Step 2: Configure ExoPlayer instance**

---

### Task 3: UI-Backend Hookup
**Files:**
- Modify: `app/src/main/java/com/jusmusic/ui/screens/PlayerScreen.kt`

- [ ] **Step 1: Connect `PlayerScreen` to `JUSPlayerController`**
- [ ] **Step 2: Replace placeholder UI with live state (Track/Art/Controls).**

---

### Task 4: Queue Management
**Files:**
- Modify: `app/src/main/java/com/jusmusic/ui/screens/QueueScreen.kt`

- [ ] **Step 1: Implement queue state management.**
- [ ] **Step 2: Connect `QueueScreen` to `JUSPlayerController`.**
