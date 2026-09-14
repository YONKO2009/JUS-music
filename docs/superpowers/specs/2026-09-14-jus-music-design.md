# JUS music — Architecture Design Spec

**Date:** 2026-09-14
**App Name:** JUS music
**Package:** `com.jusmusic`
**Source:** New Android project with backend ported from BitChord (`com.music.bitchord`)
**License:** GPLv3 (inherited from BitChord)

---

## 1. Tech Stack

| Layer | Technology | Version |
|-------|-----------|---------|
| Platform | Native Android | minSdk 26 / compileSdk 36 / targetSdk 36 |
| Language | Kotlin | 2.3.20 |
| UI Framework | Jetpack Compose + Material 3 | compose-bom 2024.12.01 |
| Playback | Media3 ExoPlayer | 1.11.0 |
| Networking | Ktor 3 + OkHttp | 3.0.3 |
| Serialization | kotlinx-serialization-json | 1.7.3 |
| Image Loading | Coil 3 | 3.0.4 |
| Glass Effects | Haze | 1.3.1 |
| Stream Resolution | NewPipeExtractor | v0.26.3 |
| AI/DSP | ONNX Runtime Android | 1.28.0 |
| Native DSP | C++ via CMake/JNI | — |
| QuickJS | quickjs-kt-android | 1.0.5 |
| Build System | Gradle Kotlin DSL | AGP 8.10.1 |

### Build Flavors
- `dev` → `com.dev.jusmusic` (side-by-side install)
- `prod` → `com.jusmusic`

---

## 2. Project Structure

