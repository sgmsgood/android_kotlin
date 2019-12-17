package com.opusone.leanon.testcalculator


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun mainActivityTest() {
        val appCompatEditText = onView(
            allOf(
                withId(R.id.leftInput), withText("0"),
                childAtPosition(
                    allOf(
                        withId(R.id.outputDataLayout),
                        childAtPosition(
                            withClassName(`is`("androidx.constraintlayout.widget.ConstraintLayout")),
                            0
                        )
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        appCompatEditText.perform(replaceText("1234"))

        val appCompatEditText2 = onView(
            allOf(
                withId(R.id.leftInput), withText("1234"),
                childAtPosition(
                    allOf(
                        withId(R.id.outputDataLayout),
                        childAtPosition(
                            withClassName(`is`("androidx.constraintlayout.widget.ConstraintLayout")),
                            0
                        )
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        appCompatEditText2.perform(closeSoftKeyboard())

        val appCompatEditText3 = onView(
            allOf(
                withId(R.id.rightInput), withText("0"),
                childAtPosition(
                    allOf(
                        withId(R.id.outputDataLayout),
                        childAtPosition(
                            withClassName(`is`("androidx.constraintlayout.widget.ConstraintLayout")),
                            0
                        )
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        appCompatEditText3.perform(replaceText("4321"))

        val appCompatEditText4 = onView(
            allOf(
                withId(R.id.rightInput), withText("4321"),
                childAtPosition(
                    allOf(
                        withId(R.id.outputDataLayout),
                        childAtPosition(
                            withClassName(`is`("androidx.constraintlayout.widget.ConstraintLayout")),
                            0
                        )
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        appCompatEditText4.perform(closeSoftKeyboard())

        val appCompatButton = onView(
            allOf(
                withId(R.id.sumButton), withText("+"),
                childAtPosition(
                    allOf(
                        withId(R.id.calButtonLayout),
                        childAtPosition(
                            withId(R.id.calculatorButtonLayout),
                            0
                        )
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        appCompatButton.perform(click())

        val appCompatEditText5 = onView(
            allOf(
                withId(R.id.rightInput), withText("4321"),
                childAtPosition(
                    allOf(
                        withId(R.id.outputDataLayout),
                        childAtPosition(
                            withClassName(`is`("androidx.constraintlayout.widget.ConstraintLayout")),
                            0
                        )
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        appCompatEditText5.perform(pressImeActionButton())

        val appCompatButton2 = onView(
            allOf(
                withId(R.id.calButton), withText("cul"),
                childAtPosition(
                    allOf(
                        withId(R.id.calculatorButtonLayout),
                        childAtPosition(
                            withClassName(`is`("androidx.constraintlayout.widget.ConstraintLayout")),
                            1
                        )
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        appCompatButton2.perform(click())

        val appCompatButton3 = onView(
            allOf(
                withId(R.id.minusButton), withText("-"),
                childAtPosition(
                    allOf(
                        withId(R.id.calButtonLayout),
                        childAtPosition(
                            withId(R.id.calculatorButtonLayout),
                            0
                        )
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        appCompatButton3.perform(click())

        val appCompatButton4 = onView(
            allOf(
                withId(R.id.calButton), withText("cul"),
                childAtPosition(
                    allOf(
                        withId(R.id.calculatorButtonLayout),
                        childAtPosition(
                            withClassName(`is`("androidx.constraintlayout.widget.ConstraintLayout")),
                            1
                        )
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        appCompatButton4.perform(click())

        val appCompatButton5 = onView(
            allOf(
                withId(R.id.multiplyButton), withText("*"),
                childAtPosition(
                    allOf(
                        withId(R.id.calButtonLayout),
                        childAtPosition(
                            withId(R.id.calculatorButtonLayout),
                            0
                        )
                    ),
                    3
                ),
                isDisplayed()
            )
        )
        appCompatButton5.perform(click())

        val appCompatButton6 = onView(
            allOf(
                withId(R.id.calButton), withText("cul"),
                childAtPosition(
                    allOf(
                        withId(R.id.calculatorButtonLayout),
                        childAtPosition(
                            withClassName(`is`("androidx.constraintlayout.widget.ConstraintLayout")),
                            1
                        )
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        appCompatButton6.perform(click())

        val appCompatButton7 = onView(
            allOf(
                withId(R.id.divisionButton), withText("%"),
                childAtPosition(
                    allOf(
                        withId(R.id.calButtonLayout),
                        childAtPosition(
                            withId(R.id.calculatorButtonLayout),
                            0
                        )
                    ),
                    4
                ),
                isDisplayed()
            )
        )
        appCompatButton7.perform(click())

        val appCompatButton8 = onView(
            allOf(
                withId(R.id.calButton), withText("cul"),
                childAtPosition(
                    allOf(
                        withId(R.id.calculatorButtonLayout),
                        childAtPosition(
                            withClassName(`is`("androidx.constraintlayout.widget.ConstraintLayout")),
                            1
                        )
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        appCompatButton8.perform(click())

        val appCompatButton9 = onView(
            allOf(
                withId(R.id.clearButton), withText("C"),
                childAtPosition(
                    allOf(
                        withId(R.id.calButtonLayout),
                        childAtPosition(
                            withId(R.id.calculatorButtonLayout),
                            0
                        )
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        appCompatButton9.perform(click())

        val appCompatButton10 = onView(
            allOf(
                withId(R.id.calButton), withText("cul"),
                childAtPosition(
                    allOf(
                        withId(R.id.calculatorButtonLayout),
                        childAtPosition(
                            withClassName(`is`("androidx.constraintlayout.widget.ConstraintLayout")),
                            1
                        )
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        appCompatButton10.perform(click())
    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

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
