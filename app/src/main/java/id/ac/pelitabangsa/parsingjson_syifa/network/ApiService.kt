package id.ac.pelitabangsa.parsingjson_syifa.network

import id.ac.pelitabangsa.parsingjson_syifa.model.ResponseUser
import okhttp3.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    //menampilkan user dengan query
    @GET("api/useer")
    fun getListUsers(@Query("page") page: String): retrofit2.Call<ResponseUser>
}