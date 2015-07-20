package com.shinav.gcmnetworkmanagerdemo.injection;

import android.content.Context;

import com.shinav.gcmnetworkmanagerdemo.injection.component.ApplicationComponent;

public class Injector {

    private static final String INJECTOR_SERVICE = "com.shinav.gcmnetworkmanagerdemo.injector";

    @SuppressWarnings("ResourceType") // Explicitly doing a custom service.
    public static ApplicationComponent obtain(Context context) {
        return (ApplicationComponent) context.getApplicationContext().getSystemService(INJECTOR_SERVICE);
    }

    public static boolean matchesService(String name) {
        return INJECTOR_SERVICE.equals(name);
    }

    private Injector() {
        throw new AssertionError("No instances.");
    }

}
