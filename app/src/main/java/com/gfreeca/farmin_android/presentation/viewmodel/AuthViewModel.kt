package com.gfreeca.farmin_android.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gfreeca.farmin_android.domain.exception.BadRequestException
import com.gfreeca.farmin_android.domain.exception.NotFoundException
import com.gfreeca.farmin_android.domain.model.auth.req.SignInReqModel
import com.gfreeca.farmin_android.domain.model.auth.res.SignInResModel
import com.gfreeca.farmin_android.domain.usecase.SignInUseCase
import com.gfreeca.farmin_android.presentation.viewmodel.util.Event
import kotlinx.coroutines.launch
import javax.inject.Inject

class AuthViewModel @Inject constructor(
    private val signInUseCase: SignInUseCase
) : ViewModel() {
    private val _signInResponse = MutableLiveData<Event<SignInResModel>>()
    val signInResponse: LiveData<Event<SignInResModel>> get() = _signInResponse

    fun signIn(id: String, password: String) = viewModelScope.launch {
        signInUseCase(
            SignInReqModel(
                id = id,
                password = password
            )
        ).onSuccess {
            _signInResponse.value = Event.Success(it)
        }.onFailure {
            _signInResponse.value =
                when (it) {
                    is BadRequestException -> Event.BadRequest
                    is NotFoundException -> Event.NotFound
                    else -> Event.UnKnown
                }
        }
    }
}