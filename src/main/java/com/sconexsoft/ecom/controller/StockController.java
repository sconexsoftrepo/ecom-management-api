package com.sconexsoft.ecom.controller;

import com.sconexsoft.ecom.entity.ProductInStockTran;
import com.sconexsoft.ecom.entity.ProductOutStockTran;
import com.sconexsoft.ecom.service.ProductInStockTranService;
import com.sconexsoft.ecom.service.ProductOutStockTranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stocks")
public class StockController {

    @Autowired
    private ProductInStockTranService productInStockTranService;

    @Autowired
    private ProductOutStockTranService productOutStockTranService;

    // Endpoint to create a ProductInStockTran
    @PostMapping("/in")
    public ResponseEntity<ProductInStockTran> createProductInStock(@RequestBody ProductInStockTran productInStockTran) {
        ProductInStockTran createdInStock = productInStockTranService.createProductInStockTran(productInStockTran);
        return ResponseEntity.ok(createdInStock);
    }

    // Endpoint to get a ProductInStockTran by ID
    @GetMapping("/in/{tranId}")
    public ResponseEntity<ProductInStockTran> getProductInStockById(@PathVariable Long tranId) {
        ProductInStockTran inStock = productInStockTranService.getProductInStockTranById(tranId);
        return ResponseEntity.ok(inStock);
    }

    // Endpoint to get all ProductInStockTrans
    @GetMapping("/in")
    public ResponseEntity<List<ProductInStockTran>> getAllProductInStock() {
        List<ProductInStockTran> inStocks = productInStockTranService.getAllProductInStockTrans();
        return ResponseEntity.ok(inStocks);
    }

    // Endpoint to update a ProductInStockTran
    @PutMapping("/in")
    public ResponseEntity<ProductInStockTran> updateProductInStock(@RequestBody ProductInStockTran productInStockTran) {
        ProductInStockTran updatedInStock = productInStockTranService.updateProductInStockTran(productInStockTran);
        return ResponseEntity.ok(updatedInStock);
    }

    // Endpoint to delete a ProductInStockTran by ID
    @DeleteMapping("/in/{tranId}")
    public ResponseEntity<Void> deleteProductInStock(@PathVariable Long tranId) {
        productInStockTranService.deleteProductInStockTran(tranId);
        return ResponseEntity.noContent().build();
    }

    // Endpoint to create a ProductOutStockTran
    @PostMapping("/out")
    public ResponseEntity<ProductOutStockTran> createProductOutStock(@RequestBody ProductOutStockTran productOutStockTran) {
        ProductOutStockTran createdOutStock = productOutStockTranService.createProductOutStockTran(productOutStockTran);
        return ResponseEntity.ok(createdOutStock);
    }

    // Endpoint to get a ProductOutStockTran by ID
    @GetMapping("/out/{tranId}")
    public ResponseEntity<ProductOutStockTran> getProductOutStockById(@PathVariable Long tranId) {
        ProductOutStockTran outStock = productOutStockTranService.getProductOutStockTranById(tranId);
        return ResponseEntity.ok(outStock);
    }

    // Endpoint to get all ProductOutStockTrans
    @GetMapping("/out")
    public ResponseEntity<List<ProductOutStockTran>> getAllProductOutStock() {
        List<ProductOutStockTran> outStocks = productOutStockTranService.getAllProductOutStockTrans();
        return ResponseEntity.ok(outStocks);
    }

    // Endpoint to update a ProductOutStockTran
    @PutMapping("/out")
    public ResponseEntity<ProductOutStockTran> updateProductOutStock(@RequestBody ProductOutStockTran productOutStockTran) {
        ProductOutStockTran updatedOutStock = productOutStockTranService.updateProductOutStockTran(productOutStockTran);
        return ResponseEntity.ok(updatedOutStock);
    }

    // Endpoint to delete a ProductOutStockTran by ID
    @DeleteMapping("/out/{tranId}")
    public ResponseEntity<Void> deleteProductOutStock(@PathVariable Long tranId) {
        productOutStockTranService.deleteProductOutStockTran(tranId);
        return ResponseEntity.noContent().build();
    }

    // Endpoint to get ProductInStockTrans by Product ID
    @GetMapping("/in/product/{productId}")
    public ResponseEntity<List<ProductInStockTran>> getProductInStockByProductId(@PathVariable Long productId) {
        List<ProductInStockTran> inStocks = productInStockTranService.getProductInStockTransByProductId(productId);
        return ResponseEntity.ok(inStocks);
    }

    // Endpoint to get ProductOutStockTrans by Product ID
    @GetMapping("/out/product/{productId}")
    public ResponseEntity<List<ProductOutStockTran>> getProductOutStockByProductId(@PathVariable Long productId) {
        List<ProductOutStockTran> outStocks = productOutStockTranService.getProductOutStockTransByProductId(productId);
        return ResponseEntity.ok(outStocks);
    }

    // Endpoint to get ProductInStockTrans by Dealer ID
    @GetMapping("/in/dealer/{dealerId}")
    public ResponseEntity<List<ProductInStockTran>> getProductInStockByDealerId(@PathVariable Long dealerId) {
        List<ProductInStockTran> inStocks = productInStockTranService.getProductInStockTransByDealerId(dealerId);
        return ResponseEntity.ok(inStocks);
    }

    // Endpoint to get ProductOutStockTrans by Dealer ID
    @GetMapping("/out/dealer/{dealerId}")
    public ResponseEntity<List<ProductOutStockTran>> getProductOutStockByDealerId(@PathVariable Long dealerId) {
        List<ProductOutStockTran> outStocks = productOutStockTranService.getProductOutStockTransByDealerId(dealerId);
        return ResponseEntity.ok(outStocks);
    }
}