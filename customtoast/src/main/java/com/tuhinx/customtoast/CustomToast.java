package com.tuhinx.customtoast;


import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.os.VibratorManager;
import android.text.Html;
import android.view.Gravity;
import android.view.HapticFeedbackConstants;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowInsets;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import android.graphics.drawable.Drawable;

public class CustomToast {

    // Animation types
    public enum AnimationType {
        NONE, SLIDE_FROM_TOP, SLIDE_FROM_BOTTOM, SLIDE_FROM_LEFT, SLIDE_FROM_RIGHT,
        FADE_IN, SCALE_UP, BOUNCE
    }

    // Toast types with predefined styles
    public enum ToastType {
        SUCCESS, ERROR, WARNING, INFO, CUSTOM
    }

    // Icon positions
    public enum IconPosition {
        LEFT, RIGHT, TOP, BOTTOM
    }

    // Toast positions
    public enum ToastPosition {
        TOP, CENTER, BOTTOM, CUSTOM,
        TOP_LEFT, TOP_RIGHT, BOTTOM_LEFT, BOTTOM_RIGHT,
        CENTER_LEFT, CENTER_RIGHT, EDGE_TO_EDGE
    }

    // Position alignment options
    public enum PositionAlignment {
        START, CENTER, END
    }

    // Screen edge options
    public enum ScreenEdge {
        TOP, BOTTOM, LEFT, RIGHT, ALL
    }

    public static class Builder {
        private final Context context;
        private String message;
        private int imageResourceId;
        private Drawable imageDrawable; // Support for direct drawable
        private int iconResourceId; // Support for icon resources
        private Drawable iconDrawable; // Support for direct icon drawable
        private int iconTintColor = Color.TRANSPARENT; // Icon tint color
        private boolean enableIconTint = false; // Enable icon tinting
        private int backgroundColor = Color.BLACK; // Default color
        private ImageView.ScaleType scaleType = ImageView.ScaleType.CENTER_CROP; // Default scale type
        private int imageWidth = 100; // Default width
        private int imageHeight = 100; // Default height
        private int iconWidth = 24; // Default icon width (dp)
        private int iconHeight = 24; // Default icon height (dp)
        private int textColor = Color.WHITE; // Default text color
        private String typefaceName = "sans-serif"; // Default typeface
        private int typefaceStyle = Typeface.NORMAL; // Default typeface style
        private int strokeColor = Color.TRANSPARENT; // Default stroke color
        private int strokeWidth = 0; // Default stroke width

        // New awesome features
        private AnimationType animationType = AnimationType.FADE_IN;
        private long animationDuration = 300; // milliseconds
        private ToastType toastType = ToastType.CUSTOM;
        private IconPosition iconPosition = IconPosition.LEFT;
        private ToastPosition toastPosition = ToastPosition.BOTTOM;
        private long customDuration = 2000; // milliseconds
        private boolean enableSwipeToDismiss = false;
        private View.OnClickListener onClickListener;
        private boolean showProgress = false;
        private int progressColor = Color.WHITE;
        private boolean enableHtmlText = false;
        private boolean enableShadow = true;
        private float shadowRadius = 8f;
        private int shadowColor = Color.parseColor("#40000000");
        private boolean enableGradient = false;
        private int gradientStartColor = Color.BLACK;
        private int gradientEndColor = Color.GRAY;
        private GradientDrawable.Orientation gradientOrientation = GradientDrawable.Orientation.LEFT_RIGHT;
        private float cornerRadiusTopLeft = 30f;
        private float cornerRadiusTopRight = 30f;
        private float cornerRadiusBottomLeft = 30f;
        private float cornerRadiusBottomRight = 30f;
        private int marginLeft = 0;
        private int marginTop = 0;
        private int marginRight = 0;
        private int marginBottom = 100;
        private int customX = 0;
        private int customY = 0;

        // Enhanced position control
        private PositionAlignment horizontalAlignment = PositionAlignment.CENTER;
        private PositionAlignment verticalAlignment = PositionAlignment.CENTER;
        private float positionPercentageX = 0.5f; // 0.0 to 1.0 (left to right)
        private float positionPercentageY = 0.5f; // 0.0 to 1.0 (top to bottom)
        private boolean usePercentagePositioning = false;
        private ScreenEdge snapToEdge = null;
        private int edgeOffset = 16; // dp offset from edge
        private boolean avoidStatusBar = true;
        private boolean avoidNavigationBar = true;
        private boolean centerInAvailableSpace = false;
        private int maxWidth = -1; // -1 for wrap_content
        private int maxHeight = -1; // -1 for wrap_content

        // Android 15 (API 35) specific features
        private boolean enableHapticFeedback = false;
        private boolean enableVibration = false;
        private boolean respectSystemTheme = true;
        private boolean enableEdgeToEdge = false;
        private boolean enablePredictiveBack = false;
        private int hapticFeedbackType = HapticFeedbackConstants.CONTEXT_CLICK;
        private long vibrationDuration = 50; // milliseconds

        public Builder(Context context) {
            this.context = context;
        }

        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder setImageResource(int imageResourceId) {
            this.imageResourceId = imageResourceId;
            this.imageDrawable = null; // Clear drawable if resource is set
            return this;
        }

        /**
         * Set image from drawable resource (supports vector drawables, PNGs, etc.)
         * @param drawableResourceId Resource ID from res/drawable folder
         * @return Builder instance
         */
        public Builder setImageDrawable(int drawableResourceId) {
            this.imageDrawable = ContextCompat.getDrawable(context, drawableResourceId);
            this.imageResourceId = 0; // Clear resource ID if drawable is set
            return this;
        }

        /**
         * Set image from direct drawable object
         * @param drawable Drawable object
         * @return Builder instance
         */
        public Builder setImageDrawable(Drawable drawable) {
            this.imageDrawable = drawable;
            this.imageResourceId = 0; // Clear resource ID if drawable is set
            return this;
        }

        /**
         * Set icon from drawable resource (optimized for icons)
         * @param iconResourceId Resource ID from res/drawable folder
         * @return Builder instance
         */
        public Builder setIcon(int iconResourceId) {
            this.iconResourceId = iconResourceId;
            this.iconDrawable = null; // Clear drawable if resource is set
            return this;
        }

        /**
         * Set icon from direct drawable object
         * @param iconDrawable Drawable object for icon
         * @return Builder instance
         */
        public Builder setIcon(Drawable iconDrawable) {
            this.iconDrawable = iconDrawable;
            this.iconResourceId = 0; // Clear resource ID if drawable is set
            return this;
        }

