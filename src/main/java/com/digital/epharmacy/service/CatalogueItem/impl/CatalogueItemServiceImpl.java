package com.digital.epharmacy.service.CatalogueItem.impl;

/*
 * Author: Nelson Mpyana
 * Desc: CatalogueItemServiceImpl
 * Date: 3 September 2020
 */

import com.digital.epharmacy.entity.Catalogue.CatalogueItem;
import com.digital.epharmacy.repository.CatalogueItem.CatalogueItemRepository;
import com.digital.epharmacy.service.CatalogueItem.CatalogueItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
;
import java.util.stream.Collectors;

//import com.digital.epharmacy.repository.CatalogueItem.Impl.CatalogueItemRepositoryImpl;
//import org.springframework.data.domain.Page;

@Service
public class CatalogueItemServiceImpl implements CatalogueItemService {
    private static final int PAGE_ELEMENT_SIZE_ADMIN=12;
    private static final int PAGE_ELEMENT_SIZE_CUSTOMER=12;



    @Autowired
    private CatalogueItemRepository repository;

    @Override
    public Set<CatalogueItem> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    public List<CatalogueItem> findAllItemsByProductCategory(String productCategory){
        Set<CatalogueItem> orders = getAll();
        List <CatalogueItem> itemsByCategory;

        itemsByCategory = orders.stream()
                .filter(o -> o.getCategory()
                        .getCategory_name()
                .trim()
                .equalsIgnoreCase(productCategory))
                .collect(Collectors.toList());
        return itemsByCategory;
    }

    @Override
    public CatalogueItem create(CatalogueItem catalogueItem) {
        return this.repository.save(catalogueItem);
    }

    @Override
    public CatalogueItem read(Long catalogueItem) {
        return this.repository.findById(catalogueItem).orElse(null);
    }



    @Override
    public CatalogueItem update(CatalogueItem catalogueItem) {
        return this.repository.save(catalogueItem);
    }


    @Override
    public boolean delete(Long catalogueItem) {
        this.repository.deleteById(catalogueItem);
        if (!this.repository.existsById(catalogueItem)) return true;
        return false;
    }

}
