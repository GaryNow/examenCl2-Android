package pe.com.examencl2.ProyectoREST

import retrofit2.Response
import retrofit2.http.GET

interface ItBookAPI {
    //https://api.itbook.store/1.0/search/mongodb
    @GET("search/mongodb")
    suspend fun getBooks() : Response<ItBookList>
}