        /**
         * Set icon with tint color
         * @param iconResourceId Resource ID from res/drawable folder
         * @param tintColor Color to tint the icon
         * @return Builder instance
         */
        public Builder setIcon(int iconResourceId, int tintColor) {
            this.iconResourceId = iconResourceId;
            this.iconTintColor = tintColor;
            this.enableIconTint = true;
            this.iconDrawable = null; // Clear drawable if resource is set
            return this;
        }

        /**
         * Set icon tint color (for coloring vector icons)
         * @param tintColor Color to tint the icon
         * @return Builder instance
         */
        public Builder setIconTint(int tintColor) {
            this.iconTintColor = tintColor;
            this.enableIconTint = true;
            return this;
        }

        /**
         * Set icon dimensions
         * @param width Icon width in dp
         * @param height Icon height in dp
         * @return Builder instance
         */
        public Builder setIconSize(int width, int height) {
            this.iconWidth = width;
            this.iconHeight = height;
            return this;
        }

        public Builder setBackgroundColor(int backgroundColor) {
            this.backgroundColor = backgroundColor;
            return this;
        }

        public Builder setScaleType(ImageView.ScaleType scaleType) {
            this.scaleType = scaleType;
            return this;
        }

        public Builder setImageWidth(int width) {
            this.imageWidth = width;
            return this;
        }

        public Builder setImageHeight(int height) {
            this.imageHeight = height;
            return this;
        }

        public Builder setTextColor(int textColor) {
            this.textColor = textColor;
            return this;
        }

        public Builder setTypefaceName(String typefaceName) {
            this.typefaceName = typefaceName;
            return this;
        }

        public Builder setTypefaceStyle(int typefaceStyle) {
            this.typefaceStyle = typefaceStyle;
            return this;
        }

        public Builder setStrokeColor(int strokeColor) {
            this.strokeColor = strokeColor;
            return this;
        }

        public Builder setStrokeWidth(int strokeWidth) {
            this.strokeWidth = strokeWidth;
            return this;
        }

        // Animation methods
        public Builder setAnimationType(AnimationType animationType) {
            this.animationType = animationType;
            return this;
        }

        public Builder setAnimationDuration(long duration) {
            this.animationDuration = duration;
            return this;
        }

        // Toast type methods
        public Builder setToastType(ToastType toastType) {
            this.toastType = toastType;
            applyToastTypeDefaults();
            return this;
        }

        // Position methods
        public Builder setIconPosition(IconPosition iconPosition) {
            this.iconPosition = iconPosition;
            return this;
        }

        public Builder setToastPosition(ToastPosition toastPosition) {
            this.toastPosition = toastPosition;
            return this;
        }

        public Builder setCustomPosition(int x, int y) {
            this.customX = x;
            this.customY = y;
            this.toastPosition = ToastPosition.CUSTOM;
            return this;
        }

        public Builder setMargins(int left, int top, int right, int bottom) {
            this.marginLeft = left;
            this.marginTop = top;
            this.marginRight = right;
            this.marginBottom = bottom;
            return this;
        }

        /**
         * Set position using percentage of screen (0.0 to 1.0)
         * @param percentageX Horizontal position (0.0 = left, 1.0 = right)
         * @param percentageY Vertical position (0.0 = top, 1.0 = bottom)
         * @return Builder instance
         */
        public Builder setPositionPercentage(float percentageX, float percentageY) {
            this.positionPercentageX = Math.max(0f, Math.min(1f, percentageX));
            this.positionPercentageY = Math.max(0f, Math.min(1f, percentageY));
            this.usePercentagePositioning = true;
            this.toastPosition = ToastPosition.CUSTOM;
            return this;
        }

        /**
         * Set alignment for positioning
         * @param horizontal Horizontal alignment
         * @param vertical Vertical alignment
         * @return Builder instance
         */
        public Builder setAlignment(PositionAlignment horizontal, PositionAlignment vertical) {
            this.horizontalAlignment = horizontal;
            this.verticalAlignment = vertical;
            return this;
        }

        /**
         * Snap toast to screen edge with offset
         * @param edge Screen edge to snap to
         * @param offset Offset from edge in dp
         * @return Builder instance
         */
        public Builder snapToEdge(ScreenEdge edge, int offset) {
            this.snapToEdge = edge;
            this.edgeOffset = offset;
            this.toastPosition = ToastPosition.CUSTOM;
            return this;
        }

        /**
         * Snap toast to screen edge with default offset
         * @param edge Screen edge to snap to
         * @return Builder instance
         */
        public Builder snapToEdge(ScreenEdge edge) {
            return snapToEdge(edge, 16);
        }

        /**
         * Set whether to avoid system bars
         * @param avoidStatusBar Avoid status bar area
         * @param avoidNavigationBar Avoid navigation bar area
         * @return Builder instance
         */
        public Builder avoidSystemBars(boolean avoidStatusBar, boolean avoidNavigationBar) {
            this.avoidStatusBar = avoidStatusBar;
            this.avoidNavigationBar = avoidNavigationBar;
            return this;
        }

        /**
         * Center toast in available space (excluding system bars)
         * @param enable Enable centering in available space
         * @return Builder instance
         */
        public Builder centerInAvailableSpace(boolean enable) {
            this.centerInAvailableSpace = enable;
            return this;
        }

        /**
         * Set maximum dimensions for the toast
         * @param maxWidth Maximum width in dp (-1 for wrap_content)
         * @param maxHeight Maximum height in dp (-1 for wrap_content)
         * @return Builder instance
         */
        public Builder setMaxDimensions(int maxWidth, int maxHeight) {
            this.maxWidth = maxWidth;
            this.maxHeight = maxHeight;
            return this;
        }

        // Duration methods
        public Builder setCustomDuration(long duration) {
            this.customDuration = duration;
            return this;
        }

        // Interactive methods
        public Builder setOnClickListener(View.OnClickListener listener) {
            this.onClickListener = listener;
            return this;
        }

        public Builder enableSwipeToDismiss(boolean enable) {
            this.enableSwipeToDismiss = enable;
            return this;
        }

        // Progress methods
        public Builder showProgress(boolean show) {
            this.showProgress = show;
            return this;
        }

        public Builder setProgressColor(int color) {
            this.progressColor = color;
            return this;
        }