```
JUSmusic/
├── app/
│   ├── src/main/
│   │   ├── assets/
│   │   │   ├── beat_this_int8.onnx          ← Automix beat model (from BitChord)
│   │   │   ├── vocals_umxhq_int8.onnx      ← Vocal separation model (from BitChord)
│   │   │   ├── Logo.svg                     ← JUS music logo
│   │   │   └── login_illustration.png       ← Hero illustration (person with headphones)
│   │   ├── cpp/                             ← Native C++ JNI bindings (from BitChord)
│   │   │   └── jni/
│   │   │       ├── analysis_jni.cpp
│   │   │       ├── mel_jni.cpp
│   │   │       └── vocal_jni.cpp
│   │   ├── java/com/jusmusic/
│   │   │   ├── JUSApplication.kt            ← Application class (Coil, auth init)
│   │   │   ├── MainActivity.kt              ← Single-activity, Compose root, navigation
│   │   │   │
│   │   │   ├── auth/                        ← Authentication (ported from BitChord)
│   │   │   │   ├── AccountSessions.kt
│   │   │   │   ├── AuthStore.kt
│   │   │   │   ├── WebSession.kt
│   │   │   │   ├── YtMusicLoginScreen.kt    ← Google sign-in via WebView
│   │   │   │   └── DiscordLoginScreen.kt
│   │   │   │
│   │   │   ├── data/                        ← Data layer (ported from BitChord)
│   │   │   │   ├── Models.kt               ← Song, BrowseItem, SearchResult, etc.
│   │   │   │   ├── YtMusicRepository.kt     ← All YouTube Music API methods
│   │   │   │   ├── Http.kt                  ← Shared Ktor client
│   │   │   │   ├── LikeState.kt
│   │   │   │   ├── LocalMediaRepository.kt
│   │   │   │   ├── NerdStats.kt
│   │   │   │   ├── TrackLog.kt
│   │   │   │   ├── AppSettings.kt           ← SharedPreferences settings
│   │   │   │   ├── AppUpdateChecker.kt
│   │   │   │   ├── DebugLog.kt
│   │   │   │   │
│   │   │   │   ├── innertube/               ← YouTube Innertube API
│   │   │   │   │   ├── Innertube.kt
│   │   │   │   │   ├── InnertubeParser.kt
│   │   │   │   │   ├── PlayerClient.kt
│   │   │   │   │   ├── StreamResolver.kt
│   │   │   │   │   └── PlaybackTracker.kt
│   │   │   │   │
│   │   │   │   ├── canvas/                  ← Canvas artwork providers
│   │   │   │   │   ├── CanvasRepository.kt
│   │   │   │   │   ├── CanvasCache.kt
│   │   │   │   │   ├── CanvasArtwork.kt
│   │   │   │   │   ├── SpotifyCanvas.kt
│   │   │   │   │   ├── SpotifyToken.kt
│   │   │   │   │   ├── AppleMusicCanvas.kt
│   │   │   │   │   ├── TidalCanvas.kt
│   │   │   │   │   └── CommunityCanvas.kt
│   │   │   │   │
│   │   │   │   ├── discord/                 ← Discord Rich Presence
│   │   │   │   │   ├── DiscordRPC.kt
│   │   │   │   │   └── SuperProperties.kt
│   │   │   │   │
│   │   │   │   ├── lyrics/                  ← Multi-source lyrics
│   │   │   │   │   └── LyricsRepository.kt  ← LrcLib, Genius, Musixmatch, KuGou, etc.
│   │   │   │   │
│   │   │   │   ├── scrobble/                ← Scrobbling
│   │   │   │   │   ├── ScrobbleManager.kt
│   │   │   │   │   ├── LastFM.kt
│   │   │   │   │   └── ListenBrainzManager.kt
│   │   │   │   │
│   │   │   │   └── sources/                 ← Pluggable audio sources
│   │   │   │       ├── SourceRegistry.kt
│   │   │   │       ├── AddonSource.kt
│   │   │   │       ├── AddonClient.kt
│   │   │   │       ├── ModuleSource.kt
│   │   │   │       └── QuickJsExecutor.kt
│   │   │   │
│   │   │   ├── download/                    ← Download manager (ported from BitChord)
│   │   │   │   ├── Downloads.kt             ← Queue, state, enqueue/run
│   │   │   │   ├── DownloadService.kt       ← Foreground service, 4 workers
│   │   │   │   ├── DownloadStore.kt         ← MediaStore / file writes
│   │   │   │   ├── Downloader.kt            ← Byte transfer
│   │   │   │   ├── MediaTagger.kt           ← Tag orchestrator
│   │   │   │   ├── FlacTagger.kt
│   │   │   │   ├── Mp4Tagger.kt
│   │   │   │   ├── WebmTagger.kt
│   │   │   │   └── LyricsTag.kt
│   │   │   │
│   │   │   ├── playback/                    ← Playback engine (ported from BitChord)
│   │   │   │   ├── PlaybackService.kt       ← MediaLibraryService, dual ExoPlayers
│   │   │   │   ├── CrossfadeController.kt   ← sin/cos constant-power crossfade
│   │   │   │   ├── SessionPlayer.kt         ← Media3 session wrapper
│   │   │   │   ├── QueueBuilder.kt          ← Radio/autoplay queue extension
│   │   │   │   ├── QueueShuffle.kt          ← Shuffle as queue edit
│   │   │   │   ├── SpatialAudioProcessor.kt
│   │   │   │   ├── TransitionFilterProcessor.kt
│   │   │   │   ├── AudioCache.kt
│   │   │   │   └── smart/                   ← Automix / AI
│   │   │   │       ├── TrackAnalyzer.kt
│   │   │   │       ├── BeatTracker.kt
│   │   │   │       ├── VocalTracker.kt
│   │   │   │       ├── TransitionPlanner.kt
│   │   │   │       ├── TransitionPolicy.kt
│   │   │   │       ├── AudioDecoder.kt
│   │   │   │       ├── MelSpectrogram.kt
│   │   │   │       ├── LocalAudioSource.kt
│   │   │   │       ├── AutomixAnalysisSource.kt
│   │   │   │       └── TrackFeatures.kt
│   │   │   │
│   │   │   ├── ui/                          ← ALL NEW — JUS music monochrome design
│   │   │   │   ├── theme/
│   │   │   │   │   ├── Theme.kt             ← JUS monochrome theme
│   │   │   │   │   ├── Color.kt             ← #FFFFFF, #0A0A0A, #6B7280, #9CA3AF
│   │   │   │   │   └── Type.kt              ← Gasoek One, Dela Gothic One, Figtree
│   │   │   │   │
│   │   │   │   ├── screens/
│   │   │   │   │   ├── LoginScreen.kt       ← Onboarding (your Figma Screen 1)
│   │   │   │   │   ├── HomeScreen.kt        ← Feed + greeting (Screen 2)
│   │   │   │   │   ├── SearchScreen.kt      ← Search + filters (Screen 3)
│   │   │   │   │   ├── LibraryScreen.kt     ← Playlists/albums/artists (Screen 5)
│   │   │   │   │   ├── LikedSongsScreen.kt  ← Liked songs list (Screen 6)
│   │   │   │   │   ├── QueueScreen.kt       ← Now playing + next queue (Screen 7)
│   │   │   │   │   ├── SettingsScreen.kt    ← All settings (Screen 8)
│   │   │   │   │   └── DetailScreen.kt      ← Album/artist/playlist detail
│   │   │   │   │
│   │   │   │   ├── player/
│   │   │   │   │   ├── NowPlayingScreen.kt  ← Full-screen player (Screen 4)
│   │   │   │   │   └── CanvasArtworkPlayer.kt
│   │   │   │   │
│   │   │   │   ├── components/
│   │   │   │   │   ├── MiniPlayer.kt        ← Persistent bottom mini player
│   │   │   │   │   ├── BottomTabBar.kt      ← Home/Search/Library/Liked tabs
│   │   │   │   │   ├── SongActionsSheet.kt  ← Song context menu
│   │   │   │   │   ├── PlaylistPickerSheet.kt
│   │   │   │   │   ├── DownloadManagerSheet.kt
│   │   │   │   │   └── TopBar.kt            ← Scrollable top bar
│   │   │   │   │
│   │   │   │   └── icons/                   ← Custom monochrome icon set
│   │   │   │
│   │   │   └── widget/                      ← Home screen widgets (JUS branded)
│   │   │       ├── MediaWidget.kt
│   │   │       └── WidgetActions.kt
│   │   │
│   │   └── res/
│   │       ├── font/
│   │       │   ├── gasoek_one.ttf
│   │       │   ├── dela_gothic_one.ttf
│   │       │   ├── figtree_regular.ttf
│   │       │   ├── figtree_semibold.ttf
│   │       │   └── figtree_bold.ttf
│   │       ├── drawable/                    ← Icons, launcher
│   │       ├── values/strings.xml
│   │       └── xml/
│   │           └── automotive_app_desc.xml  ← Android Auto
│   └── build.gradle.kts
│
├── native/analyzer/                         ← C++ DSP library (verbatim from BitChord)
│   ├── CMakeLists.txt
│   ├── audio_analysis.cpp/h
│   ├── mel_spectrogram.cpp/h
│   ├── resampler.cpp/h
│   ├── tempo_analysis.cpp/h
│   └── vocal_spectrogram.cpp/h
│
├── build.gradle.kts                         ← Top-level Gradle
├── settings.gradle.kts
├── gradle.properties
├── gradlew / gradlew.bat
└── keystore.properties.example
```

