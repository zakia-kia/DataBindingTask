package com.zakia.idn.databindingtask.common

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.core.widget.ImageViewCompat
import androidx.databinding.BindingAdapter
import com.zakia.idn.databindingtask.R
import com.zakia.idn.databindingtask.data.ProfileObservableViewModel

object BindingAdapter {
    //Like
    @BindingAdapter("app:popularityIcon")
    @JvmStatic
    fun popularityIcon(imageView: ImageView, popularity: ProfileObservableViewModel.LikesNumber) {
        //merubah color
        val color = getAssociateColor(popularity, imageView.context)
        //merubah gambar
        ImageViewCompat.setImageTintList(imageView, ColorStateList.valueOf(color))
        imageView.setImageDrawable(getDrawablePopularity(popularity, imageView.context))
    }

    private fun getDrawablePopularity(
        popularity: ProfileObservableViewModel.LikesNumber,
        context: Context
    ): Drawable? {
        return when (popularity) {
            ProfileObservableViewModel.LikesNumber.NORMAL -> {
                ContextCompat.getDrawable(context, R.drawable.ic_thumb_up_black_24dp)
            }
            ProfileObservableViewModel.LikesNumber.POPULAR -> {
                ContextCompat.getDrawable(context, R.drawable.ic_thumb_up_black_24dp)
            }
            ProfileObservableViewModel.LikesNumber.STAR -> {
                ContextCompat.getDrawable(context, R.drawable.ic_favorite)
            }
        }
    }

    private fun getAssociateColor(
        popularity: ProfileObservableViewModel.LikesNumber, context: Context
    ): Int {
        return when (popularity) {
            ProfileObservableViewModel.LikesNumber.STAR -> ContextCompat.getColor(
                context,
                R.color.star
            )
            ProfileObservableViewModel.LikesNumber.POPULAR -> ContextCompat.getColor(
                context,
                R.color.popular
            )
            ProfileObservableViewModel.LikesNumber.NORMAL -> ContextCompat.getColor(
                context,
                R.color.normal
            )

        }
    }

    //UnLike
    @BindingAdapter("app:unPopularityIcon")
    @JvmStatic
    fun unLikePopularityIcon(
        imageView: ImageView,
        unPopularity: ProfileObservableViewModel.UnLikeNumbers
    ) {
        val color = getAssociateUnLikeColor(unPopularity, imageView.context)
        ImageViewCompat.setImageTintList(imageView, ColorStateList.valueOf(color))
        imageView.setImageDrawable(getDrawableUnLikePopularity(unPopularity, imageView.context))
    }

    private fun getDrawableUnLikePopularity(
        unPopularity: ProfileObservableViewModel.UnLikeNumbers,
        context: Context
    ): Drawable? {
        return when (unPopularity) {
            ProfileObservableViewModel.UnLikeNumbers.UNSATISFYING -> ContextCompat.getDrawable(
                context,
                R.drawable.ic_sentiment_dissatisfied
            )
            ProfileObservableViewModel.UnLikeNumbers.NOTPOPULAR -> ContextCompat.getDrawable(
                context,
                R.drawable.ic_thumb_down
            )
            ProfileObservableViewModel.UnLikeNumbers.NORMAL -> ContextCompat.getDrawable(
                context,
                R.drawable.ic_thumb_down
            )
        }
    }

    private fun getAssociateUnLikeColor(
        unPopularity: ProfileObservableViewModel.UnLikeNumbers,
        context: Context
    ): Int {
        return when (unPopularity) {
            ProfileObservableViewModel.UnLikeNumbers.NORMAL -> ContextCompat.getColor(
                context,
                R.color.color_normal
            )
            ProfileObservableViewModel.UnLikeNumbers.NOTPOPULAR -> ContextCompat.getColor(
                context,
                R.color.Unpopular
            )
            ProfileObservableViewModel.UnLikeNumbers.UNSATISFYING -> ContextCompat.getColor(
                context,
                R.color.color_Dissatisfying
            )
        }
    }
}