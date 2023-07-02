package com.gfreeca.farmin_android.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gfreeca.farmin_android.domain.exception.NotFoundException
import com.gfreeca.farmin_android.domain.exception.UnauthorizedException
import com.gfreeca.farmin_android.domain.model.announcement.res.RecruitPostInfoModel
import com.gfreeca.farmin_android.domain.usecase.GetRecruitListUseCase
import com.gfreeca.farmin_android.presentation.viewmodel.util.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getRecruitListUseCase: GetRecruitListUseCase
) : ViewModel() {
    private val _getRecruitListResponse = MutableLiveData<Event<List<RecruitPostInfoModel>>>()
    val getRecruitListResponse: LiveData<Event<List<RecruitPostInfoModel>>> get() = _getRecruitListResponse

    fun getRecruitList() = viewModelScope.launch {
        getRecruitListUseCase()
            .onSuccess {
                _getRecruitListResponse.value = Event.Success(it)
            }.onFailure {
                _getRecruitListResponse.value = when (it) {
                    is UnauthorizedException -> Event.Unauthorized
                    is NotFoundException -> Event.NotFound
                    else -> Event.UnKnown
                }
            }
    }
}