package com.assignmet;

import android.content.Intent;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;


import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.assignmet.network_utilities.EspressoIdlingResouce;
import com.assignmet.view.MainActivity;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static junit.framework.TestCase.assertTrue;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {


    @Rule
    public ActivityTestRule<MainActivity>mainActivityActivityTestRule=new ActivityTestRule<>(MainActivity.class,true,false);
    @Before
    public void init() {

        IdlingRegistry.getInstance().register(EspressoIdlingResouce.getIdlingResource());
    }

    @After
    public void unregisterIdlingResource() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResouce.getIdlingResource());
    }
    @Test
    public void recycleTest() {
        Intent intent = new Intent();
        mainActivityActivityTestRule.launchActivity(intent);
        Espresso.onView(withId(R.id.viewList)).perform(RecyclerViewActions.actionOnItemAtPosition(1,click()));
        assertTrue(mainActivityActivityTestRule.getActivity().isFinishing());

    }

}