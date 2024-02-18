import com.example.network.repository.UserRepositoryImpl
import com.example.network_api.api.FootballManagerApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DataSourceModule {
    @Provides
    @Singleton
    fun provideUserRepositoryImpl(footballManagerApi: FootballManagerApi) : UserRepositoryImpl {
        return UserRepositoryImpl(footballManagerApi)
    }
}