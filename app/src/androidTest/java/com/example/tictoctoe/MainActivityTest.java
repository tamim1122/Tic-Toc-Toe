package com.example.tictoctoe;

import android.app.Activity;
import android.app.Instrumentation;
import android.view.View;

import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.junit.Assert.assertNotNull;

public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);
    private  MainActivity mActivity =null;

    @Before
    public void setUp() {
        mActivity= mActivityTestRule.getActivity();
    }
    @Test
    public void teslaunch()
    {
        View view=mActivity.findViewById(R.id.mainbtn_1);
        View view1=mActivity.findViewById(R.id.mainbtn_2);
                assertNotNull(view);
    }

    @After
    public void tearDown() {
            mActivity =null;
    }

}
