package com.opusone.leanon.bloodpressure

import android.content.Context
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.AxisBase
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.listener.OnChartValueSelectedListener
import com.github.mikephil.charting.utils.ColorTemplate
import kotlinx.android.synthetic.main.fragment_weekend_graph.*


class WeekendGraphFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_weekend_graph, container, false)
        val lineChartView = this.lineChart

        val list = arrayListOf<Entry>()
        list.add(Entry(0f, 50f)) // on point/index 0, the data is 50
        list.add(Entry(1f, 100f))// on point/index 1, the data is 100
        list.add(Entry(2f, 75f))  // on point/index 2, the data is 75

        val lineDataSet1 = LineDataSet(list, "Company 1")
        lineDataSet1.color = Color.RED
        lineDataSet1.setDrawValues(false)
        lineDataSet1.setAxisDependency(YAxis.AxisDependency.LEFT)

        val lineData = LineData(lineDataSet1)
        lineChartView?.data = lineData

        val xAxis = lineChartView?.xAxis
        xAxis?.position = XAxis.XAxisPosition.BOTTOM
        xAxis?.textColor = Color.BLACK
        xAxis?.enableGridDashedLine(8f, 24f, 0f)

        val yLAxis = lineChartView?.axisLeft
        yLAxis?.textColor = Color.BLACK

        val yRAxis = lineChartView?.axisRight
        yRAxis?.setDrawLabels(false)
        yRAxis?.setDrawAxisLine(false)
        yRAxis?.setDrawGridLines(false)

        val description = Description()
        description.text = ""

        lineChartView?.isDoubleTapToZoomEnabled = false
        lineChartView?.setDrawGridBackground(false)
        lineChartView?.description = description
//        lineChartView.animateY(2000, Easing.EasingFunction { })

        lineChartView?.invalidate()
//        initWidget()
//        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

    }

    override fun onDetach() {
        super.onDetach()
    }

//    private fun initWidget(){
//        initChart()
//    }
//
//    private fun initChart(){
//        lineChart.apply {
//            setOnChartValueSelectedListener(object : OnChartValueSelectedListener {
//                override fun onValueSelected(e: Entry, h: Highlight) {
//                    Log.i("Entry selected", e.toString())
//
//                    lineChart.centerViewToAnimated(
//                        e.x, e.y, lineChart.data.getDataSetByIndex(h.dataSetIndex).axisDependency, 500
//                    )
//                }
//
//                override fun onNothingSelected() {
//                    Log.i("Nothing selected", "Nothing selected.")
//                }
//            })
//
//            description.isEnabled = false
//            dragDecelerationFrictionCoef = 0.9f
//            isDragEnabled = true
//            isHighlightPerDragEnabled = true
//            setTouchEnabled(true)
//            setScaleEnabled(true)
//            setScaleMinima(3f, 0f)
//            setDrawGridBackground(false)
//            setPinchZoom(false)
//            setBackgroundColor(Color.WHITE)
//            animateX(1000)
//            axisLeft.isEnabled = false
//            axisRight.isEnabled = false
//            legend.isEnabled = false
//            isDoubleTapToZoomEnabled = false
//
//            xAxis.apply {
//                textSize = 11f
//                textColor = Color.GREEN
//                setDrawGridLines(false)
//                setDrawAxisLine(true)
//                isGranularityEnabled = true
//                position = XAxis.XAxisPosition.BOTTOM
//                valueFormatter = object : IndexAxisValueFormatter() {
//                    override fun getAxisLabel(value: Float, axis: AxisBase?): String {
//                        return value.toString()
//                    }
//                }
//            }
//        }
//
//        setData()
//    }
//
//    private fun setData() {
//
//        val values1 = java.util.ArrayList<Entry>()
//        values1.add(Entry(0f, 52f))
//        values1.add(Entry(1f, 55.1f))
//        values1.add(Entry(2f, 57f))
//        values1.add(Entry(3f, 59f))
//        values1.add(Entry(4f, 55f))
//        values1.add(Entry(5f, 56f))
//        values1.add(Entry(6f, 55.4f))
//        values1.add(Entry(7f, 55.2f))
//        values1.add(Entry(8f, 54.8f))
//        values1.add(Entry(9f, 54.1f))
//        values1.add(Entry(10f, 53.2f))
//        values1.add(Entry(11f, 53.8f))
//        values1.add(Entry(12f, 54.5f))
//
//        val set1: LineDataSet
//
//        if (lineChart.data != null && lineChart.data.dataSetCount > 0) {
//            set1 = lineChart.data.getDataSetByIndex(0) as LineDataSet
//            set1.values = values1
//            lineChart.data.notifyDataChanged()
//            lineChart.notifyDataSetChanged()
//
//        } else {
//            set1 = LineDataSet(values1, "")
//            set1.axisDependency = YAxis.AxisDependency.LEFT
//            set1.color = ColorTemplate.getHoloBlue()
//            set1.setCircleColor(Color.GREEN)
//            set1.lineWidth = 2f
//            set1.circleRadius = 3f
//            set1.fillAlpha = 65
//            set1.fillColor = ColorTemplate.getHoloBlue()
//            set1.highLightColor = Color.rgb(244, 117, 117)
//            set1.setDrawCircleHole(false)
//
//            val data = LineData(set1)
//            data.setValueTextColor(Color.RED)
//            data.setValueTextSize(9f)
//
//            // set data
//            lineChart.data = data
//        }
//    }
}
