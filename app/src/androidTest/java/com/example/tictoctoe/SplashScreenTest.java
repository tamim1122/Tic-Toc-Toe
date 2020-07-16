package com.example.tictoctoe;

import android.view.View;

import androidx.test.espresso.ViewAction;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class SplashScreenTest {
    @Rule
    public ActivityTestRule<SplashScreen> sActivityTestRule =new ActivityTestRule<SplashScreen>(SplashScreen.class);
    private  SplashScreen sActivity =null;


    @Before
    public void setUp() {
        sActivity = sActivityTestRule.getActivity();
    }
    @Test
    public void testLaunch()
    {

        View view=sActivity.findViewById(R.id.allsplashscreen);
        assertNotNull(view);
    }

    @After
    public void tearDown() {
        sActivity =null;
    }


}

