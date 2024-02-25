package com.namnp.instagram_android.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.namnp.instagram_android.constant.Constants
import com.namnp.instagram_android.domain.use_case.UseCases
import com.namnp.instagram_android.presentation.ui.MainEvent
import com.namnp.instagram_android.utils.Theme
import com.namnp.instagram_android.utils.ThemeState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel
@Inject
constructor(
    private val useCases: UseCases,
) : ViewModel() {

    private val _themeState: MutableStateFlow<ThemeState> =
        MutableStateFlow(ThemeState(theme = Theme.Light))
    val themeState: StateFlow<ThemeState> = _themeState

    init {
        getThemeState()
    }

    private fun toggleDarkMode() {
//        _themeState.value.toggleDarkMode()
        _themeState.value =
            _themeState.value.copy(
                theme = if (_themeState.value.theme == Theme.Light)
                    Theme.Dark
                else Theme.Light
            )
    }

    private fun getThemeState() {
        viewModelScope.launch(Dispatchers.IO) {
            val isDarkTheme = useCases.getDataStoreValueUseCase(
                key = Constants.PREFERENCES_KEY_DARK_THEME
            ).stateIn(viewModelScope).value.toBoolean()
            _themeState.value = ThemeState(theme = if (isDarkTheme) Theme.Dark else Theme.Light)
        }
    }

    fun saveThemeState() {
        val isDarkTheme = themeState.value.theme == Theme.Dark
        viewModelScope.launch(Dispatchers.IO) {
            useCases.setDataStoreValueUseCase(
                key = Constants.PREFERENCES_KEY_DARK_THEME,
                value = isDarkTheme.toString()
            )
        }
    }

    fun onEvent(event: MainEvent) {
        when(event) {
            MainEvent.OnToggleDarkTheme -> {
                toggleDarkMode()
            }
            else -> {}
        }
    }
}