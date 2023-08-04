
//import android.content.Context

//import com.google.firebase.analytics.FirebaseAnalytics
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.android.qualifiers.ApplicationContext
//import dagger.hilt.components.SingletonComponent
//import javax.inject.Singleton
//
//@Module
//@InstallIn(SingletonComponent::class)
//object AnalyticsModule {
//    @Singleton
//    @Provides
//    fun provideFirebaseAnalytics(@ApplicationContext context: Context): FirebaseAnalytics {
//        return FirebaseAnalytics.getInstance(context)
//    }
//    @Singleton
//    @Provides
//    @FirebaseLogger
//    fun provideFirebaseEventLogger(firebaseAnalytics: FirebaseAnalytics,sp:JustloSP): Logger {
//        return FirebaseEventLogger(firebaseAnalytics,sp)
//    }
//
//    @Provides
//    @Singleton
//    fun provideCompositeLogger(@FirebaseLogger firebaseLogger: Logger
//    ): Logger {
//        return CompositeLogger(firebaseLogger, justLogger)
//    }
//}
