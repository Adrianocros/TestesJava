package br.com.testedeinteracao.produtapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import com.github.tomakehurst.wiremock.extension.responsetemplating.UrlPath;
import com.github.tomakehurst.wiremock.matching.UrlPathPattern;
import com.github.tomakehurst.wiremock.matching.UrlPattern;
import com.google.common.net.MediaType;
import com.jayway.jsonpath.JsonPath;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;


@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {
    private static final String MOCKED_RESULT = "{\"products\" : [\n" + 
    "       {\n" +
    "       \"id\": 1,\n" +
    "       \"nome\": \"CocaColca\", \n" +
    "       \"price\": 10.0\n"+
    "   },\n" +
    "   {\n" +
    "       \"id\": 2,\n" +
    "       \"nome\": \"Pepice\", \n" +
    "       \"price\": 20.0\n"+
    "   }\n" +
    "]}";

//Variavel static WireMockServer na porta 8081
private static WireMockServer wireMockServer = new WireMockServer(options().port(8081));


//Setup para o teste
@Autowired
private MockMvc mockMvc;

@Autowired
private ObjectMapper objectMapper;

//inicia o wireMockServer com start antes de da construção da instancia 
@BeforeAll
static void beforeAll() throws JsonProcessingException{
    wireMockServer.start();
}


//Antes de cada metodo de teste seja restartado todas as stubs, gatante que a cada teste ha um senario limpo
@BeforeEach
void setUp(){
    wireMockServer.resetAll();
}

//Apos todos os testes executarem para o wireMockServer para nao ficar utilizando a porta 8081
@AfterAll
static void afterAll(){
    wireMockServer.stop();
}


//Inicio do teste
public void shouldFindAllProducts() throws Exception{
    wireMockServer.stubFor(
        WireMock.get(urlPathEqualTo("/product"))
        .willReturn(aResponse()notify();
            .withStatus(200)
            .withHeader("Content-Type","application/json")
            .withBody((MOCKED_RESULT))));
    
    mockMvc.perform(
        get("/produt").contentType(MediaType.APPLICATION_JSON))
        .addExpect(status().isOK())
        .addExpect(jsonPath("$", hasSize(2)));

    )
    
}




}


    
