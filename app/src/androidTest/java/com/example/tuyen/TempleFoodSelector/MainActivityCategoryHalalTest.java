package com.example.tuyen.TempleFoodSelector;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityCategoryHalalTest {

    //UI interactions and assertions on View elements. UI interactions include tap and type actions that a person
    // may use to interact with your app. Assertions verify the existence or contents of visual elements on the screen
    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void mainActivityCategoryHalalTest() {
        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.choose), withText("Categories"),
                        withParent(withId(R.id.content_main)),
                        isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.Halal), withText("Halal"),
                        withParent(allOf(withId(R.id.activity_choosing_category),
                                withParent(withId(android.R.id.content)))),
                        isDisplayed()));
        appCompatButton2.perform(click());

        ViewInteraction appCompatButton3 = onView(
                allOf(withId(R.id.maps), withText("Maps"),
                        withParent(withId(R.id.content_yolo2)),
                        isDisplayed()));
        appCompatButton3.perform(click());

    }

}
