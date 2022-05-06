package com.Sitrack.test;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class DemoService {

    public int consultar(String url, String fraseaBuscar) {
        if (StringUtils.hasLength(url) && StringUtils.hasLength(fraseaBuscar)) {

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();
            try {
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                // guardamos el contenido de toda la pagina en un string
                String webPage = response.body();
                // buscamos una palabra
                String[] words = webPage.split(fraseaBuscar);

                //contamos
                Integer count = words.length-1;
                //mostramos la frase
                String message = String.format("cantidad que se repite la palabra %s, es: %s ", fraseaBuscar, count);
                System.out.println(message);

                // convertimos a Array los elementos de cada string
                String[] fraseCortada = fraseaBuscar.split(" ");


                // contamos las veces que se repite cada palabra recorriendo los array
                for (String palabraFrase: fraseCortada) {

                    String[] cadaPalabra = webPage.split(palabraFrase);
                    Integer veces = cadaPalabra.length-1;
                    System.out.println(palabraFrase+" Se repite:"+ veces +" veces");
                }

                return 1;

            }catch (IOException | InterruptedException e) {

            }
        } else {
            String message = String.format("Valores ingrsador erroneos url: %s, texto: %s ", url, fraseaBuscar);
            System.out.println(message);
        }

        return 0;
    }

}