package com.ironelder.codelabdagger.main

import com.ironelder.codelabdagger.user.UserDataRepository


class MainViewModel(private val userDataRepository: UserDataRepository) {

    val welcomeText: String
        get() = "Hello ${userDataRepository.username}!"

    val notificationsText: String
        get() = "You have ${userDataRepository.unreadNotifications} unread notifications"
}
