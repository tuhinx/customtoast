package com.tuhinx.customtoast.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;

import com.tuhinx.customtoast.CustomToast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setup button click listeners
        setupButtonListeners();

        // Start auto demo after 2 seconds
        new Handler().postDelayed(() -> {
            showcaseAwesomeFeatures();
            showDrawableToasts(); // Show drawable examples
        }, 2000);
    }

    private void setupButtonListeners() {
        findViewById(R.id.btnSuccess).setOnClickListener(v -> showSuccessToast());
        findViewById(R.id.btnError).setOnClickListener(v -> showErrorToast());
        findViewById(R.id.btnWarning).setOnClickListener(v -> showWarningToast());
        findViewById(R.id.btnInfo).setOnClickListener(v -> showInfoToast());
        findViewById(R.id.btnCustom).setOnClickListener(v -> showCustomToast());
        findViewById(R.id.btnGradient).setOnClickListener(v -> showGradientToast());
        findViewById(R.id.btnProgress).setOnClickListener(v -> showProgressToast());
        findViewById(R.id.btnDark).setOnClickListener(v -> showDarkToast());

        // Drawable resource buttons
        findViewById(R.id.btnStar).setOnClickListener(v -> showStarToast());
        findViewById(R.id.btnHeart).setOnClickListener(v -> showHeartToast());
        findViewById(R.id.btnRocket).setOnClickListener(v -> showRocketToast());
        findViewById(R.id.btnDiamond).setOnClickListener(v -> showDiamondToast());

        // Position control buttons
        findViewById(R.id.btnTopLeft).setOnClickListener(v -> showTopLeftToast());
        findViewById(R.id.btnTopRight).setOnClickListener(v -> showTopRightToast());
        findViewById(R.id.btnCenterLeft).setOnClickListener(v -> showCenterLeftToast());
        findViewById(R.id.btnCenterRight).setOnClickListener(v -> showCenterRightToast());
        findViewById(R.id.btnBottomLeft).setOnClickListener(v -> showBottomLeftToast());
        findViewById(R.id.btnBottomRight).setOnClickListener(v -> showBottomRightToast());
        findViewById(R.id.btnPercentage).setOnClickListener(v -> showPercentageToast());
        findViewById(R.id.btnEdgeSnap).setOnClickListener(v -> showEdgeSnapToast());
    }

    private void showSuccessToast() {
        CustomToast.showSuccessWithHaptic(this, "✅ SUCCESS - Green Toast with Haptic!");
    }

    private void showErrorToast() {
        CustomToast.showErrorWithVibration(this, "❌ ERROR - Red Toast with Vibration!");
    }

    private void showWarningToast() {
        CustomToast.showWarningWithFeedback(this, "⚠️ WARNING - Orange Toast with Feedback!");
    }

    private void showInfoToast() {
        CustomToast.showInfoEdgeToEdge(this, "ℹ️ INFO - Blue Toast with Edge-to-Edge!");
    }

    private void showCustomToast() {
        new CustomToast.Builder(this)
                .setMessage("🟣 CUSTOM - Purple Toast!")
                .setBackgroundColor(Color.parseColor("#9C27B0"))
                .setTextColor(Color.WHITE)
                .setAnimationType(CustomToast.AnimationType.SLIDE_FROM_LEFT)
                .setCornerRadius(25f)
                .setCustomDuration(3000)
                .show();
    }

    private void showGradientToast() {
        new CustomToast.Builder(this)
                .setMessage("🌈 GRADIENT - Rainbow Toast!")
                .setTextColor(Color.WHITE)
                .enableGradient(true)
                .setGradient(Color.parseColor("#FF6B6B"), Color.parseColor("#4ECDC4"),
                           GradientDrawable.Orientation.LEFT_RIGHT)
                .setAnimationType(CustomToast.AnimationType.SCALE_UP)
                .setCornerRadius(30f)
                .setCustomDuration(3000)
                .show();
    }

    private void showProgressToast() {
        new CustomToast.Builder(this)
                .setMessage("⏳ PROGRESS - Blue Loading Toast!")
                .setBackgroundColor(Color.parseColor("#2196F3"))
                .setTextColor(Color.WHITE)
                .showProgress(true)
                .setProgressColor(Color.WHITE)
                .setAnimationType(CustomToast.AnimationType.FADE_IN)
                .setCustomDuration(3000)
                .show();
    }

    private void showDarkToast() {
        new CustomToast.Builder(this)
                .setMessage("🌙 DARK - Dark Theme Toast!")
                .setBackgroundColor(Color.parseColor("#212121"))
                .setTextColor(Color.parseColor("#E0E0E0"))
                .setAnimationType(CustomToast.AnimationType.BOUNCE)
                .setCornerRadius(20f)
                .enableShadow(true)
                .setCustomDuration(3000)
                .show();
    }

    // New methods to showcase drawable resource support
    private void showDrawableToasts() {
        // Show toasts with drawable resources after a delay
        new Handler().postDelayed(() -> {
            showStarToast();
        }, 32000);

        new Handler().postDelayed(() -> {
            showHeartToast();
        }, 36000);

        new Handler().postDelayed(() -> {
            showRocketToast();
        }, 40000);

        new Handler().postDelayed(() -> {
            showDiamondToast();
        }, 44000);
    }

    private void showStarToast() {
        CustomToast.showSuccessWithIcon(this, "⭐ SUCCESS with Star Icon!", R.drawable.ic_star);
    }

    private void showHeartToast() {
        CustomToast.showErrorWithIcon(this, "❤️ ERROR with Heart Icon!", R.drawable.ic_heart);
    }

    private void showRocketToast() {
        new CustomToast.Builder(this)
                .setMessage("🚀 ROCKET Vector Icon!")
                .setIcon(R.drawable.ic_rocket, Color.YELLOW)
                .setIconSize(24, 24) // Normal icon size
                .setBackgroundColor(Color.parseColor("#FF5722"))
                .setTextColor(Color.WHITE)
                .setAnimationType(CustomToast.AnimationType.SLIDE_FROM_LEFT)
                .setCornerRadius(20f)
                .enableShadow(true)
                .setCustomDuration(3000)
                .show();
    }

    private void showDiamondToast() {
        new CustomToast.Builder(this)
                .setMessage("💎 DIAMOND with Custom Drawable!")
                .setIcon(R.drawable.ic_diamond, Color.CYAN)
                .setIconSize(24, 24) // Normal icon size
                .setBackgroundColor(Color.parseColor("#9C27B0"))
                .setTextColor(Color.WHITE)
                .setAnimationType(CustomToast.AnimationType.SCALE_UP)
                .setCornerRadius(25f)
                .enableShadow(true)
                .setCustomDuration(3000)
                .show();
    }

    // Position control demo methods
    private void showTopLeftToast() {
        CustomToast.showTopLeft(this, "↖️ TOP LEFT Position!", CustomToast.ToastType.INFO);
    }

    private void showTopRightToast() {
        CustomToast.showTopRight(this, "↗️ TOP RIGHT Position!", CustomToast.ToastType.WARNING);
    }

    private void showCenterLeftToast() {
        CustomToast.showCenterLeft(this, "⬅️ CENTER LEFT Position!", CustomToast.ToastType.SUCCESS);
    }

    private void showCenterRightToast() {
        CustomToast.showCenterRight(this, "➡️ CENTER RIGHT Position!", CustomToast.ToastType.ERROR);
    }

    private void showBottomLeftToast() {
        CustomToast.showBottomLeft(this, "↙️ BOTTOM LEFT Position!", CustomToast.ToastType.SUCCESS);
    }

    private void showBottomRightToast() {
        CustomToast.showBottomRight(this, "↘️ BOTTOM RIGHT Position!", CustomToast.ToastType.WARNING);
    }

    private void showPercentageToast() {
        CustomToast.showAtPercentage(this, "📍 25%, 75% Position!",
            CustomToast.ToastType.INFO, 0.25f, 0.75f);
    }

    private void showEdgeSnapToast() {
        CustomToast.showAtEdge(this, "📌 Snapped to TOP Edge!",
            CustomToast.ToastType.SUCCESS, CustomToast.ScreenEdge.TOP);
    }

    private void showcaseAwesomeFeatures() {
        // Show toasts with longer delays so you can see each color clearly

        // 1. Android 15 Success Toast with haptic feedback (GREEN)
        CustomToast.showSuccessWithHaptic(this, "✅ SUCCESS - Green Toast with Haptic!");

        // 2. Android 15 Error Toast with vibration (RED) - 4 second delay
        new Handler().postDelayed(() -> {
            CustomToast.showErrorWithVibration(this, "❌ ERROR - Red Toast with Vibration!");
        }, 4000);

        // 3. Android 15 Warning Toast with feedback (ORANGE) - 8 second delay
        new Handler().postDelayed(() -> {
            CustomToast.showWarningWithFeedback(this, "⚠️ WARNING - Orange Toast with Feedback!");
        }, 8000);

        // 4. Android 15 Info Toast with edge-to-edge (BLUE) - 12 second delay
        new Handler().postDelayed(() -> {
            CustomToast.showInfoEdgeToEdge(this, "ℹ️ INFO - Blue Toast with Edge-to-Edge!");
        }, 12000);

        // 5. Custom Purple Toast - 16 second delay
        new Handler().postDelayed(() -> {
            new CustomToast.Builder(this)
                    .setMessage("🟣 CUSTOM - Purple Toast!")
                    .setBackgroundColor(Color.parseColor("#9C27B0"))
                    .setTextColor(Color.WHITE)
                    .setAnimationType(CustomToast.AnimationType.SLIDE_FROM_LEFT)
                    .setCornerRadius(25f)
                    .setCustomDuration(3000)
                    .show();
        }, 16000);

        // 6. Gradient Toast (RAINBOW) - 20 second delay
        new Handler().postDelayed(() -> {
            new CustomToast.Builder(this)
                    .setMessage("🌈 GRADIENT - Rainbow Toast!")
                    .setTextColor(Color.WHITE)
                    .enableGradient(true)
                    .setGradient(Color.parseColor("#FF6B6B"), Color.parseColor("#4ECDC4"),
                               GradientDrawable.Orientation.LEFT_RIGHT)
                    .setAnimationType(CustomToast.AnimationType.SCALE_UP)
                    .setCornerRadius(30f)
                    .setCustomDuration(3000)
                    .show();
        }, 20000);

        // 7. Progress Toast (BLUE) - 24 second delay
        new Handler().postDelayed(() -> {
            new CustomToast.Builder(this)
                    .setMessage("⏳ PROGRESS - Blue Loading Toast!")
                    .setBackgroundColor(Color.parseColor("#2196F3"))
                    .setTextColor(Color.WHITE)
                    .showProgress(true)
                    .setProgressColor(Color.WHITE)
                    .setAnimationType(CustomToast.AnimationType.FADE_IN)
                    .setCustomDuration(3000)
                    .show();
        }, 24000);

        // 8. Dark Theme Toast (DARK) - 28 second delay
        new Handler().postDelayed(() -> {
            new CustomToast.Builder(this)
                    .setMessage("🌙 DARK - Dark Theme Toast!")
                    .setBackgroundColor(Color.parseColor("#212121"))
                    .setTextColor(Color.parseColor("#E0E0E0"))
                    .setAnimationType(CustomToast.AnimationType.BOUNCE)
                    .setCornerRadius(20f)
                    .enableShadow(true)
                    .setCustomDuration(3000)
                    .show();
        }, 28000);
    }
}