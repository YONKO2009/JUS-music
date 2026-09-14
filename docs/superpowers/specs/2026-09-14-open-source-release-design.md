# Design: Open Source & Automated Release Workflow for JUS Music

**Goal:** Transform the JUS Music project into a public open-source repository with automated GitHub Release workflows for APK distribution.

## 1. Governance & Legal
*   **License:** MIT License. Simple, permissive, and standard for open-source projects.
*   **Repository Visibility:** Public GitHub repository.

## 2. Project Meta-Documentation
*   **README.md:** 
    *   Project Overview.
    *   Features.
    *   **Installation Guide:** Explicit instructions on sideloading an APK on Android, including "Unknown Sources" setting.
*   **CONTRIBUTING.md (Optional):** Basic guidelines for external contributions.

## 3. Automation Strategy (CI/CD)
*   **Provider:** GitHub Actions.
*   **Pipeline:**
    *   **CI (Every Push):** Runs build (`./gradlew assembleDebug`) to ensure the code remains buildable.
    *   **Release (On Tag `v*`):** 
        *   Triggers `assembleRelease`.
        *   Automatically creates a GitHub Release.
        *   Attaches `app-release.apk` as a downloadable asset.

## 4. Security & Compliance
*   **Secret Management:** Ensure any existing secret/API keys are removed from the codebase and instructed to be provided via environment variables (GitHub Secrets).
*   **Git Cleanup:** Verify `.gitignore` is comprehensive (excludes `local.properties`, build artifacts, etc.).

---

**Spec Self-Review:**
- Placeholder scan: None.
- Internal consistency: Everything aligns with open-source and APK distribution.
- Scope check: Focused on metadata, documentation, and the CI pipeline.
- Ambiguity check: The sideloading instruction is a critical dependency for distribution.

---

**User Review:** The design doc is ready. Please review this architectural approach before we create the technical implementation plan.
