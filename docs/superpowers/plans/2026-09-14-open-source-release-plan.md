# JUS Music Open Source & CI/CD Implementation Plan

> **For agentic workers:** REQUIRED SUB-SKILL: Use superpowers:subagent-driven-development (recommended) or superpowers:executing-plans to implement this plan task-by-task. Steps use checkbox (`- [ ]`) syntax for tracking.

**Goal:** Transform the JUS Music codebase into a professional public open-source project with automated APK release builds using GitHub Actions.

**Architecture:** Initialize Git, add open-source documentation/licensing, configure CI/CD pipeline, and establish release automation workflows.

**Tech Stack:** Git, GitHub Actions, Gradle.

**Spec:** `docs/superpowers/specs/2026-09-14-open-source-release-design.md`

## Global Constraints

- Project must remain buildable in the repository state after every commit.
- No secrets (API keys) are to be committed to the public repository.
- GitHub releases must be triggered by tag pushes.

---

### Task 1: Repository Foundation & Documentation

**Files:**
- Create: `LICENSE` (MIT)
- Create: `README.md` (Project overview + installation instructions)
- Create: `.gitignore` (Standard Android + build exclusion)

**Interfaces:**
- Produces: Professional repo home with clear licensing and installation docs.

- [ ] **Step 1: Initialize Git and add .gitignore**
- [ ] **Step 2: Create LICENSE file (MIT)**
- [ ] **Step 3: Create professional README.md**
- [ ] **Step 4: Commit all foundation files**

### Task 2: Configure CI Pipeline (Build Validation)

**Files:**
- Create: `.github/workflows/android-ci.yml`

**Interfaces:**
- Consumes: Standard Android Gradle build process
- Produces: Automated build verification on every push.

- [ ] **Step 1: Write `android-ci.yml`**
- [ ] **Step 2: Commit workflow**

### Task 3: Configure Release Pipeline (Automated APK)

**Files:**
- Create: `.github/workflows/android-release.yml`

**Interfaces:**
- Consumes: Tags (triggered by `v*` tag)
- Produces: GitHub Release with attached `app-release.apk`

- [ ] **Step 1: Write `android-release.yml`**
- [ ] **Step 2: Commit workflow**
