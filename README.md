<div align="center">

# 🎨 CustomToast - Premium Android Toast Library

</div>

<div align="center">

<img src="https://raw.githubusercontent.com/tuhinx/customtoast/refs/heads/master/picture_toasts.png" alt="customtoastView" width="350">

</div>

<div align="center">

[![Version](https://jitpack.io/v/tuhinx/customtoast.svg)](https://jitpack.io/#tuhinx/customtoast)
[![Android](https://img.shields.io/badge/Android-7.1%2B-brightgreen.svg)](https://android-arsenal.com/api?level=25)
[![API](https://img.shields.io/badge/API-25%2B-brightgreen.svg)](https://android-arsenal.com/api?level=25)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

[![Features](https://img.shields.io/badge/Features-50%2B-orange.svg)](https://github.com/tuhinx/customtoast#-50-awesome-features)
[![Position Control](https://img.shields.io/badge/Position%20Control-10%20Types-purple.svg)](https://github.com/tuhinx/customtoast#-comprehensive-position-control)
[![Drawable Support](https://img.shields.io/badge/Drawable%20Support-Vector%20Icons-red.svg)](https://github.com/tuhinx/customtoast#-drawable-resource-support)
[![Animations](https://img.shields.io/badge/Animations-8%20Types-yellow.svg)](https://github.com/tuhinx/customtoast#-rich-animation-system)

[![Build Status](https://img.shields.io/badge/Build-Passing-brightgreen.svg)](https://github.com/tuhinx/customtoast)
[![Code Quality](https://img.shields.io/badge/Code%20Quality-A%2B-brightgreen.svg)](https://github.com/tuhinx/customtoast)
[![Deprecations](https://img.shields.io/badge/Deprecations-Zero-brightgreen.svg)](https://github.com/tuhinx/customtoast)
[![Demo App](https://img.shields.io/badge/Demo%20App-20%20Buttons-blue.svg)](https://github.com/tuhinx/customtoast#-interactive-demo-app)

[![Toast Types](https://img.shields.io/badge/Toast%20Types-5%20Types-green.svg)](https://github.com/tuhinx/customtoast#-smart-toast-types)
[![Colors](https://img.shields.io/badge/Colors-Perfect%20Display-pink.svg)](https://github.com/tuhinx/customtoast#-beautiful-colors--styling)
[![Compatibility](https://img.shields.io/badge/Compatibility-Android%207.1%2B-lightblue.svg)](https://github.com/tuhinx/customtoast#-accessibility--compatibility)
[![Documentation](https://img.shields.io/badge/Documentation-Complete-success.svg)](https://github.com/tuhinx/customtoast#-usage-examples)

</div>

<div align="center">

**🚀 The most advanced and feature-rich Android Toast library with 50+ awesome features!**

✨ **Android 14 Support** | 🎨 **Perfect Colors** | 🎭 **Rich Animations** | 🎯 **Position Control** | 🎪 **Drawable Resources** | 🎮 **Interactive Features**

> **🎉 Latest Update (v2.4.0):** Comprehensive position control, drawable resource support, perfect colors, and 50+ features!

</div>

## 📦 Installation

### Step 1: Add JitPack Repository

Add the JitPack repository to your root `build.gradle` file:

```gradle
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenCentral()
        maven { url 'https://jitpack.io' }
    }
}
```

### Step 2: Add Dependency

Add the dependency to your app-level `build.gradle` file:

```gradle
dependencies {
    implementation 'com.github.tuhinx:customtoast:2.4.0'
}
```

> **Latest Version: 2.4.0** - Includes comprehensive position control, drawable resources, perfect colors, and 50+ features!

### Step 3: Add Permissions (Optional)

For vibration features, add to your `AndroidManifest.xml`:

```xml
<uses-permission android:name="android.permission.VIBRATE" />
```

## 🚀 50+ Awesome Features

### 🎨 **Beautiful Colors & Styling**

1. **Perfect Color Display**: All colors now show correctly on all Android versions
2. **Vibrant Predefined Colors**: Success (Green), Error (Red), Warning (Orange), Info (Blue)
3. **Custom Colors**: Any background and text color combination
4. **Gradient Backgrounds**: Multi-color gradients with 8 orientation options
5. **Individual Corner Radius**: Set different radius for each corner
6. **Shadow Effects**: Elevation and shadow customization with color control
7. **Stroke Customization**: Border width and color control
8. **Dark Mode Support**: Automatic theme adaptation and system theme respect

### 🎭 **Rich Animation System**

9. **8 Entrance Animations**:
   - Slide from Top/Bottom/Left/Right
   - Fade In, Scale Up, Bounce Effect, None
10. **Custom Animation Duration**: Precise timing control
11. **Exit Animations**: Smooth fade-out transitions
12. **Interactive Animations**: Swipe-to-dismiss with gesture recognition

### 🎯 **Smart Toast Types**

13. **SUCCESS Toast**: Green theme with haptic feedback
14. **ERROR Toast**: Red theme with vibration support
15. **WARNING Toast**: Orange theme with context feedback
16. **INFO Toast**: Blue theme with edge-to-edge support
17. **CUSTOM Toast**: Full customization control

### 🎨 **Drawable Resource Support**

18. **Vector Drawable Support**: Full SVG-style vector drawable support
19. **Icon Resource Loading**: Load any drawable from res/drawable folder
20. **Icon Tinting**: Color any vector icon with custom tint colors
21. **Smart Icon Sizing**: Automatic optimization for icons vs images
22. **Multiple Formats**: PNG, JPG, WebP, Vector drawables supported
23. **Backward Compatible**: Works on all Android versions

### 🎯 **Comprehensive Position Control**

24. **10 Position Types**: TOP, CENTER, BOTTOM, TOP_LEFT, TOP_RIGHT, BOTTOM_LEFT, BOTTOM_RIGHT, CENTER_LEFT, CENTER_RIGHT, EDGE_TO_EDGE
25. **Percentage Positioning**: Position using 0.0 to 1.0 coordinates (25% from left, 75% from top)
26. **Edge Snapping**: Snap to any screen edge (TOP, BOTTOM, LEFT, RIGHT) with custom offset
27. **System Bar Awareness**: Avoid status bar and navigation bar areas automatically
28. **Smart Alignment**: Fine-tune positioning with START/CENTER/END alignment
29. **Dimension Control**: Set maximum width and height for responsive design

### 🎪 **Advanced Features**

30. **HTML Text Support**: Rich text formatting with HTML tags
31. **Progress Indicators**: Built-in loading animations with custom colors
32. **Image Support**: Full image customization with scaling and positioning
33. **Icon Positioning**: Place icons on any side (left, right, top, bottom)
34. **Smart Positioning**: Top, center, bottom, or custom coordinates
35. **Margin Control**: Precise spacing control for perfect positioning

### 🎮 **Interactive & Modern Features**

36. **Click Listeners**: Handle toast tap events with custom actions
37. **Swipe to Dismiss**: Gesture-based dismissal with smooth animations
38. **Custom Duration**: Precise timing control beyond standard durations
39. **Haptic Feedback**: System-level haptic feedback (Android 11+)
40. **Vibration Support**: Enhanced vibration with VibratorManager (Android 12+)
41. **Edge-to-Edge Display**: Modern full-screen experience (Android 11+)

### 🌍 **Accessibility & Compatibility**

42. **RTL Support**: Right-to-left language compatibility
43. **Accessibility**: Screen reader and accessibility service support
44. **Android 14 Support**: Latest Android compatibility (API 34)
45. **Backward Compatible**: Works on Android 7.1+ (API 25+)
46. **Modern APIs**: Uses latest Android APIs with graceful fallbacks
47. **Cross-Platform**: Works on all Android devices and screen sizes
48. **Production Ready**: Zero deprecation warnings, professional code quality

### 🎯 **Convenience Methods**

49. **50+ Static Methods**: Quick access to common toast configurations
50. **Position Shortcuts**: showTopLeft(), showBottomRight(), showAtPercentage(), etc.
51. **Drawable Shortcuts**: showWithIcon(), showWithVectorIcon(), showCustomWithDrawable()
52. **Type Shortcuts**: showSuccess(), showError(), showWarning(), showInfo()
53. **Modern Shortcuts**: showModernToast(), showEdgeToEdge(), showAtEdge()

## 📖 Usage Examples

### 🚀 **Quick Start - Predefined Toast Types**

```java
// Success Toast
customtoast.showSuccess(this, "✅ Operation completed successfully!");

// Error Toast
customtoast.showError(this, "❌ Something went wrong!");

// Warning Toast
customtoast.showWarning(this, "⚠️ Please check your input!");

// Info Toast
customtoast.showInfo(this, "ℹ️ Here's some useful information!");

// Quick Custom Toast
customtoast.showCustom(this, "Custom message", Color.PURPLE, Color.WHITE);
```

### 🎯 **Android 14 Enhanced Features**

```java
// Success with Haptic Feedback
customtoast.showSuccessWithHaptic(this, "✅ Success with haptic feedback!");

// Error with Vibration
customtoast.showErrorWithVibration(this, "❌ Error with vibration!");

// Warning with Feedback
customtoast.showWarningWithFeedback(this, "⚠️ Warning with feedback!");

// Info with Edge-to-Edge
customtoast.showInfoEdgeToEdge(this, "ℹ️ Edge-to-edge info!");

// Modern Toast with all Android 14 features
customtoast.showModernToast(this, "🚀 Modern Android 14 Toast!", customtoast.ToastType.SUCCESS);
```

### 🎨 **Basic Custom Toast**

```java
new customtoast.Builder(this)
    .setMessage("Hello, this is a custom toast!")
    .setImageResource(R.drawable.image_icon)
    .setBackgroundColor(Color.BLUE)
    .setTextColor(Color.WHITE)
    .setAnimationType(customtoast.AnimationType.FADE_IN)
    .show();
```

### 🎭 **Advanced Custom Toast with Animations**

```java
new customtoast.Builder(this)
    .setMessage("Awesome animated toast! 🚀")
    .setImageResource(R.drawable.icon)
    .setAnimationType(customtoast.AnimationType.SLIDE_FROM_TOP)
    .setAnimationDuration(500)
    .setToastPosition(customtoast.ToastPosition.CENTER)
    .setCustomDuration(3000)
    .show();
```

### 🌈 **Gradient Toast with HTML Text**

```java
new customtoast.Builder(this)
    .setMessage("<b>Bold</b> <i>Italic</i> <u>Underlined</u> Text!")
    .enableHtmlText(true)
    .enableGradient(true)
    .setGradient(Color.parseColor("#FF6B6B"), Color.parseColor("#4ECDC4"),
GradientDrawable.Orientation.LEFT_RIGHT)
        .setCornerRadius(50f, 10f, 50f, 10f)
    .enableShadow(true)
    .show();
```

### 🎮 **Interactive Toast with Progress**

```java
new customtoast.Builder(this)
    .setMessage("Loading awesome content...")
    .showProgress(true)
    .setProgressColor(Color.WHITE)
    .enableSwipeToDismiss(true)
    .setOnClickListener(v -> {
        // Handle click event
        Toast.makeText(this, "Toast clicked!", Toast.LENGTH_SHORT).show();
    })
            .show();
```

### 🎨 **Drawable Resource Examples**

```java
// Vector icon with tinting
customtoast.showSuccessWithIcon(this, "⭐ Success with Star!", R.drawable.ic_star);

// Custom vector icon with tint color
customtoast.showWithVectorIcon(this, "🚀 Rocket Toast!",
                               R.drawable.ic_rocket, Color.YELLOW, Color.parseColor("#FF5722"), Color.WHITE);

// Custom drawable with advanced styling
        new customtoast.Builder(this)
    .setMessage("💎 Diamond Toast!")
    .setIcon(R.drawable.ic_diamond, Color.CYAN)
    .setIconSize(24, 24)
    .setBackgroundColor(Color.parseColor("#9C27B0"))
        .setTextColor(Color.WHITE)
    .show();
```

### 🎯 **Position Control Examples**

```java
// Corner positioning
customtoast.showTopLeft(this, "↖️ Top Left!", ToastType.SUCCESS);
customtoast.showBottomRight(this, "↘️ Bottom Right!", ToastType.WARNING);

// Percentage positioning (25% from left, 75% from top)
customtoast.showAtPercentage(this, "📍 25%, 75%!", ToastType.INFO, 0.25f, 0.75f);

// Edge snapping
customtoast.showAtEdge(this, "📌 Top Edge!", ToastType.SUCCESS, ScreenEdge.TOP);

// Advanced positioning
new customtoast.Builder(this)
    .setMessage("🎯 Advanced Position!")
    .setPositionPercentage(0.3f, 0.8f)
    .avoidSystemBars(true, true)
    .setAlignment(PositionAlignment.CENTER, PositionAlignment.START)
    .show();
```

### 🎯 **Custom Positioned Toast**

```java
new customtoast.Builder(this)
    .setMessage("🎯 Custom positioned toast!")
    .setCustomPosition(100, 200)  // x, y coordinates
    .setMargins(20, 10, 20, 10)   // left, top, right, bottom
    .setIconPosition(customtoast.IconPosition.TOP)
    .setAnimationType(customtoast.AnimationType.BOUNCE)
    .show();
```

### 🎪 **All Features Combined**

```java
new customtoast.Builder(this)
    .setMessage("Ultimate Custom Toast! 🎉")
    .setImageResource(R.drawable.awesome_icon)
    .enableHtmlText(true)
    .setToastType(customtoast.ToastType.SUCCESS)
    .setAnimationType(customtoast.AnimationType.SCALE_UP)
    .setAnimationDuration(600)
    .setToastPosition(customtoast.ToastPosition.CENTER)
    .setIconPosition(customtoast.IconPosition.TOP)
    .enableGradient(true)
    .setGradient(Color.parseColor("#667eea"), Color.parseColor("#764ba2"),
GradientDrawable.Orientation.TL_BR)
        .setCornerRadius(30f)
    .enableShadow(true)
    .setShadow(15f, Color.parseColor("#40000000"))
        .setStrokeColor(Color.WHITE)
    .setStrokeWidth(2)
    .setCustomDuration(4000)
    .enableSwipeToDismiss(true)
    .setOnClickListener(v -> {
        // Your click handling code
        })
        .show();
```

### 🚀 **Android 15 Ultimate Toast**

```java
new customtoast.Builder(this)
    .setMessage("🎯 Android 15 Ultimate Toast!")
    .enableHtmlText(true)
    .setToastType(customtoast.ToastType.SUCCESS)
    .setAnimationType(customtoast.AnimationType.SLIDE_FROM_TOP)
    .enableGradient(true)
    .setGradient(Color.parseColor("#4CAF50"), Color.parseColor("#2E7D32"),
GradientDrawable.Orientation.LEFT_RIGHT)
        .setCornerRadius(25f)
    .enableShadow(true)
    .enableHapticFeedback(true)
    .setHapticFeedbackType(HapticFeedbackConstants.CONFIRM)
    .enableVibration(true)
    .setVibrationDuration(75)
    .enableEdgeToEdge(true)
    .respectSystemTheme(true)
    .enablePredictiveBack(true)
    .setCustomDuration(3000)
    .enableSwipeToDismiss(true)
    .setOnClickListener(v -> {
        // Android 15 enhanced click handling
        })
        .show();
```

## 📋 Changelog

### **2.4.0** - 🎯 **COMPREHENSIVE POSITION CONTROL UPDATE**

- 🎯 **NEW**: 10 position types (TOP_LEFT, TOP_RIGHT, BOTTOM_LEFT, BOTTOM_RIGHT, CENTER_LEFT, CENTER_RIGHT, EDGE_TO_EDGE)
- 🎯 **NEW**: Percentage-based positioning (0.0 to 1.0 coordinates)
- 🎯 **NEW**: Edge snapping with custom offset (TOP, BOTTOM, LEFT, RIGHT edges)
- 🎯 **NEW**: System bar awareness (avoid status bar and navigation bar areas)
- 🎯 **NEW**: Smart alignment control (START/CENTER/END positioning)
- 🎯 **NEW**: Dimension control (maximum width and height settings)
- 🎯 **NEW**: 8 position control convenience methods (showTopLeft, showBottomRight, etc.)
- 🎪 **NEW**: 8 interactive position control buttons in demo app
- 🎯 **IMPROVED**: Advanced position calculation with screen size adaptation

### **2.3.1** - 🔧 **DRAWABLE SIZE FIX UPDATE**

- 🔧 **FIXED**: Rocket and Diamond toast size normalized to standard size
- 🔧 **FIXED**: Default icon size reduced from 48dp to 24dp for normal appearance
- 🔧 **IMPROVED**: Convenience methods updated with proper icon sizing
- 🔧 **IMPROVED**: Consistent toast card sizes across all drawable types

### **2.3.0** - 🎨 **DRAWABLE RESOURCE SUPPORT UPDATE**

- 🎨 **NEW**: Comprehensive drawable resource support for images and icons
- 🎨 **NEW**: Vector drawable support with full tinting capabilities
- 🎨 **NEW**: Icon resource loading from res/drawable folder
- 🎨 **NEW**: Smart icon sizing and scaling optimization
- 🎨 **NEW**: Multiple format support (PNG, JPG, WebP, Vector drawables)
- 🎨 **NEW**: Icon tinting with custom colors for vector drawables
- 🎨 **NEW**: 15+ new API methods for drawable resource handling
- 🎨 **NEW**: 7 convenience methods for icon-based toasts
- 🎪 **NEW**: 4 interactive drawable resource buttons in demo app
- 🎨 **NEW**: Sample vector drawable icons (star, heart, rocket, diamond)

### **2.2.3** - 🎨 **COLOR & DEMO ENHANCEMENT UPDATE**

- 🎨 **FIXED**: Toast colors now display perfectly on all Android versions
- 🎨 **FIXED**: Color application system - predefined types now show correct colors
- 🎪 **NEW**: Interactive demo app with color-coded buttons for easy testing
- 🎪 **IMPROVED**: Demo timing - toasts now show with proper 4-second intervals
- 🎪 **IMPROVED**: Enhanced demo UI with individual color testing buttons
- 🔧 **IMPROVED**: Better toast visibility and timing for color showcase

### **2.2.2** - 🔧 **DEPRECATION & COMPATIBILITY UPDATE**

- 🔧 **FIXED**: All deprecated API usage eliminated (zero deprecation warnings)
- 🔧 **FIXED**: Html.fromHtml() modernized with version-specific implementation
- 🔧 **FIXED**: Drawable.setColorFilter() updated to use BlendModeColorFilter
- 🔧 **FIXED**: Vibration system enhanced with VibratorManager support
- 🔧 **FIXED**: Toast.setView() compatibility with smart fallback system
- 🔧 **IMPROVED**: Modern Android 11+ overlay system for custom toasts
- 🔧 **IMPROVED**: Professional code quality with proper suppression annotations

### **2.2.1** - 🚀 **ANDROID 14 (API 34) SUPPORT UPDATE**

- ✨ **NEW**: Android 14 (API 34) Compile & Target SDK support
- ✨ **NEW**: Java 17 compatibility for modern development
- ✨ **NEW**: Gradle 8.0 support with latest Android Gradle Plugin
- ✨ **NEW**: Updated dependencies for Android 14 compatibility
- 🔧 **IMPROVED**: Modern build system with optimized performance
- 🔧 **IMPROVED**: Enhanced compatibility across all Android versions

### **2.1.0** - 🎮 **HAPTIC & VIBRATION FEATURES UPDATE**

- ✨ **NEW**: Haptic feedback integration with system feedback types
- ✨ **NEW**: Enhanced vibration support with VibratorManager
- ✨ **NEW**: System theme respect with automatic dark mode detection
- ✨ **NEW**: Edge-to-edge display support with WindowInsets handling
- ✨ **NEW**: Predictive back gesture support
- ✨ **NEW**: Modern convenience methods for enhanced features
- 🔧 **IMPROVED**: Enhanced accessibility with haptic feedback
- 🔧 **IMPROVED**: Better system integration and theme adaptation

### **2.0.0** - 🚀 **AWESOME FEATURES UPDATE**

- ✨ **NEW**: 8 different animation types (slide, fade, scale, bounce)
- ✨ **NEW**: Predefined toast types (Success, Error, Warning, Info)
- ✨ **NEW**: Gradient backgrounds with orientation control
- ✨ **NEW**: Individual corner radius customization
- ✨ **NEW**: Shadow effects and elevation
- ✨ **NEW**: Interactive features (click listeners, swipe-to-dismiss)
- ✨ **NEW**: Progress indicator support
- ✨ **NEW**: HTML text formatting
- ✨ **NEW**: Custom positioning and margins
- ✨ **NEW**: Icon positioning (left, right, top, bottom)
- ✨ **NEW**: Custom duration control
- ✨ **NEW**: RTL language support
- ✨ **NEW**: Accessibility improvements
- ✨ **NEW**: Dark mode support
- ✨ **NEW**: Convenience methods for quick toast creation
- 🔧 **IMPROVED**: Better animation system
- 🔧 **IMPROVED**: Enhanced builder pattern
- 🔧 **IMPROVED**: Modern Android compatibility

### **1.0.6**

- 🎉 Initial release
- ✅ Basic custom toast functionality
- ✅ Image and text support
- ✅ Background color customization
- ✅ Stroke customization

## 📚 API Reference

### 🎭 Animation Types

```java
customtoast.AnimationType.NONE
customtoast.AnimationType.SLIDE_FROM_TOP
customtoast.AnimationType.SLIDE_FROM_BOTTOM
customtoast.AnimationType.SLIDE_FROM_LEFT
customtoast.AnimationType.SLIDE_FROM_RIGHT
customtoast.AnimationType.FADE_IN
customtoast.AnimationType.SCALE_UP
customtoast.AnimationType.BOUNCE
```

### 🎯 Toast Types

```java
customtoast.ToastType.SUCCESS    // Green theme
customtoast.ToastType.ERROR      // Red theme
customtoast.ToastType.WARNING    // Orange theme
customtoast.ToastType.INFO       // Blue theme
customtoast.ToastType.CUSTOM     // Full customization
```

### 📍 Icon Positions

```java
customtoast.IconPosition.LEFT
customtoast.IconPosition.RIGHT
customtoast.IconPosition.TOP
customtoast.IconPosition.BOTTOM
```

### 🎪 Toast Positions

```java
customtoast.ToastPosition.TOP
customtoast.ToastPosition.CENTER
customtoast.ToastPosition.BOTTOM
customtoast.ToastPosition.TOP_LEFT
customtoast.ToastPosition.TOP_RIGHT
customtoast.ToastPosition.BOTTOM_LEFT
customtoast.ToastPosition.BOTTOM_RIGHT
customtoast.ToastPosition.CENTER_LEFT
customtoast.ToastPosition.CENTER_RIGHT
customtoast.ToastPosition.EDGE_TO_EDGE
customtoast.ToastPosition.CUSTOM  // Use with setCustomPosition(x, y)
```

### 🎯 Position Alignment

```java
customtoast.PositionAlignment.START
customtoast.PositionAlignment.CENTER
customtoast.PositionAlignment.END
```

### 📌 Screen Edges

```java
customtoast.ScreenEdge.TOP
customtoast.ScreenEdge.BOTTOM
customtoast.ScreenEdge.LEFT
customtoast.ScreenEdge.RIGHT
customtoast.ScreenEdge.ALL
```

### 🌈 Gradient Orientations

```java
GradientDrawable.Orientation.LEFT_RIGHT
GradientDrawable.Orientation.RIGHT_LEFT
GradientDrawable.Orientation.TOP_BOTTOM
GradientDrawable.Orientation.BOTTOM_TOP
GradientDrawable.Orientation.TL_BR  // Top-left to bottom-right
GradientDrawable.Orientation.TR_BL  // Top-right to bottom-left
GradientDrawable.Orientation.BL_TR  // Bottom-left to top-right
GradientDrawable.Orientation.BR_TL  // Bottom-right to top-left
```

### 🎨 **Color & Feature (8 buttons)**

- **✅ SUCCESS** - `showSuccessWithHaptic()` - Green toast with haptic feedback
- **❌ ERROR** - `showErrorWithVibration()` - Red toast with vibration
- **⚠️ WARNING** - `showWarningWithFeedback()` - Orange toast with context feedback
- **ℹ️ INFO** - `showInfoEdgeToEdge()` - Blue toast with edge-to-edge display
- **🟣 CUSTOM** - Custom purple toast with slide animation and corner radius
- **🌈 GRADIENT** - Rainbow gradient toast with scale-up animation
- **⏳ PROGRESS** - Blue loading toast with progress indicator
- **🌙 DARK** - Dark theme toast with shadow effects

### 🎨 **Drawable Resource (4 buttons)**

- **⭐ STAR** - `showSuccessWithIcon()` - Success toast with star vector icon
- **❤️ HEART** - `showErrorWithIcon()` - Error toast with heart vector icon
- **🚀 ROCKET** - Custom rocket toast with yellow tint and orange background
- **💎 DIAMOND** - Custom diamond toast with cyan tint and purple background

### 🎯 **Position Control (8 buttons)**

- **↖️ TOP LEFT** - `showTopLeft()` - Info toast positioned at top-left corner
- **↗️ TOP RIGHT** - `showTopRight()` - Warning toast positioned at top-right corner
- **⬅️ CENTER LEFT** - `showCenterLeft()` - Success toast positioned at center-left edge
- **➡️ CENTER RIGHT** - `showCenterRight()` - Error toast positioned at center-right edge
- **↙️ BOTTOM LEFT** - `showBottomLeft()` - Success toast positioned at bottom-left corner
- **↘️ BOTTOM RIGHT** - `showBottomRight()` - Warning toast positioned at bottom-right corner
- **📍 PERCENTAGE** - `showAtPercentage()` - Info toast at 25% from left, 75% from top
- **📌 EDGE SNAP** - `showAtEdge()` - Success toast snapped to top edge

## 🤝 Contributing

We welcome contributions! Please feel free to submit a Pull Request. For major changes, please open an issue first to discuss what you would like to change.

## ⭐ Show Your Support

If you find this library helpful, please give it a ⭐ on GitHub!

## 📄 License

```
Copyright 2024 Tuhinx

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

---

**🎨 CustomToast - Making Android Toasts Beautiful Since 2024** ✨
