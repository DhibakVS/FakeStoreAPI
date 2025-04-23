package dev.dhibak.ProductService.client;

import dev.dhibak.ProductService.ProductServiceApplication;
import dev.dhibak.ProductService.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Component
public class FakeStoreClient {
    @Autowired
    private RestTemplate restTemplate;

    public ProductDTO[] getAllProduct(){
        String getAllProductURL="https://fakestoreapi.com/products";
        ProductDTO[] response= restTemplate.getForObject(getAllProductURL,ProductDTO[].class);
        return response;
    }

    public ProductDTO getProductById(int id){
        String getProductByIdURL="https://fakestoreapi.com/products/"+id;
        ProductDTO response= restTemplate.getForObject(getProductByIdURL,ProductDTO.class);
        return response;
    }
    public ProductDTO createProduct(ProductDTO productDTO){
        String url="https://fakestoreapi.com/products";
        ProductDTO response=restTemplate.postForObject(url,productDTO,ProductDTO.class);
        return response;
    }
    public ProductDTO updateProduct(int id,ProductDTO productDTO){
        String url="https://fakestoreapi.com/products/"+id;
        ProductDTO response=putForObject(url,productDTO,ProductDTO.class);
        return response;
    }

    public <T> T putForObject(String url, @Nullable Object request, Class<T> responseType, Object... uriVariables) throws RestClientException {
        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
        HttpMessageConverterExtractor<T> responseExtractor = new HttpMessageConverterExtractor(responseType, restTemplate.getMessageConverters());
        return restTemplate.execute(url, HttpMethod.PUT, requestCallback, responseExtractor, (Object[])uriVariables);
    }
}
