# BitChord Music App

A minimalist, editorial-style mobile music experience designed for discovery and relaxation. Built with clean monochrome aesthetics, editorial typography, and a focus on lo-fi listening culture.

## Features

- **Editorial Login / Onboarding Screen** — Minimalist typography hierarchy with custom Google Fonts (Gasoek One, Dela Gothic One, Figtree)
- **Hero Illustration** — Monochrome line-art illustration featuring a person with headphones, cat, smartphone, books, and plant
- **Clean Monochrome Palette** — Pure black and white with gray secondary tones for a high-contrast editorial feel
- **Responsive Mobile Layout** — Optimized for mobile viewports up to 430px width
- **Cross-Platform Foundation** — Android module (`app/`) with Kotlin and Gradle build system

## Sideloading Installation Guide

This is an Android application. To install on a device:

1. **Enable Developer Options** on your Android device (tap Build Number 7 times in Settings > About Phone).
2. **Enable USB Debugging** in Settings > Developer Options.
3. **Build APK** via Gradle:
   ```bash
   ./gradlew :app:assembleDebug
   ```
4. **Install the APK** (found at `app/build/outputs/apk/debug/app-debug.apk`) using:
   ```bash
   adb install app/build/outputs/apk/debug/app-debug.apk
   ```
5. **Or sideload manually** — Transfer the APK to your device and open it to install (may require allowing unknown sources in Settings).