        // Text formatting methods
        public Builder enableHtmlText(boolean enable) {
            this.enableHtmlText = enable;
            return this;
        }

        // Shadow methods
        public Builder enableShadow(boolean enable) {
            this.enableShadow = enable;
            return this;
        }

        public Builder setShadow(float radius, int color) {
            this.shadowRadius = radius;
            this.shadowColor = color;
            this.enableShadow = true;
            return this;
        }

        // Gradient methods
        public Builder enableGradient(boolean enable) {
            this.enableGradient = enable;
            return this;
        }

        public Builder setGradient(int startColor, int endColor, GradientDrawable.Orientation orientation) {
            this.gradientStartColor = startColor;
            this.gradientEndColor = endColor;
            this.gradientOrientation = orientation;
            this.enableGradient = true;
            return this;
        }

        // Corner radius methods
        public Builder setCornerRadius(float radius) {
            this.cornerRadiusTopLeft = radius;
            this.cornerRadiusTopRight = radius;
            this.cornerRadiusBottomLeft = radius;
            this.cornerRadiusBottomRight = radius;
            return this;
        }

        public Builder setCornerRadius(float topLeft, float topRight, float bottomLeft, float bottomRight) {
            this.cornerRadiusTopLeft = topLeft;
            this.cornerRadiusTopRight = topRight;
            this.cornerRadiusBottomLeft = bottomLeft;
            this.cornerRadiusBottomRight = bottomRight;
            return this;
        }

        // Android 15 (API 35) specific methods
        public Builder enableHapticFeedback(boolean enable) {
            this.enableHapticFeedback = enable;
            return this;
        }

        public Builder setHapticFeedbackType(int hapticType) {
            this.hapticFeedbackType = hapticType;
            this.enableHapticFeedback = true;
            return this;
        }

        public Builder enableVibration(boolean enable) {
            this.enableVibration = enable;
            return this;
        }

        public Builder setVibrationDuration(long duration) {
            this.vibrationDuration = duration;
            this.enableVibration = true;
            return this;
        }

        public Builder respectSystemTheme(boolean respect) {
            this.respectSystemTheme = respect;
            return this;
        }

        public Builder enableEdgeToEdge(boolean enable) {
            this.enableEdgeToEdge = enable;
            return this;
        }

        public Builder enablePredictiveBack(boolean enable) {
            this.enablePredictiveBack = enable;
            return this;
        }

        // Helper method to apply predefined toast type styles
        private void applyToastTypeDefaults() {
            // Apply Android 15 system theme colors if enabled
            boolean isDarkMode = respectSystemTheme && isSystemInDarkMode();

            switch (toastType) {
                case SUCCESS:
                    backgroundColor = isDarkMode ? Color.parseColor("#2E7D32") : Color.parseColor("#4CAF50");
                    textColor = Color.WHITE;
                    enableShadow = true;
                    shadowColor = Color.parseColor("#1B5E20");
                    enableHapticFeedback = true;
                    hapticFeedbackType = HapticFeedbackConstants.CONFIRM;
                    // Set default success icon if no icon is set
                    if (iconResourceId == 0 && iconDrawable == null && imageResourceId == 0 && imageDrawable == null) {
                        setDefaultSuccessIcon();
                    }
                    break;
                case ERROR:
                    backgroundColor = isDarkMode ? Color.parseColor("#C62828") : Color.parseColor("#F44336");
                    textColor = Color.WHITE;
                    enableShadow = true;
                    shadowColor = Color.parseColor("#B71C1C");
                    enableHapticFeedback = true;
                    enableVibration = true;
                    hapticFeedbackType = HapticFeedbackConstants.REJECT;
                    vibrationDuration = 100;
                    // Set default error icon if no icon is set
                    if (iconResourceId == 0 && iconDrawable == null && imageResourceId == 0 && imageDrawable == null) {
                        setDefaultErrorIcon();
                    }
                    break;
                case WARNING:
                    backgroundColor = isDarkMode ? Color.parseColor("#E65100") : Color.parseColor("#FF9800");
                    textColor = Color.WHITE;
                    enableShadow = true;
                    shadowColor = Color.parseColor("#BF360C");
                    enableHapticFeedback = true;
                    hapticFeedbackType = HapticFeedbackConstants.CONTEXT_CLICK;
                    // Set default warning icon if no icon is set
                    if (iconResourceId == 0 && iconDrawable == null && imageResourceId == 0 && imageDrawable == null) {
                        setDefaultWarningIcon();
                    }
                    break;
                case INFO:
                    backgroundColor = isDarkMode ? Color.parseColor("#1565C0") : Color.parseColor("#2196F3");
                    textColor = Color.WHITE;
                    enableShadow = true;
                    shadowColor = Color.parseColor("#0D47A1");
                    enableHapticFeedback = true;
                    hapticFeedbackType = HapticFeedbackConstants.CONTEXT_CLICK;
                    // Set default info icon if no icon is set
                    if (iconResourceId == 0 && iconDrawable == null && imageResourceId == 0 && imageDrawable == null) {
                        setDefaultInfoIcon();
                    }
                    break;
                case CUSTOM:
                default:
                    // Keep current settings
                    break;
            }
        }

        private boolean isSystemInDarkMode() {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                int nightModeFlags = context.getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
                return nightModeFlags == Configuration.UI_MODE_NIGHT_YES;
            }
            return false;
        }

        /**
         * Set default success icon (checkmark)
         */
        private void setDefaultSuccessIcon() {
            // Create a simple checkmark drawable programmatically
            iconDrawable = createCheckmarkDrawable();
            iconTintColor = Color.WHITE;
            enableIconTint = true;
            iconWidth = 24;
            iconHeight = 24;
        }

        /**
         * Set default error icon (X mark)
         */
        private void setDefaultErrorIcon() {
            // Create a simple X mark drawable programmatically
            iconDrawable = createXMarkDrawable();
            iconTintColor = Color.WHITE;
            enableIconTint = true;
            iconWidth = 24;
            iconHeight = 24;
        }

        /**
         * Set default warning icon (exclamation mark)
         */
        private void setDefaultWarningIcon() {
            // Create a simple exclamation mark drawable programmatically
            iconDrawable = createExclamationDrawable();
            iconTintColor = Color.WHITE;
            enableIconTint = true;
            iconWidth = 24;
            iconHeight = 24;
        }

