package com.gfreeca.farmin_android.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gfreeca.farmin_android.domain.exception.BadRequestException
import com.gfreeca.farmin_android.domain.exception.NotFoundException
import com.gfreeca.farmin_android.domain.exception.UnauthorizedException
import com.gfreeca.farmin_android.domain.usecase.ApplicationFarmUseCase
import com.gfreeca.farmin_android.presentation.viewmodel.util.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ApplicationViewModel @Inject constructor(
    private val applicationFarmUseCase: ApplicationFarmUseCase
) : ViewModel() {
    private val _applicationFarmResponse = MutableLiveData<Event<Unit>>()
    val applicationFarmResponse: LiveData<Event<Unit>> get() = _applicationFarmResponse

    fun applicationFarm(idx: Int) = viewModelScope.launch {
        applicationFarmUseCase(
            idx = idx
        ).onSuccess {
            _applicationFarmResponse.value = Event.Success()
        }.onFailure {
            _applicationFarmResponse.value = when (it) {
                is BadRequestException -> Event.BadRequest
                is UnauthorizedException -> Event.Unauthorized
                is NotFoundException -> Event.NotFound
                else -> Event.UnKnown
            }
        }
    }
}