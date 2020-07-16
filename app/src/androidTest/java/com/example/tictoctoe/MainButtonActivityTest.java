package com.example.tictoctoe;

import android.app.Activity;
import android.app.Instrumentation;

import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.junit.Assert.*;

public class MainButtonActivityTest {
        @Rule
        public ActivityTestRule<MainActivity> mButtonActivityTestRule=new ActivityTestRule<>(MainActivity.class);
        private MainActivity mActivity =null;
        Instrumentation.ActivityMonitor monitor =getInstrumentation().addMonitor(GameLaunch.class.getName(),null,false);


        @Before
        public void setUp() throws Exception {
            mActivity =mButtonActivityTestRule.getActivity();
        }
        @Test
        public void testLaunchofGameLaunchOnButtonClick()
        {
            assertNotNull(mActivity.findViewById(R.id.mainbtn_1));
            onView(withId(R.id.mainbtn_1)).perform(click());

            Activity gameLaunch = getInstrumentation().waitForMonitorWithTimeout(monitor,4000);
            assertNotNull(gameLaunch);
            gameLaunch.finish();


        }

        @After
        public void tearDown() throws   Exception {
            mActivity=null;
        }
    }