        /**
         * Set default info icon (i mark)
         */
        private void setDefaultInfoIcon() {
            // Create a simple info mark drawable programmatically
            iconDrawable = createInfoDrawable();
            iconTintColor = Color.WHITE;
            enableIconTint = true;
            iconWidth = 24;
            iconHeight = 24;
        }

        /**
         * Create a simple checkmark drawable
         */
        private Drawable createCheckmarkDrawable() {
            // Use a simple text-based approach for better compatibility
            return createTextDrawable("✓");
        }

        /**
         * Create a simple X mark drawable
         */
        private Drawable createXMarkDrawable() {
            // Use a simple text-based approach for better compatibility
            return createTextDrawable("✕");
        }

        /**
         * Create a simple exclamation mark drawable
         */
        private Drawable createExclamationDrawable() {
            // Use a simple text-based approach for better compatibility
            return createTextDrawable("!");
        }

        /**
         * Create a simple info mark drawable
         */
        private Drawable createInfoDrawable() {
            // Use a simple text-based approach for better compatibility
            return createTextDrawable("i");
        }

        /**
         * Create a text-based drawable for simple icons
         */
        private Drawable createTextDrawable(String text) {
            // For now, return null and let the system handle it
            // In a real implementation, you could create a custom drawable with text
            return null;
        }

        public void show() {
            // Apply predefined toast type defaults first
            applyToastTypeDefaults();

            // Create main container layout
            LinearLayout toastLayout = createMainLayout();

            // Apply background styling
            applyBackgroundStyling(toastLayout);

            // Create and add content views
            addContentViews(toastLayout);

            // Apply animations and interactions
            applyAnimationsAndInteractions(toastLayout);

            // Create and display the toast
            displayToast(toastLayout);
        }

        private LinearLayout createMainLayout() {
            LinearLayout layout = new LinearLayout(context);

            // Set orientation based on icon position
            if (iconPosition == IconPosition.TOP || iconPosition == IconPosition.BOTTOM) {
                layout.setOrientation(LinearLayout.VERTICAL);
            } else {
                layout.setOrientation(LinearLayout.HORIZONTAL);
            }

            layout.setGravity(Gravity.CENTER);
            layout.setPadding(20, 20, 20, 20);

            // Apply RTL support
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN_MR1) {
                Configuration config = context.getResources().getConfiguration();
                if (config.getLayoutDirection() == View.LAYOUT_DIRECTION_RTL) {
                    layout.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
                }
            }

