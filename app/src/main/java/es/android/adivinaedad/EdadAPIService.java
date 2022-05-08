package es.android.adivinaedad;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface EdadAPIService {

    @GET("/")
    Call getEdad(@Query("name") String nombre);
}
