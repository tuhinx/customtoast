package com.tuhinx.customtoast;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit tests for CustomToast awesome features
 */
public class CustomToastTest {

    @Test
    public void testBuilderPatternExists() {
        // Test that CustomToast class and Builder exist
        assertNotNull(CustomToast.class);
        assertNotNull(CustomToast.Builder.class);
    }

    @Test
    public void testAnimationTypes() {
        // Test all animation types are available
        CustomToast.AnimationType[] types = CustomToast.AnimationType.values();
        assertEquals(8, types.length);

        assertTrue(containsAnimationType(types, CustomToast.AnimationType.NONE));
        assertTrue(containsAnimationType(types, CustomToast.AnimationType.SLIDE_FROM_TOP));
        assertTrue(containsAnimationType(types, CustomToast.AnimationType.SLIDE_FROM_BOTTOM));
        assertTrue(containsAnimationType(types, CustomToast.AnimationType.SLIDE_FROM_LEFT));
        assertTrue(containsAnimationType(types, CustomToast.AnimationType.SLIDE_FROM_RIGHT));
        assertTrue(containsAnimationType(types, CustomToast.AnimationType.FADE_IN));
        assertTrue(containsAnimationType(types, CustomToast.AnimationType.SCALE_UP));
        assertTrue(containsAnimationType(types, CustomToast.AnimationType.BOUNCE));
    }

    @Test
    public void testToastTypes() {
        // Test all toast types are available
        CustomToast.ToastType[] types = CustomToast.ToastType.values();
        assertEquals(5, types.length);

        assertTrue(containsToastType(types, CustomToast.ToastType.SUCCESS));
        assertTrue(containsToastType(types, CustomToast.ToastType.ERROR));
        assertTrue(containsToastType(types, CustomToast.ToastType.WARNING));
        assertTrue(containsToastType(types, CustomToast.ToastType.INFO));
        assertTrue(containsToastType(types, CustomToast.ToastType.CUSTOM));
    }

    @Test
    public void testIconPositions() {
        // Test all icon positions are available
        CustomToast.IconPosition[] positions = CustomToast.IconPosition.values();
        assertEquals(4, positions.length);

        assertTrue(containsIconPosition(positions, CustomToast.IconPosition.LEFT));
        assertTrue(containsIconPosition(positions, CustomToast.IconPosition.RIGHT));
        assertTrue(containsIconPosition(positions, CustomToast.IconPosition.TOP));
        assertTrue(containsIconPosition(positions, CustomToast.IconPosition.BOTTOM));
    }

    @Test
    public void testToastPositions() {
        // Test all toast positions are available
        CustomToast.ToastPosition[] positions = CustomToast.ToastPosition.values();
        assertEquals(4, positions.length);

        assertTrue(containsToastPosition(positions, CustomToast.ToastPosition.TOP));
        assertTrue(containsToastPosition(positions, CustomToast.ToastPosition.CENTER));
        assertTrue(containsToastPosition(positions, CustomToast.ToastPosition.BOTTOM));
        assertTrue(containsToastPosition(positions, CustomToast.ToastPosition.CUSTOM));
    }

    // Helper methods
    private boolean containsAnimationType(CustomToast.AnimationType[] types, CustomToast.AnimationType target) {
        for (CustomToast.AnimationType type : types) {
            if (type == target) return true;
        }
        return false;
    }

    private boolean containsToastType(CustomToast.ToastType[] types, CustomToast.ToastType target) {
        for (CustomToast.ToastType type : types) {
            if (type == target) return true;
        }
        return false;
    }

    private boolean containsIconPosition(CustomToast.IconPosition[] positions, CustomToast.IconPosition target) {
        for (CustomToast.IconPosition position : positions) {
            if (position == target) return true;
        }
        return false;
    }

    private boolean containsToastPosition(CustomToast.ToastPosition[] positions, CustomToast.ToastPosition target) {
        for (CustomToast.ToastPosition position : positions) {
            if (position == target) return true;
        }
        return false;
    }
}
