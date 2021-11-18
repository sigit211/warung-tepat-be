package org.shifted.controller;

import org.shifted.entity.product.ProductStockUpdate;
import org.shifted.entity.request.CheckoutRequest;
import org.shifted.entity.request.FillCartRequest;
import org.shifted.repository.CartContentRepository;
import org.shifted.repository.ProductRepository;
import org.shifted.service.CartService;
import org.shifted.service.ProductService;
import org.shifted.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestApiController {
//    protected final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CartContentRepository cartContentRepository;

    @Autowired
    private CartService cartService;

    @Autowired
    private ProductService productService;

    @Autowired
    private TransactionService transactionService;

    //Get all products available
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public ResponseEntity<?> findAllProducts() {
        try {
            return ResponseEntity.ok(productRepository.findAll());
        } catch (Exception e) {
            return new ResponseEntity<>(e.getCause().getCause().getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    //Find all products in cart by cart_id
    @RequestMapping(value = "/in-cart", method = RequestMethod.GET)
    public ResponseEntity<?> getProductsInCart(@RequestParam long cart_id) {
        try {
            return ResponseEntity.ok(cartContentRepository.findProductInCartByCartId(cart_id));
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }

    //Initialize cart for new user
    @RequestMapping(value = "/init-cart", method = RequestMethod.POST)
    public ResponseEntity<?> intializeCart(@RequestBody String user_id) {
        try {
            return ResponseEntity.ok(cartService.initCart(user_id));
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }

    //Create cart
    @RequestMapping(value = "/create-cart", method = RequestMethod.POST)
    public ResponseEntity<?> createCart(@RequestBody String user_id) {
        try {
            return ResponseEntity.ok(cartService.createCart(user_id));
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }

    //Fill active cart with products
    @RequestMapping(value = "/fill-cart", method = RequestMethod.POST)
    public ResponseEntity<?> addProductstoCart(@RequestBody FillCartRequest request) {
        try {
            return ResponseEntity.ok(cartService.fillCart(request.getCart(), request.getProduct(), request.getProduct_qty()));
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }

    //Cart checkout
    @RequestMapping(value = "/checkout", method = RequestMethod.POST)
    public ResponseEntity<?> checkout(@RequestBody CheckoutRequest request) {
        try {
            updateStock(request.getProducts());
            return ResponseEntity.ok(transactionService.saveTransaction(request.getTransaction()));
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }

    //Get transactions
    @RequestMapping(value = "/transaction", method = RequestMethod.GET)
    public ResponseEntity<?> getTransactions(@RequestParam String id) {
        try {
            return ResponseEntity.ok(transactionService.findTransaction(id));
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }

    private void updateStock(List<ProductStockUpdate> products) {
        for (ProductStockUpdate product : products) {
            try {
                productService.updateStock(product.getProduct(), product.getQty_taken());
            } catch (Exception e) {
                System.err.println(e);
            }
        }
    }

}
