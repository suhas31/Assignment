package com.assignmet.network_utilities;

import androidx.test.espresso.IdlingResource;
import androidx.test.espresso.idling.CountingIdlingResource;

public class EspressoIdlingResouce {

    private static final String RESOURCE = "GLOBAL";

    private static CountingIdlingResource mCountingIdlingResource =
            new CountingIdlingResource(RESOURCE);

    public static void increment() {
        mCountingIdlingResource.increment();
    }

    public static void decrement() {
        mCountingIdlingResource.decrement();
    }

    public static IdlingResource getIdlingResource() {
        return mCountingIdlingResource;
    }
}
