package com.ironelder.codelabdagger.settings

import com.ironelder.codelabdagger.user.UserDataRepository
import com.ironelder.codelabdagger.user.UserManager
import javax.inject.Inject


class SettingsViewModel @Inject constructor(
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
