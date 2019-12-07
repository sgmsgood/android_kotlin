package com.opusone.leanon.testrobocalendar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.marcohc.robotocalendar.RobotoCalendarView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity: AppCompatActivity(), RobotoCalendarView.RobotoCalendarListener {

	private lateinit var robotoCalendarView: RobotoCalendarView
	private var currentCalendar: Calendar? = null
	private var currentMonthIndex: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
		// Gets the calendar from the view
		robotoCalendarView = robotoCalendarPicker as RobotoCalendarView

		// Set listener, in this case, the same activity
		robotoCalendarView.setRobotoCalendarListener(this);

		// Initialize the RobotoCalendarPicker with the current index and date
		currentMonthIndex = 0;
		currentCalendar = Calendar.getInstance(Locale.getDefault());
		robotoCalendarView.onFinishTemporaryDetach();

		// Mark current day
		robotoCalendarView.markDayAsSelectedDay(currentCalendar as Date)

    }

    override fun onDayClick(date: Date?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onRightButtonClick() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onDayLongClick(date: Date?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onLeftButtonClick() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}