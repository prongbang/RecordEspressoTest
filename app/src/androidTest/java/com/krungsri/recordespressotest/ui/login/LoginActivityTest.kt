package com.krungsri.recordespressotest.ui.login


import androidx.test.espresso.DataInteraction
import androidx.test.espresso.ViewInteraction
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent

import androidx.test.InstrumentationRegistry.getInstrumentation
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*

import com.krungsri.recordespressotest.R

import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher
import org.hamcrest.core.IsInstanceOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.anything
import org.hamcrest.Matchers.`is`

@LargeTest
@RunWith(AndroidJUnit4::class)
class LoginActivityTest {

	@Rule
	@JvmField
	var mActivityTestRule = ActivityTestRule(LoginActivity::class.java)

	@Test
	fun loginActivityTest() {
		val appCompatEditText = onView(
				allOf(withId(R.id.username),
						childAtPosition(
								allOf(withId(R.id.container),
										childAtPosition(
												withId(android.R.id.content),
												0)),
								0),
						isDisplayed()))
		appCompatEditText.perform(click())

		val appCompatEditText2 = onView(
				allOf(withId(R.id.username),
						childAtPosition(
								allOf(withId(R.id.container),
										childAtPosition(
												withId(android.R.id.content),
												0)),
								0),
						isDisplayed()))
		appCompatEditText2.perform(replaceText("aaaaaa"), closeSoftKeyboard())

		val appCompatEditText3 = onView(
				allOf(withId(R.id.username), withText("aaaaaa"),
						childAtPosition(
								allOf(withId(R.id.container),
										childAtPosition(
												withId(android.R.id.content),
												0)),
								0),
						isDisplayed()))
		appCompatEditText3.perform(pressImeActionButton())

		val appCompatEditText4 = onView(
				allOf(withId(R.id.password),
						childAtPosition(
								allOf(withId(R.id.container),
										childAtPosition(
												withId(android.R.id.content),
												0)),
								1),
						isDisplayed()))
		appCompatEditText4.perform(replaceText("123456"), closeSoftKeyboard())

		val materialButton = onView(
				allOf(withId(R.id.login), withText("Sign in or register"),
						childAtPosition(
								allOf(withId(R.id.container),
										childAtPosition(
												withId(android.R.id.content),
												0)),
								2),
						isDisplayed()))
		materialButton.perform(click())
	}

	private fun childAtPosition(
			parentMatcher: Matcher<View>, position: Int): Matcher<View> {

		return object : TypeSafeMatcher<View>() {
			override fun describeTo(description: Description) {
				description.appendText("Child at position $position in parent ")
				parentMatcher.describeTo(description)
			}

			public override fun matchesSafely(view: View): Boolean {
				val parent = view.parent
				return parent is ViewGroup && parentMatcher.matches(parent)
						&& view == parent.getChildAt(position)
			}
		}
	}
}
