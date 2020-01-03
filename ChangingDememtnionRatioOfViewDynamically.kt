package com.fg.lolc.feature.common.component

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import com.fg.lolc.R
import com.fg.lolc.feature.common.enums.LineCount
import kotlinx.android.synthetic.main.component_multiple_vertical_text.view.*


class MultipleVerticalTextComponent @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    init {
        LayoutInflater.from(context)
            .inflate(R.layout.component_multiple_vertical_text, this, true)

        attrs?.let {

            val typedArray = context.obtainStyledAttributes(
                it,
                R.styleable.MultipleVerticalTextComponent,
                0,
                0
            )

            if (typedArray.hasValue(R.styleable.MultipleVerticalTextComponent_mvt_no_of_right_text)) {
                setLayoutHeight(
                    LineCount.values()[typedArray.getInt(
                        R.styleable.MultipleVerticalTextComponent_mvt_no_of_right_text,
                        0
                    )]
                )
            }
            if (typedArray.hasValue(R.styleable.MultipleVerticalTextComponent_is_bottom_line_hide)) {
                hideBottomLine(
                    typedArray.getBoolean(
                        R.styleable.MultipleVerticalTextComponent_is_bottom_line_hide,
                        false
                    )
                )
            }
            if (typedArray.hasValue(R.styleable.MultipleVerticalTextComponent_mvt_left_text)) {
                setLeftText(
                    typedArray.getString(
                        R.styleable.MultipleVerticalTextComponent_mvt_left_text
                    )
                )
            }
            if (typedArray.hasValue(R.styleable.MultipleVerticalTextComponent_mvt_first_right_text)) {
                setFirstLineRightText(
                    typedArray.getString(
                        R.styleable.MultipleVerticalTextComponent_mvt_first_right_text
                    )
                )
            }
            if (typedArray.hasValue(R.styleable.MultipleVerticalTextComponent_mvt_second_right_text)) {
                setSecondLineRighttext(
                    typedArray.getString(
                        R.styleable.MultipleVerticalTextComponent_mvt_second_right_text
                    )
                )
            }
            if (typedArray.hasValue(R.styleable.MultipleVerticalTextComponent_mvt_third_right_text)) {
                setThirdLineRightText(
                    typedArray.getString(
                        R.styleable.MultipleVerticalTextComponent_mvt_third_right_text
                    )
                )
            }
            if (typedArray.hasValue(R.styleable.MultipleVerticalTextComponent_mvt_third_right_text)) {
                setFourthLineRightText(
                    typedArray.getString(
                        R.styleable.MultipleVerticalTextComponent_mvt_third_right_text
                    )
                )
            }
        }
    }

    /**
     * set layout height in this function I changed the "Dimension Ratio" of one constraint layout by using the following tags
     * @param numberOfLines : Int?
     */
    fun setLayoutHeight(numberOfLines: LineCount) {

        var set = ConstraintSet()
        set.clone(multipleVerticalTextComponent)

        when (numberOfLines) {
            LineCount.ONE -> {
                set.setDimensionRatio(R.id.mvtWrapper, "1:0.18")
            }
            LineCount.TWO -> {
                set.setDimensionRatio(R.id.mvtWrapper, "1:0.36")
                mvtRightSecondLineTv.visibility = View.VISIBLE
            }
            LineCount.THREE -> {
                set.setDimensionRatio(R.id.mvtWrapper, "1:0.54")
                mvtRightSecondLineTv.visibility = View.VISIBLE
                mvtRightThirdLineTv.visibility = View.VISIBLE
            }
            LineCount.FOUR -> {
                set.setDimensionRatio(R.id.mvtWrapper, "1:0.72")
                mvtRightSecondLineTv.visibility = View.VISIBLE
                mvtRightThirdLineTv.visibility = View.VISIBLE
                mvtRightFourthLineTv.visibility = View.VISIBLE
            }
        }

        set.applyTo(multipleVerticalTextComponent)
    }

    /**
     * hide the bottom line
     * @param hide: Boolean?
     */
    fun hideBottomLine(hide: Boolean?) {
        if (hide!!) {
            mvtBottomLine.visibility = View.GONE
        }
    }

    /**
     * set left textView text
     * @param text : String?
     */
    fun setLeftText(text : String?){
        mvtLeftTv.setTextViewText(text)
    }

    /**
     * set right first textView text
     * @param text : String?
     */
    fun setFirstLineRightText(text: String?){
        mvtRightFirstLineTv.setTextViewText(text)
    }

    /**
     * set right second textView text
     * @param text : String?
     */
    fun setSecondLineRighttext(text: String?){
        mvtRightSecondLineTv.setTextViewText(text)
    }

    /**
     * set right third textView text
     * @param text : String?
     */
    fun setThirdLineRightText(text: String?){
        mvtRightThirdLineTv.setTextViewText(text)
    }

    /**
     * set right fourth textView text
     * @param text : String?
     */
    fun setFourthLineRightText(text: String?){
        mvtRightFourthLineTv.setTextViewText(text)
    }
}
