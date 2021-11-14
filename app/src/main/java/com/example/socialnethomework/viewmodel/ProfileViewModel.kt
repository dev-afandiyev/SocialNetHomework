package com.example.socialnethomework.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.socialnethomework.domain.ProfileInteractor
import com.example.socialnethomework.model.UserModel
import com.example.socialnethomework.util.ApiState
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel
@Inject constructor(private val interactor: ProfileInteractor)
 : ViewModel() {

    val newsStateFlow: MutableStateFlow<ApiState>
            = MutableStateFlow(ApiState.Empty)

    val _newsStateFlow: StateFlow<ApiState> = newsStateFlow

    private var compositeDisposable = CompositeDisposable()

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

    fun getAllItem(): LiveData<UserModel?>? {
        return interactor.getAllItem()
    }

    fun getNews() = viewModelScope.launch {
        newsStateFlow.value = ApiState.Loading
        interactor.getNews()
            .filter { it.isNotEmpty() }
            .flowOn(Dispatchers.Default)
            .catch { newsStateFlow.value = ApiState.Failure(it)}
            .collect{ newsStateFlow.value = ApiState.Success(it) }
    }

}

