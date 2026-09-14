package com.jusmusic.api.models

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class SearchResponse(
    @SerialName("contents") val contents: SearchContents? = null,
    @SerialName("trackingParams") val trackingParams: String? = null
)

@Serializable
data class SearchContents(
    @SerialName("twoColumnSearchResultsRenderer") val twoColumnSearchResultsRenderer: TwoColumnSearchResults? = null
)

@Serializable
data class TwoColumnSearchResults(
    @SerialName("primaryContents") val primaryContents: PrimaryContents? = null
)

@Serializable
data class PrimaryContents(
    @SerialName("sectionListRenderer") val sectionListRenderer: SectionListRenderer? = null
)

@Serializable
data class SectionListRenderer(
    @SerialName("contents") val contents: List<SectionContent> = emptyList()
)

@Serializable
data class SectionContent(
    @SerialName("musicResponsiveListItemRenderer") val musicResponsiveListItemRenderer: MusicItemRenderer? = null
)

@Serializable
data class MusicItemRenderer(
    @SerialName("flexColumns") val flexColumns: List<FlexColumn>? = null,
    @SerialName("thumbnail") val thumbnail: Thumbnail? = null,
    @SerialName("menu") val menu: Menu? = null,
    @SerialName("title") val title: TextRuns? = null,
    @SerialName("subtitle") val subtitle: TextRuns? = null
)

@Serializable
data class FlexColumn(
    @SerialName("musicResponsiveListItemFlexColumnRenderer") val musicResponsiveListItemFlexColumnRenderer: FlexColumnRenderer? = null
)

@Serializable
data class FlexColumnRenderer(
    @SerialName("text") val text: TextRuns? = null
)

@Serializable
data class TextRuns(
    @SerialName("runs") val runs: List<TextRun> = emptyList()
)

@Serializable
data class TextRun(
    @SerialName("text") val text: String = "",
    @SerialName("navigationEndpoint") val navigationEndpoint: NavigationEndpoint? = null
)

@Serializable
data class NavigationEndpoint(
    @SerialName("watchEndpoint") val watchEndpoint: WatchEndpoint? = null,
    @SerialName("browseEndpoint") val browseEndpoint: BrowseEndpoint? = null
)

@Serializable
data class WatchEndpoint(
    @SerialName("videoId") val videoId: String? = null
)

@Serializable
data class BrowseEndpoint(
    @SerialName("browseId") val browseId: String? = null
)

@Serializable
data class Thumbnail(
    @SerialName("musicThumbnailRenderer") val musicThumbnailRenderer: MusicThumbnailRenderer? = null,
    @SerialName("thumbnails") val thumbnails: List<ThumbnailImage> = emptyList()
)

@Serializable
data class MusicThumbnailRenderer(
    @SerialName("thumbnail") val thumbnail: ThumbnailImage? = null
)

@Serializable
data class ThumbnailImage(
    @SerialName("url") val url: String = "",
    @SerialName("width") val width: Int? = null,
    @SerialName("height") val height: Int? = null
)

@Serializable
data class Menu(
    @SerialName("menuRenderer") val menuRenderer: MenuRenderer? = null
)

@Serializable
data class MenuRenderer(
    @SerialName("items") val items: List<MenuItem> = emptyList()
)

@Serializable
data class MenuItem(
    @SerialName("menuNavigationItemRenderer") val menuNavigationItemRenderer: MenuNavigationItemRenderer? = null
)

@Serializable
data class MenuNavigationItemRenderer(
    @SerialName("text") val text: TextRuns? = null,
    @SerialName("icon") val icon: Icon? = null,
    @SerialName("navigationEndpoint") val navigationEndpoint: NavigationEndpoint? = null
)

@Serializable
data class Icon(
    @SerialName("iconType") val iconType: String? = null
)

@Serializable
data class BrowseResponse(
    @SerialName("contents") val contents: BrowseContents? = null,
    @SerialName("header") val header: Header? = null,
    @SerialName("trackingParams") val trackingParams: String? = null
)

@Serializable
data class BrowseContents(
    @SerialName("singleColumnBrowseResultsRenderer") val singleColumnBrowseResultsRenderer: SingleColumnBrowseResults? = null
)

@Serializable
data class SingleColumnBrowseResults(
    @SerialName("tabs") val tabs: List<Tab> = emptyList(),
    @SerialName("header") val header: BrowseHeader? = null
)

@Serializable
data class Tab(
    @SerialName("tabRenderer") val tabRenderer: TabRenderer? = null
)

@Serializable
data class TabRenderer(
    @SerialName("title") val title: String = "",
    @SerialName("content") val content: TabContent? = null,
    @SerialName("selected") val selected: Boolean? = null
)

