---

# Compose Multiplatform

**프로젝트는 두 개의 모듈로 구성**

1. **composeApp**
    1. **설명:** Android, Desktop, iOS, Web 애플리케이션에서 공통으로 사용하는 로직이 포함된 Kotlin 모듈입니다.
    2. **특징**
        1. 모든 플랫폼에서 사용되는 코드가 이 모듈에 위치합니다.
        2. Gradle 빌드 시스템을 사용하여 빌드 과정을 자동화합니다.
2. **iosApp**
    1. **설명:** iOS 애플리케이션으로 빌드되는 Xcode 프로젝트입니다.
    2. **특징**
        1. 공유 모듈(composeApp)을 iOS 프레임워크로 의존하여 사용합니다.

---

**Compose Multiplatform 프로젝트 구조**

![스크린샷 2025-03-22 20.55.57.png](attachment:2a59f7c5-b58d-4ada-97ab-cc5470ec9bf5:스크린샷_2025-03-22_20.55.57.png)

- **`composeApp` 모듈**은 다음과 같은 소스셋(Source Set)들로 구성되어 있음
- **`androidMain`**
- **`commonMain`**
- **`desktopMain`**
- **`iosMain`**
- **`wasmJsMain`**
- **소스셋(Source Set) 설명**
    - 소스셋은 `Gradle`의 개념으로, 논리적으로 함께 그룹화된 여러 파일들을 의미하며, 각 그룹은 고유의 의존성을 가짐
- **플랫폼별 소스셋 역할**
    - **`commonMain`**
        - 모든 플랫폼에서 공통으로 사용하는 Kotlin 코드를 포함
    - **platform-specific 소스셋**
        - 각 플랫폼에 특화된 Kotlin 코드를 포함
    - **`androidMain`**과 **`desktopMain`**은 Kotlin/JVM을 사용함
    - **`iosMain`**은 Kotlin/Native를 사용함
    - **`wasmJsMain`**은 Kotlin/Wasm을 사용함
- **빌드 시 공통 코드의 처리 방식**
    - 공유 모듈이 Android 라이브러리로 빌드될 때, 공통 Kotlin 코드는 Kotlin/JVM으로 취급
    - iOS 프레임워크로 빌드될 때는 Kotlin/Native로, 웹 앱으로 빌드될 때는 Kotlin/Wasm으로 취급
- **`App.kt` 파일**
- 위치: composeApp/src/commonMain/kotlin
- 이 파일에는 최소하지만 완전한 Compose Multiplatform UI를 구현하는 App() 함수가 포함되어 있음

---

<aside>
💡

목표

1. 화면 2개 만들기 
    1. 화면 1:  동영상 플레이어 리스트 
    2. 화면 2: 동영상 재생 화면 
2. 소형 플레이어 제공
3. Android, iOS, Desktop 서비스 제공 
</aside>

## 3개의 OS를 제공하기 위해 라이브러리를 사용함

```kotlin
mediaplayerKmp = "2.0.6"
mediaplayer-kmp = { module = "io.github.khubaibkhan4:mediaplayer-kmp", version.ref = "mediaplayerKmp" }
```

- build.gradle.kts
    - `commonMain` 안에 선언해주면됨

```kotlin
  commonMain.dependencies {
	   implementation(libs.mediaplayer.kmp)
  }
```

## 구조

**`MainScreen`**

- 앱의 메인 화면으로, 영상 목록과 플레이어(전체 화면 또는 최소화)를 조건에 따라 표시
- 영상을 선택하면 VideoPlayerState.loadVideo()를 호출하여 상태를 업데이트

**`VideoListScreen`**

- 영상 목록을 LazyColumn으로 구현하여 각 항목에 대해 카드 형태로 영상 썸네일과 정보를 표시
- 이미지 로딩은 Coil을 활용

**`VideoPlayerScreen`**

- 전체 화면 영상 재생 UI를 제공하며, 소형플레이어 기능을 지원

**`MiniPlayer`**

- 소형 플레이어 UI로, 드래그 제스처를 지원해 사용자가 자유롭게 위치를 변경할 수 있음
- 상단 우측 버튼을 통해 전체 화면 재생으로 전환하거나 플레이어를 종료할 수 있음

**`VideoPlayerState`**

- 영상 재생 상태를 관리하는 클래스로, `Compose`의 `mutableStateO`를 사용하여 상태 변경 시 UI가 자동으로 재구성

---

현재 안되는 부분

⇒ 기본 플레이어 → 소형플레이어, 소형플레이어 → 기본플레이어로 바뀔때 다시 초기화되서 처음부터 봐야됨
