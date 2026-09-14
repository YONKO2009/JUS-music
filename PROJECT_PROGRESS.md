# Music App - Project Progress

## Status: Login Screen — Ready to Build
**Date:** 2026-09-13
**Tech Stack:** React Native (cross-platform iOS + Android)

---

## Design Assets Collected ✅

### Figma File
- `music app.fig` — Full Figma source file (5.6 MB)

### Screen Mockups (8 screens total)
| # | File | Screen |
|---|------|--------|
| 1 | `iPhone 16 & 17 Pro - 1.png` | **Login / Onboarding** |
| 2 | `iPhone 16 & 17 Pro - 2.png` | Home |
| 3 | `iPhone 16 & 17 Pro - 3.png` | Search |
| 4 | `iPhone 16 & 17 Pro - 4.png` | Player |
| 5 | `iPhone 16 & 17 Pro - 5.png` | Library |
| 6 | `iPhone 16 & 17 Pro - 6.png` | Liked Songs |
| 7 | `iPhone 16 & 17 Pro - 7.png` | Queue |
| 8 | `iPhone 16 & 17 Pro - 8.png` | Settings |

### Illustration Asset
- `login page's all asesst of 1.png` — Hero illustration (person with headphones, cat, phone, books, plant) — black monochrome line-art on transparent/black background

### Old Reference Screenshots
- `LOGIN PAGE.png`, `HOME.png`, `SEARCH.png`, `PLAYER.png`, `LIBRARY.png`, `LIKED SONG .png`, `QUEUE.png`, `SETTING.png`

---

## Login Screen — Full Design Spec ✅

### Typography Hierarchy (Google Fonts)
1. **Gasoek One** → "Music" (hero word, ~72px, ultra-heavy blocky display)
2. **Dela Gothic One** → "for a better you" (~36px, wide punchy gothic)
3. **Figtree** (weights 400, 600, 700) → tagline, button text, sign-in link, all UI text

### Color Palette
- Background: Pure white `#FFFFFF`
- Primary text / buttons: Deep black `#0A0A0A` / `#000000`
- Secondary text: Gray `#6B7280`
- Inactive dots: Light gray `#9CA3AF`
- Active dot: Black `#000000`
- No other colors on login screen (pure monochrome)

### Layout (Top to Bottom)
1. **Typography Section** (top-left aligned, padding ~24px horizontal, ~48px top):
   - Line 1: "Music" — Gasoek One, ~72px, deep black, tight tracking
   - Line 2-3: "for a better you" — Dela Gothic One, ~36px, tight line-height
   - Tagline: "Discover. listen. feel." — Figtree 500 weight, ~15px, gray-700, margin-top ~12px

2. **Hero Illustration** (center/full-width):
   - Monochrome line-art illustration
   - Person leaning back with headphones, eyes closed
   - Sleeping cat beside them
   - Smartphone on floor
   - Books on shelf + tall indoor plant near window
   - Clean vector lines, zero color fills

3. **Bottom Action Section**:
   - **CTA Button**: Full-width pill-shaped, solid black `#000`, white text "Get Started →", Figtree bold 16px
   - Hover/press: scale 0.98 micro-interaction
   - **Secondary Link**: "Already have an account? " (Figtree 14px regular, gray) + "Sign in" (Figtree 14px bold, black, clickable)
   - **Pagination Dots**: 3 dots centered — 1st active (black, slightly wider), 2nd & 3rd inactive (gray)
   - **Home Indicator**: iOS-style swipe bar at bottom center

### Design Aesthetic
- Minimalist Japanese lo-fi editorial
- High visual contrast, monochrome palette
- Generous negative space / whitespace
- Fully responsive within mobile viewport (max-width: 430px, min-height: 844px)
- No glassmorphism, no gradients, no shadows on this screen
- Clean, editorial feel

---

## Next Steps
1. ⬜ Set up React Native project (Expo or bare)
2. ⬜ Install Google Fonts (Gasoek One, Dela Gothic One, Figtree)
3. ⬜ Copy illustration asset into project assets folder
4. ⬜ Build Login/Onboarding screen pixel-perfect
5. ⬜ Add "Get Started" → navigation logic
6. ⬜ Add "Sign in" → login form flow
7. ⬜ Then move to remaining screens (Home, Search, Player, Library, Liked Songs, Queue, Settings)

---

## App Screens Overview (for future reference)

### Screen 2: Home
- "Good Morning" + user name greeting
- Bell notification icon + profile avatar
- Search bar ("Search song, Artist, podcast....")
- Hero card ("Chill Vibe" with play button)
- "Made for you" section with playlist cards (Focus, Relax, Dance)
- "Recently played" section with track cards
- Bottom tab bar: Home (active), Search, Library, Liked

### Screen 3: Search
- "Search" heading
- Search input field
- Category pills: Songs (active), Artists, Album, Playlists
- Browse list: Trending, New release, Top charts, Mood, Genre, Podcast
- Bottom tab bar

### Screen 4: Player
- "Playing from" / "My playlist" header
- Large square album artwork (rounded corners)
- Track title + artist name
- Progress bar with timestamps
- Controls: Shuffle, Previous, Play (large circle), Next, Repeat
- Secondary row: info, music note, queue icons
- Track info card at bottom

### Screen 5: Library
- "Your Library" heading with search + add icons
- Category pills: Playlist (active), Artists, Album, Downloaded
- Vertical playlist list with thumbnails + 3-dot overflow
- Bottom tab bar

### Screen 6: Liked Songs
- Back arrow + 3-dot overflow
- Large red album cover art
- "Liked Songs" heading
- Playlist info (saves count, duration)
- Action row: add, download, overflow, play button
- Track list with album art thumbnails

### Screen 7: Queue
- "Queue" heading + delete icon
- "Now Playing" current track
- "Next In Queue" list with drag handles

### Screen 8: Settings
- Back arrow + "Settings" heading
- Profile circle + name + plan
- Settings list: Upgrade, Download, Audio Quality, Notifications, Appearance, Language, Data & Storage, About
- "Log Out" pill button at bottom

### Bottom Tab Bar (shared across Home, Search, Library, Liked)
- Home (house icon)
- Search (magnifying glass)
- Library (music note icon)
- Liked (heart icon)
