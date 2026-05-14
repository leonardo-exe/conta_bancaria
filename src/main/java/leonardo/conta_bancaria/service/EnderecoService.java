package leonardo.conta_bancaria.service;

import leonardo.conta_bancaria.dao.*;
import leonardo.conta_bancaria.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class EnderecoService {
    @Autowired
    private DaoEstados daoEstados;
    @Autowired
    private DaoCidades daoCidades;
    @Autowired
    private DaoBairros daoBairros;
    @Autowired
    private DaoLogradouros daoLogradouros;
    @Autowired
    private DaoCEP daoCEP;
    @Autowired
    private DaoEnderecos daoEnderecos;
    private Scanner in = new Scanner(System.in);

    public void insertCEP(String cep) {
        try {
            EnderecoCompleto endereco = buscarEndereco(cep);
            Estados estado =  daoEstados.select(endereco.getEstado());
            Cidades cidade = daoCidades.select(endereco.getLocalidade());
            Bairros bairro = daoBairros.select(endereco.getBairro());
            Logradouros logradouro = daoLogradouros.select(endereco.getLogradouro());
            if (estado == null) {
                System.out.println("Digite a sigla do estado em que este CEP reside");
                daoEstados.insert(new Estados(endereco.getEstado(), in.nextLine()));
                estado =  daoEstados.select(endereco.getEstado());
            }
            if (cidade == null) {
                daoCidades.insert(new Cidades(-1, endereco.getLocalidade(), estado.getSigla()));
                cidade = daoCidades.select(endereco.getLocalidade());
            }
            if (bairro == null) {
                daoBairros.insert(new Bairros(-1, endereco.getBairro(), cidade.getId()));
                bairro = daoBairros.select(endereco.getBairro());
            }
            if (logradouro == null) {
                daoLogradouros.insert(new Logradouros(-1, endereco.getLogradouro(), bairro.getId()));
                logradouro = daoLogradouros.select(endereco.getLogradouro());
            }
            daoCEP.insert(new CEP(cep, logradouro.getId()));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Formato do cep invalido");
        }
    }

    private EnderecoCompleto buscarEndereco(String cep) throws Exception {
        var request = HttpRequest.newBuilder()
                .uri(URI.create("https://viacep.com.br/ws/" + cep + "/json/"))
                .GET()
                .build();
        var response = HttpClient.newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, EnderecoCompleto.class);
    }

    public void insertEndereco(String cep, int numero, String complemento) {

    }
}
