package br.com.alura.desafios;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class DesafioUm {

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite o titulo do livro: ");
        var tituloLivro = leitura.nextLine();

        String endereco = "https://www.googleapis.com/books/v1/volumes?q=" + tituloLivro +
                "&key=AIzaSyCW7T5vpa__xUaCugEo9tpwaM0GBFqw0fg";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());

    }
}
