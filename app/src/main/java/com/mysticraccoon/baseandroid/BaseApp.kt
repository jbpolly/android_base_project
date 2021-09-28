package com.mysticraccoon.baseandroid

import android.app.Application
import androidx.databinding.library.BuildConfig
import androidx.lifecycle.*
import com.mysticraccoon.baseandroid.di.koin.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.component.KoinApiExtension
import org.koin.core.component.KoinComponent
import org.koin.core.context.startKoin
import timber.log.Timber

@KoinApiExtension
class BaseApp: Application(), LifecycleObserver, KoinComponent {

    companion object {

        //used to notify the whole app when there is a new notification
//        private val notifyNewMessageObservable = MutableLiveData<Int>()
//
//        fun subscribeToNotificationCount() = notifyNewMessageObservable
//        var newNotificationCount: Int = 0
//            set(value) {
//                field = value
//                notifyNewMessageObservable.postValue(newNotificationCount)
//            }
    }

//    var isAppRunning = false
//        private set

    override fun onCreate() {
        super.onCreate()
        setupFirebase()
        startDependencyInjection()
        configureTimber()
        ProcessLifecycleOwner.get().lifecycle.addObserver(this)

    }

    private fun startDependencyInjection() {
        // start Koin!
        startKoin {
            // declare used Android context
            androidContext(this@BaseApp)
            // declare module
            modules(
                listOf(
                    viewModelModule
                )
            )
        }



    }

    private fun setupFirebase() {
      //  FirebaseApp.initializeApp(this)
    }

    private fun configureTimber() {
        if (BuildConfig.DEBUG)
            Timber.plant(Timber.DebugTree())
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onAppBackgrounded() {
      //  isAppRunning = false
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onAppForegrounded() {
      //  isAppRunning = true

        //This allows checking if the authorization token is valid when initializing the app
//        runBlocking {
//            AuthObject.authorizationToken ?: return@runBlocking
//
//            val userRepository = get<UserRepository>()
//            userRepository.validateToken()
//        }
    }

}