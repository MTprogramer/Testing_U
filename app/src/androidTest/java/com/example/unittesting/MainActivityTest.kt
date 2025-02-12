package com.example.unittesting

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.activityScenarioRule
import org.junit.Assert.*
import org.junit.Rule

import org.junit.Test

class MainActivityTest {

    @get:Rule
    val activityScenario = activityScenarioRule<MainActivity>()

    @Test
    fun textSubmitButton_ExpectCorrectValue() {
        onView(withId(R.id.editText1)).perform(typeText("Hello"))
        onView(withId(R.id.editText2)).perform(typeText("Coders"), closeSoftKeyboard())
        onView(withId(R.id.buttonSend)).perform(click())
        onView(withId(R.id.textViewReceived)).check(matches(withText("Hello Coders")))

    }
}