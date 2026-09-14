---
name: task-2-brief
description: Brief for Phase 2, Task 2: Network Client Framework
metadata:
  type: reference
---

# Task 2: Network Client Framework

**Files:**
- Create: `app/src/main/java/com/jusmusic/api/JUSNetworkClient.kt`

**Interfaces:**
- Produces: `JUSNetworkClient` (singleton-ready client)

- [ ] **Step 1: Define `JUSNetworkClient` class/object**
  - Use `HttpClient` with `OkHttp` engine.
  - Install `ContentNegotiation` plugin with `json` serialization (ignore unknown keys, pretty print false).
  - Add `WebSockets` plugin.
  - Implement a central `baseUrl` configuration for Innertube API.

- [ ] **Step 2: Add request wrapper methods**
  - Create standard `get` and `post` request wrappers including necessary headers (YouTube format headers are critical — match BitChord approach if possible, otherwise placeholder).

- [ ] **Step 3: Commit**
