package com.example.transitiondemo

import android.os.Bundle
import android.transition.ChangeBounds
import android.transition.Transition
import android.transition.TransitionManager
import android.view.MotionEvent
import android.view.View
import android.view.animation.BounceInterpolator
import androidx.appcompat.app.AppCompatActivity
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
        val changeBounds = ChangeBounds()
        changeBounds.duration = 3000
        changeBounds.interpolator = BounceInterpolator()
        TransitionManager.beginDelayedTransition(myLayout, changeBounds)
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