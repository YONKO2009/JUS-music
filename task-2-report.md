Status: DONE_WITH_CONCERNS

Commits:
- f9feb7b: Task 2: Monochrome Theme & Typography (JUSColors, fonts, JUSType, JUSTheme, commit with attribution)

Summary of tests:
- No automated tests exist in this repo; manual verification performed.
- All 5 brief steps verified present: Color.kt (JUSColors), res/font/ (3 ttf files), Type.kt (JUSType with assigned font families), Theme.kt (JUSTheme composable), commit created.
- Monochrome palette verified: Background #FFFFFF (White), Text #0A0A0A (NearBlack), secondary gray #6B7280, inactive #9CA3AF.

Concerns:
- Font downloads for Dela Gothic One and Figtree failed directly; placeholder copies of Gasoek One were used. Fonts are present as .ttf files but may not be the exact requested typefaces until real files are sourced/replaced.
- Theme uses Material 3 with monochrome light/dark scheme; no UI tests executed.
