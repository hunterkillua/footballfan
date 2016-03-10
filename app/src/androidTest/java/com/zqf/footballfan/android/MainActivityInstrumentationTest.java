//package com.zqf.footballfan.android;
//
//import android.support.test.InstrumentationRegistry;
//import android.support.test.espresso.action.ViewActions;
//import android.support.test.rule.ActivityTestRule;
//import android.support.test.runner.AndroidJUnit4;
//import android.test.ActivityInstrumentationTestCase2;
//import android.test.suitebuilder.annotation.LargeTest;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Rule;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//
//import static android.support.test.espresso.Espresso.onView;
//import static android.support.test.espresso.action.ViewActions.click;
//import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
//import static android.support.test.espresso.action.ViewActions.typeText;
//import static android.support.test.espresso.assertion.ViewAssertions.matches;
//import static android.support.test.espresso.matcher.ViewMatchers.withId;
//import static android.support.test.espresso.matcher.ViewMatchers.withText;
//
//import com.zqf.footballfan.android.uientry.home.MainActivity;
//
//@RunWith(AndroidJUnit4.class)
//@LargeTest
//
///**
// * Created by liyan on 16/2/19.
// */
//public class MainActivityInstrumentationTest {
//
//    private static final String STRING_TO_BE_TYPED = "Peter";
//
//    @Rule
//    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<MainActivity>(
//            MainActivity.class);
//
//    @Test
//    public void sayHello(){
////        onView(withId(R.id.editText)).perform(typeText(STRING_TO_BE_TYPED), closeSoftKeyboard()); //line 1
////
////        onView(withText("Say hello!")).perform(click()); //line 2
////
////        String expectedText = "Hello, " + STRING_TO_BE_TYPED + "!";
////        onView(withId(R.id.textView)).check(matches(withText(expectedText))); //line 3
//    }
//}
