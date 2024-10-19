package com.venfriti.dailypulse

import androidx.lifecycle.ViewModel

actual open class BaseViewModel: ViewModel() {

    actual val scope = viewModelScope
}