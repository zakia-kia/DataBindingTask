package com.zakia.idn.databindingtask.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.zakia.idn.databindingtask.common.FoodsBaseViewModel

class MainViewModel : ViewModel() {
    private val _likeNumber = MutableLiveData(0)
    private val _unlikeNumber = MutableLiveData(0)

    val scoreLike: LiveData<Int> = _likeNumber
    val scoreUnLike: LiveData<Int> = _unlikeNumber

    val popularity: LiveData<ProfileObservableViewModel.LikesNumber> =
        Transformations.map(_likeNumber) {
            when {
                it > 9 -> ProfileObservableViewModel.LikesNumber.STAR
                it > 5 -> ProfileObservableViewModel.LikesNumber.POPULAR
                else -> ProfileObservableViewModel.LikesNumber.NORMAL
            }
        }

    val unPopularity: LiveData<ProfileObservableViewModel.UnLikeNumbers> =
        Transformations.map(_unlikeNumber) {
            when {
                it > 9 -> ProfileObservableViewModel.UnLikeNumbers.UNSATISFYING
                it > 5 -> ProfileObservableViewModel.UnLikeNumbers.NOTPOPULAR
                else -> ProfileObservableViewModel.UnLikeNumbers.NORMAL
            }
        }

    fun onLike() {
        _likeNumber.value = (_likeNumber.value ?: 0) + 1
    }

    fun onUnLike() {
        _unlikeNumber.value = (_unlikeNumber.value ?: 0) + 1
    }
}

//Observable
class ProfileObservableViewModel : FoodsBaseViewModel() {
    enum class LikesNumber {
        NORMAL,
        POPULAR,
        STAR
    }

    enum class UnLikeNumbers {
        NORMAL,
        NOTPOPULAR,
        UNSATISFYING
    }
}


