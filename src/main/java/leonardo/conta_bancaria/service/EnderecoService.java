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
    private DaoCep daoCep;
    @Autowired
    private DaoEnderecos daoEnderecos;
    private Scanner in = new Scanner(System.in);

    public EnderecoCompleto insertCep(String cep, String logradouro) {
        try {
            EnderecoCompleto endereco = new EnderecoCompleto();
            endereco.setLogradouro(logradouro);
            Cep CEP = daoCep.select(cep);
            Logradouros log = daoLogradouros.select(logradouro);
            if (CEP == null)
                daoCep.insert(new Cep(cep));
            if (log == null) {
                endereco = buscarEndereco(cep);
                Estados estado = daoEstados.select(endereco.getEstado());
                Cidades cidade = daoCidades.select(endereco.getLocalidade());
                Bairros bairro = daoBairros.select(endereco.getBairro());
                if (bairro != null)
                    if (bairro.getIdCidade() != cidade.getId())
                        bairro = null;
                if (estado == null) {
                    System.out.println("Digite a sigla do estado em que este CEP reside");
                    daoEstados.insert(new Estados(endereco.getEstado(), in.nextLine()));
                    estado = daoEstados.select(endereco.getEstado());
                }
                if (cidade == null) {
                    daoCidades.insert(new Cidades(-1, endereco.getLocalidade(), estado.getSigla()));
                    cidade = daoCidades.select(endereco.getLocalidade());
                }
                if (bairro == null) {
                    if (endereco.getBairro().isEmpty())
                        endereco.setBairro(endereco.getLocalidade());
                    if (daoBairros.select(endereco.getLocalidade()) == null)
                        daoBairros.insert(new Bairros(-1, endereco.getBairro(), cidade.getId()));
                    bairro = daoBairros.select(endereco.getBairro());
                }
                log = daoLogradouros.select(endereco.getLogradouro());
                if (log == null || log.getLogradouro().isEmpty()) {
                    if (endereco.getLogradouro().isEmpty()) {
                        daoLogradouros.insert(new Logradouros(-1, logradouro, bairro.getId()));
                        endereco.setLogradouro(logradouro);
                    }
                    else {
                        daoLogradouros.insert(new Logradouros(-1, endereco.getLogradouro(), bairro.getId()));
                    }
                }
                return endereco;
            }
            return endereco;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Formato do cep invalido");
            return null;
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

    public int insertEndereco(String cep, String logradouro, int numero, String complemento) {
        try {
            EnderecoCompleto end = insertCep(cep, logradouro);
            if (end == null)
                return -1;
            logradouro = end.getLogradouro();
            Enderecos endereco = new Enderecos(-1, cep, numero, complemento, daoLogradouros.select(logradouro).getId());
            Integer id = daoEnderecos.queryId(endereco);
            if (id != null)
                return id;
            return daoEnderecos.insert(endereco);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
