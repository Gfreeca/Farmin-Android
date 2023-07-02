package com.gfreeca.farmin_android.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gfreeca.farmin_android.domain.model.announcement.res.RecruitPostInfoModel
import com.gfreeca.farmin_android.domain.usecase.GetRecruitListUseCase
import com.gfreeca.farmin_android.presentation.viewmodel.util.Event
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val getRecruitListUseCase: GetRecruitListUseCase
) : ViewModel() {
    private val _getRecruitListResponse = MutableLiveData<Event<RecruitPostInfoModel>>()
    val getRecruitListResponse: LiveData<Event<RecruitPostInfoModel>> get() = _getRecruitListResponse

    fun getRecruitList() = viewModelScope.launch {
        getRecruitListUseCase()
            .onSuccess {
                Log.d("dddd", it.toString())
            }.onFailure {
                Log.d("dddd", it.toString())
            }
    }
}