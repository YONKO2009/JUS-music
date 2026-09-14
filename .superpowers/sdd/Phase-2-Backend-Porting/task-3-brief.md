---
name: task-3-brief
description: Brief for Phase 2, Task 3: API Models (Innertube)
metadata:
  type: reference
---

# Task 3: API Models (Innertube)

**Files:**
- Create: `app/src/main/java/com/jusmusic/api/models/InnertubeModels.kt`

**Interfaces:**
- Consumes: JSON data from Innertube API
- Produces: Data classes for Search, Browse, and Playback response handling.

- [ ] **Step 1: Define base serialization classes**
  - Implement `SearchResponse`, `BrowseResponse`, and `PlayerResponse` data classes using `kotlinx.serialization` annotations (e.g., `@Serializable`, `@SerialName`).
  - Keep models minimal for now, focusing on essential fields for phase 1 features (Track title, artist, art url, duration).

- [ ] **Step 2: Commit**
