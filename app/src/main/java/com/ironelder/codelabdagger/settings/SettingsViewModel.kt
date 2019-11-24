package com.ironelder.codelabdagger.settings

import com.ironelder.codelabdagger.user.UserDataRepository
import com.ironelder.codelabdagger.user.UserManager


/**
 * SettingsViewModel is the ViewModel that [SettingsActivity] uses to handle complex logic.
 */
class SettingsViewModel(
    private val userDataRepository: UserDataRepository,
    private val userManager: UserManager
) {

    fun refreshNotifications() {
        userDataRepository.refreshUnreadNotifications()
    }

    fun logout() {
        userManager.logout()
    }
}