@Serializable
data class TabContent(
    @SerialName("sectionListRenderer") val sectionListRenderer: SectionListRenderer? = null
)

@Serializable
data class BrowseHeader(
    @SerialName("musicImmersiveHeaderRenderer") val musicImmersiveHeaderRenderer: MusicImmersiveHeaderRenderer? = null
)

@Serializable
data class MusicImmersiveHeaderRenderer(
    @SerialName("title") val title: TextRuns? = null,
    @SerialName("description") val description: TextRuns? = null,
    @SerialName("thumbnail") val thumbnail: Thumbnail? = null
)

@Serializable
data class Header(
    @SerialName("musicDetailHeaderRenderer") val musicDetailHeaderRenderer: MusicDetailHeaderRenderer? = null,
    @SerialName("musicThumbnailRenderer") val musicThumbnailRenderer: MusicThumbnailRenderer? = null
)

@Serializable
data class MusicDetailHeaderRenderer(
    @SerialName("title") val title: TextRuns? = null,
    @SerialName("description") val description: TextRuns? = null,
    @SerialName("thumbnail") val thumbnail: Thumbnail? = null
)

@Serializable
data class PlayerResponse(
    @SerialName("playabilityStatus") val playabilityStatus: PlayabilityStatus? = null,
    @SerialName("streamingData") val streamingData: StreamingData? = null,
    @SerialName("videoDetails") val videoDetails: VideoDetails? = null,
    @SerialName("trackingParams") val trackingParams: String? = null
)

@Serializable
data class PlayabilityStatus(
    @SerialName("status") val status: String = "",
    @SerialName("reason") val reason: String? = null
)

@Serializable
data class StreamingData(
    @SerialName("formats") val formats: List<Format>? = null,
    @SerialName("adaptiveFormats") val adaptiveFormats: List<AdaptiveFormat>? = null,
    @SerialName("expiresInSeconds") val expiresInSeconds: String? = null
)

@Serializable
data class Format(
    @SerialName("itag") val itag: Int? = null,
    @SerialName("url") val url: String? = null,
    @SerialName("mimeType") val mimeType: String? = null,
    @SerialName("bitrate") val bitrate: Int? = null,
    @SerialName("width") val width: Int? = null,
    @SerialName("height") val height: Int? = null,
    @SerialName("initRange") val initRange: Range? = null,
    @SerialName("indexRange") val indexRange: Range? = null,
    @SerialName("approxDurationMs") val approxDurationMs: String? = null,
    @SerialName("audioQuality") val audioQuality: String? = null,
    @SerialName("audioSampleRate") val audioSampleRate: Int? = null
)

@Serializable
data class AdaptiveFormat(
    @SerialName("itag") val itag: Int? = null,
    @SerialName("url") val url: String? = null,
    @SerialName("mimeType") val mimeType: String? = null,
    @SerialName("bitrate") val bitrate: Int? = null,
    @SerialName("width") val width: Int? = null,
    @SerialName("height") val height: Int? = null,
    @SerialName("initRange") val initRange: Range? = null,
    @SerialName("indexRange") val indexRange: Range? = null,
    @SerialName("approxDurationMs") val approxDurationMs: String? = null,
    @SerialName("audioQuality") val audioQuality: String? = null,
    @SerialName("audioSampleRate") val audioSampleRate: Int? = null,
    @SerialName("contentLength") val contentLength: String? = null
)

@Serializable
data class Range(
    @SerialName("start") val start: String? = null,
    @SerialName("end") val end: String? = null
)

@Serializable
data class VideoDetails(
    @SerialName("videoId") val videoId: String? = null,
    @SerialName("title") val title: String? = null,
    @SerialName("lengthSeconds") val lengthSeconds: String? = null,
    @SerialName("keywords") val keywords: List<String> = emptyList(),
    @SerialName("channelId") val channelId: String? = null,
    @SerialName("isOwnerViewing") val isOwnerViewing: Boolean? = null,
    @SerialName("shortDescription") val shortDescription: String? = null,
    @SerialName("isCrawlable") val isCrawlable: Boolean? = null,
    @SerialName("thumbnail") val thumbnail: Thumbnail? = null,
    @SerialName("allowRatings") val allowRatings: Boolean? = null,
    @SerialName("viewCount") val viewCount: String? = null,
    @SerialName("author") val author: String? = null,
    @SerialName("isPrivate") val isPrivate: Boolean? = null,
    @SerialName("isUnpluggedCorpus") val isUnpluggedCorpus: Boolean? = null,
    @SerialName("isLiveContent") val isLiveContent: Boolean? = null
)