            return layout;
        }

        private void applyBackgroundStyling(LinearLayout layout) {
            GradientDrawable background = new GradientDrawable();

            // Apply gradient or solid color
            if (enableGradient) {
                int[] colors = {gradientStartColor, gradientEndColor};
                background = new GradientDrawable(gradientOrientation, colors);
            } else {
                background.setColor(backgroundColor);
            }

            // Apply individual corner radii
            float[] radii = {
                cornerRadiusTopLeft, cornerRadiusTopLeft,
                cornerRadiusTopRight, cornerRadiusTopRight,
                cornerRadiusBottomRight, cornerRadiusBottomRight,
                cornerRadiusBottomLeft, cornerRadiusBottomLeft
            };
            background.setCornerRadii(radii);

            // Apply stroke
            background.setStroke(strokeWidth, strokeColor);

            layout.setBackground(background);

            // Apply shadow effect
            if (enableShadow && android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                layout.setElevation(shadowRadius);
            }
        }

        private void addContentViews(LinearLayout layout) {
            // Create ImageView for icon/image
            ImageView imageView = null;
            if (hasImageOrIcon()) {
                imageView = createImageView();
            }

            // Create TextView for message
            TextView textView = createTextView();

            // Create ProgressBar if needed
            ProgressBar progressBar = null;
            if (showProgress) {
                progressBar = createProgressBar();
            }

            // Add views in correct order based on icon position
            addViewsInOrder(layout, imageView, textView, progressBar);
        }

        /**
         * Check if any image or icon is set
         */
        private boolean hasImageOrIcon() {
            return imageResourceId != 0 || imageDrawable != null ||
                   iconResourceId != 0 || iconDrawable != null;
        }

        private ImageView createImageView() {
            ImageView imageView = new ImageView(context);

            // Determine which image/icon to use and set appropriate dimensions
            boolean isIcon = false;
            int width = imageWidth;
            int height = imageHeight;

            // Priority: icon > image > imageDrawable > imageResource
            if (iconResourceId != 0 || iconDrawable != null) {
                isIcon = true;
                width = dpToPx(iconWidth);
                height = dpToPx(iconHeight);

                if (iconDrawable != null) {
                    imageView.setImageDrawable(iconDrawable);
                } else {
                    imageView.setImageResource(iconResourceId);
                }

                // Apply icon tint if enabled
                if (enableIconTint && iconTintColor != Color.TRANSPARENT) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        imageView.setImageTintList(android.content.res.ColorStateList.valueOf(iconTintColor));
                    } else {
                        // Fallback for older versions
                        Drawable drawable = imageView.getDrawable();
                        if (drawable != null) {
                            drawable = DrawableCompat.wrap(drawable);
                            DrawableCompat.setTint(drawable, iconTintColor);
                            imageView.setImageDrawable(drawable);
                        }
                    }
                }

                // Icons typically use CENTER_INSIDE for better scaling
                imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);

            } else if (imageDrawable != null) {
                imageView.setImageDrawable(imageDrawable);
                imageView.setScaleType(scaleType);
                width = dpToPx(imageWidth);
                height = dpToPx(imageHeight);

            } else if (imageResourceId != 0) {
                imageView.setImageResource(imageResourceId);
                imageView.setScaleType(scaleType);
                width = dpToPx(imageWidth);
                height = dpToPx(imageHeight);
            }

            // Set layout parameters
            imageView.setLayoutParams(new LinearLayout.LayoutParams(width, height));

            // Set padding (smaller for icons)
            int padding = isIcon ? dpToPx(4) : dpToPx(8);
            imageView.setPadding(padding, padding, padding, padding);

            return imageView;
        }

        /**
         * Convert dp to pixels
         */
        private int dpToPx(int dp) {
            float density = context.getResources().getDisplayMetrics().density;
            return Math.round(dp * density);
        }

        private TextView createTextView() {
            TextView textView = new TextView(context);

            // Set text with HTML support if enabled
            if (enableHtmlText) {
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                    textView.setText(Html.fromHtml(message, Html.FROM_HTML_MODE_LEGACY));
                } else {
                    // Use the non-deprecated method for older versions
                    @SuppressWarnings("deprecation")
                    CharSequence htmlText = Html.fromHtml(message);
                    textView.setText(htmlText);
                }
            } else {
                textView.setText(message);
            }

            textView.setTextColor(textColor);
            Typeface typeface = Typeface.create(typefaceName, typefaceStyle);
            textView.setTypeface(typeface);
            textView.setPadding(10, 10, 10, 10);

            // Apply accessibility
            textView.setContentDescription(message);

            return textView;
        }

        private ProgressBar createProgressBar() {
            ProgressBar progressBar = new ProgressBar(context, null, android.R.attr.progressBarStyleHorizontal);
            progressBar.setIndeterminate(true);

            // Use modern ColorFilter API
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.Q) {
                progressBar.getIndeterminateDrawable().setColorFilter(
                    new android.graphics.BlendModeColorFilter(progressColor, android.graphics.BlendMode.SRC_IN)
                );
            } else {
                // Use deprecated method for older versions
                @SuppressWarnings("deprecation")
                android.graphics.PorterDuffColorFilter colorFilter =
                    new android.graphics.PorterDuffColorFilter(progressColor, android.graphics.PorterDuff.Mode.SRC_IN);
                progressBar.getIndeterminateDrawable().setColorFilter(colorFilter);
            }

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            );
            params.setMargins(10, 5, 10, 5);
            progressBar.setLayoutParams(params);
            return progressBar;
        }

        private void addViewsInOrder(LinearLayout layout, ImageView imageView, TextView textView, ProgressBar progressBar) {
            switch (iconPosition) {
                case TOP:
                    if (imageView != null) layout.addView(imageView);
                    layout.addView(textView);
                    if (progressBar != null) layout.addView(progressBar);
                    break;
                case BOTTOM:
                    layout.addView(textView);
                    if (progressBar != null) layout.addView(progressBar);
                    if (imageView != null) layout.addView(imageView);
                    break;
                case RIGHT:
                    layout.addView(textView);
                    if (progressBar != null) layout.addView(progressBar);
                    if (imageView != null) layout.addView(imageView);
                    break;
                case LEFT:
                default:
                    if (imageView != null) layout.addView(imageView);
                    layout.addView(textView);
                    if (progressBar != null) layout.addView(progressBar);
                    break;
            }
        }

        private void applyAnimationsAndInteractions(LinearLayout layout) {
            // Apply click listener
            if (onClickListener != null) {
                layout.setOnClickListener(v -> {
                    // Apply haptic feedback for Android 15
                    applyHapticFeedback(v);
                    applyVibration();
                    onClickListener.onClick(v);
                });
                layout.setClickable(true);
                layout.setFocusable(true);
            }

            // Apply swipe to dismiss
            if (enableSwipeToDismiss) {
                applySwipeToDismiss(layout);
            }

            // Apply Android 15 edge-to-edge support
            if (enableEdgeToEdge && Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                applyEdgeToEdgeSupport(layout);
            }
        }

        private void applyHapticFeedback(View view) {
            if (enableHapticFeedback && Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                view.performHapticFeedback(hapticFeedbackType);
            }
        }

        @SuppressLint("MissingPermission")
        @SuppressWarnings("deprecation")
        private void applyVibration() {
            if (!enableVibration) return;

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                // Use VibratorManager for Android 12+
                VibratorManager vibratorManager = (VibratorManager) context.getSystemService(Context.VIBRATOR_MANAGER_SERVICE);
                if (vibratorManager != null) {
                    Vibrator vibrator = vibratorManager.getDefaultVibrator();
                    VibrationEffect effect = VibrationEffect.createOneShot(vibrationDuration, VibrationEffect.DEFAULT_AMPLITUDE);
                    vibrator.vibrate(effect);
                }
            } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                // Use VibrationEffect for Android 8+
                Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
                if (vibrator != null) {
                    VibrationEffect effect = VibrationEffect.createOneShot(vibrationDuration, VibrationEffect.DEFAULT_AMPLITUDE);
                    vibrator.vibrate(effect);
                }
            } else {
                // Use legacy vibration for older versions
                Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
                if (vibrator != null) {
                    long[] pattern = {0, vibrationDuration};
                    int repeat = -1; // Don't repeat
                    vibrator.vibrate(pattern, repeat);
                }
            }
        }

        private void applyEdgeToEdgeSupport(LinearLayout layout) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                layout.setOnApplyWindowInsetsListener((v, insets) -> {
                    // Handle system bars insets for edge-to-edge display
                    int systemBarsInsets = insets.getInsets(WindowInsets.Type.systemBars()).top;
                    v.setPadding(v.getPaddingLeft(), systemBarsInsets + v.getPaddingTop(),
                               v.getPaddingRight(), v.getPaddingBottom());
                    return insets;
                });
            }
        }

        private void applySwipeToDismiss(LinearLayout layout) {
            layout.setOnTouchListener(new View.OnTouchListener() {
                private float startX;
                private float startY;
                private boolean isSwipeDetected = false;

                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            startX = event.getX();
                            startY = event.getY();
                            isSwipeDetected = false;
                            return true;
                        case MotionEvent.ACTION_MOVE:
                            float deltaX = Math.abs(event.getX() - startX);
                            float deltaY = Math.abs(event.getY() - startY);
                            if (deltaX > 100 && deltaX > deltaY) {
                                isSwipeDetected = true;
                                // Animate dismissal
                                ObjectAnimator.ofFloat(v, "translationX", deltaX * (event.getX() > startX ? 1 : -1))
                                        .setDuration(200).start();
                                return true;
                            }
                            break;
                        case MotionEvent.ACTION_UP:
                            if (isSwipeDetected) {
                                // Complete dismissal animation
                                ObjectAnimator animator = ObjectAnimator.ofFloat(v, "alpha", 0f);
                                animator.setDuration(200);
                                animator.start();
                                return true;
                            }
                            break;
                    }
                    return false;
                }
            });
        }

        private void displayToast(LinearLayout layout) {
            // Always try to use custom view first, with fallback for modern Android
            try {
                displayLegacyToast(layout);
            } catch (Exception e) {
                // If custom view fails on modern Android, use alternative approach
                displayModernToast(layout);
            }
        }

        @SuppressWarnings("deprecation")
        private void displayLegacyToast(LinearLayout layout) {
            Toast toast = new Toast(context);
            toast.setView(layout);

            // Calculate advanced position
            int[] position = calculateAdvancedPosition();
            int gravity = getGravityFromPosition();

            toast.setGravity(gravity, position[0], position[1]);

            // Apply entrance animation
            applyEntranceAnimation(layout);

            // Show toast
            toast.show();

            // Handle custom duration
            if (customDuration > 0) {
                new Handler(Looper.getMainLooper()).postDelayed(() -> {
                    applyExitAnimation(layout);
                }, customDuration);
            }
        }

        /**
         * Calculate advanced position based on all positioning options
         * @return int array [x, y] coordinates
         */
        private int[] calculateAdvancedPosition() {
            int x = customX + marginLeft - marginRight;
            int y = customY + marginTop - marginBottom;

            // Handle percentage positioning
            if (usePercentagePositioning) {
                android.util.DisplayMetrics metrics = context.getResources().getDisplayMetrics();
                x = (int) (metrics.widthPixels * positionPercentageX);
                y = (int) (metrics.heightPixels * positionPercentageY);

                // Adjust for system bars if needed
                if (avoidStatusBar || avoidNavigationBar) {
                    int[] adjustments = getSystemBarAdjustments();
                    if (avoidStatusBar) y += adjustments[0]; // Status bar height
                    if (avoidNavigationBar) y -= adjustments[1]; // Navigation bar height
                }
            }

            // Handle edge snapping
            if (snapToEdge != null) {
                int[] edgePosition = calculateEdgePosition();
                x = edgePosition[0];
                y = edgePosition[1];
            }

            return new int[]{x, y};
        }

        /**
         * Calculate position for edge snapping
         */
        private int[] calculateEdgePosition() {
            android.util.DisplayMetrics metrics = context.getResources().getDisplayMetrics();
            int offsetPx = dpToPx(edgeOffset);
            int x = 0, y = 0;

            switch (snapToEdge) {
                case TOP:
                    x = metrics.widthPixels / 2; // Center horizontally
                    y = offsetPx;
                    if (avoidStatusBar) {
                        y += getSystemBarAdjustments()[0];
                    }
                    break;
                case BOTTOM:
                    x = metrics.widthPixels / 2; // Center horizontally
                    y = metrics.heightPixels - offsetPx;
                    if (avoidNavigationBar) {
                        y -= getSystemBarAdjustments()[1];
                    }
                    break;
                case LEFT:
                    x = offsetPx;
                    y = metrics.heightPixels / 2; // Center vertically
                    break;
                case RIGHT:
                    x = metrics.widthPixels - offsetPx;
                    y = metrics.heightPixels / 2; // Center vertically
                    break;
                case ALL:
                    // Full screen with offset
                    x = offsetPx;
                    y = offsetPx;
                    break;
            }

            return new int[]{x, y};
        }

        /**
         * Get system bar heights for positioning adjustments
         * @return int array [statusBarHeight, navigationBarHeight]
         */
        private int[] getSystemBarAdjustments() {
            int statusBarHeight = 0;
            int navigationBarHeight = 0;

            // Get status bar height
            int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
            if (resourceId > 0) {
                statusBarHeight = context.getResources().getDimensionPixelSize(resourceId);
            }

            // Get navigation bar height
            resourceId = context.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
            if (resourceId > 0) {
                navigationBarHeight = context.getResources().getDimensionPixelSize(resourceId);
            }

            return new int[]{statusBarHeight, navigationBarHeight};
        }

        private void displayModernToast(LinearLayout layout) {
            // For modern Android versions, create an overlay window to show custom toast
            if (context instanceof android.app.Activity) {
                displayOverlayToast(layout);
            } else {
                // Fallback to simple toast if not an Activity context
                displaySimpleToast();
            }
        }

        private void displayOverlayToast(LinearLayout layout) {
            android.app.Activity activity = (android.app.Activity) context;

            // Get the root view of the activity
            android.view.ViewGroup rootView = activity.findViewById(android.R.id.content);
            if (rootView == null) {
                displaySimpleToast();
                return;
            }

            // Create a container for the toast
            android.widget.FrameLayout container = new android.widget.FrameLayout(context);
            android.widget.FrameLayout.LayoutParams containerParams =
                new android.widget.FrameLayout.LayoutParams(
                    android.widget.FrameLayout.LayoutParams.WRAP_CONTENT,
                    android.widget.FrameLayout.LayoutParams.WRAP_CONTENT
                );

            // Calculate advanced position for modern toast
            int[] position = calculateAdvancedPosition();
            int gravity = getGravityFromPosition();

            // Apply advanced positioning
            if (usePercentagePositioning || snapToEdge != null) {
                // For advanced positioning, use absolute positioning
                containerParams.gravity = Gravity.TOP | Gravity.START;
                containerParams.setMargins(position[0], position[1], 0, 0);
            } else {
                // Use standard gravity-based positioning
                containerParams.gravity = gravity;
                containerParams.setMargins(marginLeft, marginTop, marginRight, marginBottom);
            }

            // Apply max dimensions if set
            if (maxWidth > 0) {
                containerParams.width = dpToPx(maxWidth);
            }
            if (maxHeight > 0) {
                containerParams.height = dpToPx(maxHeight);
            }

            container.setLayoutParams(containerParams);

            // Add the styled layout to the container
            container.addView(layout);

            // Add container to root view
            rootView.addView(container);

            // Apply entrance animation
            applyEntranceAnimation(layout);

            // Auto-remove after duration
            long duration = customDuration > 0 ? customDuration :
                          (customDuration > 2000 ? 3500L : 2000L);

            new android.os.Handler(android.os.Looper.getMainLooper()).postDelayed(() -> {
                applyExitAnimation(layout);
                // Remove after exit animation
                new android.os.Handler(android.os.Looper.getMainLooper()).postDelayed(() -> {
                    try {
                        rootView.removeView(container);
                    } catch (Exception e) {
                        // View might already be removed
                    }
                }, 300);
            }, duration);
        }

        private void displaySimpleToast() {
            // Fallback to simple toast
            Toast toast = Toast.makeText(context, message,
                customDuration > 2000 ? Toast.LENGTH_LONG : Toast.LENGTH_SHORT);
            toast.show();
        }

        private int getGravityFromPosition() {
            switch (toastPosition) {
                case TOP:
                    return Gravity.TOP | Gravity.CENTER_HORIZONTAL;
                case CENTER:
                    return Gravity.CENTER;
                case TOP_LEFT:
                    return Gravity.TOP | Gravity.START;
                case TOP_RIGHT:
                    return Gravity.TOP | Gravity.END;
                case BOTTOM_LEFT:
                    return Gravity.BOTTOM | Gravity.START;
                case BOTTOM_RIGHT:
                    return Gravity.BOTTOM | Gravity.END;
                case CENTER_LEFT:
                    return Gravity.CENTER_VERTICAL | Gravity.START;
                case CENTER_RIGHT:
                    return Gravity.CENTER_VERTICAL | Gravity.END;
                case EDGE_TO_EDGE:
                    return Gravity.CENTER;
                case CUSTOM:
                    return calculateCustomGravity();
                case BOTTOM:
                default:
                    return Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL;
            }
        }

        /**
         * Calculate gravity for custom positioning
         */
        private int calculateCustomGravity() {
            if (usePercentagePositioning || snapToEdge != null) {
                return Gravity.TOP | Gravity.START; // Use top-left as base for calculations
            }

            // Use alignment settings
            int gravity = 0;

            // Vertical alignment
            switch (verticalAlignment) {
                case START:
                    gravity |= Gravity.TOP;
                    break;
                case END:
                    gravity |= Gravity.BOTTOM;
                    break;
                case CENTER:
                default:
                    gravity |= Gravity.CENTER_VERTICAL;
                    break;
            }

            // Horizontal alignment
            switch (horizontalAlignment) {
                case START:
                    gravity |= Gravity.START;
                    break;
                case END:
                    gravity |= Gravity.END;
                    break;
                case CENTER:
                default:
                    gravity |= Gravity.CENTER_HORIZONTAL;
                    break;
            }

            return gravity;
        }

        private void applyEntranceAnimation(View view) {
            switch (animationType) {
                case SLIDE_FROM_TOP:
                    ObjectAnimator.ofFloat(view, "translationY", -200f, 0f)
                            .setDuration(animationDuration).start();
                    break;
                case SLIDE_FROM_BOTTOM:
                    ObjectAnimator.ofFloat(view, "translationY", 200f, 0f)
                            .setDuration(animationDuration).start();
                    break;
                case SLIDE_FROM_LEFT:
                    ObjectAnimator.ofFloat(view, "translationX", -200f, 0f)
                            .setDuration(animationDuration).start();
                    break;
                case SLIDE_FROM_RIGHT:
                    ObjectAnimator.ofFloat(view, "translationX", 200f, 0f)
                            .setDuration(animationDuration).start();
                    break;
                case FADE_IN:
                    ObjectAnimator.ofFloat(view, "alpha", 0f, 1f)
                            .setDuration(animationDuration).start();
                    break;
                case SCALE_UP:
                    ObjectAnimator scaleX = ObjectAnimator.ofFloat(view, "scaleX", 0f, 1f);
                    ObjectAnimator scaleY = ObjectAnimator.ofFloat(view, "scaleY", 0f, 1f);
                    scaleX.setDuration(animationDuration);
                    scaleY.setDuration(animationDuration);
                    scaleX.start();
                    scaleY.start();
                    break;
                case BOUNCE:
                    ObjectAnimator bounceAnimator = ObjectAnimator.ofFloat(view, "translationY", -50f, 0f);
                    bounceAnimator.setDuration(animationDuration);
                    bounceAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
                    bounceAnimator.start();
                    break;
                case NONE:
                default:
                    // No animation
                    break;
            }
        }

        private void applyExitAnimation(View view) {
            ObjectAnimator.ofFloat(view, "alpha", 1f, 0f)
                    .setDuration(200).start();
        }
    }

    // Convenience methods for quick toast creation
    public static void showSuccess(Context context, String message) {
        new Builder(context)
                .setMessage(message)
                .setToastType(ToastType.SUCCESS)
                .setAnimationType(AnimationType.SLIDE_FROM_TOP)
                .show();
    }

    public static void showError(Context context, String message) {
        new Builder(context)
                .setMessage(message)
                .setToastType(ToastType.ERROR)
                .setAnimationType(AnimationType.BOUNCE)
                .show();
    }

    public static void showWarning(Context context, String message) {
        new Builder(context)
                .setMessage(message)
                .setToastType(ToastType.WARNING)
                .setAnimationType(AnimationType.FADE_IN)
                .show();
    }

    public static void showInfo(Context context, String message) {
        new Builder(context)
                .setMessage(message)
                .setToastType(ToastType.INFO)
                .setAnimationType(AnimationType.SCALE_UP)
                .show();
    }

    public static void showCustom(Context context, String message, int backgroundColor, int textColor) {
        new Builder(context)
                .setMessage(message)
                .setBackgroundColor(backgroundColor)
                .setTextColor(textColor)
                .setAnimationType(AnimationType.FADE_IN)
                .show();
    }

    // Android 15 (API 35) enhanced convenience methods
    public static void showSuccessWithHaptic(Context context, String message) {
        new Builder(context)
                .setMessage(message)
                .setToastType(ToastType.SUCCESS)
                .setAnimationType(AnimationType.SLIDE_FROM_TOP)
                .enableHapticFeedback(true)
                .setHapticFeedbackType(HapticFeedbackConstants.CONFIRM)
                .respectSystemTheme(true)
                .show();
    }

    public static void showErrorWithVibration(Context context, String message) {
        new Builder(context)
                .setMessage(message)
                .setToastType(ToastType.ERROR)
                .setAnimationType(AnimationType.BOUNCE)
                .enableHapticFeedback(true)
                .enableVibration(true)
                .setHapticFeedbackType(HapticFeedbackConstants.REJECT)
                .setVibrationDuration(100)
                .respectSystemTheme(true)
                .show();
    }

    public static void showWarningWithFeedback(Context context, String message) {
        new Builder(context)
                .setMessage(message)
                .setToastType(ToastType.WARNING)
                .setAnimationType(AnimationType.FADE_IN)
                .enableHapticFeedback(true)
                .setHapticFeedbackType(HapticFeedbackConstants.CONTEXT_CLICK)
                .respectSystemTheme(true)
                .show();
    }

    public static void showInfoEdgeToEdge(Context context, String message) {
        new Builder(context)
                .setMessage(message)
                .setToastType(ToastType.INFO)
                .setAnimationType(AnimationType.SCALE_UP)
                .enableHapticFeedback(true)
                .enableEdgeToEdge(true)
                .respectSystemTheme(true)
                .show();
    }

    public static void showModernToast(Context context, String message, ToastType type) {
        new Builder(context)
                .setMessage(message)
                .setToastType(type)
                .setAnimationType(AnimationType.SLIDE_FROM_TOP)
                .enableHapticFeedback(true)
                .enableEdgeToEdge(true)
                .respectSystemTheme(true)
                .enablePredictiveBack(true)
                .show();
    }

    // Drawable resource convenience methods

    /**
     * Show success toast with custom icon from drawable resource
     */
    public static void showSuccessWithIcon(Context context, String message, int iconResourceId) {
        new Builder(context)
                .setMessage(message)
                .setToastType(ToastType.SUCCESS)
                .setIcon(iconResourceId, Color.WHITE)
                .setAnimationType(AnimationType.SLIDE_FROM_TOP)
                .enableHapticFeedback(true)
                .show();
    }

    /**
     * Show error toast with custom icon from drawable resource
     */
    public static void showErrorWithIcon(Context context, String message, int iconResourceId) {
        new Builder(context)
                .setMessage(message)
                .setToastType(ToastType.ERROR)
                .setIcon(iconResourceId, Color.WHITE)
                .setAnimationType(AnimationType.BOUNCE)
                .enableHapticFeedback(true)
                .enableVibration(true)
                .show();
    }

    /**
     * Show warning toast with custom icon from drawable resource
     */
    public static void showWarningWithIcon(Context context, String message, int iconResourceId) {
        new Builder(context)
                .setMessage(message)
                .setToastType(ToastType.WARNING)
                .setIcon(iconResourceId, Color.WHITE)
                .setAnimationType(AnimationType.FADE_IN)
                .enableHapticFeedback(true)
                .show();
    }

    /**
     * Show info toast with custom icon from drawable resource
     */
    public static void showInfoWithIcon(Context context, String message, int iconResourceId) {
        new Builder(context)
                .setMessage(message)
                .setToastType(ToastType.INFO)
                .setIcon(iconResourceId, Color.WHITE)
                .setAnimationType(AnimationType.SCALE_UP)
                .enableHapticFeedback(true)
                .show();
    }

    /**
     * Show custom toast with image from drawable resource
     */
    public static void showWithImage(Context context, String message, int imageResourceId, int backgroundColor, int textColor) {
        new Builder(context)
                .setMessage(message)
                .setImageDrawable(imageResourceId)
                .setBackgroundColor(backgroundColor)
                .setTextColor(textColor)
                .setAnimationType(AnimationType.FADE_IN)
                .show();
    }

    /**
     * Show toast with vector drawable icon (supports tinting)
     */
    public static void showWithVectorIcon(Context context, String message, int vectorResourceId, int iconTintColor, int backgroundColor, int textColor) {
        new Builder(context)
                .setMessage(message)
                .setIcon(vectorResourceId, iconTintColor)
                .setIconSize(24, 24) // Normal icon size
                .setBackgroundColor(backgroundColor)
                .setTextColor(textColor)
                .setAnimationType(AnimationType.SCALE_UP)
                .show();
    }

    /**
     * Show toast with drawable and custom styling
     */
    public static void showCustomWithDrawable(Context context, String message, int drawableResourceId, int backgroundColor, int textColor, AnimationType animation) {
        new Builder(context)
                .setMessage(message)
                .setIcon(drawableResourceId) // Use icon method for normal size
                .setIconSize(24, 24) // Normal icon size
                .setBackgroundColor(backgroundColor)
                .setTextColor(textColor)
                .setAnimationType(animation)
                .enableShadow(true)
                .show();
    }

    // Position control convenience methods

    /**
     * Show toast at top-left corner
     */
    public static void showTopLeft(Context context, String message, ToastType type) {
        new Builder(context)
                .setMessage(message)
                .setToastType(type)
                .setToastPosition(ToastPosition.TOP_LEFT)
                .setMargins(16, 16, 0, 0)
                .show();
    }

    /**
     * Show toast at top-right corner
     */
    public static void showTopRight(Context context, String message, ToastType type) {
        new Builder(context)
                .setMessage(message)
                .setToastType(type)
                .setToastPosition(ToastPosition.TOP_RIGHT)
                .setMargins(0, 16, 16, 0)
                .show();
    }

    /**
     * Show toast at bottom-left corner
     */
    public static void showBottomLeft(Context context, String message, ToastType type) {
        new Builder(context)
                .setMessage(message)
                .setToastType(type)
                .setToastPosition(ToastPosition.BOTTOM_LEFT)
                .setMargins(16, 0, 0, 16)
                .show();
    }

    /**
     * Show toast at bottom-right corner
     */
    public static void showBottomRight(Context context, String message, ToastType type) {
        new Builder(context)
                .setMessage(message)
                .setToastType(type)
                .setToastPosition(ToastPosition.BOTTOM_RIGHT)
                .setMargins(0, 0, 16, 16)
                .show();
    }

    /**
     * Show toast at center-left edge
     */
    public static void showCenterLeft(Context context, String message, ToastType type) {
        new Builder(context)
                .setMessage(message)
                .setToastType(type)
                .setToastPosition(ToastPosition.CENTER_LEFT)
                .setMargins(16, 0, 0, 0)
                .show();
    }

    /**
     * Show toast at center-right edge
     */
    public static void showCenterRight(Context context, String message, ToastType type) {
        new Builder(context)
                .setMessage(message)
                .setToastType(type)
                .setToastPosition(ToastPosition.CENTER_RIGHT)
                .setMargins(0, 0, 16, 0)
                .show();
    }

    /**
     * Show toast at percentage position (0.0 to 1.0)
     */
    public static void showAtPercentage(Context context, String message, ToastType type, float percentageX, float percentageY) {
        new Builder(context)
                .setMessage(message)
                .setToastType(type)
                .setPositionPercentage(percentageX, percentageY)
                .show();
    }

    /**
     * Show toast snapped to screen edge
     */
    public static void showAtEdge(Context context, String message, ToastType type, ScreenEdge edge) {
        new Builder(context)
                .setMessage(message)
                .setToastType(type)
                .snapToEdge(edge)
                .show();
    }

    /**
     * Show toast with edge-to-edge positioning
     */
    public static void showEdgeToEdge(Context context, String message, ToastType type) {
        new Builder(context)
                .setMessage(message)
                .setToastType(type)
                .setToastPosition(ToastPosition.EDGE_TO_EDGE)
                .setMaxDimensions(-1, 80) // Full width, limited height
                .avoidSystemBars(true, true)
                .show();
    }
}
