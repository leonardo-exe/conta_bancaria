package leonardo.conta_bancaria.service;

import leonardo.conta_bancaria.dao.*;
import leonardo.conta_bancaria.dto.*;
import leonardo.conta_bancaria.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
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
    @Autowired
    private Scanner in;

    public Integer insertCep(String cep, String logradouro) {
        try {
            Cep CEP = daoCep.select(cep);
            if (CEP == null) {
                daoCep.insert(new Cep(cep));
            }
            EnderecoCompletoDTO endereco = buscarEndereco(cep);
            Estados estado = daoEstados.select(endereco.getEstado());
            if (estado == null) {
                System.out.println("Digite a sigla do estado em que este CEP reside");
                daoEstados.insert(new Estados(endereco.getEstado(), in.nextLine().substring(0, 2)));
                estado = daoEstados.select(endereco.getEstado());
            }
            Cidades cidade = daoCidades.select(endereco.getLocalidade());
            if (cidade == null) {
                daoCidades.insert(new Cidades(-1, endereco.getLocalidade(), estado.getSigla()));
                cidade = daoCidades.select(endereco.getLocalidade());
            }
            if (endereco.getBairro() == null || endereco.getBairro().isEmpty()) {
                endereco.setBairro(cidade.getCidade());
            }
            Bairros bairro = daoBairros.selectPorNomeECidade(endereco.getBairro(), cidade.getId());
            if (bairro == null) {
                daoBairros.insert(new Bairros(-1, endereco.getBairro(), cidade.getId()));
                bairro = daoBairros.selectPorNomeECidade(endereco.getBairro(), cidade.getId());
            }
            String nomeLogradouroFinal = (endereco.getLogradouro() == null || endereco.getLogradouro().isEmpty())
                    ? logradouro
                    : endereco.getLogradouro();
            Logradouros log = daoLogradouros.selectPorNomeEBairro(nomeLogradouroFinal, bairro.getId());
            if (log == null) {
                return daoLogradouros.insert(new Logradouros(-1, nomeLogradouroFinal, bairro.getId()));
            }
            return log.getId();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Formato do cep invalido");
            return null;
        }
    }

    private EnderecoCompletoDTO buscarEndereco(String cep) throws Exception {
        var request = HttpRequest.newBuilder()
                .uri(URI.create("https://viacep.com.br/ws/" + cep + "/json/"))
                .GET()
                .build();
        var response = HttpClient.newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, EnderecoCompletoDTO.class);
    }

    public int insertEndereco(String cep, String logradouro, int numero, String complemento) {
        try {
            Integer idl = insertCep(cep, logradouro);
            if (idl == null)
                return -1;
            Enderecos endereco = new Enderecos(-1, cep, numero, complemento, idl);
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
