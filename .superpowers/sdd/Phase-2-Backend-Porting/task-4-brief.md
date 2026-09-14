---
name: task-4-brief
description: Brief for Phase 2, Task 4: API Endpoint Integration
metadata:
  type: reference
---

# Task 4: API Endpoint Integration

**Files:**
- Create: `app/src/main/java/com/jusmusic/api/JUSApiEndpoints.kt`

**Interfaces:**
- Consumes: `JUSNetworkClient` (Task 2 client)
- Produces: API methods for Search, Browse, and Playback resolution.

- [ ] **Step 1: Implement `JUSApiEndpoints` class**
  - Inject or use the `JUSNetworkClient` instance.

- [ ] **Step 2: Add API methods**
  - `search(query: String): SearchResponse`
  - `browse(browseId: String): BrowseResponse`
  - `getPlaybackDetails(videoId: String): PlayerResponse`

- [ ] **Step 3: Commit**