---

## 3. UI Theme — JUS music Monochrome Design System

### 3.1 Color Palette

```kotlin
object JUSColors {
    val Background = Color(0xFFFFFFFF)      // Pure white
    val OnBackground = Color(0xFF0A0A0A)    // Deep black — primary text, headings
    val Surface = Color(0xFF000000)          // Solid black — buttons, active elements
    val OnSurface = Color(0xFFFFFFFF)        // White text on black surfaces
    val Secondary = Color(0xFF6B7280)        // Gray — taglines, secondary text
    val Inactive = Color(0xFF9CA3AF)         // Light gray — dots, disabled states
    val PlayerDynamic = Color.Unspecified    // Overridden per-track from album art palette
}
```

- All screens except Player use strict monochrome
- Player screen uses dynamic artwork-driven palette via `rememberArtworkPalette()` (from BitChord's `androidx.palette` integration)
- No gradients, no shadows, no glassmorphism on non-player screens
- High contrast, generous whitespace, editorial feel

### 3.2 Typography

| Font | Usage | Weight | Size Range |
|------|-------|--------|-----------|
| Gasoek One | Hero words ("Music" on login) | Regular (ultra-heavy by design) | 48–72px |
| Dela Gothic One | Section subtitles ("for a better you") | Regular | 28–36px |
| Figtree | All UI text — buttons, labels, body, links | 400, 600, 700 | 12–18px |

### 3.3 Component Style Rules

- **Buttons:** Full-width pill-shaped, solid black fill, white text, Figtree bold 16px. Press: scale(0.98).
- **Cards:** Clean rectangles, no shadows, thin border or none, rounded corners 12–16dp.
- **Bottom Tab Bar:** 4 tabs (Home, Search, Library, Liked). Active = black icon + label. Inactive = gray icon.
- **Mini Player:** Bottom-anchored, above tab bar. Track art + title + play/pause. Clean white background, black text.
- **Lists:** Vertical scroll, thumbnail + title + artist, 3-dot overflow menu. No divider lines (whitespace separation).
- **Search:** Text input with rounded border, category pills (Songs/Artists/Albums/Playlists), active = black fill.

---

## 4. Screen Specifications

### Screen 1: Login / Onboarding

**Layout (top to bottom):**
1. Typography: "Music" (Gasoek One 72px) → "for a better you" (Dela Gothic One 36px) → "Discover. listen. feel." (Figtree 15px gray)
2. Hero illustration (monochrome line-art, person with headphones + cat)
3. "Get Started →" pill button (full-width, black)
4. "Already have an account? Sign in" (gray + black link)
5. 3 pagination dots (1st active/wider, 2nd+3rd gray)

**Backend:** "Get Started" → navigate to YT Music WebView login (auth/YtMusicLoginScreen). "Sign in" → same flow.

### Screen 2: Home

**Layout:**
1. "Good Morning, [Name]" greeting + bell icon + profile avatar
2. Search bar ("Search song, Artist, podcast...")
3. Hero card ("Chill Vibe" with play button)
4. "Made for you" horizontal scroll (Focus, Relax, Dance cards)
5. "Recently played" horizontal scroll

**Backend:** `YtMusicRepository.home()` → parsed `HomeShelf` list. Greeting from account data. Search bar navigates to Search screen.

### Screen 3: Search

**Layout:**
1. "Search" heading
2. Search input field
3. Filter pills: Songs (active), Artists, Album, Playlists
4. Browse categories: Trending, New release, Top charts, Mood, Genre, Podcast

**Backend:** `YtMusicRepository.search()` with `SearchFilter` (ALL/SONGS/VIDEOS/ALBUMS/ARTISTS/PLAYLISTS). `searchPage()` for pagination. Browse via `moodGenreShelves()`.

### Screen 4: Player (Now Playing)

**Layout:**
1. "Playing from" / "My playlist" header
2. Large album artwork (rounded corners, dynamic background color from art)
3. Track title + artist name
4. Progress slider with timestamps
5. Controls: Shuffle, Previous, Play (large circle), Next, Repeat
6. Secondary row: info, lyrics, queue icons

**Backend:** `PlaybackService` media session state. `CrossfadeController` for transitions. Lyrics from `LyricsRepository`. Canvas artwork from `CanvasRepository`.

**This is the one screen that breaks monochrome** — album art palette drives background/accent colors.

### Screen 5: Library

**Layout:**
1. "Your Library" heading + search icon + add icon
2. Filter pills: Playlist (active), Artists, Album, Downloaded
3. Vertical playlist list with thumbnails + 3-dot overflow

**Backend:** `YtMusicRepository.library()` → `LibraryItemPage`. Downloads from `Downloads.saved`. Local media from `LocalMediaRepository`.

### Screen 6: Liked Songs

**Layout:**
1. Back arrow + 3-dot overflow
2. Large red album cover art
3. "Liked Songs" heading + count + duration
4. Action row: add, download, overflow, play button
5. Track list with thumbnails

**Backend:** `YtMusicRepository.browseSongs()`. `LikeState` for like toggles. Download individual tracks via `Downloads.enqueue()`.

### Screen 7: Queue

**Layout:**
1. "Queue" heading + delete icon
2. "Now Playing" current track (highlighted)
3. "Next In Queue" list with drag handles for reorder

**Backend:** `PlaybackService.player.currentMediaItem` for now playing. Queue from player media items. Reorder via `player.moveMediaItem()`. `QueueShuffle` for shuffle toggle.

### Screen 8: Settings

**Layout:**
1. Back arrow + "Settings" heading
2. Profile circle + name + plan
3. Settings list: Upgrade, Download, Audio Quality, Notifications, Appearance, Language, Data & Storage, About
4. "Log Out" pill button

**Backend:** `AppSettings` SharedPreferences. Audio quality enum (LOW/MEDIUM/HIGH/LOSSLESS). Crossfade duration (0–12s). Spatial audio toggle. Sleep timer. Lyrics source selection.

---

## 5. Backend Port Strategy

### 5.1 What Gets Copied Directly

All files under these BitChord packages are copied with `com.music.bitchord` → `com.jusmusic` package rename:

- `data/innertube/` — Innertube API, parser, player client, stream resolver
- `data/YtMusicRepository.kt` — All API methods (home, search, library, browse, radio, etc.)
- `data/Models.kt` — Song, BrowseItem, SearchResult, SearchFilter, LibraryState, etc.
- `data/Http.kt` — Ktor client setup
- `data/LikeState.kt`, `NerdStats.kt`, `TrackLog.kt`
- `data/canvas/` — All canvas artwork providers
- `data/discord/` — Discord RPC + SuperProperties
- `data/lyrics/` — LyricsRepository + all lyric sources
- `data/scrobble/` — ScrobbleManager, LastFM, ListenBrainz
- `data/sources/` — SourceRegistry, AddonSource, ModuleSource, QuickJsExecutor
- `data/AppSettings.kt` — Settings management
- `data/LocalMediaRepository.kt` — Local file scanning
- `auth/` — AuthStore, WebSession, AccountSessions
- `playback/` — PlaybackService, CrossfadeController, SessionPlayer, QueueBuilder, QueueShuffle, SpatialAudioProcessor, TransitionFilterProcessor, AudioCache
- `playback/smart/` — TrackAnalyzer, BeatTracker, VocalTracker, TransitionPlanner, TransitionPolicy, AudioDecoder, MelSpectrogram, AutomixAnalysisSource, TrackFeatures
- `download/` — Downloads, DownloadService, DownloadStore, Downloader, MediaTagger, FlacTagger, Mp4Tagger, WebmTagger, LyricsTag
- `native/analyzer/` — Entire C++ DSP directory (verbatim, no changes)
- `assets/` — ONNX models (verbatim)

### 5.2 What Gets Rewritten

- `ui/` — Completely new, JUS music monochrome design
- `MainActivity.kt` — Same state-driven navigation pattern but with JUS tab layout (4 tabs: Home, Search, Library, Liked)
- `JUSApplication.kt` — Application class with Coil init, auth init (same logic, renamed)
- `widget/` — Home screen widgets with JUS branding
- `res/font/` — Gasoek One, Dela Gothic One, Figtree (replacing SF Pro Display)
- `res/drawable/` — New launcher icon, notification icon
- All branding strings, app name references

### 5.3 ViewModel Architecture

BitChord uses a single `MainViewModel` (~114KB). We'll keep this pattern for simplicity but organize it:

```kotlin
class MainViewModel(application: Application) : AndroidViewModel(application) {
    // State flows — same as BitChord
    val home: StateFlow<HomeState>
    val search: StateFlow<SearchState>
    val library: StateFlow<LibraryState>
    val player: StateFlow<PlayerState>
    val settings: StateFlow<AppSettings>
    val detailStack: SnapshotStateList<DetailPage>

    // Repositories — injected same as BitChord
    private val ytMusic = YtMusicRepository(...)
    private val lyricsRepo = LyricsRepository(...)
    // ...
}
```

---

## 6. Key Architecture Decisions

### 6.1 Dual ExoPlayer Crossfade
Exactly as BitChord: two full `ExoPlayer` instances swap roles. `CrossfadeController` arms the standby player with the incoming track, applies sin/cos volume curves for constant-power crossfade, then calls `adoptPlayer()` to swap session ownership. No changes needed.

### 6.2 Stream Resolution
Multi-source via `StreamResolver`: tries YouTube clients in order (IOS → ANDROID_MUSIC → TVHTML5 → ANDROID_VR → ANDROID), falls back to NewPipeExtractor for signature solving. Module sources (JioSaavn, custom addons) can upgrade quality. Copied verbatim.

### 6.3 Queue as Direct Edit
Shuffle edits the ExoPlayer queue directly (not a playback mode flag). `QueueShuffle` keeps original order for undo. AutoPlay extends queue from the bottom with `MAX_QUEUED_AUTOPLAY` tracks. Copied verbatim.

### 6.4 Download Pipeline
`Downloads.enqueue()` → `DownloadService` (foreground, 4 workers) → `prepare()` resolves stream → `transfer()` writes via `DownloadStore` (MediaStore API 29+) → `MediaTagger.embed()` writes metadata. Copied verbatim.

### 6.5 Navigation
State-driven Compose navigation (no NavHost), same as BitChord. Tabs via `AnimatedContent` keyed on `selectedTab`. Detail pages via `detailStack`. Sheets/modals overlay.

---

## 7. Build Phases

### Phase 1: Foundation
- Create Android project with Gradle Kotlin DSL
- Set up package `com.jusmusic`, build flavors (dev/prod)
- Add all dependencies (match BitChord's build.gradle.kts)
- Set up theme (JUS monochrome colors, fonts)
- Build all 8 screen composables with placeholder/static data
- Navigation shell (4 tabs + detail push + sheets)
- Build MiniPlayer and BottomTabBar components

### Phase 2: Auth + Core API
- Port auth/ (AuthStore, WebSession, AccountSessions)
- Port data/innertube/ (Innertube, Parser, PlayerClient, StreamResolver)
- Port YtMusicRepository, Models, Http
- Wire HomeScreen to live `home()` API data
- Wire SearchScreen to live `search()` API data
- Google sign-in via WebView on LoginScreen

### Phase 3: Playback
- Port playback/ (PlaybackService, CrossfadeController, QueueBuilder, QueueShuffle, SessionPlayer)
- Port native/analyzer/ C++ and cpp/jni/ bindings
- Connect Player screen to media session state
- Wire MiniPlayer to playback state
- Media notification + lock screen controls
- Queue screen with drag-to-reorder

### Phase 4: Library + Downloads
- Port download/ (Downloads, DownloadService, DownloadStore, taggers)
- Wire Library screen to `library()` API
- Wire Liked Songs to `browseSongs()` + LikeState
- Download manager sheet
- Offline playback from downloaded files

### Phase 5: Polish
- Port lyrics/ (LyricsRepository + all sources)
- Port scrobble/ (ScrobbleManager, LastFM, ListenBrainz)
- Port discord/ (DiscordRPC)
- Port canvas/ (CanvasRepository + providers)
- Wire Settings screen to AppSettings
- Dynamic player colors from album art palette

### Phase 6: Automix
- Port playback/smart/ (TrackAnalyzer, BeatTracker, VocalTracker, TransitionPlanner)
- Port ONNX models and C++ DSP pipeline
- Wire smart crossfade into CrossfadeController
- Spatial audio processor

---

## 8. Dependencies (from BitChord's build.gradle.kts)

```kotlin
// Compose
implementation(platform("androidx.compose:compose-bom:2024.12.01"))
implementation("androidx.compose.foundation:foundation:1.10.0")
implementation("androidx.compose.ui:ui")
implementation("androidx.compose.ui:ui-graphics")
implementation("androidx.compose.material3:material3")
implementation("androidx.compose.material:material-icons-extended")
implementation("androidx.navigation:navigation-compose:2.8.5")
implementation("androidx.activity:activity-compose:1.9.3")

// Media3
implementation("androidx.media3:media3-exoplayer:1.11.0")
implementation("androidx.media3:media3-session:1.11.0")
implementation("androidx.media3:media3-common:1.11.0")
implementation("androidx.media3:media3-datasource-okhttp:1.11.0")
implementation("androidx.media3:media3-exoplayer-hls:1.11.0")
implementation("androidx.media3:media3-exoplayer-dash:1.11.0")

// Networking
implementation("io.ktor:ktor-client-core:3.0.3")
implementation("io.ktor:ktor-client-okhttp:3.0.3")
implementation("io.ktor:ktor-client-content-negotiation:3.0.3")
implementation("io.ktor:ktor-serialization-kotlinx-json:3.0.3")
implementation("io.ktor:ktor-client-websockets:3.0.3")

// Image
implementation("io.coil-kt.coil3:coil-compose:3.0.4")
implementation("io.coil-kt.coil3:coil-network-okhttp:3.0.4")
implementation("androidx.palette:palette-ktx:1.0.0")

// Glass effects
implementation("dev.chrisbanes.haze:haze:1.3.1")

// Stream resolution
implementation("org.schabi.newpipe:NewPipeExtractor:v0.26.3")
implementation("org.jsoup:jsoup:1.22.2")
implementation("org.mozilla:rhino:1.8.1")
implementation("org.mozilla:rhino-engine:1.8.1")
implementation("com.google.protobuf:protobuf-javalite:4.35.0")

// Serialization
implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.3")
implementation("org.jetbrains.kotlinx:kotlinx-coroutines-guava:1.9.0")

// QuickJS (plugins)
implementation("app.nicholasgasior.quickjs:quickjs-kt-android:1.0.5")

// ONNX (Automix)
implementation("com.microsoft.onnxruntime:onnxruntime-android:1.28.0")

// Security
implementation("androidx.security:security-crypto:1.1.0-alpha06")

// Rich text
implementation("com.halilibo.compose-richtext:richtext-ui-material3:0.20.0")

// Core
implementation("androidx.appcompat:appcompat:1.7.0")
implementation("androidx.core:core-ktx:1.15.0")
```

---

## 9. Testing Strategy

- Unit tests for: queue building, stream resolution, download store, lyrics parsing, search paging, audio output policy (ported from BitChord's test suite)
- Instrumented tests for: Android Auto media library, basic app launch
- Manual testing for: playback, crossfade, notification controls, download + offline play

---

## 10. Non-Goals (Explicitly Out of Scope)

- iOS / cross-platform — this is Android-only
- Custom backend server — client-only, talks directly to YouTube/Discord/Last.fm
- Original music content — this streams from YouTube Music
- Monetization features — no ads, no premium tier
- App Store deployment — APK/sideload only (YouTube Music TOS)
