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

    public Integer consultar(String url, String texto) {
        if (StringUtils.hasLength(url) && StringUtils.hasLength(texto)) {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();
            try {
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                // guardamos el contenido de toda la pagina en un string
                String webPage = response.body();
                // buscarmos una palabra
                String[] words = webPage.split(texto);

                String[] cortado = texto.split(" ");

                //contamos
                Integer count = words.length;
                // mostramos la frase
                String message = String.format("cantidad que se repite la palabra %s, es: %s ", texto, count);
                System.out.println(message);

                // contamos las veces que se repite cada palabra
                for (String lenguaje: cortado) {

                    String[] cadaPalabra = webPage.split(lenguaje);
                    Integer veces = cadaPalabra.length;

                    System.out.println(lenguaje+" Se repite:"+ veces+" veces");
                }


                return count;
            }catch (IOException | InterruptedException e) {

            }
        } else {
            String message = String.format("Valores ingrsador erroneos url: %s, texto: %s ", url, texto);
            System.out.println(message);
        }

        return 0;
    }

}