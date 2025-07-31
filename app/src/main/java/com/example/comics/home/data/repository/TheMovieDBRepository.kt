import com.example.comics.home.data.dto.DataMoviesResponseDTO
import com.example.comics.network.resources.ObserveNetworkStateHandler
import kotlinx.coroutines.flow.Flow

interface TheMovieDBRepository {
    fun getTrendingMovies(): Flow<ObserveNetworkStateHandler<DataMoviesResponseDTO>>
}