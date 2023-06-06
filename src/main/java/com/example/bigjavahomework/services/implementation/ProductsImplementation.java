package com.example.bigjavahomework.services.implementation;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import com.example.bigjavahomework.resources.ProductsResource;
import com.example.bigjavahomework.entityes.Products;
import com.example.bigjavahomework.repositoryes.ProductsRepository;
import com.example.bigjavahomework.services.ProductsService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.bigjavahomework.mappers.ProductsMapper.PRODUCTS_MAPPER;

@Service
@RequiredArgsConstructor
public class ProductsImplementation implements ProductsService {
    private final ProductsRepository productsRepository;

    @Override
    public List<ProductsResource> getAll() {
        return PRODUCTS_MAPPER.toProductsResources(productsRepository.findAll());
    }

    @Override
    public Optional<ProductsResource> getById(Integer id) {
        return productsRepository.findById(id).map(PRODUCTS_MAPPER::toProductsResource);
    }

    @Override
    public ProductsResource create(ProductsResource productsResource) {
        try {
            Products products = productsRepository.save(PRODUCTS_MAPPER.fromProductsResource(productsResource));
            productsResource.setId(products.getId());
            return productsResource;
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Product with id " + productsResource.getId() + " already exists.");
        }
    }

    @Override
    public ProductsResource update(ProductsResource productsResource, Integer id) {
        try {
            Products products = productsRepository.getReferenceById(id);

            products.setName(productsResource.getName());
            products.setPrice(productsResource.getPrice());
            products.setQuantity(productsResource.getQuantity());
            products.setWeight(productsResource.getWeight());
            products.setInfo(productsResource.getInfo());

            return PRODUCTS_MAPPER.toProductsResource(productsRepository.save(products));
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Unable to find product with id " + id + ".");
        }
    }

    @Override
    public void deleteById(Integer id) {
        if (productsRepository.existsById(id)) {
            productsRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Unable to find product with id " + id + ".");
        }
    }
}