package com.example.transitiondemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.TransitionManager
import android.view.MotionEvent
import android.view.View
import androidx.constraintlayout.widget.ConstraintSet
import kotlinx.android.synthetic.main.activity_transition_demo.*

class TransitionDemoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transition_demo)
        myLayout.setOnTouchListener { v: View, m: MotionEvent ->
            handleTouch()
            true
        }
    }

    private fun handleTouch() {
        TransitionManager.beginDelayedTransition(myLayout)
        myButton.minWidth = 500
        myButton.minHeight = 350

        val set = ConstraintSet()
        set.connect(
            R.id.myButton, ConstraintSet.BOTTOM,
            ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, 0
        )
        set.connect(
            R.id.myButton, ConstraintSet.RIGHT,
            ConstraintSet.PARENT_ID, ConstraintSet.RIGHT, 0
        )

        set.constrainWidth(R.id.myButton, ConstraintSet.WRAP_CONTENT)

        set.applyTo(myLayout)
    }
}